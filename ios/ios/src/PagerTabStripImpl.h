//
//  Generated by the J2ObjC translator.  DO NOT EDIT!
//  source: D:\Java\git\core-ios-widgets\IOSViewPagerPlugin\src\main\java\com\ashera\viewpager\PagerTabStripImpl.java
//

#include "J2ObjC_header.h"

#pragma push_macro("INCLUDE_ALL_PagerTabStripImpl")
#ifdef RESTRICT_PagerTabStripImpl
#define INCLUDE_ALL_PagerTabStripImpl 0
#else
#define INCLUDE_ALL_PagerTabStripImpl 1
#endif
#undef RESTRICT_PagerTabStripImpl

#if !defined (ASPagerTabStripImpl_) && (INCLUDE_ALL_PagerTabStripImpl || defined(INCLUDE_ASPagerTabStripImpl))
#define ASPagerTabStripImpl_

#define RESTRICT_BaseHasWidgets 1
#define INCLUDE_ASBaseHasWidgets 1
#include "BaseHasWidgets.h"

@class ASPagerTabStripImpl_PagerTabStripBean;
@class ASPagerTabStripImpl_PagerTabStripCommandBuilder;
@class ASPagerTabStripImpl_PagerTabStripCommandParamsBuilder;
@class ASPagerTabStripImpl_PagerTabStripParamsBean;
@class ASWidgetAttribute;
@class IOSClass;
@protocol ASIFragment;
@protocol ASILifeCycleDecorator;
@protocol ASIWidget;
@protocol JavaUtilMap;

@interface ASPagerTabStripImpl : ASBaseHasWidgets
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

- (ASPagerTabStripImpl_PagerTabStripBean *)getBean;

- (ASPagerTabStripImpl_PagerTabStripCommandBuilder *)getBuilder;

- (id)getChildAttributeWithASIWidget:(id<ASIWidget>)w
               withASWidgetAttribute:(ASWidgetAttribute *)key;

- (ASPagerTabStripImpl_PagerTabStripParamsBean *)getParamsBean;

- (ASPagerTabStripImpl_PagerTabStripCommandParamsBuilder *)getParamsBuilder;

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

J2OBJC_EMPTY_STATIC_INIT(ASPagerTabStripImpl)

inline NSString *ASPagerTabStripImpl_get_LOCAL_NAME(void);
/*! INTERNAL ONLY - Use accessor function from above. */
FOUNDATION_EXPORT NSString *ASPagerTabStripImpl_LOCAL_NAME;
J2OBJC_STATIC_FIELD_OBJ_FINAL(ASPagerTabStripImpl, LOCAL_NAME, NSString *)

inline NSString *ASPagerTabStripImpl_get_GROUP_NAME(void);
/*! INTERNAL ONLY - Use accessor function from above. */
FOUNDATION_EXPORT NSString *ASPagerTabStripImpl_GROUP_NAME;
J2OBJC_STATIC_FIELD_OBJ_FINAL(ASPagerTabStripImpl, GROUP_NAME, NSString *)

FOUNDATION_EXPORT void ASPagerTabStripImpl_init(ASPagerTabStripImpl *self);

FOUNDATION_EXPORT ASPagerTabStripImpl *new_ASPagerTabStripImpl_init(void) NS_RETURNS_RETAINED;

FOUNDATION_EXPORT ASPagerTabStripImpl *create_ASPagerTabStripImpl_init(void);

FOUNDATION_EXPORT void ASPagerTabStripImpl_initWithNSString_(ASPagerTabStripImpl *self, NSString *localname);

FOUNDATION_EXPORT ASPagerTabStripImpl *new_ASPagerTabStripImpl_initWithNSString_(NSString *localname) NS_RETURNS_RETAINED;

FOUNDATION_EXPORT ASPagerTabStripImpl *create_ASPagerTabStripImpl_initWithNSString_(NSString *localname);

FOUNDATION_EXPORT void ASPagerTabStripImpl_initWithNSString_withNSString_(ASPagerTabStripImpl *self, NSString *groupName, NSString *localname);

FOUNDATION_EXPORT ASPagerTabStripImpl *new_ASPagerTabStripImpl_initWithNSString_withNSString_(NSString *groupName, NSString *localname) NS_RETURNS_RETAINED;

FOUNDATION_EXPORT ASPagerTabStripImpl *create_ASPagerTabStripImpl_initWithNSString_withNSString_(NSString *groupName, NSString *localname);

J2OBJC_TYPE_LITERAL_HEADER(ASPagerTabStripImpl)

@compatibility_alias ComAsheraViewpagerPagerTabStripImpl ASPagerTabStripImpl;

#endif

#if !defined (ASPagerTabStripImpl_PagerTabStripExt_) && (INCLUDE_ALL_PagerTabStripImpl || defined(INCLUDE_ASPagerTabStripImpl_PagerTabStripExt))
#define ASPagerTabStripImpl_PagerTabStripExt_

#define RESTRICT_PagerTabStrip 1
#define INCLUDE_ASPagerTabStrip 1
#include "PagerTabStrip.h"

#define RESTRICT_ILifeCycleDecorator 1
#define INCLUDE_ASILifeCycleDecorator 1
#include "ILifeCycleDecorator.h"

#define RESTRICT_IMaxDimension 1
#define INCLUDE_ASIMaxDimension 1
#include "IMaxDimension.h"

@class ADRect;
@class ADView;
@class ASPagerTabStripImpl;
@class ASWidgetAttribute;
@class IOSIntArray;
@class IOSObjectArray;
@protocol ASHasWidgets;
@protocol ASIWidget;
@protocol JavaUtilList;

@interface ASPagerTabStripImpl_PagerTabStripExt : ASPagerTabStrip < ASILifeCycleDecorator, ASIMaxDimension >

#pragma mark Public

