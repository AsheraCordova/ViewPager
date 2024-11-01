//
//  Generated by the J2ObjC translator.  DO NOT EDIT!
//  source: D:\Java\git\core-ios-widgets\IOSViewPagerPlugin\src\main\java\com\ashera\viewpager\PagerTitleStripImpl.java
//

#include "J2ObjC_header.h"

#pragma push_macro("INCLUDE_ALL_PagerTitleStripImpl")
#ifdef RESTRICT_PagerTitleStripImpl
#define INCLUDE_ALL_PagerTitleStripImpl 0
#else
#define INCLUDE_ALL_PagerTitleStripImpl 1
#endif
#undef RESTRICT_PagerTitleStripImpl

#if !defined (ASPagerTitleStripImpl_) && (INCLUDE_ALL_PagerTitleStripImpl || defined(INCLUDE_ASPagerTitleStripImpl))
#define ASPagerTitleStripImpl_

#define RESTRICT_BaseHasWidgets 1
#define INCLUDE_ASBaseHasWidgets 1
#include "BaseHasWidgets.h"

@class ASPagerTitleStripImpl_PagerTitleStripBean;
@class ASPagerTitleStripImpl_PagerTitleStripCommandBuilder;
@class ASPagerTitleStripImpl_PagerTitleStripCommandParamsBuilder;
@class ASPagerTitleStripImpl_PagerTitleStripParamsBean;
@class ASWidgetAttribute;
@class IOSClass;
@protocol ASIFragment;
@protocol ASILifeCycleDecorator;
@protocol ASIWidget;
@protocol JavaUtilMap;

@interface ASPagerTitleStripImpl : ASBaseHasWidgets
@property id uiView;

#pragma mark Public

- (instancetype)init;

- (instancetype)initWithNSString:(NSString *)localname;

- (instancetype)initWithNSString:(NSString *)groupName
                    withNSString:(NSString *)localname;

- (void)addWithASIWidget:(id<ASIWidget>)w
                 withInt:(jint)index;

- (id)asNativeWidget;

- (id)asWidget;

- (jboolean)checkIosVersionWithNSString:(NSString *)v;

- (void)createWithASIFragment:(id<ASIFragment>)fragment
              withJavaUtilMap:(id<JavaUtilMap>)params;

- (void)createPaneWithJavaUtilMap:(id<JavaUtilMap>)params;

- (id)getAttributeWithASWidgetAttribute:(ASWidgetAttribute *)key
              withASILifeCycleDecorator:(id<ASILifeCycleDecorator>)decorator;

- (ASPagerTitleStripImpl_PagerTitleStripBean *)getBean;

- (ASPagerTitleStripImpl_PagerTitleStripCommandBuilder *)getBuilder;

- (id)getChildAttributeWithASIWidget:(id<ASIWidget>)w
               withASWidgetAttribute:(ASWidgetAttribute *)key;

- (ASPagerTitleStripImpl_PagerTitleStripParamsBean *)getParamsBean;

- (ASPagerTitleStripImpl_PagerTitleStripCommandParamsBuilder *)getParamsBuilder;

- (id)getPluginWithNSString:(NSString *)plugin;

- (IOSClass *)getViewClass;

- (void)invalidate;

- (void)loadAttributesWithNSString:(NSString *)localName;

- (id<ASIWidget>)newInstance OBJC_METHOD_FAMILY_NONE;

- (jboolean)removeWithInt:(jint)index;

- (jboolean)removeWithASIWidget:(id<ASIWidget>)w;

- (void)requestLayout;

- (void)setAttributeWithASWidgetAttribute:(ASWidgetAttribute *)key
                             withNSString:(NSString *)strValue
                                   withId:(id)objValue
                withASILifeCycleDecorator:(id<ASILifeCycleDecorator>)decorator;

- (void)setChildAttributeWithASIWidget:(id<ASIWidget>)w
                 withASWidgetAttribute:(ASWidgetAttribute *)key
                          withNSString:(NSString *)strValue
                                withId:(id)objValue;

- (void)setIdWithNSString:(NSString *)id_;

- (void)setVisibleWithBoolean:(jboolean)b;

@end

J2OBJC_EMPTY_STATIC_INIT(ASPagerTitleStripImpl)

inline NSString *ASPagerTitleStripImpl_get_LOCAL_NAME(void);
/*! INTERNAL ONLY - Use accessor function from above. */
FOUNDATION_EXPORT NSString *ASPagerTitleStripImpl_LOCAL_NAME;
J2OBJC_STATIC_FIELD_OBJ_FINAL(ASPagerTitleStripImpl, LOCAL_NAME, NSString *)

inline NSString *ASPagerTitleStripImpl_get_GROUP_NAME(void);
/*! INTERNAL ONLY - Use accessor function from above. */
FOUNDATION_EXPORT NSString *ASPagerTitleStripImpl_GROUP_NAME;
J2OBJC_STATIC_FIELD_OBJ_FINAL(ASPagerTitleStripImpl, GROUP_NAME, NSString *)

FOUNDATION_EXPORT void ASPagerTitleStripImpl_init(ASPagerTitleStripImpl *self);

FOUNDATION_EXPORT ASPagerTitleStripImpl *new_ASPagerTitleStripImpl_init(void) NS_RETURNS_RETAINED;

FOUNDATION_EXPORT ASPagerTitleStripImpl *create_ASPagerTitleStripImpl_init(void);

FOUNDATION_EXPORT void ASPagerTitleStripImpl_initWithNSString_(ASPagerTitleStripImpl *self, NSString *localname);

FOUNDATION_EXPORT ASPagerTitleStripImpl *new_ASPagerTitleStripImpl_initWithNSString_(NSString *localname) NS_RETURNS_RETAINED;

FOUNDATION_EXPORT ASPagerTitleStripImpl *create_ASPagerTitleStripImpl_initWithNSString_(NSString *localname);

FOUNDATION_EXPORT void ASPagerTitleStripImpl_initWithNSString_withNSString_(ASPagerTitleStripImpl *self, NSString *groupName, NSString *localname);

FOUNDATION_EXPORT ASPagerTitleStripImpl *new_ASPagerTitleStripImpl_initWithNSString_withNSString_(NSString *groupName, NSString *localname) NS_RETURNS_RETAINED;

FOUNDATION_EXPORT ASPagerTitleStripImpl *create_ASPagerTitleStripImpl_initWithNSString_withNSString_(NSString *groupName, NSString *localname);

J2OBJC_TYPE_LITERAL_HEADER(ASPagerTitleStripImpl)

@compatibility_alias ComAsheraViewpagerPagerTitleStripImpl ASPagerTitleStripImpl;

#endif

#if !defined (ASPagerTitleStripImpl_PagerTitleStripExt_) && (INCLUDE_ALL_PagerTitleStripImpl || defined(INCLUDE_ASPagerTitleStripImpl_PagerTitleStripExt))
#define ASPagerTitleStripImpl_PagerTitleStripExt_

