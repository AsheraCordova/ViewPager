package androidx.viewpager.widget;
import r.android.graphics.drawable.Drawable;
import r.android.view.View;
public class PagerTabStrip extends PagerTitleStrip {
  private static final int INDICATOR_HEIGHT=3;
  private static final int MIN_PADDING_BOTTOM=INDICATOR_HEIGHT + 3;
  private static final int TAB_PADDING=16;
  private static final int TAB_SPACING=32;
  private static final int MIN_TEXT_SPACING=TAB_SPACING + TAB_PADDING * 2;
  private static final int FULL_UNDERLINE_HEIGHT=1;
  private static final int MIN_STRIP_HEIGHT=32;
  private int mIndicatorColor;
  private int mIndicatorHeight;
  private int mMinPaddingBottom;
  private int mMinTextSpacing;
  private int mMinStripHeight;
  private int mTabPadding;
  private int mTabAlpha=0xFF;
  private boolean mDrawFullUnderline=false;
  private boolean mDrawFullUnderlineSet=false;
  private int mFullUnderlineHeight;
  private boolean mIgnoreTap;
  private float mInitialMotionX;
  private float mInitialMotionY;
  private int mTouchSlop;
  public void setPadding(  int left,  int top,  int right,  int bottom){
    if (bottom < mMinPaddingBottom) {
      bottom=mMinPaddingBottom;
    }
    super.setPadding(left,top,right,bottom);
  }
  public void setTextSpacing(  int spacingPixels){
    if (spacingPixels < mMinTextSpacing) {
      spacingPixels=mMinTextSpacing;
    }
    super.setTextSpacing(spacingPixels);
  }
  public void setDrawFullUnderline(  boolean drawFull){
    mDrawFullUnderline=drawFull;
    mDrawFullUnderlineSet=true;updateBorderBottomWidth();
    invalidate();
  }
  int getMinHeight(){
    return Math.max(super.getMinHeight(),mMinStripHeight);
  }
  void updateTextPositions(  int position,  float positionOffset,  boolean force){
    super.updateTextPositions(position,positionOffset,force);
    mTabAlpha=(int)(Math.abs(positionOffset - 0.5f) * 2 * 0xFF);
    invalidate();
  }
  public PagerTabStrip(  com.ashera.widget.HasWidgets widget){
    super(widget);
    mIndicatorHeight=(int)com.ashera.converter.ConverterFactory.get("dimension").convertFrom(INDICATOR_HEIGHT + "dp",null,widget.getFragment());
    mMinPaddingBottom=(int)com.ashera.converter.ConverterFactory.get("dimension").convertFrom(MIN_PADDING_BOTTOM + "dp",null,widget.getFragment());
    mMinTextSpacing=(int)com.ashera.converter.ConverterFactory.get("dimension").convertFrom(MIN_TEXT_SPACING + "dp",null,widget.getFragment());
    mTabPadding=(int)com.ashera.converter.ConverterFactory.get("dimension").convertFrom(TAB_PADDING + "dp",null,widget.getFragment());
    mFullUnderlineHeight=(int)com.ashera.converter.ConverterFactory.get("dimension").convertFrom(FULL_UNDERLINE_HEIGHT + "dp",null,widget.getFragment());
    mMinStripHeight=(int)com.ashera.converter.ConverterFactory.get("dimension").convertFrom(MIN_STRIP_HEIGHT + "dp",null,widget.getFragment());
    setPadding(getPaddingLeft(),getPaddingTop(),getPaddingRight(),getPaddingBottom());
    setTextSpacing(getTextSpacing());
  }
  public void init(  com.ashera.widget.HasWidgets widget){
    super.init(widget);
    mDrawFullUnderline=true;
    updateBorderBottomWidth();
    setMyAttribute("borderBottomColor",com.ashera.converter.ConverterFactory.get("color").convertFrom("#aaa",null,widget.getFragment()));
    mCurrText.setMyAttribute("borderBottomWidth",mIndicatorHeight);
    mCurrText.setMyAttribute("paddingBottom",mIndicatorHeight);
    mCurrText.setMyAttribute("borderBottomColor",com.ashera.converter.ConverterFactory.get("color").convertFrom("#f00",null,widget.getFragment()));
    mPrevText.setMyAttribute("onClick",new OnClickListener(){
      @Override public void onClick(      View v){
        mPager.setCurrentItem(mPager.getCurrentItem() - 1);
      }
    }
);
    mNextText.setMyAttribute("onClick",new OnClickListener(){
      @Override public void onClick(      View v){
        mPager.setCurrentItem(mPager.getCurrentItem() + 1);
      }
    }
);
    mCurrText.setMyAttribute("singleLine",true);
    mPrevText.setMyAttribute("singleLine",true);
    mNextText.setMyAttribute("singleLine",true);
    mCurrText.setMyAttribute("textAllCaps",true);
    mPrevText.setMyAttribute("textAllCaps",true);
    mNextText.setMyAttribute("textAllCaps",true);
  }
  public void setTabIndicatorColor(  Object objValue){
    mCurrText.setMyAttribute("borderBottomColor",objValue);
  }
  private void updateBorderBottomWidth(){
    if (mDrawFullUnderline) {
      setMyAttribute("borderBottomWidth",mFullUnderlineHeight);
    }
 else {
      setMyAttribute("borderBottomWidth",0);
    }
  }
}