- (instancetype)initWithASPagerTabStripImpl:(ASPagerTabStripImpl *)outer$;

- (void)drawableStateChanged;

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

J2OBJC_EMPTY_STATIC_INIT(ASPagerTabStripImpl_PagerTabStripExt)

FOUNDATION_EXPORT void ASPagerTabStripImpl_PagerTabStripExt_initWithASPagerTabStripImpl_(ASPagerTabStripImpl_PagerTabStripExt *self, ASPagerTabStripImpl *outer$);

FOUNDATION_EXPORT ASPagerTabStripImpl_PagerTabStripExt *new_ASPagerTabStripImpl_PagerTabStripExt_initWithASPagerTabStripImpl_(ASPagerTabStripImpl *outer$) NS_RETURNS_RETAINED;

FOUNDATION_EXPORT ASPagerTabStripImpl_PagerTabStripExt *create_ASPagerTabStripImpl_PagerTabStripExt_initWithASPagerTabStripImpl_(ASPagerTabStripImpl *outer$);

J2OBJC_TYPE_LITERAL_HEADER(ASPagerTabStripImpl_PagerTabStripExt)

#endif

#if !defined (ASPagerTabStripImpl_PagerTabStripCommandBuilder_) && (INCLUDE_ALL_PagerTabStripImpl || defined(INCLUDE_ASPagerTabStripImpl_PagerTabStripCommandBuilder))
#define ASPagerTabStripImpl_PagerTabStripCommandBuilder_

#define RESTRICT_ViewGroupImpl 1
#define INCLUDE_ASViewGroupImpl_ViewGroupCommandBuilder 1
#include "ViewGroupImpl.h"

@class ASPagerTabStripImpl;

@interface ASPagerTabStripImpl_PagerTabStripCommandBuilder : ASViewGroupImpl_ViewGroupCommandBuilder

#pragma mark Public

- (instancetype)initWithASPagerTabStripImpl:(ASPagerTabStripImpl *)outer$;

- (ASPagerTabStripImpl_PagerTabStripCommandBuilder *)addAllModelWithId:(id)arg0;

- (ASPagerTabStripImpl_PagerTabStripCommandBuilder *)addModelByIndexWithId:(id)arg0
                                                                    withId:(id)arg1;

- (ASPagerTabStripImpl_PagerTabStripCommandBuilder *)addModelWithId:(id)arg0;

- (ASPagerTabStripImpl_PagerTabStripCommandBuilder *)executeWithBoolean:(jboolean)setter;

- (ASPagerTabStripImpl_PagerTabStripCommandBuilder *)invalidate;

- (ASPagerTabStripImpl_PagerTabStripCommandBuilder *)notifyDataSetChangedWithBoolean:(jboolean)arg0;

- (ASPagerTabStripImpl_PagerTabStripCommandBuilder *)refreshUiFromModelWithNSString:(NSString *)arg0;

- (ASPagerTabStripImpl_PagerTabStripCommandBuilder *)removeModelAtIndexWithInt:(jint)arg0;

- (ASPagerTabStripImpl_PagerTabStripCommandBuilder *)removeModelByIdWithNSString:(NSString *)arg0;

- (ASPagerTabStripImpl_PagerTabStripCommandBuilder *)requestLayout;

- (ASPagerTabStripImpl_PagerTabStripCommandBuilder *)reset;

- (ASPagerTabStripImpl_PagerTabStripCommandBuilder *)setAddStatesFromChildrenWithBoolean:(jboolean)arg0;

- (ASPagerTabStripImpl_PagerTabStripCommandBuilder *)setAlphaWithFloat:(jfloat)arg0;

- (ASPagerTabStripImpl_PagerTabStripCommandBuilder *)setAsDragSourceWithNSString:(NSString *)arg0;

- (ASPagerTabStripImpl_PagerTabStripCommandBuilder *)setAttributeUnderTestWithNSString:(NSString *)arg0;

- (ASPagerTabStripImpl_PagerTabStripCommandBuilder *)setBackgroundRepeatWithNSString:(NSString *)arg0;

- (ASPagerTabStripImpl_PagerTabStripCommandBuilder *)setBackgroundTintModeWithNSString:(NSString *)arg0;

- (ASPagerTabStripImpl_PagerTabStripCommandBuilder *)setBackgroundTintWithNSString:(NSString *)arg0;

- (ASPagerTabStripImpl_PagerTabStripCommandBuilder *)setBackgroundWithNSString:(NSString *)arg0;

- (ASPagerTabStripImpl_PagerTabStripCommandBuilder *)setChildXmlWithNSString:(NSString *)arg0;

- (ASPagerTabStripImpl_PagerTabStripCommandBuilder *)setClickableWithBoolean:(jboolean)arg0;

- (ASPagerTabStripImpl_PagerTabStripCommandBuilder *)setClipChildrenWithBoolean:(jboolean)arg0;

- (ASPagerTabStripImpl_PagerTabStripCommandBuilder *)setClipToPaddingWithBoolean:(jboolean)arg0;

- (ASPagerTabStripImpl_PagerTabStripCommandBuilder *)setContentDescriptionWithNSString:(NSString *)arg0;

- (ASPagerTabStripImpl_PagerTabStripCommandBuilder *)setCustomErrorMessageKeysWithNSString:(NSString *)arg0;

- (ASPagerTabStripImpl_PagerTabStripCommandBuilder *)setCustomErrorMessageValuesWithNSString:(NSString *)arg0;

- (ASPagerTabStripImpl_PagerTabStripCommandBuilder *)setDrawFullUnderlineWithBoolean:(jboolean)value;

- (ASPagerTabStripImpl_PagerTabStripCommandBuilder *)setDuplicateParentStateWithBoolean:(jboolean)arg0;

