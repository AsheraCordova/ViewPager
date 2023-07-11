package androidx.viewpager.widget;
import r.android.content.res.Resources;
import r.android.database.DataSetObserver;
import r.android.graphics.Canvas;
import r.android.graphics.Rect;
import r.android.graphics.drawable.Drawable;
import r.android.os.Parcelable;
import r.android.util.Log;
import r.android.view.Gravity;
import r.android.view.View;
import r.android.view.ViewGroup;
import r.android.view.ViewParent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
public class ViewPager extends ViewGroup {
  private static final String TAG="ViewPager";
  private static final boolean DEBUG=false;
  private static final int DEFAULT_OFFSCREEN_PAGES=1;
  private static final int MAX_SETTLE_DURATION=600;
  private static final int MIN_DISTANCE_FOR_FLING=25;
  private static final int DEFAULT_GUTTER_SIZE=16;
  private static final int MIN_FLING_VELOCITY=400;
  private int mExpectedAdapterCount;
static class ItemInfo {
    Object object;
    int position;
    boolean scrolling;
    float widthFactor;
    float offset;
  }
  private static final Comparator<ItemInfo> COMPARATOR=new Comparator<ItemInfo>(){
    public int compare(    ItemInfo lhs,    ItemInfo rhs){
      return lhs.position - rhs.position;
    }
  }
;
  private final ArrayList<ItemInfo> mItems=new ArrayList<ItemInfo>();
  private final ItemInfo mTempItem=new ItemInfo();
  private final Rect mTempRect=new Rect();
  PagerAdapter mAdapter;
  int mCurItem;
  private int mRestoredCurItem=-1;
  private Parcelable mRestoredAdapterState=null;
  private ClassLoader mRestoredClassLoader=null;
  private boolean mIsScrollStarted;
  private PagerObserver mObserver;
  private int mPageMargin;
  private Drawable mMarginDrawable;
  private int mTopPageBounds;
  private int mBottomPageBounds;
  private float mFirstOffset=-Float.MAX_VALUE;
  private float mLastOffset=Float.MAX_VALUE;
  private boolean mInLayout;
  private boolean mScrollingCacheEnabled;
  private boolean mPopulatePending;
  private int mOffscreenPageLimit=DEFAULT_OFFSCREEN_PAGES;
  private boolean mIsBeingDragged;
  private boolean mIsUnableToDrag;
  private int mDefaultGutterSize;
  private int mGutterSize;
  private int mTouchSlop;
  private boolean mDragInGutterEnabled=true;
  private float mLastMotionX;
  private float mLastMotionY;
  private float mInitialMotionX;
  private float mInitialMotionY;
  private int mActivePointerId=INVALID_POINTER;
  private static final int INVALID_POINTER=-1;
  private int mMinimumVelocity;
  private int mMaximumVelocity;
  private int mFlingDistance;
  private int mCloseEnough;
  private static final int CLOSE_ENOUGH=2;
  private boolean mFakeDragging;
  private boolean mFirstLayout=true;
  private boolean mCalledSuper;
  private int mDecorChildCount;
  private List<OnPageChangeListener> mOnPageChangeListeners;
  private OnPageChangeListener mOnPageChangeListener;
  private OnPageChangeListener mInternalPageChangeListener;
  private List<OnAdapterChangeListener> mAdapterChangeListeners;
  private PageTransformer mPageTransformer;
  private int mPageTransformerLayerType;
  private static final int DRAW_ORDER_DEFAULT=0;
  private static final int DRAW_ORDER_FORWARD=1;
  private static final int DRAW_ORDER_REVERSE=2;
  private int mDrawingOrder;
  private ArrayList<View> mDrawingOrderedChildren;
  private static final ViewPositionComparator sPositionComparator=new ViewPositionComparator();
  public static final int SCROLL_STATE_IDLE=0;
  public static final int SCROLL_STATE_DRAGGING=1;
  public static final int SCROLL_STATE_SETTLING=2;
  private int mScrollState=SCROLL_STATE_IDLE;
public interface OnPageChangeListener {
    void onPageScrolled(    int position,    float positionOffset,    int positionOffsetPixels);
    void onPageSelected(    int position);
    void onPageScrollStateChanged(    int state);
  }
public interface PageTransformer {
    void transformPage(    View page,    float position);
  }
public interface OnAdapterChangeListener {
    void onAdapterChanged(    ViewPager viewPager,    PagerAdapter oldAdapter,    PagerAdapter newAdapter);
  }
  public void setAdapter(  PagerAdapter adapter){
    if (mAdapter != null) {
      mAdapter.setViewPagerObserver(null);
      mAdapter.startUpdate(this);
      for (int i=0; i < mItems.size(); i++) {
        final ItemInfo ii=mItems.get(i);
        mAdapter.destroyItem(this,ii.position,ii.object);
      }
      mAdapter.finishUpdate(this);
      mItems.clear();
      removeNonDecorViews();
      mCurItem=0;
      scrollTo(0,0);
    }
    final PagerAdapter oldAdapter=mAdapter;
    mAdapter=adapter;
    mExpectedAdapterCount=0;
    if (mAdapter != null) {
      if (mObserver == null) {
        mObserver=new PagerObserver();
      }
      mAdapter.setViewPagerObserver(mObserver);
      mPopulatePending=false;
      final boolean wasFirstLayout=mFirstLayout;
      mFirstLayout=true;
      mExpectedAdapterCount=mAdapter.getCount();
      if (mRestoredCurItem >= 0) {
        mAdapter.restoreState(mRestoredAdapterState,mRestoredClassLoader);
        setCurrentItemInternal(mRestoredCurItem,false,true);
        mRestoredCurItem=-1;
        mRestoredAdapterState=null;
        mRestoredClassLoader=null;
      }
 else       if (!wasFirstLayout) {
        populate();
      }
 else {
        requestLayout();
      }
    }
    if (mAdapterChangeListeners != null && !mAdapterChangeListeners.isEmpty()) {
      for (int i=0, count=mAdapterChangeListeners.size(); i < count; i++) {
        mAdapterChangeListeners.get(i).onAdapterChanged(this,oldAdapter,adapter);
      }
    }
  }
  private void removeNonDecorViews(){
    for (int i=0; i < getChildCount(); i++) {
      final View child=getChildAt(i);
      final LayoutParams lp=(LayoutParams)child.getLayoutParams();
      if (!lp.isDecor) {
        removeViewAt(i);
        i--;
      }
    }
  }
  public PagerAdapter getAdapter(){
    return mAdapter;
  }
  public void addOnAdapterChangeListener(  OnAdapterChangeListener listener){
    if (mAdapterChangeListeners == null) {
      mAdapterChangeListeners=new ArrayList<>();
    }
    mAdapterChangeListeners.add(listener);
  }
  public void removeOnAdapterChangeListener(  OnAdapterChangeListener listener){
    if (mAdapterChangeListeners != null) {
      mAdapterChangeListeners.remove(listener);
    }
  }
  private int getClientWidth(){
    return getMeasuredWidth() - getPaddingLeft() - getPaddingRight();
  }
  public void setCurrentItem(  int item){
    mPopulatePending=false;
    setCurrentItemInternal(item,!mFirstLayout,false);
  }
  public void setCurrentItem(  int item,  boolean smoothScroll){
    mPopulatePending=false;
    setCurrentItemInternal(item,smoothScroll,false);
  }
  public int getCurrentItem(){
    return mCurItem;
  }
  void setCurrentItemInternal(  int item,  boolean smoothScroll,  boolean always){
    setCurrentItemInternal(item,smoothScroll,always,0);
  }
  void setCurrentItemInternal(  int item,  boolean smoothScroll,  boolean always,  int velocity){
    if (mAdapter == null || mAdapter.getCount() <= 0) {
      setScrollingCacheEnabled(false);
      return;
    }
    if (!always && mCurItem == item && mItems.size() != 0) {
      setScrollingCacheEnabled(false);
      return;
    }
    if (item < 0) {
      item=0;
    }
 else     if (item >= mAdapter.getCount()) {
      item=mAdapter.getCount() - 1;
    }
    final int pageLimit=mOffscreenPageLimit;
    if (item > (mCurItem + pageLimit) || item < (mCurItem - pageLimit)) {
      for (int i=0; i < mItems.size(); i++) {
        mItems.get(i).scrolling=true;
      }
    }
    final boolean dispatchSelected=mCurItem != item;
    if (mFirstLayout) {
      mCurItem=item;
      if (dispatchSelected) {
        dispatchOnPageSelected(item);
      }
      requestLayout();
    }
 else {
      populate(item);
      scrollToItem(item,smoothScroll,velocity,dispatchSelected);
    }
  }
  public void scrollToItem(  int item,  boolean smoothScroll,  int velocity,  boolean dispatchSelected){
    final ItemInfo curInfo=infoForPosition(item);
    int destX=0;
    if (curInfo != null) {
      final int width=getClientWidth();
      destX=(int)(width * Math.max(mFirstOffset,Math.min(curInfo.offset,mLastOffset)));
    }
    if (smoothScroll) {
      smoothScrollTo(destX,0,velocity);
      if (dispatchSelected) {
        dispatchOnPageSelected(item);
      }
    }
 else {
      if (dispatchSelected) {
        dispatchOnPageSelected(item);
      }
      completeScroll(false);
      scrollTo(destX,0);
      pageScrolled(destX);
    }
  }
  public void setOnPageChangeListener(  OnPageChangeListener listener){
    mOnPageChangeListener=listener;
  }
  public void setPageTransformer(  boolean reverseDrawingOrder,  PageTransformer transformer){
    setPageTransformer(reverseDrawingOrder,transformer,View.LAYER_TYPE_HARDWARE);
  }
  public void setPageTransformer(  boolean reverseDrawingOrder,  PageTransformer transformer,  int pageLayerType){
    final boolean hasTransformer=transformer != null;
    final boolean needsPopulate=hasTransformer != (mPageTransformer != null);
    mPageTransformer=transformer;
    setChildrenDrawingOrderEnabled(hasTransformer);
    if (hasTransformer) {
      mDrawingOrder=reverseDrawingOrder ? DRAW_ORDER_REVERSE : DRAW_ORDER_FORWARD;
      mPageTransformerLayerType=pageLayerType;
    }
 else {
      mDrawingOrder=DRAW_ORDER_DEFAULT;
    }
    if (needsPopulate)     populate();
  }
  OnPageChangeListener setInternalPageChangeListener(  OnPageChangeListener listener){
    OnPageChangeListener oldListener=mInternalPageChangeListener;
    mInternalPageChangeListener=listener;
    return oldListener;
  }
  public int getOffscreenPageLimit(){
    return mOffscreenPageLimit;
  }
  public void setOffscreenPageLimit(  int limit){
    if (limit < DEFAULT_OFFSCREEN_PAGES) {
      Log.w(TAG,"Requested offscreen page limit " + limit + " too small; defaulting to "+ DEFAULT_OFFSCREEN_PAGES);
      limit=DEFAULT_OFFSCREEN_PAGES;
    }
    if (limit != mOffscreenPageLimit) {
      mOffscreenPageLimit=limit;
      populate();
    }
  }
  public void setPageMargin(  int marginPixels){
    final int oldMargin=mPageMargin;
    mPageMargin=marginPixels;
    final int width=getWidth();
    recomputeScrollPosition(width,width,marginPixels,oldMargin);
    requestLayout();
  }
  public int getPageMargin(){
    return mPageMargin;
  }
  public void setPageMarginDrawable(  Drawable d){
    mMarginDrawable=d;
    if (d != null)     refreshDrawableState();
    setWillNotDraw(d == null);
    invalidate();
  }
  protected void drawableStateChanged(){
    super.drawableStateChanged();
    final Drawable d=mMarginDrawable;
    if (d != null && d.isStateful()) {
      d.setState(getDrawableState());
    }
  }
  ItemInfo addNewItem(  int position,  int index){
    ItemInfo ii=new ItemInfo();
    ii.position=position;
    ii.object=mAdapter.instantiateItem(this,position);
    ii.widthFactor=mAdapter.getPageWidth(position);
    if (index < 0 || index >= mItems.size()) {
      mItems.add(ii);
    }
 else {
      mItems.add(index,ii);
    }
    return ii;
  }
  void dataSetChanged(){
    final int adapterCount=mAdapter.getCount();
    mExpectedAdapterCount=adapterCount;
    boolean needPopulate=mItems.size() < mOffscreenPageLimit * 2 + 1 && mItems.size() < adapterCount;
    int newCurrItem=mCurItem;
    boolean isUpdating=false;
    for (int i=0; i < mItems.size(); i++) {
      final ItemInfo ii=mItems.get(i);
      final int newPos=mAdapter.getItemPosition(ii.object);
      if (newPos == PagerAdapter.POSITION_UNCHANGED) {
        continue;
      }
      if (newPos == PagerAdapter.POSITION_NONE) {
        mItems.remove(i);
        i--;
        if (!isUpdating) {
          mAdapter.startUpdate(this);
          isUpdating=true;
        }
        mAdapter.destroyItem(this,ii.position,ii.object);
        needPopulate=true;
        if (mCurItem == ii.position) {
          newCurrItem=Math.max(0,Math.min(mCurItem,adapterCount - 1));
          needPopulate=true;
        }
        continue;
      }
      if (ii.position != newPos) {
        if (ii.position == mCurItem) {
          newCurrItem=newPos;
        }
        ii.position=newPos;
        needPopulate=true;
      }
    }
    if (isUpdating) {
      mAdapter.finishUpdate(this);
    }
    Collections.sort(mItems,COMPARATOR);
    if (needPopulate) {
      final int childCount=getChildCount();
      for (int i=0; i < childCount; i++) {
        final View child=getChildAt(i);
        final LayoutParams lp=(LayoutParams)child.getLayoutParams();
        if (!lp.isDecor) {
          lp.widthFactor=0.f;
        }
      }
      setCurrentItemInternal(newCurrItem,false,true);
      requestLayout();
    }
  }
  void populate(){
    populate(mCurItem);
  }
  void populate(  int newCurrentItem){
    ItemInfo oldCurInfo=null;
    if (mCurItem != newCurrentItem) {
      oldCurInfo=infoForPosition(mCurItem);
      mCurItem=newCurrentItem;
    }
    if (mAdapter == null) {
      sortChildDrawingOrder();
      return;
    }
    if (mPopulatePending) {
      if (DEBUG)       Log.i(TAG,"populate is pending, skipping for now...");
      sortChildDrawingOrder();
      return;
    }
    if (false) {
      return;
    }
    mAdapter.startUpdate(this);
    final int pageLimit=mOffscreenPageLimit;
    final int startPos=Math.max(0,mCurItem - pageLimit);
    final int N=mAdapter.getCount();
    final int endPos=Math.min(N - 1,mCurItem + pageLimit);
    if (N != mExpectedAdapterCount) {
      String resName;
      try {
        resName=getResources().getResourceName(getId());
      }
 catch (      Resources.NotFoundException e) {
        resName=Integer.toHexString(getId());
      }
      throw new IllegalStateException("The application's PagerAdapter changed the adapter's" + " contents without calling PagerAdapter#notifyDataSetChanged!" + " Expected adapter item count: " + mExpectedAdapterCount + ", found: "+ N+ " Pager id: "+ resName+ " Pager class: "+ getClass()+ " Problematic adapter: "+ mAdapter.getClass());
    }
    int curIndex=-1;
    ItemInfo curItem=null;
    for (curIndex=0; curIndex < mItems.size(); curIndex++) {
      final ItemInfo ii=mItems.get(curIndex);
      if (ii.position >= mCurItem) {
        if (ii.position == mCurItem)         curItem=ii;
        break;
      }
    }
    if (curItem == null && N > 0) {
      curItem=addNewItem(mCurItem,curIndex);
    }
    if (curItem != null) {
      float extraWidthLeft=0.f;
      int itemIndex=curIndex - 1;
      ItemInfo ii=itemIndex >= 0 ? mItems.get(itemIndex) : null;
      final int clientWidth=getClientWidth();
      final float leftWidthNeeded=clientWidth <= 0 ? 0 : 2.f - curItem.widthFactor + (float)getPaddingLeft() / (float)clientWidth;
      for (int pos=mCurItem - 1; pos >= 0; pos--) {
        if (extraWidthLeft >= leftWidthNeeded && pos < startPos) {
          if (ii == null) {
            break;
          }
          if (pos == ii.position && !ii.scrolling) {
            mItems.remove(itemIndex);
            mAdapter.destroyItem(this,pos,ii.object);
            if (DEBUG) {
              Log.i(TAG,"populate() - destroyItem() with pos: " + pos + " view: "+ ((View)ii.object));
            }
            itemIndex--;
            curIndex--;
            ii=itemIndex >= 0 ? mItems.get(itemIndex) : null;
          }
        }
 else         if (ii != null && pos == ii.position) {
          extraWidthLeft+=ii.widthFactor;
          itemIndex--;
          ii=itemIndex >= 0 ? mItems.get(itemIndex) : null;
        }
 else {
          ii=addNewItem(pos,itemIndex + 1);
          extraWidthLeft+=ii.widthFactor;
          curIndex++;
          ii=itemIndex >= 0 ? mItems.get(itemIndex) : null;
        }
      }
      float extraWidthRight=curItem.widthFactor;
      itemIndex=curIndex + 1;
      if (extraWidthRight < 2.f) {
        ii=itemIndex < mItems.size() ? mItems.get(itemIndex) : null;
        final float rightWidthNeeded=clientWidth <= 0 ? 0 : (float)getPaddingRight() / (float)clientWidth + 2.f;
        for (int pos=mCurItem + 1; pos < N; pos++) {
          if (extraWidthRight >= rightWidthNeeded && pos > endPos) {
            if (ii == null) {
              break;
            }
            if (pos == ii.position && !ii.scrolling) {
              mItems.remove(itemIndex);
              mAdapter.destroyItem(this,pos,ii.object);
              if (DEBUG) {
                Log.i(TAG,"populate() - destroyItem() with pos: " + pos + " view: "+ ((View)ii.object));
              }
              ii=itemIndex < mItems.size() ? mItems.get(itemIndex) : null;
            }
          }
 else           if (ii != null && pos == ii.position) {
            extraWidthRight+=ii.widthFactor;
            itemIndex++;
            ii=itemIndex < mItems.size() ? mItems.get(itemIndex) : null;
          }
 else {
            ii=addNewItem(pos,itemIndex);
            itemIndex++;
            extraWidthRight+=ii.widthFactor;
            ii=itemIndex < mItems.size() ? mItems.get(itemIndex) : null;
          }
        }
      }
      calculatePageOffsets(curItem,curIndex,oldCurInfo);
      mAdapter.setPrimaryItem(this,mCurItem,curItem.object);
    }
    if (DEBUG) {
      Log.i(TAG,"Current page list:");
      for (int i=0; i < mItems.size(); i++) {
        Log.i(TAG,"#" + i + ": page "+ mItems.get(i).position);
      }
    }
    mAdapter.finishUpdate(this);
    final int childCount=getChildCount();
    for (int i=0; i < childCount; i++) {
      final View child=getChildAt(i);
      final LayoutParams lp=(LayoutParams)child.getLayoutParams();
      lp.childIndex=i;
      if (!lp.isDecor && lp.widthFactor == 0.f) {
        final ItemInfo ii=infoForChild(child);
        if (ii != null) {
          lp.widthFactor=ii.widthFactor;
          lp.position=ii.position;
        }
      }
    }
    sortChildDrawingOrder();
    if (hasFocus()) {
      View currentFocused=findFocus();
      ItemInfo ii=currentFocused != null ? infoForAnyChild(currentFocused) : null;
      if (ii == null || ii.position != mCurItem) {
        for (int i=0; i < getChildCount(); i++) {
          View child=getChildAt(i);
          ii=infoForChild(child);
          if (ii != null && ii.position == mCurItem) {
            if (true) {
              break;
            }
          }
        }
      }
    }
  }
  private void sortChildDrawingOrder(){
    if (mDrawingOrder != DRAW_ORDER_DEFAULT) {
      if (mDrawingOrderedChildren == null) {
        mDrawingOrderedChildren=new ArrayList<View>();
      }
 else {
        mDrawingOrderedChildren.clear();
      }
      final int childCount=getChildCount();
      for (int i=0; i < childCount; i++) {
        final View child=getChildAt(i);
        mDrawingOrderedChildren.add(child);
      }
      Collections.sort(mDrawingOrderedChildren,sPositionComparator);
    }
  }
  private void calculatePageOffsets(  ItemInfo curItem,  int curIndex,  ItemInfo oldCurInfo){
    final int N=mAdapter.getCount();
    final int width=getClientWidth();
    final float marginOffset=width > 0 ? (float)mPageMargin / width : 0;
    if (oldCurInfo != null) {
      final int oldCurPosition=oldCurInfo.position;
      if (oldCurPosition < curItem.position) {
        int itemIndex=0;
        ItemInfo ii=null;
        float offset=oldCurInfo.offset + oldCurInfo.widthFactor + marginOffset;
        for (int pos=oldCurPosition + 1; pos <= curItem.position && itemIndex < mItems.size(); pos++) {
          ii=mItems.get(itemIndex);
          while (pos > ii.position && itemIndex < mItems.size() - 1) {
            itemIndex++;
            ii=mItems.get(itemIndex);
          }
          while (pos < ii.position) {
            offset+=mAdapter.getPageWidth(pos) + marginOffset;
            pos++;
          }
          ii.offset=offset;
          offset+=ii.widthFactor + marginOffset;
        }
      }
 else       if (oldCurPosition > curItem.position) {
        int itemIndex=mItems.size() - 1;
        ItemInfo ii=null;
        float offset=oldCurInfo.offset;
        for (int pos=oldCurPosition - 1; pos >= curItem.position && itemIndex >= 0; pos--) {
          ii=mItems.get(itemIndex);
          while (pos < ii.position && itemIndex > 0) {
            itemIndex--;
            ii=mItems.get(itemIndex);
          }
          while (pos > ii.position) {
            offset-=mAdapter.getPageWidth(pos) + marginOffset;
            pos--;
          }
          offset-=ii.widthFactor + marginOffset;
          ii.offset=offset;
        }
      }
    }
    final int itemCount=mItems.size();
    float offset=curItem.offset;
    int pos=curItem.position - 1;
    mFirstOffset=curItem.position == 0 ? curItem.offset : -Float.MAX_VALUE;
    mLastOffset=curItem.position == N - 1 ? curItem.offset + curItem.widthFactor - 1 : Float.MAX_VALUE;
    for (int i=curIndex - 1; i >= 0; i--, pos--) {
      final ItemInfo ii=mItems.get(i);
      while (pos > ii.position) {
        offset-=mAdapter.getPageWidth(pos--) + marginOffset;
      }
      offset-=ii.widthFactor + marginOffset;
      ii.offset=offset;
      if (ii.position == 0)       mFirstOffset=offset;
    }
    offset=curItem.offset + curItem.widthFactor + marginOffset;
    pos=curItem.position + 1;
    for (int i=curIndex + 1; i < itemCount; i++, pos++) {
      final ItemInfo ii=mItems.get(i);
      while (pos < ii.position) {
        offset+=mAdapter.getPageWidth(pos++) + marginOffset;
      }
      if (ii.position == N - 1) {
        mLastOffset=offset + ii.widthFactor - 1;
      }
      ii.offset=offset;
      offset+=ii.widthFactor + marginOffset;
    }
  }
  public void addView(  View child,  int index,  ViewGroup.LayoutParams params){
    if (!checkLayoutParams(params)) {
      params=generateLayoutParams(params);
    }
    final LayoutParams lp=(LayoutParams)params;
    lp.isDecor|=isDecorView(child);
    if (mInLayout) {
      if (lp != null && lp.isDecor) {
        throw new IllegalStateException("Cannot add pager decor view during layout");
      }
      lp.needsMeasure=true;
      addViewInLayout(child,index,params);
    }
 else {
      super.addView(child,index,params);
    }
  }
  ItemInfo infoForChild(  View child){
    for (int i=0; i < mItems.size(); i++) {
      ItemInfo ii=mItems.get(i);
      if (mAdapter.isViewFromObject(child,ii.object)) {
        return ii;
      }
    }
    return null;
  }
  ItemInfo infoForAnyChild(  View child){
    ViewParent parent;
    while ((parent=child.getParent()) != this) {
      if (!(parent instanceof View)) {
        return null;
      }
      child=(View)parent;
    }
    return infoForChild(child);
  }
  ItemInfo infoForPosition(  int position){
    for (int i=0; i < mItems.size(); i++) {
      ItemInfo ii=mItems.get(i);
      if (ii.position == position) {
        return ii;
      }
    }
    return null;
  }
  protected void onMeasure(  int widthMeasureSpec,  int heightMeasureSpec){
    setMeasuredDimension(getDefaultSize(0,widthMeasureSpec),getDefaultSize(0,heightMeasureSpec));
    final int measuredWidth=getMeasuredWidth();
    final int maxGutterSize=measuredWidth / 10;
    mGutterSize=Math.min(maxGutterSize,mDefaultGutterSize);
    int childWidthSize=measuredWidth - getPaddingLeft() - getPaddingRight();
    int childHeightSize=getMeasuredHeight() - getPaddingTop() - getPaddingBottom();
    int size=getChildCount();
    for (int i=0; i < size; ++i) {
      final View child=getChildAt(i);
      if (child.getVisibility() != GONE) {
        final LayoutParams lp=(LayoutParams)child.getLayoutParams();
        if (lp != null && lp.isDecor) {
          final int hgrav=lp.gravity & Gravity.HORIZONTAL_GRAVITY_MASK;
          final int vgrav=lp.gravity & Gravity.VERTICAL_GRAVITY_MASK;
          int widthMode=MeasureSpec.AT_MOST;
          int heightMode=MeasureSpec.AT_MOST;
          boolean consumeVertical=vgrav == Gravity.TOP || vgrav == Gravity.BOTTOM;
          boolean consumeHorizontal=hgrav == Gravity.LEFT || hgrav == Gravity.RIGHT;
          if (consumeVertical) {
            widthMode=MeasureSpec.EXACTLY;
          }
 else           if (consumeHorizontal) {
            heightMode=MeasureSpec.EXACTLY;
          }
          int widthSize=childWidthSize;
          int heightSize=childHeightSize;
          if (lp.width != LayoutParams.WRAP_CONTENT) {
            widthMode=MeasureSpec.EXACTLY;
            if (lp.width != LayoutParams.MATCH_PARENT) {
              widthSize=lp.width;
            }
          }
          if (lp.height != LayoutParams.WRAP_CONTENT) {
            heightMode=MeasureSpec.EXACTLY;
            if (lp.height != LayoutParams.MATCH_PARENT) {
              heightSize=lp.height;
            }
          }
          final int widthSpec=MeasureSpec.makeMeasureSpec(widthSize,widthMode);
          final int heightSpec=MeasureSpec.makeMeasureSpec(heightSize,heightMode);
          child.measure(widthSpec,heightSpec);
          if (consumeVertical) {
            childHeightSize-=child.getMeasuredHeight();
          }
 else           if (consumeHorizontal) {
            childWidthSize-=child.getMeasuredWidth();
          }
        }
      }
    }
    int childWidthMeasureSpec=MeasureSpec.makeMeasureSpec(childWidthSize,MeasureSpec.EXACTLY);
    int childHeightMeasureSpec=MeasureSpec.makeMeasureSpec(childHeightSize,MeasureSpec.EXACTLY);
    mInLayout=true;
    populate();
    mInLayout=false;
    size=getChildCount();
    for (int i=0; i < size; ++i) {
      final View child=getChildAt(i);
      if (child.getVisibility() != GONE) {
        if (DEBUG) {
          Log.v(TAG,"Measuring #" + i + " "+ child+ ": "+ childWidthMeasureSpec);
        }
        final LayoutParams lp=(LayoutParams)child.getLayoutParams();
        if (lp == null || !lp.isDecor) {
          final int widthSpec=MeasureSpec.makeMeasureSpec((int)(childWidthSize * lp.widthFactor),MeasureSpec.EXACTLY);
          child.measure(widthSpec,childHeightMeasureSpec);
        }
      }
    }
  }
  private void recomputeScrollPosition(  int width,  int oldWidth,  int margin,  int oldMargin){
    if (oldWidth > 0 && !mItems.isEmpty()) {
      if (!true) {
        //mScroller.setFinalX(getCurrentItem() * getClientWidth());
      }
 else {
        final int widthWithMargin=width - getPaddingLeft() - getPaddingRight() + margin;
        final int oldWidthWithMargin=oldWidth - getPaddingLeft() - getPaddingRight() + oldMargin;
        final int xpos=getScrollX();
        final float pageOffset=(float)xpos / oldWidthWithMargin;
        final int newOffsetPixels=(int)(pageOffset * widthWithMargin);
        scrollTo(newOffsetPixels,getScrollY());
      }
    }
 else {
      final ItemInfo ii=infoForPosition(mCurItem);
      final float scrollOffset=ii != null ? Math.min(ii.offset,mLastOffset) : 0;
      final int scrollPos=(int)(scrollOffset * (width - getPaddingLeft() - getPaddingRight()));
      if (scrollPos != getScrollX()) {
        completeScroll(false);
        scrollTo(scrollPos,getScrollY());
      }
    }
  }
  protected void onLayout(  boolean changed,  int l,  int t,  int r,  int b){
    final int count=getChildCount();
    int width=r - l;
    int height=b - t;
    int paddingLeft=getPaddingLeft();
    int paddingTop=getPaddingTop();
    int paddingRight=getPaddingRight();
    int paddingBottom=getPaddingBottom();
    final int scrollX=getScrollX();
    int decorCount=0;
    for (int i=0; i < count; i++) {
      final View child=getChildAt(i);
      if (child.getVisibility() != GONE) {
        final LayoutParams lp=(LayoutParams)child.getLayoutParams();
        int childLeft=0;
        int childTop=0;
        if (lp.isDecor) {
          final int hgrav=lp.gravity & Gravity.HORIZONTAL_GRAVITY_MASK;
          final int vgrav=lp.gravity & Gravity.VERTICAL_GRAVITY_MASK;
switch (hgrav) {
default :
            childLeft=paddingLeft;
          break;
case Gravity.LEFT:
        childLeft=paddingLeft;
      paddingLeft+=child.getMeasuredWidth();
    break;
case Gravity.CENTER_HORIZONTAL:
  childLeft=Math.max((width - child.getMeasuredWidth()) / 2,paddingLeft);
break;
case Gravity.RIGHT:
childLeft=width - paddingRight - child.getMeasuredWidth();
paddingRight+=child.getMeasuredWidth();
break;
}
switch (vgrav) {
default :
childTop=paddingTop;
break;
case Gravity.TOP:
childTop=paddingTop;
paddingTop+=child.getMeasuredHeight();
break;
case Gravity.CENTER_VERTICAL:
childTop=Math.max((height - child.getMeasuredHeight()) / 2,paddingTop);
break;
case Gravity.BOTTOM:
childTop=height - paddingBottom - child.getMeasuredHeight();
paddingBottom+=child.getMeasuredHeight();
break;
}
childLeft+=scrollX;
child.layout(childLeft,childTop,childLeft + child.getMeasuredWidth(),childTop + child.getMeasuredHeight());
decorCount++;
}
}
}
final int childWidth=width - paddingLeft - paddingRight;
for (int i=0; i < count; i++) {
final View child=getChildAt(i);
if (child.getVisibility() != GONE) {
final LayoutParams lp=(LayoutParams)child.getLayoutParams();
ItemInfo ii;
if (!lp.isDecor && (ii=infoForChild(child)) != null) {
int loff=(int)(childWidth * ii.offset);
int childLeft=paddingLeft + loff;
int childTop=paddingTop;
if (lp.needsMeasure) {
lp.needsMeasure=false;
final int widthSpec=MeasureSpec.makeMeasureSpec((int)(childWidth * lp.widthFactor),MeasureSpec.EXACTLY);
final int heightSpec=MeasureSpec.makeMeasureSpec((int)(height - paddingTop - paddingBottom),MeasureSpec.EXACTLY);
child.measure(widthSpec,heightSpec);
}
if (DEBUG) {
Log.v(TAG,"Positioning #" + i + " "+ child+ " f="+ ii.object+ ":"+ childLeft+ ","+ childTop+ " "+ child.getMeasuredWidth()+ "x"+ child.getMeasuredHeight());
}
child.layout(childLeft,childTop,childLeft + child.getMeasuredWidth(),childTop + child.getMeasuredHeight());
}
}
}
mTopPageBounds=paddingTop;
mBottomPageBounds=height - paddingBottom;
mDecorChildCount=decorCount;
if (mFirstLayout) {
scrollToItem(mCurItem,false,0,false);
}
mFirstLayout=false;
}
public boolean pageScrolled(int xpos){
if (mItems.size() == 0) {
if (mFirstLayout) {
return false;
}
mCalledSuper=false;
onPageScrolled(0,0,0);
if (!mCalledSuper) {
throw new IllegalStateException("onPageScrolled did not call superclass implementation");
}
return false;
}
final ItemInfo ii=infoForCurrentScrollPosition();
final int width=getClientWidth();
final int widthWithMargin=width + mPageMargin;
final float marginOffset=(float)mPageMargin / width;
final int currentPage=ii.position;
final float pageOffset=(((float)xpos / width) - ii.offset) / (ii.widthFactor + marginOffset);
final int offsetPixels=(int)(pageOffset * widthWithMargin);
mCalledSuper=false;
onPageScrolled(currentPage,pageOffset,offsetPixels);
if (!mCalledSuper) {
throw new IllegalStateException("onPageScrolled did not call superclass implementation");
}
return true;
}
protected void onPageScrolled(int position,float offset,int offsetPixels){
if (mDecorChildCount > 0) {
final int scrollX=getScrollX();
int paddingLeft=getPaddingLeft();
int paddingRight=getPaddingRight();
final int width=getWidth();
final int childCount=getChildCount();
for (int i=0; i < childCount; i++) {
final View child=getChildAt(i);
final LayoutParams lp=(LayoutParams)child.getLayoutParams();
if (!lp.isDecor) continue;
final int hgrav=lp.gravity & Gravity.HORIZONTAL_GRAVITY_MASK;
int childLeft=0;
switch (hgrav) {
default :
childLeft=paddingLeft;
break;
case Gravity.LEFT:
childLeft=paddingLeft;
paddingLeft+=child.getWidth();
break;
case Gravity.CENTER_HORIZONTAL:
childLeft=Math.max((width - child.getMeasuredWidth()) / 2,paddingLeft);
break;
case Gravity.RIGHT:
childLeft=width - paddingRight - child.getMeasuredWidth();
paddingRight+=child.getMeasuredWidth();
break;
}
childLeft+=scrollX;
final int childOffset=childLeft - child.getLeft();
if (childOffset != 0) {
child.offsetLeftAndRight(childOffset);
}
}
}
dispatchOnPageScrolled(position,offset,offsetPixels);
if (mPageTransformer != null) {
final int scrollX=getScrollX();
final int childCount=getChildCount();
for (int i=0; i < childCount; i++) {
final View child=getChildAt(i);
final LayoutParams lp=(LayoutParams)child.getLayoutParams();
if (lp.isDecor) continue;
final float transformPos=(float)(child.getLeft() - scrollX) / getClientWidth();
mPageTransformer.transformPage(child,transformPos);
}
}
mCalledSuper=true;
}
private void dispatchOnPageScrolled(int position,float offset,int offsetPixels){
if (mOnPageChangeListener != null) {
mOnPageChangeListener.onPageScrolled(position,offset,offsetPixels);
}
if (mOnPageChangeListeners != null) {
for (int i=0, z=mOnPageChangeListeners.size(); i < z; i++) {
OnPageChangeListener listener=mOnPageChangeListeners.get(i);
if (listener != null) {
listener.onPageScrolled(position,offset,offsetPixels);
}
}
}
if (mInternalPageChangeListener != null) {
mInternalPageChangeListener.onPageScrolled(position,offset,offsetPixels);
}
}
private void dispatchOnPageSelected(int position){
if (mOnPageChangeListener != null) {
mOnPageChangeListener.onPageSelected(position);
}
if (mOnPageChangeListeners != null) {
for (int i=0, z=mOnPageChangeListeners.size(); i < z; i++) {
OnPageChangeListener listener=mOnPageChangeListeners.get(i);
if (listener != null) {
listener.onPageSelected(position);
}
}
}
if (mInternalPageChangeListener != null) {
mInternalPageChangeListener.onPageSelected(position);
}
}
private boolean performDrag(float x,float y){
boolean needsInvalidate=false;
final float dX=mLastMotionX - x;
mLastMotionX=x;
final float releaseConsumed=releaseHorizontalGlow(dX,y);
final float deltaX=dX - releaseConsumed;
if (releaseConsumed != 0) {
needsInvalidate=true;
}
if (Math.abs(deltaX) < 0.0001f) {
return needsInvalidate;
}
float oldScrollX=getScrollX();
float scrollX=oldScrollX + deltaX;
final int width=getClientWidth();
float leftBound=width * mFirstOffset;
float rightBound=width * mLastOffset;
boolean leftAbsolute=true;
boolean rightAbsolute=true;
final ItemInfo firstItem=mItems.get(0);
final ItemInfo lastItem=mItems.get(mItems.size() - 1);
if (firstItem.position != 0) {
leftAbsolute=false;
leftBound=firstItem.offset * width;
}
if (lastItem.position != mAdapter.getCount() - 1) {
rightAbsolute=false;
rightBound=lastItem.offset * width;
}
if (scrollX < leftBound) {
if (leftAbsolute) {
float over=leftBound - scrollX;
//EdgeEffectCompat.onPullDistance(mLeftEdge,over / width,1 - y / getHeight());
needsInvalidate=true;
}
scrollX=leftBound;
}
 else if (scrollX > rightBound) {
if (rightAbsolute) {
float over=scrollX - rightBound;
//EdgeEffectCompat.onPullDistance(mRightEdge,over / width,y / getHeight());
needsInvalidate=true;
}
scrollX=rightBound;
}
mLastMotionX+=scrollX - (int)scrollX;
scrollTo((int)scrollX,getScrollY());
pageScrolled((int)scrollX);
return needsInvalidate;
}
private ItemInfo infoForCurrentScrollPosition(){
final int width=getClientWidth();
final float scrollOffset=width > 0 ? (float)getScrollX() / width : 0;
final float marginOffset=width > 0 ? (float)mPageMargin / width : 0;
int lastPos=-1;
float lastOffset=0.f;
float lastWidth=0.f;
boolean first=true;
ItemInfo lastItem=null;
for (int i=0; i < mItems.size(); i++) {
ItemInfo ii=mItems.get(i);
float offset;
if (!first && ii.position != lastPos + 1) {
ii=mTempItem;
ii.offset=lastOffset + lastWidth + marginOffset;
ii.position=lastPos + 1;
ii.widthFactor=mAdapter.getPageWidth(ii.position);
i--;
}
offset=ii.offset;
final float leftBound=offset;
final float rightBound=offset + ii.widthFactor + marginOffset;
if (first || scrollOffset >= leftBound) {
if (scrollOffset < rightBound || i == mItems.size() - 1) {
return ii;
}
}
 else {
return lastItem;
}
first=false;
lastPos=ii.position;
lastOffset=offset;
lastWidth=ii.widthFactor;
lastItem=ii;
}
return lastItem;
}
private int determineTargetPage(int currentPage,float pageOffset,int velocity,int deltaX){
int targetPage;
if (Math.abs(deltaX) > mFlingDistance && Math.abs(velocity) > mMinimumVelocity /*&& EdgeEffectCompat.getDistance(mLeftEdge) == 0 && EdgeEffectCompat.getDistance(mRightEdge) == 0*/) {
targetPage=velocity > 0 ? currentPage : currentPage + 1;
}
 else {
final float truncator=currentPage >= mCurItem ? 0.4f : 0.6f;
targetPage=currentPage + (int)(pageOffset + truncator);
}
if (mItems.size() > 0) {
final ItemInfo firstItem=mItems.get(0);
final ItemInfo lastItem=mItems.get(mItems.size() - 1);
targetPage=Math.max(firstItem.position,Math.min(targetPage,lastItem.position));
}
return targetPage;
}
protected void onDraw(Canvas canvas){
super.onDraw(canvas);
if (mPageMargin > 0 && mMarginDrawable != null && mItems.size() > 0 && mAdapter != null) {
final int scrollX=getScrollX();
final int width=getWidth();
final float marginOffset=(float)mPageMargin / width;
int itemIndex=0;
ItemInfo ii=mItems.get(0);
float offset=ii.offset;
final int itemCount=mItems.size();
final int firstPos=ii.position;
final int lastPos=mItems.get(itemCount - 1).position;
for (int pos=firstPos; pos < lastPos; pos++) {
while (pos > ii.position && itemIndex < itemCount) {
ii=mItems.get(++itemIndex);
}
float drawAt;
if (pos == ii.position) {
drawAt=(ii.offset + ii.widthFactor) * width;
offset=ii.offset + ii.widthFactor + marginOffset;
}
 else {
float widthFactor=mAdapter.getPageWidth(pos);
drawAt=(offset + widthFactor) * width;
offset+=widthFactor + marginOffset;
}
if (drawAt + mPageMargin > scrollX || true) {
mMarginDrawable.setBounds(Math.round(drawAt),mTopPageBounds,Math.round(drawAt + mPageMargin),mBottomPageBounds);
mMarginDrawable.draw(canvas);
}
if (drawAt > scrollX + width) {
break;
}
}
}
}
public boolean beginFakeDrag(){
if (mIsBeingDragged) {
return false;
}
mFakeDragging=true;
//setScrollState(SCROLL_STATE_DRAGGING);
mInitialMotionX=mLastMotionX=0;
if (mVelocityTracker == null) {
//mVelocityTracker=VelocityTracker.obtain();
}
 else {
//mVelocityTracker.clear();
}
//final long time=SystemClock.uptimeMillis();
//final MotionEvent ev=MotionEvent.obtain(time,time,MotionEvent.ACTION_DOWN,0,0,0);
//mVelocityTracker.addMovement(ev);
//ev.recycle();
//mFakeDragBeginTime=time;
return true;
}
public void endFakeDrag(){
if (!mFakeDragging) {
throw new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
}
if (mAdapter != null) {
//final VelocityTracker velocityTracker=mVelocityTracker;
//velocityTracker.computeCurrentVelocity(1000,mMaximumVelocity);
int initialVelocity=0;//(int)velocityTracker.getXVelocity(mActivePointerId);
//mPopulatePending=true;
final int width=getClientWidth();
final int scrollX=getScrollX();
final ItemInfo ii=infoForCurrentScrollPosition();
final int currentPage=ii.position;
final float pageOffset=(((float)scrollX / width) - ii.offset) / ii.widthFactor;
final int totalDelta=(int)(mLastMotionX - mInitialMotionX);
int nextPage=determineTargetPage(currentPage,pageOffset,initialVelocity,totalDelta);
setCurrentItemInternal(nextPage,true,true,initialVelocity);
}
endDrag();
mFakeDragging=false;
}
public void fakeDragBy(float xOffset){
if (!mFakeDragging) {
throw new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
}
if (mAdapter == null) {
return;
}
mLastMotionX+=xOffset;
float oldScrollX=getScrollX();
float scrollX=oldScrollX - xOffset;
final int width=getClientWidth();
float leftBound=width * mFirstOffset;
float rightBound=width * mLastOffset;
final ItemInfo firstItem=mItems.get(0);
final ItemInfo lastItem=mItems.get(mItems.size() - 1);
if (firstItem.position != 0) {
leftBound=firstItem.offset * width;
}
if (lastItem.position != mAdapter.getCount() - 1) {
rightBound=lastItem.offset * width;
}
if (scrollX < leftBound) {
scrollX=leftBound;
}
 else if (scrollX > rightBound) {
scrollX=rightBound;
}
mLastMotionX+=scrollX - (int)scrollX;
scrollTo((int)scrollX,getScrollY());
pageScrolled((int)scrollX);
//final long time=SystemClock.uptimeMillis();
//final MotionEvent ev=MotionEvent.obtain(mFakeDragBeginTime,time,MotionEvent.ACTION_MOVE,mLastMotionX,0,0);
//mVelocityTracker.addMovement(ev);
//ev.recycle();
}
public boolean isFakeDragging(){
return mFakeDragging;
}
private void endDrag(){
mIsBeingDragged=false;
mIsUnableToDrag=false;
if (mVelocityTracker != null) {
//mVelocityTracker.recycle();
mVelocityTracker=null;
}
}
public boolean canScrollHorizontally(int direction){
if (mAdapter == null) {
return false;
}
final int width=getClientWidth();
final int scrollX=getScrollX();
if (direction < 0) {
return (scrollX > (int)(width * mFirstOffset));
}
 else if (direction > 0) {
return (scrollX < (int)(width * mLastOffset));
}
 else {
return false;
}
}
protected boolean canScroll(View v,boolean checkV,int dx,int x,int y){
if (v instanceof ViewGroup) {
final ViewGroup group=(ViewGroup)v;
final int scrollX=v.getScrollX();
final int scrollY=v.getScrollY();
final int count=group.getChildCount();
for (int i=count - 1; i >= 0; i--) {
final View child=group.getChildAt(i);
if (x + scrollX >= child.getLeft() && x + scrollX < child.getRight() && y + scrollY >= child.getTop() && y + scrollY < child.getBottom() && canScroll(child,true,dx,x + scrollX - child.getLeft(),y + scrollY - child.getTop())) {
return true;
}
}
}
return checkV && v.canScrollHorizontally(-dx);
}
public boolean arrowScroll(int direction){
View currentFocused=findFocus();
if (currentFocused == this) {
currentFocused=null;
}
 else if (currentFocused != null) {
boolean isChild=false;
for (ViewParent parent=currentFocused.getParent(); parent instanceof ViewGroup; parent=parent.getParent()) {
if (parent == this) {
isChild=true;
break;
}
}
if (!isChild) {
final StringBuilder sb=new StringBuilder();
sb.append(currentFocused.getClass().getSimpleName());
for (ViewParent parent=currentFocused.getParent(); parent instanceof ViewGroup; parent=parent.getParent()) {
sb.append(" => ").append(parent.getClass().getSimpleName());
}
Log.e(TAG,"arrowScroll tried to find focus based on non-child " + "current focused view " + sb.toString());
currentFocused=null;
}
}
boolean handled=false;
View nextFocused=null;//FocusFinder.getInstance().findNextFocus(this,currentFocused,direction);
if (nextFocused != null && nextFocused != currentFocused) {
if (direction == View.FOCUS_LEFT) {
final int nextLeft=getChildRectInPagerCoordinates(mTempRect,nextFocused).left;
final int currLeft=getChildRectInPagerCoordinates(mTempRect,currentFocused).left;
if (currentFocused != null && nextLeft >= currLeft) {
handled=pageLeft();
}
 else {
handled=nextFocused.requestFocus();
}
}
 else if (direction == View.FOCUS_RIGHT) {
final int nextLeft=getChildRectInPagerCoordinates(mTempRect,nextFocused).left;
final int currLeft=getChildRectInPagerCoordinates(mTempRect,currentFocused).left;
if (currentFocused != null && nextLeft <= currLeft) {
handled=pageRight();
}
 else {
handled=nextFocused.requestFocus();
}
}
}
 else if (direction == FOCUS_LEFT || direction == FOCUS_BACKWARD) {
handled=pageLeft();
}
 else if (direction == FOCUS_RIGHT || direction == FOCUS_FORWARD) {
handled=pageRight();
}
if (handled) {
//playSoundEffect(SoundEffectConstants.getContantForFocusDirection(direction));
}
return handled;
}
private Rect getChildRectInPagerCoordinates(Rect outRect,View child){
if (outRect == null) {
outRect=new Rect();
}
if (child == null) {
outRect.set(0,0,0,0);
return outRect;
}
outRect.left=child.getLeft();
outRect.right=child.getRight();
outRect.top=child.getTop();
outRect.bottom=child.getBottom();
ViewParent parent=child.getParent();
while (parent instanceof ViewGroup && parent != this) {
final ViewGroup group=(ViewGroup)parent;
outRect.left+=group.getLeft();
outRect.right+=group.getRight();
outRect.top+=group.getTop();
outRect.bottom+=group.getBottom();
parent=group.getParent();
}
return outRect;
}
boolean pageLeft(){
if (mCurItem > 0) {
setCurrentItem(mCurItem - 1,true);
return true;
}
return false;
}
boolean pageRight(){
if (mAdapter != null && mCurItem < (mAdapter.getCount() - 1)) {
setCurrentItem(mCurItem + 1,true);
return true;
}
return false;
}
protected ViewGroup.LayoutParams generateDefaultLayoutParams(){
return new LayoutParams();
}
protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams p){
return generateDefaultLayoutParams();
}
protected boolean checkLayoutParams(ViewGroup.LayoutParams p){
return p instanceof LayoutParams && super.checkLayoutParams(p);
}
private class PagerObserver extends DataSetObserver {
PagerObserver(){
}
public void onChanged(){
dataSetChanged();
}
public void onInvalidated(){
dataSetChanged();
}
}
public static class LayoutParams extends ViewGroup.LayoutParams {
public boolean isDecor;
public int gravity;
float widthFactor=0.f;
boolean needsMeasure;
int position;
int childIndex;
public LayoutParams(){
super(MATCH_PARENT,MATCH_PARENT);
}
}
static class ViewPositionComparator implements Comparator<View> {
public int compare(View lhs,View rhs){
final LayoutParams llp=(LayoutParams)lhs.getLayoutParams();
final LayoutParams rlp=(LayoutParams)rhs.getLayoutParams();
if (llp.isDecor != rlp.isDecor) {
return llp.isDecor ? 1 : -1;
}
return llp.position - rlp.position;
}
}
Object mVelocityTracker;
private void completeScroll(boolean postEvents){
}
protected void smoothScrollTo(int x,int y,int velocity){
}
protected void scrollTo(int x,int y){
}
private void setScrollingCacheEnabled(boolean b){
}
private void setChildrenDrawingOrderEnabled(boolean hasTransformer){
}
private float releaseHorizontalGlow(float dX,float y){
return 0;
}
private boolean isDecorView(View child){
return child instanceof IDecorView;
}
public void redraw(Canvas canvas){
onDraw(canvas);
}
public static interface IDecorView {
}
public boolean isEmpty(){
return mItems.isEmpty();
}
}