#define RESTRICT_PagerTitleStrip 1
#define INCLUDE_ADXPagerTitleStrip 1
#include "PagerTitleStrip.h"

#define RESTRICT_ILifeCycleDecorator 1
#define INCLUDE_ASILifeCycleDecorator 1
#include "ILifeCycleDecorator.h"

#define RESTRICT_IMaxDimension 1
#define INCLUDE_ASIMaxDimension 1
#include "IMaxDimension.h"

@class ADRect;
@class ADView;
@class ASPagerTitleStripImpl;
@class ASWidgetAttribute;
@class IOSIntArray;
@class IOSObjectArray;
@protocol ASHasWidgets;
@protocol ASIWidget;
@protocol JavaUtilList;

@interface ASPagerTitleStripImpl_PagerTitleStripExt : ADXPagerTitleStrip < ASILifeCycleDecorator, ASIMaxDimension >

#pragma mark Public

- (instancetype)initWithASPagerTitleStripImpl:(ASPagerTitleStripImpl *)outer$;

- (void)drawableStateChanged;

- (void)endViewTransitionWithADView:(ADView *)view;

- (void)executeWithNSString:(NSString *)method
          withNSObjectArray:(IOSObjectArray *)canvas;

- (id)getAttributeWithASWidgetAttribute:(ASWidgetAttribute *)widgetAttribute;

- (void)getLocationOnScreenWithIntArray:(IOSIntArray *)appScreenLocation;

- (jint)getMaxHeight;

- (jint)getMaxWidth;

- (id<JavaUtilList>)getMethods;

- (id<ASIWidget>)getWidget;

- (void)getWindowVisibleDisplayFrameWithADRect:(ADRect *)displayFrame;

- (ADView *)inflateViewWithNSString:(NSString *)layout;

- (void)initialized OBJC_METHOD_FAMILY_NONE;

- (id<ASILifeCycleDecorator>)newInstanceWithASIWidget:(id<ASIWidget>)widget OBJC_METHOD_FAMILY_NONE;

- (void)offsetLeftAndRightWithInt:(jint)offset;

- (void)offsetTopAndBottomWithInt:(jint)offset;

- (void)onMeasureWithInt:(jint)widthMeasureSpec
                 withInt:(jint)heightMeasureSpec;

- (void)remeasure;

- (void)removeFromParent;

- (void)setAttributeWithASWidgetAttribute:(ASWidgetAttribute *)widgetAttribute
                             withNSString:(NSString *)strValue
                                   withId:(id)objValue;

- (void)setMaxHeightWithInt:(jint)height;

- (void)setMaxWidthWithInt:(jint)width;

- (void)setMyAttributeWithNSString:(NSString *)name
                            withId:(id)value;

- (void)setState0WithId:(id)value;

- (void)setState1WithId:(id)value;

- (void)setState2WithId:(id)value;

- (void)setState3WithId:(id)value;

- (void)setState4WithId:(id)value;

- (void)setVisibilityWithInt:(jint)visibility;

- (void)state0;

- (void)state1;

- (void)state2;

- (void)state3;

- (void)state4;

- (void)stateNo;

- (void)stateYes;

- (void)updateMeasuredDimensionWithInt:(jint)width
                               withInt:(jint)height;

#pragma mark Protected

- (void)onLayoutWithBoolean:(jboolean)changed
                    withInt:(jint)l
                    withInt:(jint)t
                    withInt:(jint)r
                    withInt:(jint)b;

// Disallowed inherited constructors, do not use.

- (instancetype)initWithASHasWidgets:(id<ASHasWidgets>)arg0 NS_UNAVAILABLE;

@end

J2OBJC_EMPTY_STATIC_INIT(ASPagerTitleStripImpl_PagerTitleStripExt)

FOUNDATION_EXPORT void ASPagerTitleStripImpl_PagerTitleStripExt_initWithASPagerTitleStripImpl_(ASPagerTitleStripImpl_PagerTitleStripExt *self, ASPagerTitleStripImpl *outer$);

FOUNDATION_EXPORT ASPagerTitleStripImpl_PagerTitleStripExt *new_ASPagerTitleStripImpl_PagerTitleStripExt_initWithASPagerTitleStripImpl_(ASPagerTitleStripImpl *outer$) NS_RETURNS_RETAINED;

FOUNDATION_EXPORT ASPagerTitleStripImpl_PagerTitleStripExt *create_ASPagerTitleStripImpl_PagerTitleStripExt_initWithASPagerTitleStripImpl_(ASPagerTitleStripImpl *outer$);

J2OBJC_TYPE_LITERAL_HEADER(ASPagerTitleStripImpl_PagerTitleStripExt)

#endif

#if !defined (ASPagerTitleStripImpl_PagerTitleStripCommandBuilder_) && (INCLUDE_ALL_PagerTitleStripImpl || defined(INCLUDE_ASPagerTitleStripImpl_PagerTitleStripCommandBuilder))
#define ASPagerTitleStripImpl_PagerTitleStripCommandBuilder_

#define RESTRICT_ViewGroupImpl 1
#define INCLUDE_ASViewGroupImpl_ViewGroupCommandBuilder 1
#include "ViewGroupImpl.h"

@class ASPagerTitleStripImpl;

@interface ASPagerTitleStripImpl_PagerTitleStripCommandBuilder : ASViewGroupImpl_ViewGroupCommandBuilder

#pragma mark Public

- (instancetype)initWithASPagerTitleStripImpl:(ASPagerTitleStripImpl *)outer$;

- (ASPagerTitleStripImpl_PagerTitleStripCommandBuilder *)addAllModelWithId:(id)arg0;

- (ASPagerTitleStripImpl_PagerTitleStripCommandBuilder *)addModelByIndexWithId:(id)arg0
                                                                        withId:(id)arg1;

- (ASPagerTitleStripImpl_PagerTitleStripCommandBuilder *)addModelWithId:(id)arg0;

- (ASPagerTitleStripImpl_PagerTitleStripCommandBuilder *)animatorXmlWithNSString:(NSString *)arg0;

- (ASPagerTitleStripImpl_PagerTitleStripCommandBuilder *)endAnimator;

- (ASPagerTitleStripImpl_PagerTitleStripCommandBuilder *)executeWithBoolean:(jboolean)setter;

- (ASPagerTitleStripImpl_PagerTitleStripCommandBuilder *)invalidate;

- (ASPagerTitleStripImpl_PagerTitleStripCommandBuilder *)notifyDataSetChangedWithBoolean:(jboolean)arg0;

- (ASPagerTitleStripImpl_PagerTitleStripCommandBuilder *)refreshUiFromModelWithNSString:(NSString *)arg0;