- (ASPagerTabStripImpl_PagerTabStripCommandBuilder *)setEnabledWithBoolean:(jboolean)arg0;

- (ASPagerTabStripImpl_PagerTabStripCommandBuilder *)setErrorStyleWithNSString:(NSString *)arg0;

- (ASPagerTabStripImpl_PagerTabStripCommandBuilder *)setFocusableWithBoolean:(jboolean)arg0;

- (ASPagerTabStripImpl_PagerTabStripCommandBuilder *)setForegroundGravityWithNSString:(NSString *)arg0;

- (ASPagerTabStripImpl_PagerTabStripCommandBuilder *)setForegroundRepeatWithNSString:(NSString *)arg0;

- (ASPagerTabStripImpl_PagerTabStripCommandBuilder *)setForegroundTintModeWithNSString:(NSString *)arg0;

- (ASPagerTabStripImpl_PagerTabStripCommandBuilder *)setForegroundTintWithNSString:(NSString *)arg0;

- (ASPagerTabStripImpl_PagerTabStripCommandBuilder *)setForegroundWithNSString:(NSString *)arg0;

- (ASPagerTabStripImpl_PagerTabStripCommandBuilder *)setGravityWithNSString:(NSString *)value;

- (ASPagerTabStripImpl_PagerTabStripCommandBuilder *)setIdWithNSString:(NSString *)arg0;

- (ASPagerTabStripImpl_PagerTabStripCommandBuilder *)setInvalidateOnFrameChangeWithBoolean:(jboolean)arg0;

- (ASPagerTabStripImpl_PagerTabStripCommandBuilder *)setIosAccessibilityHintWithNSString:(NSString *)arg0;

- (ASPagerTabStripImpl_PagerTabStripCommandBuilder *)setIosAccessibilityIgnoresInvertColorsWithBoolean:(jboolean)arg0;

- (ASPagerTabStripImpl_PagerTabStripCommandBuilder *)setIosAccessibilityLabelWithNSString:(NSString *)arg0;

- (ASPagerTabStripImpl_PagerTabStripCommandBuilder *)setIosAccessibilityTraitsWithNSString:(NSString *)arg0;

- (ASPagerTabStripImpl_PagerTabStripCommandBuilder *)setIosAccessibilityValueWithNSString:(NSString *)arg0;

- (ASPagerTabStripImpl_PagerTabStripCommandBuilder *)setIosAlphaWithFloat:(jfloat)arg0;

- (ASPagerTabStripImpl_PagerTabStripCommandBuilder *)setIosAutoresizesSubviewsWithBoolean:(jboolean)arg0;

- (ASPagerTabStripImpl_PagerTabStripCommandBuilder *)setIosBackgroundColorWithNSString:(NSString *)arg0;

- (ASPagerTabStripImpl_PagerTabStripCommandBuilder *)setIosClearsContextBeforeDrawingWithBoolean:(jboolean)arg0;

- (ASPagerTabStripImpl_PagerTabStripCommandBuilder *)setIosClipsToBoundsWithBoolean:(jboolean)arg0;

- (ASPagerTabStripImpl_PagerTabStripCommandBuilder *)setIosContentScaleFactorWithFloat:(jfloat)arg0;

- (ASPagerTabStripImpl_PagerTabStripCommandBuilder *)setIosInsetsLayoutMarginsFromSafeAreaWithBoolean:(jboolean)arg0;

- (ASPagerTabStripImpl_PagerTabStripCommandBuilder *)setIosIsAccessibilityElementWithBoolean:(jboolean)arg0;

- (ASPagerTabStripImpl_PagerTabStripCommandBuilder *)setIosIsExclusiveTouchWithBoolean:(jboolean)arg0;

- (ASPagerTabStripImpl_PagerTabStripCommandBuilder *)setIosIsHiddenWithBoolean:(jboolean)arg0;

- (ASPagerTabStripImpl_PagerTabStripCommandBuilder *)setIosIsMultipleTouchEnabledWithBoolean:(jboolean)arg0;

- (ASPagerTabStripImpl_PagerTabStripCommandBuilder *)setIosIsOpaqueWithBoolean:(jboolean)arg0;

- (ASPagerTabStripImpl_PagerTabStripCommandBuilder *)setIosIsUserInteractionEnabledWithBoolean:(jboolean)arg0;

- (ASPagerTabStripImpl_PagerTabStripCommandBuilder *)setIosLargeContentImageWithNSString:(NSString *)arg0;

- (ASPagerTabStripImpl_PagerTabStripCommandBuilder *)setIosLargeContentTitleWithNSString:(NSString *)arg0;

- (ASPagerTabStripImpl_PagerTabStripCommandBuilder *)setIosLayerBorderColorWithNSString:(NSString *)arg0;

- (ASPagerTabStripImpl_PagerTabStripCommandBuilder *)setIosLayerBorderWidthWithNSString:(NSString *)arg0;

- (ASPagerTabStripImpl_PagerTabStripCommandBuilder *)setIosLayerCornerRadiusWithNSString:(NSString *)arg0;

- (ASPagerTabStripImpl_PagerTabStripCommandBuilder *)setIosLayerMasksToBoundsWithBoolean:(jboolean)arg0;

- (ASPagerTabStripImpl_PagerTabStripCommandBuilder *)setIosPreservesSuperviewLayoutMarginsWithBoolean:(jboolean)arg0;

- (ASPagerTabStripImpl_PagerTabStripCommandBuilder *)setIosRestorationIdentifierWithNSString:(NSString *)arg0;

- (ASPagerTabStripImpl_PagerTabStripCommandBuilder *)setIosScalesLargeContentImageWithBoolean:(jboolean)arg0;

- (ASPagerTabStripImpl_PagerTabStripCommandBuilder *)setIosShowsLargeContentViewerWithBoolean:(jboolean)arg0;

