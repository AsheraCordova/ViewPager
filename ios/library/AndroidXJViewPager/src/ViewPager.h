//
//  Generated by the J2ObjC translator.  DO NOT EDIT!
//  source: D:\Java\git\core-javafx-widget\AndroidXJViewPager\src\main\java\androidx\viewpager\widget\ViewPager.java
//

#include "J2ObjC_header.h"

#pragma push_macro("INCLUDE_ALL_ViewPager")
#ifdef RESTRICT_ViewPager
#define INCLUDE_ALL_ViewPager 0
#else
#define INCLUDE_ALL_ViewPager 1
#endif
#undef RESTRICT_ViewPager

#if !defined (ADXViewPager_) && (INCLUDE_ALL_ViewPager || defined(INCLUDE_ADXViewPager))
#define ADXViewPager_

#define RESTRICT_ViewGroup 1
#define INCLUDE_ADViewGroup 1
#include "ViewGroup.h"

@class ADDrawable;
@class ADView;
@class ADViewGroup_LayoutParams;
@class ADXPagerAdapter;
@class ADXViewPager_ItemInfo;
@protocol ADCanvas;
@protocol ADXViewPager_OnAdapterChangeListener;
@protocol ADXViewPager_OnPageChangeListener;
@protocol ADXViewPager_PageTransformer;

@interface ADXViewPager : ADViewGroup {
 @public
  ADXPagerAdapter *mAdapter_;
  jint mCurItem_;
  id mVelocityTracker_;
}

#pragma mark Public

- (instancetype)init;

- (void)addOnAdapterChangeListenerWithADXViewPager_OnAdapterChangeListener:(id<ADXViewPager_OnAdapterChangeListener>)listener;

- (void)addOnPageChangeListenerWithADXViewPager_OnPageChangeListener:(id<ADXViewPager_OnPageChangeListener>)listener;

- (void)addViewWithADView:(ADView *)child
                  withInt:(jint)index
withADViewGroup_LayoutParams:(ADViewGroup_LayoutParams *)params;

- (jboolean)arrowScrollWithInt:(jint)direction;

- (jboolean)beginFakeDrag;

- (jboolean)canScrollHorizontallyWithInt:(jint)direction;

- (void)endFakeDrag;

- (void)fakeDragByWithFloat:(jfloat)xOffset;

- (ADXPagerAdapter *)getAdapter;

- (jint)getCurrentItem;

- (jint)getOffscreenPageLimit;

- (jint)getPageMargin;

- (jboolean)isEmpty;

- (jboolean)isFakeDragging;

- (jboolean)pageScrolledWithInt:(jint)xpos;

- (void)redrawWithADCanvas:(id<ADCanvas>)canvas;

- (void)removeOnAdapterChangeListenerWithADXViewPager_OnAdapterChangeListener:(id<ADXViewPager_OnAdapterChangeListener>)listener;

- (void)removeOnPageChangeListenerWithADXViewPager_OnPageChangeListener:(id<ADXViewPager_OnPageChangeListener>)listener;

- (void)scrollToItemWithInt:(jint)item
                withBoolean:(jboolean)smoothScroll
                    withInt:(jint)velocity
                withBoolean:(jboolean)dispatchSelected;

- (void)setAdapterWithADXPagerAdapter:(ADXPagerAdapter *)adapter;

- (void)setCurrentItemWithInt:(jint)item;

- (void)setCurrentItemWithInt:(jint)item
                  withBoolean:(jboolean)smoothScroll;

- (void)setOffscreenPageLimitWithInt:(jint)limit;

- (void)setOnPageChangeListenerWithADXViewPager_OnPageChangeListener:(id<ADXViewPager_OnPageChangeListener>)listener;

- (void)setPageMarginWithInt:(jint)marginPixels;

- (void)setPageMarginDrawableWithADDrawable:(ADDrawable *)d;