- (ASPagerTitleStripImpl_PagerTitleStripCommandBuilder *)removeModelAtIndexWithInt:(jint)arg0;

- (ASPagerTitleStripImpl_PagerTitleStripCommandBuilder *)removeModelByIdWithNSString:(NSString *)arg0;

- (ASPagerTitleStripImpl_PagerTitleStripCommandBuilder *)requestLayout;

- (ASPagerTitleStripImpl_PagerTitleStripCommandBuilder *)reset;

- (ASPagerTitleStripImpl_PagerTitleStripCommandBuilder *)setAddStatesFromChildrenWithBoolean:(jboolean)arg0;

- (ASPagerTitleStripImpl_PagerTitleStripCommandBuilder *)setAlphaWithFloat:(jfloat)arg0;

- (ASPagerTitleStripImpl_PagerTitleStripCommandBuilder *)setAnimateLayoutChangesWithBoolean:(jboolean)arg0;

- (ASPagerTitleStripImpl_PagerTitleStripCommandBuilder *)setAnimateParentHierarchyWithBoolean:(jboolean)arg0;

- (ASPagerTitleStripImpl_PagerTitleStripCommandBuilder *)setAsDragSourceWithNSString:(NSString *)arg0;

- (ASPagerTitleStripImpl_PagerTitleStripCommandBuilder *)setAttributeUnderTestWithNSString:(NSString *)arg0;

- (ASPagerTitleStripImpl_PagerTitleStripCommandBuilder *)setBackgroundRepeatWithNSString:(NSString *)arg0;

- (ASPagerTitleStripImpl_PagerTitleStripCommandBuilder *)setBackgroundTintModeWithNSString:(NSString *)arg0;

- (ASPagerTitleStripImpl_PagerTitleStripCommandBuilder *)setBackgroundTintWithNSString:(NSString *)arg0;

- (ASPagerTitleStripImpl_PagerTitleStripCommandBuilder *)setBackgroundWithNSString:(NSString *)arg0;

- (ASPagerTitleStripImpl_PagerTitleStripCommandBuilder *)setBottomWithNSString:(NSString *)arg0;

- (ASPagerTitleStripImpl_PagerTitleStripCommandBuilder *)setChildXmlWithNSString:(NSString *)arg0;

- (ASPagerTitleStripImpl_PagerTitleStripCommandBuilder *)setClickableWithBoolean:(jboolean)arg0;

- (ASPagerTitleStripImpl_PagerTitleStripCommandBuilder *)setClipChildrenWithBoolean:(jboolean)arg0;

- (ASPagerTitleStripImpl_PagerTitleStripCommandBuilder *)setClipToPaddingWithBoolean:(jboolean)arg0;

- (ASPagerTitleStripImpl_PagerTitleStripCommandBuilder *)setContentDescriptionWithNSString:(NSString *)arg0;

- (ASPagerTitleStripImpl_PagerTitleStripCommandBuilder *)setCustomErrorMessageKeysWithNSString:(NSString *)arg0;

- (ASPagerTitleStripImpl_PagerTitleStripCommandBuilder *)setCustomErrorMessageValuesWithNSString:(NSString *)arg0;

- (ASPagerTitleStripImpl_PagerTitleStripCommandBuilder *)setDuplicateParentStateWithBoolean:(jboolean)arg0;

- (ASPagerTitleStripImpl_PagerTitleStripCommandBuilder *)setElevationWithNSString:(NSString *)arg0;

- (ASPagerTitleStripImpl_PagerTitleStripCommandBuilder *)setEnabledWithBoolean:(jboolean)arg0;

- (ASPagerTitleStripImpl_PagerTitleStripCommandBuilder *)setErrorStyleWithNSString:(NSString *)arg0;

- (ASPagerTitleStripImpl_PagerTitleStripCommandBuilder *)setFocusableWithBoolean:(jboolean)arg0;

- (ASPagerTitleStripImpl_PagerTitleStripCommandBuilder *)setForegroundGravityWithNSString:(NSString *)arg0;

- (ASPagerTitleStripImpl_PagerTitleStripCommandBuilder *)setForegroundRepeatWithNSString:(NSString *)arg0;

- (ASPagerTitleStripImpl_PagerTitleStripCommandBuilder *)setForegroundTintModeWithNSString:(NSString *)arg0;

- (ASPagerTitleStripImpl_PagerTitleStripCommandBuilder *)setForegroundTintWithNSString:(NSString *)arg0;

- (ASPagerTitleStripImpl_PagerTitleStripCommandBuilder *)setForegroundWithNSString:(NSString *)arg0;

- (ASPagerTitleStripImpl_PagerTitleStripCommandBuilder *)setGravityWithNSString:(NSString *)value;

- (ASPagerTitleStripImpl_PagerTitleStripCommandBuilder *)setIdWithNSString:(NSString *)arg0;

- (ASPagerTitleStripImpl_PagerTitleStripCommandBuilder *)setInvalidateOnFrameChangeWithBoolean:(jboolean)arg0;

- (ASPagerTitleStripImpl_PagerTitleStripCommandBuilder *)setIosAccessibilityHintWithNSString:(NSString *)arg0;

- (ASPagerTitleStripImpl_PagerTitleStripCommandBuilder *)setIosAccessibilityIgnoresInvertColorsWithBoolean:(jboolean)arg0;

- (ASPagerTitleStripImpl_PagerTitleStripCommandBuilder *)setIosAccessibilityLabelWithNSString:(NSString *)arg0;

- (ASPagerTitleStripImpl_PagerTitleStripCommandBuilder *)setIosAccessibilityTraitsWithNSString:(NSString *)arg0;

- (ASPagerTitleStripImpl_PagerTitleStripCommandBuilder *)setIosAccessibilityValueWithNSString:(NSString *)arg0;

- (ASPagerTitleStripImpl_PagerTitleStripCommandBuilder *)setIosAlphaWithFloat:(jfloat)arg0;

- (ASPagerTitleStripImpl_PagerTitleStripCommandBuilder *)setIosAutoresizesSubviewsWithBoolean:(jboolean)arg0;

- (ASPagerTitleStripImpl_PagerTitleStripCommandBuilder *)setIosBackgroundColorWithNSString:(NSString *)arg0;

- (ASPagerTitleStripImpl_PagerTitleStripCommandBuilder *)setIosClearsContextBeforeDrawingWithBoolean:(jboolean)arg0;

- (ASPagerTitleStripImpl_PagerTitleStripCommandBuilder *)setIosClipsToBoundsWithBoolean:(jboolean)arg0;

- (ASPagerTitleStripImpl_PagerTitleStripCommandBuilder *)setIosContentScaleFactorWithFloat:(jfloat)arg0;

- (ASPagerTitleStripImpl_PagerTitleStripCommandBuilder *)setIosInsetsLayoutMarginsFromSafeAreaWithBoolean:(jboolean)arg0;