- (ASPagerTabStripImpl_PagerTabStripCommandBuilder *)setIosTagWithInt:(jint)arg0;

- (ASPagerTabStripImpl_PagerTabStripCommandBuilder *)setIosTintColorWithNSString:(NSString *)arg0;

- (ASPagerTabStripImpl_PagerTabStripCommandBuilder *)setIosTranslatesAutoresizingMaskIntoConstraintsWithBoolean:(jboolean)arg0;

- (ASPagerTabStripImpl_PagerTabStripCommandBuilder *)setKeepScreenOnWithBoolean:(jboolean)arg0;

- (ASPagerTabStripImpl_PagerTabStripCommandBuilder *)setLayoutDirectionWithNSString:(NSString *)arg0;

- (ASPagerTabStripImpl_PagerTabStripCommandBuilder *)setLayoutModeWithNSString:(NSString *)arg0;

- (ASPagerTabStripImpl_PagerTabStripCommandBuilder *)setListitemWithNSString:(NSString *)arg0;

- (ASPagerTabStripImpl_PagerTabStripCommandBuilder *)setLongClickableWithBoolean:(jboolean)arg0;

- (ASPagerTabStripImpl_PagerTabStripCommandBuilder *)setMaxHeightWithNSString:(NSString *)arg0;

- (ASPagerTabStripImpl_PagerTabStripCommandBuilder *)setMaxWidthWithNSString:(NSString *)arg0;

- (ASPagerTabStripImpl_PagerTabStripCommandBuilder *)setMinHeightWithNSString:(NSString *)arg0;

- (ASPagerTabStripImpl_PagerTabStripCommandBuilder *)setMinWidthWithNSString:(NSString *)arg0;

- (ASPagerTabStripImpl_PagerTabStripCommandBuilder *)setModelDescPathWithNSString:(NSString *)arg0;

- (ASPagerTabStripImpl_PagerTabStripCommandBuilder *)setModelForWithNSString:(NSString *)arg0;

- (ASPagerTabStripImpl_PagerTabStripCommandBuilder *)setModelIdPathWithNSString:(NSString *)arg0;

- (ASPagerTabStripImpl_PagerTabStripCommandBuilder *)setModelParamWithNSString:(NSString *)arg0;

- (ASPagerTabStripImpl_PagerTabStripCommandBuilder *)setModelPojoToUiParamsWithNSString:(NSString *)arg0;

- (ASPagerTabStripImpl_PagerTabStripCommandBuilder *)setModelPojoToUiWithNSString:(NSString *)arg0;

- (ASPagerTabStripImpl_PagerTabStripCommandBuilder *)setModelSyncEventsWithNSString:(NSString *)arg0;

- (ASPagerTabStripImpl_PagerTabStripCommandBuilder *)setModelUiToPojoEventIdsWithNSString:(NSString *)arg0;

- (ASPagerTabStripImpl_PagerTabStripCommandBuilder *)setModelUiToPojoWithNSString:(NSString *)arg0;

- (ASPagerTabStripImpl_PagerTabStripCommandBuilder *)setNonPrimaryAlphaWithFloat:(jfloat)value;

- (ASPagerTabStripImpl_PagerTabStripCommandBuilder *)setOnChildViewAddedWithNSString:(NSString *)arg0;

- (ASPagerTabStripImpl_PagerTabStripCommandBuilder *)setOnChildViewRemovedWithNSString:(NSString *)arg0;

- (ASPagerTabStripImpl_PagerTabStripCommandBuilder *)setOnClickWithNSString:(NSString *)arg0;

- (ASPagerTabStripImpl_PagerTabStripCommandBuilder *)setOnDragWithNSString:(NSString *)arg0;

- (ASPagerTabStripImpl_PagerTabStripCommandBuilder *)setOnKeyWithNSString:(NSString *)arg0;

- (ASPagerTabStripImpl_PagerTabStripCommandBuilder *)setOnLongClickWithNSString:(NSString *)arg0;

- (ASPagerTabStripImpl_PagerTabStripCommandBuilder *)setOnSwipedWithNSString:(NSString *)arg0;

- (ASPagerTabStripImpl_PagerTabStripCommandBuilder *)setOnTouchWithNSString:(NSString *)arg0;

- (ASPagerTabStripImpl_PagerTabStripCommandBuilder *)setOutsideTouchableWithBoolean:(jboolean)arg0;

- (ASPagerTabStripImpl_PagerTabStripCommandBuilder *)setPaddingBottomWithNSString:(NSString *)arg0;

- (ASPagerTabStripImpl_PagerTabStripCommandBuilder *)setPaddingEndWithNSString:(NSString *)arg0;

- (ASPagerTabStripImpl_PagerTabStripCommandBuilder *)setPaddingHorizontalWithNSString:(NSString *)arg0;

- (ASPagerTabStripImpl_PagerTabStripCommandBuilder *)setPaddingLeftWithNSString:(NSString *)arg0;

- (ASPagerTabStripImpl_PagerTabStripCommandBuilder *)setPaddingRightWithNSString:(NSString *)arg0;

- (ASPagerTabStripImpl_PagerTabStripCommandBuilder *)setPaddingStartWithNSString:(NSString *)arg0;

- (ASPagerTabStripImpl_PagerTabStripCommandBuilder *)setPaddingTopWithNSString:(NSString *)arg0;

- (ASPagerTabStripImpl_PagerTabStripCommandBuilder *)setPaddingVerticalWithNSString:(NSString *)arg0;

- (ASPagerTabStripImpl_PagerTabStripCommandBuilder *)setPaddingWithNSString:(NSString *)arg0;

- (ASPagerTabStripImpl_PagerTabStripCommandBuilder *)setRotationWithFloat:(jfloat)arg0;