- (void)setPageTransformerWithBoolean:(jboolean)reverseDrawingOrder
     withADXViewPager_PageTransformer:(id<ADXViewPager_PageTransformer>)transformer;

- (void)setPageTransformerWithBoolean:(jboolean)reverseDrawingOrder
     withADXViewPager_PageTransformer:(id<ADXViewPager_PageTransformer>)transformer
                              withInt:(jint)pageLayerType;

#pragma mark Protected

- (jboolean)canScrollWithADView:(ADView *)v
                    withBoolean:(jboolean)checkV
                        withInt:(jint)dx
                        withInt:(jint)x
                        withInt:(jint)y;

- (jboolean)checkLayoutParamsWithADViewGroup_LayoutParams:(ADViewGroup_LayoutParams *)p;

- (void)drawableStateChanged;

- (ADViewGroup_LayoutParams *)generateDefaultLayoutParams;

- (ADViewGroup_LayoutParams *)generateLayoutParamsWithADViewGroup_LayoutParams:(ADViewGroup_LayoutParams *)p;

- (void)onDrawWithADCanvas:(id<ADCanvas>)canvas;

- (void)onLayoutWithBoolean:(jboolean)changed
                    withInt:(jint)l
                    withInt:(jint)t
                    withInt:(jint)r
                    withInt:(jint)b;

- (void)onMeasureWithInt:(jint)widthMeasureSpec
                 withInt:(jint)heightMeasureSpec;

- (void)onPageScrolledWithInt:(jint)position
                    withFloat:(jfloat)offset
                      withInt:(jint)offsetPixels;

- (void)scrollToWithInt:(jint)x
                withInt:(jint)y;

- (void)smoothScrollToWithInt:(jint)x
                      withInt:(jint)y
                      withInt:(jint)velocity;

#pragma mark Package-Private

- (ADXViewPager_ItemInfo *)addNewItemWithInt:(jint)position
                                     withInt:(jint)index;

- (void)dataSetChanged;

- (ADXViewPager_ItemInfo *)infoForAnyChildWithADView:(ADView *)child;

- (ADXViewPager_ItemInfo *)infoForChildWithADView:(ADView *)child;

- (ADXViewPager_ItemInfo *)infoForPositionWithInt:(jint)position;

- (jboolean)pageLeft;

- (jboolean)pageRight;

- (void)populate;

- (void)populateWithInt:(jint)newCurrentItem;

- (void)setCurrentItemInternalWithInt:(jint)item
                          withBoolean:(jboolean)smoothScroll
                          withBoolean:(jboolean)always;

- (void)setCurrentItemInternalWithInt:(jint)item
                          withBoolean:(jboolean)smoothScroll
                          withBoolean:(jboolean)always
                              withInt:(jint)velocity;

- (id<ADXViewPager_OnPageChangeListener>)setInternalPageChangeListenerWithADXViewPager_OnPageChangeListener:(id<ADXViewPager_OnPageChangeListener>)listener;

@end

J2OBJC_STATIC_INIT(ADXViewPager)

J2OBJC_FIELD_SETTER(ADXViewPager, mAdapter_, ADXPagerAdapter *)
J2OBJC_FIELD_SETTER(ADXViewPager, mVelocityTracker_, id)

inline jint ADXViewPager_get_SCROLL_STATE_IDLE(void);
#define ADXViewPager_SCROLL_STATE_IDLE 0
J2OBJC_STATIC_FIELD_CONSTANT(ADXViewPager, SCROLL_STATE_IDLE, jint)

inline jint ADXViewPager_get_SCROLL_STATE_DRAGGING(void);
#define ADXViewPager_SCROLL_STATE_DRAGGING 1
J2OBJC_STATIC_FIELD_CONSTANT(ADXViewPager, SCROLL_STATE_DRAGGING, jint)

inline jint ADXViewPager_get_SCROLL_STATE_SETTLING(void);
#define ADXViewPager_SCROLL_STATE_SETTLING 2
J2OBJC_STATIC_FIELD_CONSTANT(ADXViewPager, SCROLL_STATE_SETTLING, jint)