- (ASPagerTitleStripImpl_PagerTitleStripCommandBuilder *)setIosIsAccessibilityElementWithBoolean:(jboolean)arg0;

- (ASPagerTitleStripImpl_PagerTitleStripCommandBuilder *)setIosIsExclusiveTouchWithBoolean:(jboolean)arg0;

- (ASPagerTitleStripImpl_PagerTitleStripCommandBuilder *)setIosIsHiddenWithBoolean:(jboolean)arg0;

- (ASPagerTitleStripImpl_PagerTitleStripCommandBuilder *)setIosIsMultipleTouchEnabledWithBoolean:(jboolean)arg0;

- (ASPagerTitleStripImpl_PagerTitleStripCommandBuilder *)setIosIsOpaqueWithBoolean:(jboolean)arg0;

- (ASPagerTitleStripImpl_PagerTitleStripCommandBuilder *)setIosIsUserInteractionEnabledWithBoolean:(jboolean)arg0;

- (ASPagerTitleStripImpl_PagerTitleStripCommandBuilder *)setIosLargeContentImageWithNSString:(NSString *)arg0;

- (ASPagerTitleStripImpl_PagerTitleStripCommandBuilder *)setIosLargeContentTitleWithNSString:(NSString *)arg0;

- (ASPagerTitleStripImpl_PagerTitleStripCommandBuilder *)setIosLayerBorderColorWithNSString:(NSString *)arg0;

- (ASPagerTitleStripImpl_PagerTitleStripCommandBuilder *)setIosLayerBorderWidthWithNSString:(NSString *)arg0;

- (ASPagerTitleStripImpl_PagerTitleStripCommandBuilder *)setIosLayerCornerRadiusWithNSString:(NSString *)arg0;

- (ASPagerTitleStripImpl_PagerTitleStripCommandBuilder *)setIosLayerMasksToBoundsWithBoolean:(jboolean)arg0;

- (ASPagerTitleStripImpl_PagerTitleStripCommandBuilder *)setIosPreservesSuperviewLayoutMarginsWithBoolean:(jboolean)arg0;

- (ASPagerTitleStripImpl_PagerTitleStripCommandBuilder *)setIosRestorationIdentifierWithNSString:(NSString *)arg0;

- (ASPagerTitleStripImpl_PagerTitleStripCommandBuilder *)setIosScalesLargeContentImageWithBoolean:(jboolean)arg0;

- (ASPagerTitleStripImpl_PagerTitleStripCommandBuilder *)setIosShowsLargeContentViewerWithBoolean:(jboolean)arg0;

- (ASPagerTitleStripImpl_PagerTitleStripCommandBuilder *)setIosTagWithInt:(jint)arg0;

- (ASPagerTitleStripImpl_PagerTitleStripCommandBuilder *)setIosTintColorWithNSString:(NSString *)arg0;

- (ASPagerTitleStripImpl_PagerTitleStripCommandBuilder *)setIosTranslatesAutoresizingMaskIntoConstraintsWithBoolean:(jboolean)arg0;

- (ASPagerTitleStripImpl_PagerTitleStripCommandBuilder *)setKeepScreenOnWithBoolean:(jboolean)arg0;

- (ASPagerTitleStripImpl_PagerTitleStripCommandBuilder *)setLayoutDirectionWithNSString:(NSString *)arg0;

- (ASPagerTitleStripImpl_PagerTitleStripCommandBuilder *)setLayoutModeWithNSString:(NSString *)arg0;

- (ASPagerTitleStripImpl_PagerTitleStripCommandBuilder *)setLayoutTransitionDurationWithInt:(jint)arg0;

- (ASPagerTitleStripImpl_PagerTitleStripCommandBuilder *)setLayoutTransitionWithNSString:(NSString *)arg0;

- (ASPagerTitleStripImpl_PagerTitleStripCommandBuilder *)setLeftWithNSString:(NSString *)arg0;

- (ASPagerTitleStripImpl_PagerTitleStripCommandBuilder *)setListitemWithNSString:(NSString *)arg0;

- (ASPagerTitleStripImpl_PagerTitleStripCommandBuilder *)setLongClickableWithBoolean:(jboolean)arg0;

- (ASPagerTitleStripImpl_PagerTitleStripCommandBuilder *)setMaxHeightWithNSString:(NSString *)arg0;

- (ASPagerTitleStripImpl_PagerTitleStripCommandBuilder *)setMaxWidthWithNSString:(NSString *)arg0;

- (ASPagerTitleStripImpl_PagerTitleStripCommandBuilder *)setMinHeightWithNSString:(NSString *)arg0;

- (ASPagerTitleStripImpl_PagerTitleStripCommandBuilder *)setMinWidthWithNSString:(NSString *)arg0;

- (ASPagerTitleStripImpl_PagerTitleStripCommandBuilder *)setModelDescPathWithNSString:(NSString *)arg0;

- (ASPagerTitleStripImpl_PagerTitleStripCommandBuilder *)setModelForWithNSString:(NSString *)arg0;

- (ASPagerTitleStripImpl_PagerTitleStripCommandBuilder *)setModelIdPathWithNSString:(NSString *)arg0;

- (ASPagerTitleStripImpl_PagerTitleStripCommandBuilder *)setModelParamWithNSString:(NSString *)arg0;

- (ASPagerTitleStripImpl_PagerTitleStripCommandBuilder *)setModelPojoToUiParamsWithNSString:(NSString *)arg0;

- (ASPagerTitleStripImpl_PagerTitleStripCommandBuilder *)setModelPojoToUiWithNSString:(NSString *)arg0;

- (ASPagerTitleStripImpl_PagerTitleStripCommandBuilder *)setModelSyncEventsWithNSString:(NSString *)arg0;

- (ASPagerTitleStripImpl_PagerTitleStripCommandBuilder *)setModelUiToPojoEventIdsWithNSString:(NSString *)arg0;

- (ASPagerTitleStripImpl_PagerTitleStripCommandBuilder *)setModelUiToPojoWithNSString:(NSString *)arg0;

- (ASPagerTitleStripImpl_PagerTitleStripCommandBuilder *)setNonPrimaryAlphaWithFloat:(jfloat)value;

- (ASPagerTitleStripImpl_PagerTitleStripCommandBuilder *)setOnAnimationCancelWithNSString:(NSString *)arg0;

- (ASPagerTitleStripImpl_PagerTitleStripCommandBuilder *)setOnAnimationEndWithNSString:(NSString *)arg0;

- (ASPagerTitleStripImpl_PagerTitleStripCommandBuilder *)setOnAnimationRepeatWithNSString:(NSString *)arg0;

- (ASPagerTitleStripImpl_PagerTitleStripCommandBuilder *)setOnAnimationStartWithNSString:(NSString *)arg0;