- (ASPagerTabStripImpl_PagerTabStripCommandBuilder *)setRotationXWithFloat:(jfloat)arg0;

- (ASPagerTabStripImpl_PagerTabStripCommandBuilder *)setRotationYWithFloat:(jfloat)arg0;

- (ASPagerTabStripImpl_PagerTabStripCommandBuilder *)setScaleXWithFloat:(jfloat)arg0;

- (ASPagerTabStripImpl_PagerTabStripCommandBuilder *)setScaleYWithFloat:(jfloat)arg0;

- (ASPagerTabStripImpl_PagerTabStripCommandBuilder *)setSelectedWithBoolean:(jboolean)arg0;

- (ASPagerTabStripImpl_PagerTabStripCommandBuilder *)setStyleWithNSString:(NSString *)arg0;

- (ASPagerTabStripImpl_PagerTabStripCommandBuilder *)setTabIndicatorColorWithNSString:(NSString *)value;

- (ASPagerTabStripImpl_PagerTabStripCommandBuilder *)setTextAlignmentWithNSString:(NSString *)arg0;

- (ASPagerTabStripImpl_PagerTabStripCommandBuilder *)setTextAppearanceWithNSString:(NSString *)value;

- (ASPagerTabStripImpl_PagerTabStripCommandBuilder *)setTextColorWithNSString:(NSString *)value;

- (ASPagerTabStripImpl_PagerTabStripCommandBuilder *)setTextDirectionWithNSString:(NSString *)arg0;

- (ASPagerTabStripImpl_PagerTabStripCommandBuilder *)setTextSizeWithNSString:(NSString *)value;

- (ASPagerTabStripImpl_PagerTabStripCommandBuilder *)setTextSpacingWithNSString:(NSString *)value;

- (ASPagerTabStripImpl_PagerTabStripCommandBuilder *)setTransformPivotXWithNSString:(NSString *)arg0;

- (ASPagerTabStripImpl_PagerTabStripCommandBuilder *)setTransformPivotYWithNSString:(NSString *)arg0;

- (ASPagerTabStripImpl_PagerTabStripCommandBuilder *)setTranslationXWithNSString:(NSString *)arg0;

- (ASPagerTabStripImpl_PagerTabStripCommandBuilder *)setTranslationYWithNSString:(NSString *)arg0;

- (ASPagerTabStripImpl_PagerTabStripCommandBuilder *)setTranslationZWithNSString:(NSString *)arg0;

- (ASPagerTabStripImpl_PagerTabStripCommandBuilder *)setV_maxlengthWithNSString:(NSString *)arg0;

- (ASPagerTabStripImpl_PagerTabStripCommandBuilder *)setV_maxWithNSString:(NSString *)arg0;

- (ASPagerTabStripImpl_PagerTabStripCommandBuilder *)setV_minlengthWithNSString:(NSString *)arg0;

- (ASPagerTabStripImpl_PagerTabStripCommandBuilder *)setV_minWithNSString:(NSString *)arg0;

- (ASPagerTabStripImpl_PagerTabStripCommandBuilder *)setV_patternWithNSString:(NSString *)arg0;

- (ASPagerTabStripImpl_PagerTabStripCommandBuilder *)setV_requiredWithNSString:(NSString *)arg0;

- (ASPagerTabStripImpl_PagerTabStripCommandBuilder *)setV_typeWithNSString:(NSString *)arg0;

- (ASPagerTabStripImpl_PagerTabStripCommandBuilder *)setValidationErrorDisplayTypeWithNSString:(NSString *)arg0;

- (ASPagerTabStripImpl_PagerTabStripCommandBuilder *)setValidationWithNSString:(NSString *)arg0;

- (ASPagerTabStripImpl_PagerTabStripCommandBuilder *)setVisibilityWithNSString:(NSString *)arg0;

- (ASPagerTabStripImpl_PagerTabStripCommandBuilder *)setZIndexWithInt:(jint)arg0;

- (ASPagerTabStripImpl_PagerTabStripCommandBuilder *)tryGetAddStatesFromChildren;

- (ASPagerTabStripImpl_PagerTabStripCommandBuilder *)tryGetAlpha;

- (ASPagerTabStripImpl_PagerTabStripCommandBuilder *)tryGetBackground;

- (ASPagerTabStripImpl_PagerTabStripCommandBuilder *)tryGetBackgroundTint;

- (ASPagerTabStripImpl_PagerTabStripCommandBuilder *)tryGetBackgroundTintMode;

- (ASPagerTabStripImpl_PagerTabStripCommandBuilder *)tryGetClickable;

- (ASPagerTabStripImpl_PagerTabStripCommandBuilder *)tryGetClipChildren;

- (ASPagerTabStripImpl_PagerTabStripCommandBuilder *)tryGetClipToPadding;

- (ASPagerTabStripImpl_PagerTabStripCommandBuilder *)tryGetContentDescription;

- (ASPagerTabStripImpl_PagerTabStripCommandBuilder *)tryGetDuplicateParentState;

- (ASPagerTabStripImpl_PagerTabStripCommandBuilder *)tryGetEnabled;

- (ASPagerTabStripImpl_PagerTabStripCommandBuilder *)tryGetFocusable;

- (ASPagerTabStripImpl_PagerTabStripCommandBuilder *)tryGetForeground;

- (ASPagerTabStripImpl_PagerTabStripCommandBuilder *)tryGetForegroundGravity;

- (ASPagerTabStripImpl_PagerTabStripCommandBuilder *)tryGetForegroundTint;

- (ASPagerTabStripImpl_PagerTabStripCommandBuilder *)tryGetForegroundTintMode;

- (ASPagerTabStripImpl_PagerTabStripCommandBuilder *)tryGetId;

- (ASPagerTabStripImpl_PagerTabStripCommandBuilder *)tryGetIosAccessibilityHint;

