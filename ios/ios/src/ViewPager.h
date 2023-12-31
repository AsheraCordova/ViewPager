//
//  Generated by the J2ObjC translator.  DO NOT EDIT!
//  source: D:\Java\git\core-ios-widgets\IOSViewPagerPlugin\src\main\java\androidx\viewpager\widget\ViewPager.java
//

#include "J2ObjC_header.h"

#pragma push_macro("INCLUDE_ALL_ViewPager")
#ifdef RESTRICT_ViewPager
#define INCLUDE_ALL_ViewPager 0
#else
#define INCLUDE_ALL_ViewPager 1
#endif
#undef RESTRICT_ViewPager

#if !defined (ASViewPager_) && (INCLUDE_ALL_ViewPager || defined(INCLUDE_ASViewPager))
#define ASViewPager_

#define RESTRICT_ViewGroup 1
#define INCLUDE_ADViewGroup 1
#include "ViewGroup.h"

@class ADDrawable;
@class ADView;
@class ADViewGroup_LayoutParams;
@class ASPagerAdapter;
@class ASViewPager_ItemInfo;
@protocol ADCanvas;
@protocol ASViewPager_OnAdapterChangeListener;
@protocol ASViewPager_OnPageChangeListener;
@protocol ASViewPager_PageTransformer;

@interface ASViewPager : ADViewGroup {
 @public
  ASPagerAdapter *mAdapter_;
  jint mCurItem_;
  id mVelocityTracker_;
}

#pragma mark Public

- (instancetype)init;

- (void)addOnAdapterChangeListenerWithASViewPager_OnAdapterChangeListener:(id<ASViewPager_OnAdapterChangeListener>)listener;

- (void)addViewWithADView:(ADView *)child
                  withInt:(jint)index
withADViewGroup_LayoutParams:(ADViewGroup_LayoutParams *)params;

- (jboolean)arrowScrollWithInt:(jint)direction;

- (jboolean)beginFakeDrag;

- (jboolean)canScrollHorizontallyWithInt:(jint)direction;

- (void)endFakeDrag;

- (void)fakeDragByWithFloat:(jfloat)xOffset;

- (ASPagerAdapter *)getAdapter;

- (jint)getCurrentItem;

- (jint)getOffscreenPageLimit;

- (jint)getPageMargin;

- (jboolean)isEmpty;

- (jboolean)isFakeDragging;

- (jboolean)pageScrolledWithInt:(jint)xpos;

- (void)redrawWithADCanvas:(id<ADCanvas>)canvas;

- (void)removeOnAdapterChangeListenerWithASViewPager_OnAdapterChangeListener:(id<ASViewPager_OnAdapterChangeListener>)listener;

- (void)scrollToItemWithInt:(jint)item
                withBoolean:(jboolean)smoothScroll
                    withInt:(jint)velocity
                withBoolean:(jboolean)dispatchSelected;

- (void)setAdapterWithASPagerAdapter:(ASPagerAdapter *)adapter;

- (void)setCurrentItemWithInt:(jint)item;

- (void)setCurrentItemWithInt:(jint)item
                  withBoolean:(jboolean)smoothScroll;

- (void)setOffscreenPageLimitWithInt:(jint)limit;

- (void)setOnPageChangeListenerWithASViewPager_OnPageChangeListener:(id<ASViewPager_OnPageChangeListener>)listener;

- (void)setPageMarginWithInt:(jint)marginPixels;

- (void)setPageMarginDrawableWithADDrawable:(ADDrawable *)d;

- (void)setPageTransformerWithBoolean:(jboolean)reverseDrawingOrder
      withASViewPager_PageTransformer:(id<ASViewPager_PageTransformer>)transformer;

- (void)setPageTransformerWithBoolean:(jboolean)reverseDrawingOrder
      withASViewPager_PageTransformer:(id<ASViewPager_PageTransformer>)transformer
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

- (ASViewPager_ItemInfo *)addNewItemWithInt:(jint)position
                                    withInt:(jint)index;

- (void)dataSetChanged;

- (ASViewPager_ItemInfo *)infoForAnyChildWithADView:(ADView *)child;