- (ASPagerTitleStripImpl_PagerTitleStripCommandBuilder *)setOnChildViewAddedWithNSString:(NSString *)arg0;

- (ASPagerTitleStripImpl_PagerTitleStripCommandBuilder *)setOnChildViewRemovedWithNSString:(NSString *)arg0;

- (ASPagerTitleStripImpl_PagerTitleStripCommandBuilder *)setOnClickWithNSString:(NSString *)arg0;

- (ASPagerTitleStripImpl_PagerTitleStripCommandBuilder *)setOnDragWithNSString:(NSString *)arg0;

- (ASPagerTitleStripImpl_PagerTitleStripCommandBuilder *)setOnKeyWithNSString:(NSString *)arg0;

- (ASPagerTitleStripImpl_PagerTitleStripCommandBuilder *)setOnLongClickWithNSString:(NSString *)arg0;

- (ASPagerTitleStripImpl_PagerTitleStripCommandBuilder *)setOnSwipedWithNSString:(NSString *)arg0;

- (ASPagerTitleStripImpl_PagerTitleStripCommandBuilder *)setOnTouchWithNSString:(NSString *)arg0;

- (ASPagerTitleStripImpl_PagerTitleStripCommandBuilder *)setOutsideTouchableWithBoolean:(jboolean)arg0;

- (ASPagerTitleStripImpl_PagerTitleStripCommandBuilder *)setPaddingBottomWithNSString:(NSString *)arg0;

- (ASPagerTitleStripImpl_PagerTitleStripCommandBuilder *)setPaddingEndWithNSString:(NSString *)arg0;

- (ASPagerTitleStripImpl_PagerTitleStripCommandBuilder *)setPaddingHorizontalWithNSString:(NSString *)arg0;

- (ASPagerTitleStripImpl_PagerTitleStripCommandBuilder *)setPaddingLeftWithNSString:(NSString *)arg0;

- (ASPagerTitleStripImpl_PagerTitleStripCommandBuilder *)setPaddingRightWithNSString:(NSString *)arg0;

- (ASPagerTitleStripImpl_PagerTitleStripCommandBuilder *)setPaddingStartWithNSString:(NSString *)arg0;

- (ASPagerTitleStripImpl_PagerTitleStripCommandBuilder *)setPaddingTopWithNSString:(NSString *)arg0;

- (ASPagerTitleStripImpl_PagerTitleStripCommandBuilder *)setPaddingVerticalWithNSString:(NSString *)arg0;

- (ASPagerTitleStripImpl_PagerTitleStripCommandBuilder *)setPaddingWithNSString:(NSString *)arg0;

- (ASPagerTitleStripImpl_PagerTitleStripCommandBuilder *)setRightWithNSString:(NSString *)arg0;

- (ASPagerTitleStripImpl_PagerTitleStripCommandBuilder *)setRotationWithFloat:(jfloat)arg0;

- (ASPagerTitleStripImpl_PagerTitleStripCommandBuilder *)setRotationXWithFloat:(jfloat)arg0;

- (ASPagerTitleStripImpl_PagerTitleStripCommandBuilder *)setRotationYWithFloat:(jfloat)arg0;

- (ASPagerTitleStripImpl_PagerTitleStripCommandBuilder *)setScaleXWithFloat:(jfloat)arg0;

- (ASPagerTitleStripImpl_PagerTitleStripCommandBuilder *)setScaleYWithFloat:(jfloat)arg0;

- (ASPagerTitleStripImpl_PagerTitleStripCommandBuilder *)setSelectedWithBoolean:(jboolean)arg0;

- (ASPagerTitleStripImpl_PagerTitleStripCommandBuilder *)setStyleWithNSString:(NSString *)arg0;

- (ASPagerTitleStripImpl_PagerTitleStripCommandBuilder *)setTextAlignmentWithNSString:(NSString *)arg0;

- (ASPagerTitleStripImpl_PagerTitleStripCommandBuilder *)setTextAppearanceWithNSString:(NSString *)value;

- (ASPagerTitleStripImpl_PagerTitleStripCommandBuilder *)setTextColorWithNSString:(NSString *)value;

- (ASPagerTitleStripImpl_PagerTitleStripCommandBuilder *)setTextDirectionWithNSString:(NSString *)arg0;

- (ASPagerTitleStripImpl_PagerTitleStripCommandBuilder *)setTextSizeWithNSString:(NSString *)value;

- (ASPagerTitleStripImpl_PagerTitleStripCommandBuilder *)setTextSpacingWithNSString:(NSString *)value;

- (ASPagerTitleStripImpl_PagerTitleStripCommandBuilder *)setTopWithNSString:(NSString *)arg0;

- (ASPagerTitleStripImpl_PagerTitleStripCommandBuilder *)setTransformPivotXWithNSString:(NSString *)arg0;

- (ASPagerTitleStripImpl_PagerTitleStripCommandBuilder *)setTransformPivotYWithNSString:(NSString *)arg0;

- (ASPagerTitleStripImpl_PagerTitleStripCommandBuilder *)setTranslationXWithNSString:(NSString *)arg0;

- (ASPagerTitleStripImpl_PagerTitleStripCommandBuilder *)setTranslationYWithNSString:(NSString *)arg0;

- (ASPagerTitleStripImpl_PagerTitleStripCommandBuilder *)setTranslationZWithNSString:(NSString *)arg0;

- (ASPagerTitleStripImpl_PagerTitleStripCommandBuilder *)setV_maxlengthWithNSString:(NSString *)arg0;

- (ASPagerTitleStripImpl_PagerTitleStripCommandBuilder *)setV_maxWithNSString:(NSString *)arg0;

- (ASPagerTitleStripImpl_PagerTitleStripCommandBuilder *)setV_minlengthWithNSString:(NSString *)arg0;

- (ASPagerTitleStripImpl_PagerTitleStripCommandBuilder *)setV_minWithNSString:(NSString *)arg0;

- (ASPagerTitleStripImpl_PagerTitleStripCommandBuilder *)setV_patternWithNSString:(NSString *)arg0;

- (ASPagerTitleStripImpl_PagerTitleStripCommandBuilder *)setV_requiredWithNSString:(NSString *)arg0;

- (ASPagerTitleStripImpl_PagerTitleStripCommandBuilder *)setV_typeWithNSString:(NSString *)arg0;

- (ASPagerTitleStripImpl_PagerTitleStripCommandBuilder *)setValidationErrorDisplayTypeWithNSString:(NSString *)arg0;

- (ASPagerTitleStripImpl_PagerTitleStripCommandBuilder *)setValidationWithNSString:(NSString *)arg0;

- (ASPagerTitleStripImpl_PagerTitleStripCommandBuilder *)setVisibilityWithNSString:(NSString *)arg0;

- (ASPagerTitleStripImpl_PagerTitleStripCommandBuilder *)setZIndexWithInt:(jint)arg0;