- (ASPagerTabStripImpl_PagerTabStripCommandBuilder *)tryGetIosAccessibilityIgnoresInvertColors;

- (ASPagerTabStripImpl_PagerTabStripCommandBuilder *)tryGetIosAccessibilityLabel;

- (ASPagerTabStripImpl_PagerTabStripCommandBuilder *)tryGetIosAccessibilityTraits;

- (ASPagerTabStripImpl_PagerTabStripCommandBuilder *)tryGetIosAccessibilityValue;

- (ASPagerTabStripImpl_PagerTabStripCommandBuilder *)tryGetIosAlpha;

- (ASPagerTabStripImpl_PagerTabStripCommandBuilder *)tryGetIosAutoresizesSubviews;

- (ASPagerTabStripImpl_PagerTabStripCommandBuilder *)tryGetIosBackgroundColor;

- (ASPagerTabStripImpl_PagerTabStripCommandBuilder *)tryGetIosClearsContextBeforeDrawing;

- (ASPagerTabStripImpl_PagerTabStripCommandBuilder *)tryGetIosClipsToBounds;

- (ASPagerTabStripImpl_PagerTabStripCommandBuilder *)tryGetIosContentScaleFactor;

- (ASPagerTabStripImpl_PagerTabStripCommandBuilder *)tryGetIosInsetsLayoutMarginsFromSafeArea;

- (ASPagerTabStripImpl_PagerTabStripCommandBuilder *)tryGetIosIsAccessibilityElement;

- (ASPagerTabStripImpl_PagerTabStripCommandBuilder *)tryGetIosIsExclusiveTouch;

- (ASPagerTabStripImpl_PagerTabStripCommandBuilder *)tryGetIosIsFocused;

- (ASPagerTabStripImpl_PagerTabStripCommandBuilder *)tryGetIosIsHidden;

- (ASPagerTabStripImpl_PagerTabStripCommandBuilder *)tryGetIosIsMultipleTouchEnabled;

- (ASPagerTabStripImpl_PagerTabStripCommandBuilder *)tryGetIosIsOpaque;

- (ASPagerTabStripImpl_PagerTabStripCommandBuilder *)tryGetIosIsUserInteractionEnabled;

- (ASPagerTabStripImpl_PagerTabStripCommandBuilder *)tryGetIosLargeContentImage;

- (ASPagerTabStripImpl_PagerTabStripCommandBuilder *)tryGetIosLargeContentTitle;

- (ASPagerTabStripImpl_PagerTabStripCommandBuilder *)tryGetIosPreservesSuperviewLayoutMargins;

- (ASPagerTabStripImpl_PagerTabStripCommandBuilder *)tryGetIosRestorationIdentifier;

- (ASPagerTabStripImpl_PagerTabStripCommandBuilder *)tryGetIosScalesLargeContentImage;

- (ASPagerTabStripImpl_PagerTabStripCommandBuilder *)tryGetIosShowsLargeContentViewer;

- (ASPagerTabStripImpl_PagerTabStripCommandBuilder *)tryGetIosTag;

- (ASPagerTabStripImpl_PagerTabStripCommandBuilder *)tryGetIosTintColor;

- (ASPagerTabStripImpl_PagerTabStripCommandBuilder *)tryGetIosTranslatesAutoresizingMaskIntoConstraints;

- (ASPagerTabStripImpl_PagerTabStripCommandBuilder *)tryGetKeepScreenOn;

- (ASPagerTabStripImpl_PagerTabStripCommandBuilder *)tryGetLayoutDirection;

- (ASPagerTabStripImpl_PagerTabStripCommandBuilder *)tryGetLayoutMode;

- (ASPagerTabStripImpl_PagerTabStripCommandBuilder *)tryGetLongClickable;

- (ASPagerTabStripImpl_PagerTabStripCommandBuilder *)tryGetMaxHeight;

- (ASPagerTabStripImpl_PagerTabStripCommandBuilder *)tryGetMaxWidth;

- (ASPagerTabStripImpl_PagerTabStripCommandBuilder *)tryGetMinHeight;

- (ASPagerTabStripImpl_PagerTabStripCommandBuilder *)tryGetMinWidth;

- (ASPagerTabStripImpl_PagerTabStripCommandBuilder *)tryGetModelDescPath;

- (ASPagerTabStripImpl_PagerTabStripCommandBuilder *)tryGetModelIdPath;

- (ASPagerTabStripImpl_PagerTabStripCommandBuilder *)tryGetModelParam;

- (ASPagerTabStripImpl_PagerTabStripCommandBuilder *)tryGetModelPojoToUi;

- (ASPagerTabStripImpl_PagerTabStripCommandBuilder *)tryGetModelSyncEvents;

- (ASPagerTabStripImpl_PagerTabStripCommandBuilder *)tryGetModelUiToPojo;

- (ASPagerTabStripImpl_PagerTabStripCommandBuilder *)tryGetPaddingBottom;

- (ASPagerTabStripImpl_PagerTabStripCommandBuilder *)tryGetPaddingEnd;

- (ASPagerTabStripImpl_PagerTabStripCommandBuilder *)tryGetPaddingLeft;

- (ASPagerTabStripImpl_PagerTabStripCommandBuilder *)tryGetPaddingRight;

- (ASPagerTabStripImpl_PagerTabStripCommandBuilder *)tryGetPaddingStart;

- (ASPagerTabStripImpl_PagerTabStripCommandBuilder *)tryGetPaddingTop;

- (ASPagerTabStripImpl_PagerTabStripCommandBuilder *)tryGetRotation;

- (ASPagerTabStripImpl_PagerTabStripCommandBuilder *)tryGetRotationX;

- (ASPagerTabStripImpl_PagerTabStripCommandBuilder *)tryGetRotationY;