- (ASViewPager_ItemInfo *)infoForChildWithADView:(ADView *)child;

- (ASViewPager_ItemInfo *)infoForPositionWithInt:(jint)position;

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

- (id<ASViewPager_OnPageChangeListener>)setInternalPageChangeListenerWithASViewPager_OnPageChangeListener:(id<ASViewPager_OnPageChangeListener>)listener;

@end

J2OBJC_STATIC_INIT(ASViewPager)

J2OBJC_FIELD_SETTER(ASViewPager, mAdapter_, ASPagerAdapter *)
J2OBJC_FIELD_SETTER(ASViewPager, mVelocityTracker_, id)

inline jint ASViewPager_get_SCROLL_STATE_IDLE(void);
#define ASViewPager_SCROLL_STATE_IDLE 0
J2OBJC_STATIC_FIELD_CONSTANT(ASViewPager, SCROLL_STATE_IDLE, jint)

inline jint ASViewPager_get_SCROLL_STATE_DRAGGING(void);
#define ASViewPager_SCROLL_STATE_DRAGGING 1
J2OBJC_STATIC_FIELD_CONSTANT(ASViewPager, SCROLL_STATE_DRAGGING, jint)

inline jint ASViewPager_get_SCROLL_STATE_SETTLING(void);
#define ASViewPager_SCROLL_STATE_SETTLING 2
J2OBJC_STATIC_FIELD_CONSTANT(ASViewPager, SCROLL_STATE_SETTLING, jint)

FOUNDATION_EXPORT void ASViewPager_init(ASViewPager *self);

FOUNDATION_EXPORT ASViewPager *new_ASViewPager_init(void) NS_RETURNS_RETAINED;

FOUNDATION_EXPORT ASViewPager *create_ASViewPager_init(void);

J2OBJC_TYPE_LITERAL_HEADER(ASViewPager)

@compatibility_alias AndroidxViewpagerWidgetViewPager ASViewPager;

#endif

#if !defined (ASViewPager_ItemInfo_) && (INCLUDE_ALL_ViewPager || defined(INCLUDE_ASViewPager_ItemInfo))
#define ASViewPager_ItemInfo_