- (ASPagerTitleStripImpl_PagerTitleStripCommandBuilder *)startAnimator;

- (ASPagerTitleStripImpl_PagerTitleStripCommandBuilder *)tryGetAddStatesFromChildren;

- (ASPagerTitleStripImpl_PagerTitleStripCommandBuilder *)tryGetAlpha;

- (ASPagerTitleStripImpl_PagerTitleStripCommandBuilder *)tryGetBackground;

- (ASPagerTitleStripImpl_PagerTitleStripCommandBuilder *)tryGetBackgroundTint;

- (ASPagerTitleStripImpl_PagerTitleStripCommandBuilder *)tryGetBackgroundTintMode;

- (ASPagerTitleStripImpl_PagerTitleStripCommandBuilder *)tryGetBottom;

- (ASPagerTitleStripImpl_PagerTitleStripCommandBuilder *)tryGetClickable;

- (ASPagerTitleStripImpl_PagerTitleStripCommandBuilder *)tryGetClipChildren;

- (ASPagerTitleStripImpl_PagerTitleStripCommandBuilder *)tryGetClipToPadding;

- (ASPagerTitleStripImpl_PagerTitleStripCommandBuilder *)tryGetContentDescription;

- (ASPagerTitleStripImpl_PagerTitleStripCommandBuilder *)tryGetDuplicateParentState;

- (ASPagerTitleStripImpl_PagerTitleStripCommandBuilder *)tryGetEnabled;

- (ASPagerTitleStripImpl_PagerTitleStripCommandBuilder *)tryGetFocusable;

- (ASPagerTitleStripImpl_PagerTitleStripCommandBuilder *)tryGetForeground;

- (ASPagerTitleStripImpl_PagerTitleStripCommandBuilder *)tryGetForegroundGravity;

- (ASPagerTitleStripImpl_PagerTitleStripCommandBuilder *)tryGetForegroundTint;

- (ASPagerTitleStripImpl_PagerTitleStripCommandBuilder *)tryGetForegroundTintMode;

- (ASPagerTitleStripImpl_PagerTitleStripCommandBuilder *)tryGetId;

- (ASPagerTitleStripImpl_PagerTitleStripCommandBuilder *)tryGetIosAccessibilityHint;

- (ASPagerTitleStripImpl_PagerTitleStripCommandBuilder *)tryGetIosAccessibilityIgnoresInvertColors;

- (ASPagerTitleStripImpl_PagerTitleStripCommandBuilder *)tryGetIosAccessibilityLabel;

- (ASPagerTitleStripImpl_PagerTitleStripCommandBuilder *)tryGetIosAccessibilityTraits;

- (ASPagerTitleStripImpl_PagerTitleStripCommandBuilder *)tryGetIosAccessibilityValue;

- (ASPagerTitleStripImpl_PagerTitleStripCommandBuilder *)tryGetIosAlpha;

- (ASPagerTitleStripImpl_PagerTitleStripCommandBuilder *)tryGetIosAutoresizesSubviews;

- (ASPagerTitleStripImpl_PagerTitleStripCommandBuilder *)tryGetIosBackgroundColor;

- (ASPagerTitleStripImpl_PagerTitleStripCommandBuilder *)tryGetIosClearsContextBeforeDrawing;

- (ASPagerTitleStripImpl_PagerTitleStripCommandBuilder *)tryGetIosClipsToBounds;

- (ASPagerTitleStripImpl_PagerTitleStripCommandBuilder *)tryGetIosContentScaleFactor;

- (ASPagerTitleStripImpl_PagerTitleStripCommandBuilder *)tryGetIosInsetsLayoutMarginsFromSafeArea;

- (ASPagerTitleStripImpl_PagerTitleStripCommandBuilder *)tryGetIosIsAccessibilityElement;

- (ASPagerTitleStripImpl_PagerTitleStripCommandBuilder *)tryGetIosIsExclusiveTouch;

- (ASPagerTitleStripImpl_PagerTitleStripCommandBuilder *)tryGetIosIsFocused;

- (ASPagerTitleStripImpl_PagerTitleStripCommandBuilder *)tryGetIosIsHidden;

- (ASPagerTitleStripImpl_PagerTitleStripCommandBuilder *)tryGetIosIsMultipleTouchEnabled;

- (ASPagerTitleStripImpl_PagerTitleStripCommandBuilder *)tryGetIosIsOpaque;

- (ASPagerTitleStripImpl_PagerTitleStripCommandBuilder *)tryGetIosIsUserInteractionEnabled;

- (ASPagerTitleStripImpl_PagerTitleStripCommandBuilder *)tryGetIosLargeContentImage;

- (ASPagerTitleStripImpl_PagerTitleStripCommandBuilder *)tryGetIosLargeContentTitle;

- (ASPagerTitleStripImpl_PagerTitleStripCommandBuilder *)tryGetIosPreservesSuperviewLayoutMargins;

- (ASPagerTitleStripImpl_PagerTitleStripCommandBuilder *)tryGetIosRestorationIdentifier;

- (ASPagerTitleStripImpl_PagerTitleStripCommandBuilder *)tryGetIosScalesLargeContentImage;

- (ASPagerTitleStripImpl_PagerTitleStripCommandBuilder *)tryGetIosShowsLargeContentViewer;

- (ASPagerTitleStripImpl_PagerTitleStripCommandBuilder *)tryGetIosTag;

- (ASPagerTitleStripImpl_PagerTitleStripCommandBuilder *)tryGetIosTintColor;

- (ASPagerTitleStripImpl_PagerTitleStripCommandBuilder *)tryGetIosTranslatesAutoresizingMaskIntoConstraints;

- (ASPagerTitleStripImpl_PagerTitleStripCommandBuilder *)tryGetKeepScreenOn;

- (ASPagerTitleStripImpl_PagerTitleStripCommandBuilder *)tryGetLayoutDirection;

- (ASPagerTitleStripImpl_PagerTitleStripCommandBuilder *)tryGetLayoutMode;

- (ASPagerTitleStripImpl_PagerTitleStripCommandBuilder *)tryGetLeft;

- (ASPagerTitleStripImpl_PagerTitleStripCommandBuilder *)tryGetLongClickable;

- (ASPagerTitleStripImpl_PagerTitleStripCommandBuilder *)tryGetMaxHeight;

- (ASPagerTitleStripImpl_PagerTitleStripCommandBuilder *)tryGetMaxWidth;

- (ASPagerTitleStripImpl_PagerTitleStripCommandBuilder *)tryGetMinHeight;

- (ASPagerTitleStripImpl_PagerTitleStripCommandBuilder *)tryGetMinWidth;

- (ASPagerTitleStripImpl_PagerTitleStripCommandBuilder *)tryGetModelDescPath;