- (ASPagerTabStripImpl_PagerTabStripCommandBuilder *)tryGetScaleX;

- (ASPagerTabStripImpl_PagerTabStripCommandBuilder *)tryGetScaleY;

- (ASPagerTabStripImpl_PagerTabStripCommandBuilder *)tryGetSelected;

- (ASPagerTabStripImpl_PagerTabStripCommandBuilder *)tryGetTextAlignment;

- (ASPagerTabStripImpl_PagerTabStripCommandBuilder *)tryGetTextDirection;

- (ASPagerTabStripImpl_PagerTabStripCommandBuilder *)tryGetTransformPivotX;

- (ASPagerTabStripImpl_PagerTabStripCommandBuilder *)tryGetTransformPivotY;

- (ASPagerTabStripImpl_PagerTabStripCommandBuilder *)tryGetTranslationX;

- (ASPagerTabStripImpl_PagerTabStripCommandBuilder *)tryGetTranslationY;

- (ASPagerTabStripImpl_PagerTabStripCommandBuilder *)tryGetTranslationZ;

- (ASPagerTabStripImpl_PagerTabStripCommandBuilder *)tryGetValidateForm;

- (ASPagerTabStripImpl_PagerTabStripCommandBuilder *)tryGetVisibility;

- (ASPagerTabStripImpl_PagerTabStripCommandBuilder *)updateModelDataWithNSString:(NSString *)arg0
                                                                          withId:(id)arg1;

- (ASPagerTabStripImpl_PagerTabStripCommandBuilder *)validateFormWithNSString:(NSString *)arg0;

// Disallowed inherited constructors, do not use.

- (instancetype)init NS_UNAVAILABLE;

@end

J2OBJC_EMPTY_STATIC_INIT(ASPagerTabStripImpl_PagerTabStripCommandBuilder)

FOUNDATION_EXPORT void ASPagerTabStripImpl_PagerTabStripCommandBuilder_initWithASPagerTabStripImpl_(ASPagerTabStripImpl_PagerTabStripCommandBuilder *self, ASPagerTabStripImpl *outer$);

FOUNDATION_EXPORT ASPagerTabStripImpl_PagerTabStripCommandBuilder *new_ASPagerTabStripImpl_PagerTabStripCommandBuilder_initWithASPagerTabStripImpl_(ASPagerTabStripImpl *outer$) NS_RETURNS_RETAINED;

FOUNDATION_EXPORT ASPagerTabStripImpl_PagerTabStripCommandBuilder *create_ASPagerTabStripImpl_PagerTabStripCommandBuilder_initWithASPagerTabStripImpl_(ASPagerTabStripImpl *outer$);

J2OBJC_TYPE_LITERAL_HEADER(ASPagerTabStripImpl_PagerTabStripCommandBuilder)

#endif

#if !defined (ASPagerTabStripImpl_PagerTabStripBean_) && (INCLUDE_ALL_PagerTabStripImpl || defined(INCLUDE_ASPagerTabStripImpl_PagerTabStripBean))
#define ASPagerTabStripImpl_PagerTabStripBean_

#define RESTRICT_ViewGroupImpl 1
#define INCLUDE_ASViewGroupImpl_ViewGroupBean 1
#include "ViewGroupImpl.h"

@class ASPagerTabStripImpl;
@protocol ASIWidget;

@interface ASPagerTabStripImpl_PagerTabStripBean : ASViewGroupImpl_ViewGroupBean

#pragma mark Public

- (instancetype)initWithASPagerTabStripImpl:(ASPagerTabStripImpl *)outer$;

- (void)setDrawFullUnderlineWithBoolean:(jboolean)value;

- (void)setGravityWithNSString:(NSString *)value;

- (void)setNonPrimaryAlphaWithFloat:(jfloat)value;

- (void)setTabIndicatorColorWithNSString:(NSString *)value;

- (void)setTextAppearanceWithNSString:(NSString *)value;

- (void)setTextColorWithNSString:(NSString *)value;

- (void)setTextSizeWithNSString:(NSString *)value;

- (void)setTextSpacingWithNSString:(NSString *)value;

// Disallowed inherited constructors, do not use.

- (instancetype)initWithASIWidget:(id<ASIWidget>)arg0 NS_UNAVAILABLE;

@end

J2OBJC_EMPTY_STATIC_INIT(ASPagerTabStripImpl_PagerTabStripBean)

FOUNDATION_EXPORT void ASPagerTabStripImpl_PagerTabStripBean_initWithASPagerTabStripImpl_(ASPagerTabStripImpl_PagerTabStripBean *self, ASPagerTabStripImpl *outer$);

FOUNDATION_EXPORT ASPagerTabStripImpl_PagerTabStripBean *new_ASPagerTabStripImpl_PagerTabStripBean_initWithASPagerTabStripImpl_(ASPagerTabStripImpl *outer$) NS_RETURNS_RETAINED;

FOUNDATION_EXPORT ASPagerTabStripImpl_PagerTabStripBean *create_ASPagerTabStripImpl_PagerTabStripBean_initWithASPagerTabStripImpl_(ASPagerTabStripImpl *outer$);

J2OBJC_TYPE_LITERAL_HEADER(ASPagerTabStripImpl_PagerTabStripBean)

#endif

#if !defined (ASPagerTabStripImpl_PagerTabStripParamsBean_) && (INCLUDE_ALL_PagerTabStripImpl || defined(INCLUDE_ASPagerTabStripImpl_PagerTabStripParamsBean))
#define ASPagerTabStripImpl_PagerTabStripParamsBean_

#define RESTRICT_ViewGroupImpl 1
#define INCLUDE_ASViewGroupImpl_ViewGroupParamsBean 1
#include "ViewGroupImpl.h"

@class ASPagerTabStripImpl;