FOUNDATION_EXPORT void ADXViewPager_init(ADXViewPager *self);

FOUNDATION_EXPORT ADXViewPager *new_ADXViewPager_init(void) NS_RETURNS_RETAINED;

FOUNDATION_EXPORT ADXViewPager *create_ADXViewPager_init(void);

J2OBJC_TYPE_LITERAL_HEADER(ADXViewPager)

@compatibility_alias AndroidxViewpagerWidgetViewPager ADXViewPager;

#endif

#if !defined (ADXViewPager_ItemInfo_) && (INCLUDE_ALL_ViewPager || defined(INCLUDE_ADXViewPager_ItemInfo))
#define ADXViewPager_ItemInfo_

@interface ADXViewPager_ItemInfo : NSObject {
 @public
  id object_;
  jint position_;
  jboolean scrolling_;
  jfloat widthFactor_;
  jfloat offset_;
}

#pragma mark Package-Private

- (instancetype)init;

@end

J2OBJC_EMPTY_STATIC_INIT(ADXViewPager_ItemInfo)

J2OBJC_FIELD_SETTER(ADXViewPager_ItemInfo, object_, id)

FOUNDATION_EXPORT void ADXViewPager_ItemInfo_init(ADXViewPager_ItemInfo *self);

FOUNDATION_EXPORT ADXViewPager_ItemInfo *new_ADXViewPager_ItemInfo_init(void) NS_RETURNS_RETAINED;

FOUNDATION_EXPORT ADXViewPager_ItemInfo *create_ADXViewPager_ItemInfo_init(void);

J2OBJC_TYPE_LITERAL_HEADER(ADXViewPager_ItemInfo)

#endif

#if !defined (ADXViewPager_OnPageChangeListener_) && (INCLUDE_ALL_ViewPager || defined(INCLUDE_ADXViewPager_OnPageChangeListener))
#define ADXViewPager_OnPageChangeListener_

@protocol ADXViewPager_OnPageChangeListener < JavaObject >

- (void)onPageScrolledWithInt:(jint)position
                    withFloat:(jfloat)positionOffset
                      withInt:(jint)positionOffsetPixels;

- (void)onPageSelectedWithInt:(jint)position;

- (void)onPageScrollStateChangedWithInt:(jint)state;

@end

J2OBJC_EMPTY_STATIC_INIT(ADXViewPager_OnPageChangeListener)

J2OBJC_TYPE_LITERAL_HEADER(ADXViewPager_OnPageChangeListener)

#endif

#if !defined (ADXViewPager_PageTransformer_) && (INCLUDE_ALL_ViewPager || defined(INCLUDE_ADXViewPager_PageTransformer))
#define ADXViewPager_PageTransformer_

@class ADView;

@protocol ADXViewPager_PageTransformer < JavaObject >

- (void)transformPageWithADView:(ADView *)page
                      withFloat:(jfloat)position;

@end

J2OBJC_EMPTY_STATIC_INIT(ADXViewPager_PageTransformer)

J2OBJC_TYPE_LITERAL_HEADER(ADXViewPager_PageTransformer)

#endif

#if !defined (ADXViewPager_OnAdapterChangeListener_) && (INCLUDE_ALL_ViewPager || defined(INCLUDE_ADXViewPager_OnAdapterChangeListener))
#define ADXViewPager_OnAdapterChangeListener_

@class ADXPagerAdapter;
@class ADXViewPager;

@protocol ADXViewPager_OnAdapterChangeListener < JavaObject >

- (void)onAdapterChangedWithADXViewPager:(ADXViewPager *)viewPager
                     withADXPagerAdapter:(ADXPagerAdapter *)oldAdapter
                     withADXPagerAdapter:(ADXPagerAdapter *)newAdapter;

@end