- (ASPagerTitleStripImpl_PagerTitleStripCommandBuilder *)tryGetModelIdPath;

- (ASPagerTitleStripImpl_PagerTitleStripCommandBuilder *)tryGetModelParam;

- (ASPagerTitleStripImpl_PagerTitleStripCommandBuilder *)tryGetModelPojoToUi;

- (ASPagerTitleStripImpl_PagerTitleStripCommandBuilder *)tryGetModelSyncEvents;

- (ASPagerTitleStripImpl_PagerTitleStripCommandBuilder *)tryGetModelUiToPojo;

- (ASPagerTitleStripImpl_PagerTitleStripCommandBuilder *)tryGetPaddingBottom;

- (ASPagerTitleStripImpl_PagerTitleStripCommandBuilder *)tryGetPaddingEnd;

- (ASPagerTitleStripImpl_PagerTitleStripCommandBuilder *)tryGetPaddingLeft;

- (ASPagerTitleStripImpl_PagerTitleStripCommandBuilder *)tryGetPaddingRight;

- (ASPagerTitleStripImpl_PagerTitleStripCommandBuilder *)tryGetPaddingStart;

- (ASPagerTitleStripImpl_PagerTitleStripCommandBuilder *)tryGetPaddingTop;

- (ASPagerTitleStripImpl_PagerTitleStripCommandBuilder *)tryGetRight;

- (ASPagerTitleStripImpl_PagerTitleStripCommandBuilder *)tryGetRotation;

- (ASPagerTitleStripImpl_PagerTitleStripCommandBuilder *)tryGetRotationX;

- (ASPagerTitleStripImpl_PagerTitleStripCommandBuilder *)tryGetRotationY;

- (ASPagerTitleStripImpl_PagerTitleStripCommandBuilder *)tryGetScaleX;

- (ASPagerTitleStripImpl_PagerTitleStripCommandBuilder *)tryGetScaleY;

- (ASPagerTitleStripImpl_PagerTitleStripCommandBuilder *)tryGetSelected;

- (ASPagerTitleStripImpl_PagerTitleStripCommandBuilder *)tryGetTextAlignment;

- (ASPagerTitleStripImpl_PagerTitleStripCommandBuilder *)tryGetTextDirection;

- (ASPagerTitleStripImpl_PagerTitleStripCommandBuilder *)tryGetTop;

- (ASPagerTitleStripImpl_PagerTitleStripCommandBuilder *)tryGetTransformPivotX;

- (ASPagerTitleStripImpl_PagerTitleStripCommandBuilder *)tryGetTransformPivotY;

- (ASPagerTitleStripImpl_PagerTitleStripCommandBuilder *)tryGetTranslationX;

- (ASPagerTitleStripImpl_PagerTitleStripCommandBuilder *)tryGetTranslationY;

- (ASPagerTitleStripImpl_PagerTitleStripCommandBuilder *)tryGetTranslationZ;

- (ASPagerTitleStripImpl_PagerTitleStripCommandBuilder *)tryGetValidateForm;

- (ASPagerTitleStripImpl_PagerTitleStripCommandBuilder *)tryGetVisibility;

- (ASPagerTitleStripImpl_PagerTitleStripCommandBuilder *)updateModelDataWithNSString:(NSString *)arg0
                                                                              withId:(id)arg1;

- (ASPagerTitleStripImpl_PagerTitleStripCommandBuilder *)validateFormWithNSString:(NSString *)arg0;

// Disallowed inherited constructors, do not use.

- (instancetype)init NS_UNAVAILABLE;

@end

J2OBJC_EMPTY_STATIC_INIT(ASPagerTitleStripImpl_PagerTitleStripCommandBuilder)

FOUNDATION_EXPORT void ASPagerTitleStripImpl_PagerTitleStripCommandBuilder_initWithASPagerTitleStripImpl_(ASPagerTitleStripImpl_PagerTitleStripCommandBuilder *self, ASPagerTitleStripImpl *outer$);

FOUNDATION_EXPORT ASPagerTitleStripImpl_PagerTitleStripCommandBuilder *new_ASPagerTitleStripImpl_PagerTitleStripCommandBuilder_initWithASPagerTitleStripImpl_(ASPagerTitleStripImpl *outer$) NS_RETURNS_RETAINED;

FOUNDATION_EXPORT ASPagerTitleStripImpl_PagerTitleStripCommandBuilder *create_ASPagerTitleStripImpl_PagerTitleStripCommandBuilder_initWithASPagerTitleStripImpl_(ASPagerTitleStripImpl *outer$);

J2OBJC_TYPE_LITERAL_HEADER(ASPagerTitleStripImpl_PagerTitleStripCommandBuilder)

#endif

#if !defined (ASPagerTitleStripImpl_PagerTitleStripBean_) && (INCLUDE_ALL_PagerTitleStripImpl || defined(INCLUDE_ASPagerTitleStripImpl_PagerTitleStripBean))
#define ASPagerTitleStripImpl_PagerTitleStripBean_

#define RESTRICT_ViewGroupImpl 1
#define INCLUDE_ASViewGroupImpl_ViewGroupBean 1
#include "ViewGroupImpl.h"

@class ASPagerTitleStripImpl;
@protocol ASIWidget;

@interface ASPagerTitleStripImpl_PagerTitleStripBean : ASViewGroupImpl_ViewGroupBean

#pragma mark Public

- (instancetype)initWithASPagerTitleStripImpl:(ASPagerTitleStripImpl *)outer$;

- (void)setGravityWithNSString:(NSString *)value;

- (void)setNonPrimaryAlphaWithFloat:(jfloat)value;

- (void)setTextAppearanceWithNSString:(NSString *)value;

- (void)setTextColorWithNSString:(NSString *)value;

- (void)setTextSizeWithNSString:(NSString *)value;

- (void)setTextSpacingWithNSString:(NSString *)value;

// Disallowed inherited constructors, do not use.

- (instancetype)initWithASIWidget:(id<ASIWidget>)arg0 NS_UNAVAILABLE;

@end

J2OBJC_EMPTY_STATIC_INIT(ASPagerTitleStripImpl_PagerTitleStripBean)

FOUNDATION_EXPORT void ASPagerTitleStripImpl_PagerTitleStripBean_initWithASPagerTitleStripImpl_(ASPagerTitleStripImpl_PagerTitleStripBean *self, ASPagerTitleStripImpl *outer$);

FOUNDATION_EXPORT ASPagerTitleStripImpl_PagerTitleStripBean *new_ASPagerTitleStripImpl_PagerTitleStripBean_initWithASPagerTitleStripImpl_(ASPagerTitleStripImpl *outer$) NS_RETURNS_RETAINED;

FOUNDATION_EXPORT ASPagerTitleStripImpl_PagerTitleStripBean *create_ASPagerTitleStripImpl_PagerTitleStripBean_initWithASPagerTitleStripImpl_(ASPagerTitleStripImpl *outer$);