@interface ASViewPager_ItemInfo : NSObject {
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

J2OBJC_EMPTY_STATIC_INIT(ASViewPager_ItemInfo)

J2OBJC_FIELD_SETTER(ASViewPager_ItemInfo, object_, id)

FOUNDATION_EXPORT void ASViewPager_ItemInfo_init(ASViewPager_ItemInfo *self);

FOUNDATION_EXPORT ASViewPager_ItemInfo *new_ASViewPager_ItemInfo_init(void) NS_RETURNS_RETAINED;

FOUNDATION_EXPORT ASViewPager_ItemInfo *create_ASViewPager_ItemInfo_init(void);

J2OBJC_TYPE_LITERAL_HEADER(ASViewPager_ItemInfo)

#endif

#if !defined (ASViewPager_OnPageChangeListener_) && (INCLUDE_ALL_ViewPager || defined(INCLUDE_ASViewPager_OnPageChangeListener))
#define ASViewPager_OnPageChangeListener_

@protocol ASViewPager_OnPageChangeListener < JavaObject >

- (void)onPageScrolledWithInt:(jint)position
                    withFloat:(jfloat)positionOffset
                      withInt:(jint)positionOffsetPixels;

- (void)onPageSelectedWithInt:(jint)position;

- (void)onPageScrollStateChangedWithInt:(jint)state;

@end

J2OBJC_EMPTY_STATIC_INIT(ASViewPager_OnPageChangeListener)

J2OBJC_TYPE_LITERAL_HEADER(ASViewPager_OnPageChangeListener)

#endif

#if !defined (ASViewPager_PageTransformer_) && (INCLUDE_ALL_ViewPager || defined(INCLUDE_ASViewPager_PageTransformer))
#define ASViewPager_PageTransformer_

@class ADView;

@protocol ASViewPager_PageTransformer < JavaObject >

- (void)transformPageWithADView:(ADView *)page
                      withFloat:(jfloat)position;

@end

J2OBJC_EMPTY_STATIC_INIT(ASViewPager_PageTransformer)

J2OBJC_TYPE_LITERAL_HEADER(ASViewPager_PageTransformer)

#endif

#if !defined (ASViewPager_OnAdapterChangeListener_) && (INCLUDE_ALL_ViewPager || defined(INCLUDE_ASViewPager_OnAdapterChangeListener))
#define ASViewPager_OnAdapterChangeListener_

@class ASPagerAdapter;
@class ASViewPager;

@protocol ASViewPager_OnAdapterChangeListener < JavaObject >

- (void)onAdapterChangedWithASViewPager:(ASViewPager *)viewPager
                     withASPagerAdapter:(ASPagerAdapter *)oldAdapter
                     withASPagerAdapter:(ASPagerAdapter *)newAdapter;

@end

J2OBJC_EMPTY_STATIC_INIT(ASViewPager_OnAdapterChangeListener)

J2OBJC_TYPE_LITERAL_HEADER(ASViewPager_OnAdapterChangeListener)

#endif

#if !defined (ASViewPager_LayoutParams_) && (INCLUDE_ALL_ViewPager || defined(INCLUDE_ASViewPager_LayoutParams))
#define ASViewPager_LayoutParams_

#define RESTRICT_ViewGroup 1
#define INCLUDE_ADViewGroup_LayoutParams 1
#include "ViewGroup.h"

@interface ASViewPager_LayoutParams : ADViewGroup_LayoutParams {
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

J2OBJC_EMPTY_STATIC_INIT(ASViewPager_LayoutParams)

FOUNDATION_EXPORT void ASViewPager_LayoutParams_init(ASViewPager_LayoutParams *self);

FOUNDATION_EXPORT ASViewPager_LayoutParams *new_ASViewPager_LayoutParams_init(void) NS_RETURNS_RETAINED;

FOUNDATION_EXPORT ASViewPager_LayoutParams *create_ASViewPager_LayoutParams_init(void);

J2OBJC_TYPE_LITERAL_HEADER(ASViewPager_LayoutParams)

#endif

#if !defined (ASViewPager_ViewPositionComparator_) && (INCLUDE_ALL_ViewPager || defined(INCLUDE_ASViewPager_ViewPositionComparator))
#define ASViewPager_ViewPositionComparator_

#define RESTRICT_JavaUtilComparator 1
#define INCLUDE_JavaUtilComparator 1
#include "java/util/Comparator.h"

@class ADView;
@protocol JavaUtilFunctionFunction;
@protocol JavaUtilFunctionToDoubleFunction;
@protocol JavaUtilFunctionToIntFunction;
@protocol JavaUtilFunctionToLongFunction;

@interface ASViewPager_ViewPositionComparator : NSObject < JavaUtilComparator >

#pragma mark Public

- (jint)compareWithId:(ADView *)lhs
               withId:(ADView *)rhs;

#pragma mark Package-Private

- (instancetype)init;

@end

J2OBJC_EMPTY_STATIC_INIT(ASViewPager_ViewPositionComparator)

FOUNDATION_EXPORT void ASViewPager_ViewPositionComparator_init(ASViewPager_ViewPositionComparator *self);

FOUNDATION_EXPORT ASViewPager_ViewPositionComparator *new_ASViewPager_ViewPositionComparator_init(void) NS_RETURNS_RETAINED;

FOUNDATION_EXPORT ASViewPager_ViewPositionComparator *create_ASViewPager_ViewPositionComparator_init(void);

J2OBJC_TYPE_LITERAL_HEADER(ASViewPager_ViewPositionComparator)

#endif

#if !defined (ASViewPager_IDecorView_) && (INCLUDE_ALL_ViewPager || defined(INCLUDE_ASViewPager_IDecorView))
#define ASViewPager_IDecorView_

@protocol ASViewPager_IDecorView < JavaObject >

@end

J2OBJC_EMPTY_STATIC_INIT(ASViewPager_IDecorView)

J2OBJC_TYPE_LITERAL_HEADER(ASViewPager_IDecorView)

#endif

#pragma pop_macro("INCLUDE_ALL_ViewPager")