J2OBJC_EMPTY_STATIC_INIT(ADXViewPager_OnAdapterChangeListener)

J2OBJC_TYPE_LITERAL_HEADER(ADXViewPager_OnAdapterChangeListener)

#endif

#if !defined (ADXViewPager_LayoutParams_) && (INCLUDE_ALL_ViewPager || defined(INCLUDE_ADXViewPager_LayoutParams))
#define ADXViewPager_LayoutParams_

#define RESTRICT_ViewGroup 1
#define INCLUDE_ADViewGroup_LayoutParams 1
#include "ViewGroup.h"

@interface ADXViewPager_LayoutParams : ADViewGroup_LayoutParams {
 @public
  jboolean isDecor_;
  jint gravity_;
  jfloat widthFactor_;
  jboolean needsMeasure_;
  jint position_;
  jint childIndex_;
}

#pragma mark Public

- (instancetype)init;

// Disallowed inherited constructors, do not use.

- (instancetype)initWithADViewGroup_LayoutParams:(ADViewGroup_LayoutParams *)arg0 NS_UNAVAILABLE;

- (instancetype)initWithInt:(jint)arg0
                    withInt:(jint)arg1 NS_UNAVAILABLE;

@end

J2OBJC_EMPTY_STATIC_INIT(ADXViewPager_LayoutParams)

FOUNDATION_EXPORT void ADXViewPager_LayoutParams_init(ADXViewPager_LayoutParams *self);

FOUNDATION_EXPORT ADXViewPager_LayoutParams *new_ADXViewPager_LayoutParams_init(void) NS_RETURNS_RETAINED;

FOUNDATION_EXPORT ADXViewPager_LayoutParams *create_ADXViewPager_LayoutParams_init(void);

J2OBJC_TYPE_LITERAL_HEADER(ADXViewPager_LayoutParams)

#endif

#if !defined (ADXViewPager_ViewPositionComparator_) && (INCLUDE_ALL_ViewPager || defined(INCLUDE_ADXViewPager_ViewPositionComparator))
#define ADXViewPager_ViewPositionComparator_

#define RESTRICT_JavaUtilComparator 1
#define INCLUDE_JavaUtilComparator 1
#include "java/util/Comparator.h"

@class ADView;
@protocol JavaUtilFunctionFunction;
@protocol JavaUtilFunctionToDoubleFunction;
@protocol JavaUtilFunctionToIntFunction;
@protocol JavaUtilFunctionToLongFunction;

@interface ADXViewPager_ViewPositionComparator : NSObject < JavaUtilComparator >

#pragma mark Public

- (jint)compareWithId:(ADView *)lhs
               withId:(ADView *)rhs;

#pragma mark Package-Private

- (instancetype)init;

@end

J2OBJC_EMPTY_STATIC_INIT(ADXViewPager_ViewPositionComparator)

FOUNDATION_EXPORT void ADXViewPager_ViewPositionComparator_init(ADXViewPager_ViewPositionComparator *self);

FOUNDATION_EXPORT ADXViewPager_ViewPositionComparator *new_ADXViewPager_ViewPositionComparator_init(void) NS_RETURNS_RETAINED;

FOUNDATION_EXPORT ADXViewPager_ViewPositionComparator *create_ADXViewPager_ViewPositionComparator_init(void);

J2OBJC_TYPE_LITERAL_HEADER(ADXViewPager_ViewPositionComparator)

#endif

#if !defined (ADXViewPager_IDecorView_) && (INCLUDE_ALL_ViewPager || defined(INCLUDE_ADXViewPager_IDecorView))
#define ADXViewPager_IDecorView_

@protocol ADXViewPager_IDecorView < JavaObject >

@end

J2OBJC_EMPTY_STATIC_INIT(ADXViewPager_IDecorView)

J2OBJC_TYPE_LITERAL_HEADER(ADXViewPager_IDecorView)

#endif

#pragma pop_macro("INCLUDE_ALL_ViewPager")