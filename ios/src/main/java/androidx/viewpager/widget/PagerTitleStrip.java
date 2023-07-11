package androidx.viewpager.widget;
import r.android.database.DataSetObserver;
import r.android.graphics.drawable.Drawable;
import r.android.view.Gravity;
import r.android.view.View;
import r.android.view.ViewGroup;
import r.android.view.ViewParent;
import r.android.widget.TextView;
import java.lang.ref.WeakReference;
public class PagerTitleStrip extends ViewGroup implements ViewPager.IDecorView {
  ViewPager mPager;
  TextView mPrevText;
  TextView mCurrText;
  TextView mNextText;
  private int mLastKnownCurrentPage=-1;
  float mLastKnownPositionOffset=-1;
  private int mScaledTextSpacing;
  private int mGravity;
  private boolean mUpdatingText;
  private boolean mUpdatingPositions;
  private final PageListener mPageListener=new PageListener();
  private WeakReference<PagerAdapter> mWatchingAdapter;
  private static final float SIDE_ALPHA=0.6f;
  private static final int TEXT_SPACING=16;
  private int mNonPrimaryAlpha;
  int mTextColor;
  public void setTextSpacing(  int spacingPixels){
    mScaledTextSpacing=spacingPixels;
    requestLayout();
  }
  public int getTextSpacing(){
    return mScaledTextSpacing;
  }
  public void setTextSize(  int unit,  float size){
    mPrevText.setMyAttribute("textSize", size);
    mCurrText.setMyAttribute("textSize", size);
    mNextText.setMyAttribute("textSize", size);
  }
  public void setGravity(  int gravity){
    mGravity=gravity;
    requestLayout();
  }
  public void onAttachedToWindow(){
    super.onAttachedToWindow();
    final ViewParent parent=getParent();
    if (!(parent instanceof ViewPager)) {
      throw new IllegalStateException("PagerTitleStrip must be a direct child of a ViewPager.");
    }
    final ViewPager pager=(ViewPager)parent;
    final PagerAdapter adapter=pager.getAdapter();
    pager.setInternalPageChangeListener(mPageListener);
    pager.addOnAdapterChangeListener(mPageListener);
    mPager=pager;
    updateAdapter(mWatchingAdapter != null ? mWatchingAdapter.get() : null,adapter);
  }
  public void onDetachedFromWindow(){
    super.onDetachedFromWindow();
    if (mPager != null) {
      updateAdapter(mPager.getAdapter(),null);
      mPager.setInternalPageChangeListener(null);
      mPager.removeOnAdapterChangeListener(mPageListener);
      mPager=null;
    }
  }
  void updateText(  int currentItem,  PagerAdapter adapter){
    final int itemCount=adapter != null ? adapter.getCount() : 0;
    mUpdatingText=true;
    String text="";
    if (currentItem >= 1 && adapter != null) {
      text=(String) adapter.getPageTitle(currentItem - 1);
    }
    mPrevText.setText(text);
    mCurrText.setText(adapter != null && currentItem < itemCount ? (String) adapter.getPageTitle(currentItem) : null);
    text="";
    if (currentItem + 1 < itemCount && adapter != null) {
      text=(String) adapter.getPageTitle(currentItem + 1);
    }
    mNextText.setText(text);
    final int width=getWidth() - getPaddingLeft() - getPaddingRight();
    final int maxWidth=Math.max(0,(int)(width * 0.8f));
    final int childWidthSpec=MeasureSpec.makeMeasureSpec(maxWidth,MeasureSpec.AT_MOST);
    final int childHeight=getHeight() - getPaddingTop() - getPaddingBottom();
    final int maxHeight=Math.max(0,childHeight);
    final int childHeightSpec=MeasureSpec.makeMeasureSpec(maxHeight,MeasureSpec.AT_MOST);
    mPrevText.measure(childWidthSpec,childHeightSpec);
    mCurrText.measure(childWidthSpec,childHeightSpec);
    mNextText.measure(childWidthSpec,childHeightSpec);
    mLastKnownCurrentPage=currentItem;
    if (!mUpdatingPositions) {
      updateTextPositions(currentItem,mLastKnownPositionOffset,false);
    }
    mUpdatingText=false;
  }
  public void requestLayout(){
    if (!mUpdatingText) {
      super.requestLayout();
    }
  }
  void updateAdapter(  PagerAdapter oldAdapter,  PagerAdapter newAdapter){
    if (oldAdapter != null) {
      oldAdapter.unregisterDataSetObserver(mPageListener);
      mWatchingAdapter=null;
    }
    if (newAdapter != null) {
      newAdapter.registerDataSetObserver(mPageListener);
      mWatchingAdapter=new WeakReference<PagerAdapter>(newAdapter);
    }
    if (mPager != null) {
      mLastKnownCurrentPage=-1;
      mLastKnownPositionOffset=-1;
      updateText(mPager.getCurrentItem(),newAdapter);
      requestLayout();
    }
  }
  void updateTextPositions(  int position,  float positionOffset,  boolean force){
    if (position != mLastKnownCurrentPage) {
      updateText(position,mPager.getAdapter());
    }
 else     if (!force && positionOffset == mLastKnownPositionOffset) {
      return;
    }
    mUpdatingPositions=true;
    final int prevWidth=mPrevText.getMeasuredWidth();
    final int currWidth=mCurrText.getMeasuredWidth();
    final int nextWidth=mNextText.getMeasuredWidth();
    final int halfCurrWidth=currWidth / 2;
    final int stripWidth=getWidth();
    final int stripHeight=getHeight();
    final int paddingLeft=getPaddingLeft();
    final int paddingRight=getPaddingRight();
    final int paddingTop=getPaddingTop();
    final int paddingBottom=getPaddingBottom();
    final int textPaddedLeft=paddingLeft + halfCurrWidth;
    final int textPaddedRight=paddingRight + halfCurrWidth;
    final int contentWidth=stripWidth - textPaddedLeft - textPaddedRight;
    float currOffset=positionOffset + 0.5f;
    if (currOffset > 1.f) {
      currOffset-=1.f;
    }
    final int currCenter=stripWidth - textPaddedRight - (int)(contentWidth * currOffset);
    final int currLeft=currCenter - currWidth / 2;
    final int currRight=currLeft + currWidth;
    final int prevBaseline=mPrevText.getBaseline();
    final int currBaseline=mCurrText.getBaseline();
    final int nextBaseline=mNextText.getBaseline();
    final int maxBaseline=Math.max(Math.max(prevBaseline,currBaseline),nextBaseline);
    final int prevTopOffset=maxBaseline - prevBaseline;
    final int currTopOffset=maxBaseline - currBaseline;
    final int nextTopOffset=maxBaseline - nextBaseline;
    final int alignedPrevHeight=prevTopOffset + mPrevText.getMeasuredHeight();
    final int alignedCurrHeight=currTopOffset + mCurrText.getMeasuredHeight();
    final int alignedNextHeight=nextTopOffset + mNextText.getMeasuredHeight();
    final int maxTextHeight=Math.max(Math.max(alignedPrevHeight,alignedCurrHeight),alignedNextHeight);
    final int vgrav=mGravity & Gravity.VERTICAL_GRAVITY_MASK;
    int prevTop;
    int currTop;
    int nextTop;
switch (vgrav) {
default :
case Gravity.TOP:
      prevTop=paddingTop + prevTopOffset;
    currTop=paddingTop + currTopOffset;
  nextTop=paddingTop + nextTopOffset;
break;
case Gravity.CENTER_VERTICAL:
final int paddedHeight=stripHeight - paddingTop - paddingBottom;
final int centeredTop=(paddedHeight - maxTextHeight) / 2;
prevTop=centeredTop + prevTopOffset;
currTop=centeredTop + currTopOffset;
nextTop=centeredTop + nextTopOffset;
break;
case Gravity.BOTTOM:
final int bottomGravTop=stripHeight - paddingBottom - maxTextHeight;
prevTop=bottomGravTop + prevTopOffset;
currTop=bottomGravTop + currTopOffset;
nextTop=bottomGravTop + nextTopOffset;
break;
}
mCurrText.layout(currLeft,currTop,currRight,currTop + mCurrText.getMeasuredHeight());
final int prevLeft=Math.min(paddingLeft,currLeft - mScaledTextSpacing - prevWidth);
mPrevText.layout(prevLeft,prevTop,prevLeft + prevWidth,prevTop + mPrevText.getMeasuredHeight());
final int nextLeft=Math.max(stripWidth - paddingRight - nextWidth,currRight + mScaledTextSpacing);
mNextText.layout(nextLeft,nextTop,nextLeft + nextWidth,nextTop + mNextText.getMeasuredHeight());
mLastKnownPositionOffset=positionOffset;
mUpdatingPositions=false;
}
protected void onMeasure(int widthMeasureSpec,int heightMeasureSpec){
final int widthMode=MeasureSpec.getMode(widthMeasureSpec);
if (widthMode != MeasureSpec.EXACTLY) {
throw new IllegalStateException("Must measure with an exact width");
}
final int heightPadding=getPaddingTop() + getPaddingBottom();
final int childHeightSpec=getChildMeasureSpec(heightMeasureSpec,heightPadding,LayoutParams.WRAP_CONTENT);
final int widthSize=MeasureSpec.getSize(widthMeasureSpec);
final int widthPadding=(int)(widthSize * 0.2f);
final int childWidthSpec=getChildMeasureSpec(widthMeasureSpec,widthPadding,LayoutParams.WRAP_CONTENT);
mPrevText.measure(childWidthSpec,childHeightSpec);
mCurrText.measure(childWidthSpec,childHeightSpec);
mNextText.measure(childWidthSpec,childHeightSpec);
final int height;
final int heightMode=MeasureSpec.getMode(heightMeasureSpec);
if (heightMode == MeasureSpec.EXACTLY) {
height=MeasureSpec.getSize(heightMeasureSpec);
}
 else {
final int textHeight=mCurrText.getMeasuredHeight();
final int minHeight=getMinHeight();
height=Math.max(minHeight,textHeight + heightPadding);
}
final int childState=mCurrText.getMeasuredState();
final int measuredHeight=View.resolveSizeAndState(height,heightMeasureSpec,childState << View.MEASURED_HEIGHT_STATE_SHIFT);
setMeasuredDimension(widthSize,measuredHeight);
}
protected void onLayout(boolean changed,int l,int t,int r,int b){
if (mPager != null) {
final float offset=mLastKnownPositionOffset >= 0 ? mLastKnownPositionOffset : 0;
updateTextPositions(mLastKnownCurrentPage,offset,true);
}
}
int getMinHeight(){
int minHeight=0;
final Drawable bg=getBackground();
if (bg != null) {
minHeight=bg.getIntrinsicHeight();
}
return minHeight;
}
private class PageListener extends DataSetObserver implements ViewPager.OnPageChangeListener, ViewPager.OnAdapterChangeListener {
private int mScrollState;
PageListener(){
}
public void onPageScrolled(int position,float positionOffset,int positionOffsetPixels){
if (positionOffset > 0.5f) {
position++;
}
updateTextPositions(position,positionOffset,false);
}
public void onPageSelected(int position){
if (mScrollState == ViewPager.SCROLL_STATE_IDLE) {
updateText(mPager.getCurrentItem(),mPager.getAdapter());
final float offset=mLastKnownPositionOffset >= 0 ? mLastKnownPositionOffset : 0;
updateTextPositions(mPager.getCurrentItem(),offset,true);
}
}
public void onPageScrollStateChanged(int state){
mScrollState=state;
}
public void onAdapterChanged(ViewPager viewPager,PagerAdapter oldAdapter,PagerAdapter newAdapter){
updateAdapter(oldAdapter,newAdapter);
}
public void onChanged(){
updateText(mPager.getCurrentItem(),mPager.getAdapter());
final float offset=mLastKnownPositionOffset >= 0 ? mLastKnownPositionOffset : 0;
updateTextPositions(mPager.getCurrentItem(),offset,true);
}
}
public PagerTitleStrip(com.ashera.widget.HasWidgets widget){
mGravity=Gravity.BOTTOM;
mScaledTextSpacing=(int)com.ashera.converter.ConverterFactory.get("dimension").convertFrom("16dp",null,widget.getFragment());
}
public void init(com.ashera.widget.HasWidgets widget){
mPrevText=(TextView)com.ashera.widget.WidgetFactory.createWidget("TextView","PagerTitleStrip_TextView",widget,false).asWidget();
mCurrText=(TextView)com.ashera.widget.WidgetFactory.createWidget("TextView","PagerTitleStrip_TextView",widget,false).asWidget();
mNextText=(TextView)com.ashera.widget.WidgetFactory.createWidget("TextView","PagerTitleStrip_TextView",widget,false).asWidget();
mNextText.setMyAttribute("alpha",SIDE_ALPHA);
mPrevText.setMyAttribute("alpha",SIDE_ALPHA);
}
public void setTextColor(Object objValue){
mCurrText.setMyAttribute("textColor",objValue);
mNextText.setMyAttribute("textColor",objValue);
mPrevText.setMyAttribute("textColor",objValue);
}
public void setNonPrimaryAlpha(float alpha){
mNextText.setMyAttribute("alpha",alpha);
mPrevText.setMyAttribute("alpha",alpha);
}
public void setTextAppearance(Object objValue){
mCurrText.setMyAttribute("textAppearance",objValue);
mNextText.setMyAttribute("textAppearance",objValue);
mPrevText.setMyAttribute("textAppearance",objValue);
}
}