J2OBJC_TYPE_LITERAL_HEADER(ASPagerTitleStripImpl_PagerTitleStripBean)

#endif

#if !defined (ASPagerTitleStripImpl_PagerTitleStripParamsBean_) && (INCLUDE_ALL_PagerTitleStripImpl || defined(INCLUDE_ASPagerTitleStripImpl_PagerTitleStripParamsBean))
#define ASPagerTitleStripImpl_PagerTitleStripParamsBean_

#define RESTRICT_ViewGroupImpl 1
#define INCLUDE_ASViewGroupImpl_ViewGroupParamsBean 1
#include "ViewGroupImpl.h"

@class ASPagerTitleStripImpl;

@interface ASPagerTitleStripImpl_PagerTitleStripParamsBean : ASViewGroupImpl_ViewGroupParamsBean

#pragma mark Public

- (instancetype)initWithASPagerTitleStripImpl:(ASPagerTitleStripImpl *)outer$;

// Disallowed inherited constructors, do not use.

- (instancetype)init NS_UNAVAILABLE;

@end

J2OBJC_EMPTY_STATIC_INIT(ASPagerTitleStripImpl_PagerTitleStripParamsBean)

FOUNDATION_EXPORT void ASPagerTitleStripImpl_PagerTitleStripParamsBean_initWithASPagerTitleStripImpl_(ASPagerTitleStripImpl_PagerTitleStripParamsBean *self, ASPagerTitleStripImpl *outer$);

FOUNDATION_EXPORT ASPagerTitleStripImpl_PagerTitleStripParamsBean *new_ASPagerTitleStripImpl_PagerTitleStripParamsBean_initWithASPagerTitleStripImpl_(ASPagerTitleStripImpl *outer$) NS_RETURNS_RETAINED;

FOUNDATION_EXPORT ASPagerTitleStripImpl_PagerTitleStripParamsBean *create_ASPagerTitleStripImpl_PagerTitleStripParamsBean_initWithASPagerTitleStripImpl_(ASPagerTitleStripImpl *outer$);

J2OBJC_TYPE_LITERAL_HEADER(ASPagerTitleStripImpl_PagerTitleStripParamsBean)

#endif

#if !defined (ASPagerTitleStripImpl_PagerTitleStripCommandParamsBuilder_) && (INCLUDE_ALL_PagerTitleStripImpl || defined(INCLUDE_ASPagerTitleStripImpl_PagerTitleStripCommandParamsBuilder))
#define ASPagerTitleStripImpl_PagerTitleStripCommandParamsBuilder_

#define RESTRICT_ViewGroupImpl 1
#define INCLUDE_ASViewGroupImpl_ViewGroupCommandParamsBuilder 1
#include "ViewGroupImpl.h"

@class ASPagerTitleStripImpl;

@interface ASPagerTitleStripImpl_PagerTitleStripCommandParamsBuilder : ASViewGroupImpl_ViewGroupCommandParamsBuilder

#pragma mark Public

- (instancetype)initWithASPagerTitleStripImpl:(ASPagerTitleStripImpl *)outer$;

- (ASPagerTitleStripImpl_PagerTitleStripCommandParamsBuilder *)reset;

- (ASPagerTitleStripImpl_PagerTitleStripCommandParamsBuilder *)setLayoutMarginBottomWithNSString:(NSString *)arg0;

- (ASPagerTitleStripImpl_PagerTitleStripCommandParamsBuilder *)setLayoutMarginEndWithNSString:(NSString *)arg0;

- (ASPagerTitleStripImpl_PagerTitleStripCommandParamsBuilder *)setLayoutMarginHorizontalWithNSString:(NSString *)arg0;

- (ASPagerTitleStripImpl_PagerTitleStripCommandParamsBuilder *)setLayoutMarginLeftWithNSString:(NSString *)arg0;

- (ASPagerTitleStripImpl_PagerTitleStripCommandParamsBuilder *)setLayoutMarginRightWithNSString:(NSString *)arg0;

- (ASPagerTitleStripImpl_PagerTitleStripCommandParamsBuilder *)setLayoutMarginStartWithNSString:(NSString *)arg0;

- (ASPagerTitleStripImpl_PagerTitleStripCommandParamsBuilder *)setLayoutMarginTopWithNSString:(NSString *)arg0;

- (ASPagerTitleStripImpl_PagerTitleStripCommandParamsBuilder *)setLayoutMarginVerticalWithNSString:(NSString *)arg0;

- (ASPagerTitleStripImpl_PagerTitleStripCommandParamsBuilder *)setLayoutMarginWithNSString:(NSString *)arg0;

- (ASPagerTitleStripImpl_PagerTitleStripCommandParamsBuilder *)tryGetLayoutMarginBottom;

- (ASPagerTitleStripImpl_PagerTitleStripCommandParamsBuilder *)tryGetLayoutMarginEnd;

- (ASPagerTitleStripImpl_PagerTitleStripCommandParamsBuilder *)tryGetLayoutMarginLeft;

- (ASPagerTitleStripImpl_PagerTitleStripCommandParamsBuilder *)tryGetLayoutMarginRight;

- (ASPagerTitleStripImpl_PagerTitleStripCommandParamsBuilder *)tryGetLayoutMarginStart;

- (ASPagerTitleStripImpl_PagerTitleStripCommandParamsBuilder *)tryGetLayoutMarginTop;

// Disallowed inherited constructors, do not use.

- (instancetype)init NS_UNAVAILABLE;

@end

J2OBJC_EMPTY_STATIC_INIT(ASPagerTitleStripImpl_PagerTitleStripCommandParamsBuilder)

FOUNDATION_EXPORT void ASPagerTitleStripImpl_PagerTitleStripCommandParamsBuilder_initWithASPagerTitleStripImpl_(ASPagerTitleStripImpl_PagerTitleStripCommandParamsBuilder *self, ASPagerTitleStripImpl *outer$);

FOUNDATION_EXPORT ASPagerTitleStripImpl_PagerTitleStripCommandParamsBuilder *new_ASPagerTitleStripImpl_PagerTitleStripCommandParamsBuilder_initWithASPagerTitleStripImpl_(ASPagerTitleStripImpl *outer$) NS_RETURNS_RETAINED;

FOUNDATION_EXPORT ASPagerTitleStripImpl_PagerTitleStripCommandParamsBuilder *create_ASPagerTitleStripImpl_PagerTitleStripCommandParamsBuilder_initWithASPagerTitleStripImpl_(ASPagerTitleStripImpl *outer$);

J2OBJC_TYPE_LITERAL_HEADER(ASPagerTitleStripImpl_PagerTitleStripCommandParamsBuilder)

#endif

#pragma pop_macro("INCLUDE_ALL_PagerTitleStripImpl")