@interface ASPagerTabStripImpl_PagerTabStripParamsBean : ASViewGroupImpl_ViewGroupParamsBean

#pragma mark Public

- (instancetype)initWithASPagerTabStripImpl:(ASPagerTabStripImpl *)outer$;

// Disallowed inherited constructors, do not use.

- (instancetype)init NS_UNAVAILABLE;

@end

J2OBJC_EMPTY_STATIC_INIT(ASPagerTabStripImpl_PagerTabStripParamsBean)

FOUNDATION_EXPORT void ASPagerTabStripImpl_PagerTabStripParamsBean_initWithASPagerTabStripImpl_(ASPagerTabStripImpl_PagerTabStripParamsBean *self, ASPagerTabStripImpl *outer$);

FOUNDATION_EXPORT ASPagerTabStripImpl_PagerTabStripParamsBean *new_ASPagerTabStripImpl_PagerTabStripParamsBean_initWithASPagerTabStripImpl_(ASPagerTabStripImpl *outer$) NS_RETURNS_RETAINED;

FOUNDATION_EXPORT ASPagerTabStripImpl_PagerTabStripParamsBean *create_ASPagerTabStripImpl_PagerTabStripParamsBean_initWithASPagerTabStripImpl_(ASPagerTabStripImpl *outer$);

J2OBJC_TYPE_LITERAL_HEADER(ASPagerTabStripImpl_PagerTabStripParamsBean)

#endif

#if !defined (ASPagerTabStripImpl_PagerTabStripCommandParamsBuilder_) && (INCLUDE_ALL_PagerTabStripImpl || defined(INCLUDE_ASPagerTabStripImpl_PagerTabStripCommandParamsBuilder))
#define ASPagerTabStripImpl_PagerTabStripCommandParamsBuilder_

#define RESTRICT_ViewGroupImpl 1
#define INCLUDE_ASViewGroupImpl_ViewGroupCommandParamsBuilder 1
#include "ViewGroupImpl.h"

@class ASPagerTabStripImpl;

@interface ASPagerTabStripImpl_PagerTabStripCommandParamsBuilder : ASViewGroupImpl_ViewGroupCommandParamsBuilder

#pragma mark Public

- (instancetype)initWithASPagerTabStripImpl:(ASPagerTabStripImpl *)outer$;

- (ASPagerTabStripImpl_PagerTabStripCommandParamsBuilder *)reset;

- (ASPagerTabStripImpl_PagerTabStripCommandParamsBuilder *)setLayoutMarginBottomWithNSString:(NSString *)arg0;

- (ASPagerTabStripImpl_PagerTabStripCommandParamsBuilder *)setLayoutMarginEndWithNSString:(NSString *)arg0;

- (ASPagerTabStripImpl_PagerTabStripCommandParamsBuilder *)setLayoutMarginHorizontalWithNSString:(NSString *)arg0;

- (ASPagerTabStripImpl_PagerTabStripCommandParamsBuilder *)setLayoutMarginLeftWithNSString:(NSString *)arg0;

- (ASPagerTabStripImpl_PagerTabStripCommandParamsBuilder *)setLayoutMarginRightWithNSString:(NSString *)arg0;

- (ASPagerTabStripImpl_PagerTabStripCommandParamsBuilder *)setLayoutMarginStartWithNSString:(NSString *)arg0;

- (ASPagerTabStripImpl_PagerTabStripCommandParamsBuilder *)setLayoutMarginTopWithNSString:(NSString *)arg0;

- (ASPagerTabStripImpl_PagerTabStripCommandParamsBuilder *)setLayoutMarginVerticalWithNSString:(NSString *)arg0;

- (ASPagerTabStripImpl_PagerTabStripCommandParamsBuilder *)setLayoutMarginWithNSString:(NSString *)arg0;

- (ASPagerTabStripImpl_PagerTabStripCommandParamsBuilder *)tryGetLayoutMarginBottom;

- (ASPagerTabStripImpl_PagerTabStripCommandParamsBuilder *)tryGetLayoutMarginEnd;

- (ASPagerTabStripImpl_PagerTabStripCommandParamsBuilder *)tryGetLayoutMarginLeft;

- (ASPagerTabStripImpl_PagerTabStripCommandParamsBuilder *)tryGetLayoutMarginRight;

- (ASPagerTabStripImpl_PagerTabStripCommandParamsBuilder *)tryGetLayoutMarginStart;

- (ASPagerTabStripImpl_PagerTabStripCommandParamsBuilder *)tryGetLayoutMarginTop;

// Disallowed inherited constructors, do not use.

- (instancetype)init NS_UNAVAILABLE;

@end

J2OBJC_EMPTY_STATIC_INIT(ASPagerTabStripImpl_PagerTabStripCommandParamsBuilder)

FOUNDATION_EXPORT void ASPagerTabStripImpl_PagerTabStripCommandParamsBuilder_initWithASPagerTabStripImpl_(ASPagerTabStripImpl_PagerTabStripCommandParamsBuilder *self, ASPagerTabStripImpl *outer$);

FOUNDATION_EXPORT ASPagerTabStripImpl_PagerTabStripCommandParamsBuilder *new_ASPagerTabStripImpl_PagerTabStripCommandParamsBuilder_initWithASPagerTabStripImpl_(ASPagerTabStripImpl *outer$) NS_RETURNS_RETAINED;

FOUNDATION_EXPORT ASPagerTabStripImpl_PagerTabStripCommandParamsBuilder *create_ASPagerTabStripImpl_PagerTabStripCommandParamsBuilder_initWithASPagerTabStripImpl_(ASPagerTabStripImpl *outer$);

J2OBJC_TYPE_LITERAL_HEADER(ASPagerTabStripImpl_PagerTabStripCommandParamsBuilder)

#endif

#pragma pop_macro("INCLUDE_ALL_PagerTabStripImpl")
