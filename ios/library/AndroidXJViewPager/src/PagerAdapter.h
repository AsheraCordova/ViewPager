//
//  Generated by the J2ObjC translator.  DO NOT EDIT!
//  source: D:\Java\git\core-javafx-widget\AndroidXJViewPager\src\main\java\androidx\viewpager\widget\PagerAdapter.java
//

#include "J2ObjC_header.h"

#pragma push_macro("INCLUDE_ALL_PagerAdapter")
#ifdef RESTRICT_PagerAdapter
#define INCLUDE_ALL_PagerAdapter 0
#else
#define INCLUDE_ALL_PagerAdapter 1
#endif
#undef RESTRICT_PagerAdapter

#if __has_feature(nullability)
#pragma clang diagnostic push
#pragma GCC diagnostic ignored "-Wnullability"
#pragma GCC diagnostic ignored "-Wnullability-completeness"
#endif

#if !defined (ADXPagerAdapter_) && (INCLUDE_ALL_PagerAdapter || defined(INCLUDE_ADXPagerAdapter))
#define ADXPagerAdapter_

@class ADDataSetObserver;
@class ADView;
@class ADViewGroup;
@class JavaLangClassLoader;
@protocol ADParcelable;
@protocol JavaLangCharSequence;

/*!
 @brief Base class providing the adapter to populate pages inside of
  a <code>ViewPager</code>.You will most likely want to use a more
  specific implementation of this, such as 
 <code>androidx.fragment.app.FragmentPagerAdapter</code> or 
 <code>androidx.fragment.app.FragmentStatePagerAdapter</code>.
 <p>When you implement a PagerAdapter, you must override the following methods
  at minimum:</p>
  <ul>
  <li><code>instantiateItem(ViewGroup, int)</code></li>
  <li><code>destroyItem(ViewGroup, int, Object)</code></li>
  <li><code>getCount()</code></li>
  <li><code>isViewFromObject(View, Object)</code></li>
  </ul>
  
 <p>PagerAdapter is more general than the adapters used for 
 <code>AdapterViews</code>. Instead of providing a
  View recycling mechanism directly ViewPager uses callbacks to indicate the
  steps taken during an update. A PagerAdapter may implement a form of View
  recycling if desired or use a more sophisticated method of managing page
  Views such as Fragment transactions where each page is represented by its
  own Fragment.</p>
  
 <p>ViewPager associates each page with a key Object instead of working with
  Views directly. This key is used to track and uniquely identify a given page
  independent of its position in the adapter. A call to the PagerAdapter method 
 <code>startUpdate(ViewGroup)</code> indicates that the contents of the ViewPager
  are about to change. One or more calls to <code>instantiateItem(ViewGroup, int)</code>
  and/or <code>destroyItem(ViewGroup, int, Object)</code> will follow, and the end
  of an update will be signaled by a call to <code>finishUpdate(ViewGroup)</code>.
  By the time <code>finishUpdate</code> returns the views
  associated with the key objects returned by 
 <code>instantiateItem</code> should be added to
  the parent ViewGroup passed to these methods and the views associated with
  the keys passed to <code>destroyItem</code>
  should be removed. The method <code>isViewFromObject(View, Object)</code> identifies
  whether a page View is associated with a given key object.</p>
  
 <p>A very simple PagerAdapter may choose to use the page Views themselves
  as key objects, returning them from <code>instantiateItem(ViewGroup, int)</code>
  after creation and adding them to the parent ViewGroup. A matching 
 <code>destroyItem(ViewGroup, int, Object)</code> implementation would remove the
  View from the parent ViewGroup and <code>isViewFromObject(View, Object)</code>
  could be implemented as <code>return view == object;</code>.</p>
  
 <p>PagerAdapter supports data set changes. Data set changes must occur on the
  main thread and must end with a call to <code>notifyDataSetChanged()</code> similar
  to AdapterView adapters derived from <code>r.android.widget.BaseAdapter</code>. A data
  set change may involve pages being added, removed, or changing position. The
  ViewPager will keep the current page active provided the adapter implements
  the method <code>getItemPosition(Object)</code>.</p>
 */
@interface ADXPagerAdapter : NSObject

#pragma mark Public

- (instancetype)init;

/*!
 @brief Remove a page for the given position.The adapter is responsible
  for removing the view from its container, although it only must ensure
  this is done by the time it returns from <code>finishUpdate(View)</code>.
 @param container The containing View from which the page will be removed.
 @param position The page position to be removed.
 @param object The same object that was returned by  
 <code>instantiateItem(View, int)</code> .
 */
- (void)destroyItemWithADView:(ADView *)container
                      withInt:(jint)position
                       withId:(id)object;

/*!
 @brief Remove a page for the given position.The adapter is responsible
  for removing the view from its container, although it only must ensure
  this is done by the time it returns from <code>finishUpdate(ViewGroup)</code>.
 @param container The containing View from which the page will be removed.
 @param position The page position to be removed.
 @param object The same object that was returned by  
 <code>instantiateItem(View, int)</code> .
 */
- (void)destroyItemWithADViewGroup:(ADViewGroup *)container
                           withInt:(jint)position
                            withId:(id)object;

/*!
 @brief Called when the a change in the shown pages has been completed.At this
  point you must ensure that all of the pages have actually been added or
  removed from the container as appropriate.
 @param container The containing View which is displaying this adapter's  page views.
 */
- (void)finishUpdateWithADView:(ADView *)container;

/*!
 @brief Called when the a change in the shown pages has been completed.At this
  point you must ensure that all of the pages have actually been added or
  removed from the container as appropriate.
 @param container The containing View which is displaying this adapter's  page views.
 */
- (void)finishUpdateWithADViewGroup:(ADViewGroup *)container;

/*!
 @brief Return the number of views available.
 */
- (jint)getCount;

/*!
 @brief Called when the host view is attempting to determine if an item's position
  has changed.Returns <code>POSITION_UNCHANGED</code> if the position of the given
  item has not changed or <code>POSITION_NONE</code> if the item is no longer present
  in the adapter.
 <p>The default implementation assumes that items will never
  change position and always returns <code>POSITION_UNCHANGED</code>.
 @param object Object representing an item, previously returned by a call to                
 <code>instantiateItem(View, int)</code> .
 @return object's new position index from [0, <code>getCount()</code>),
          <code>POSITION_UNCHANGED</code> if the object's position has not changed,
          or <code>POSITION_NONE</code> if the item is no longer present.
 */
- (jint)getItemPositionWithId:(id)object;

/*!
 @brief This method may be called by the ViewPager to obtain a title string
  to describe the specified page.This method may return null
  indicating no title for this page.
 The default implementation returns
  null.
 @param position The position of the title requested
 @return A title for the requested page
 */
- (id<JavaLangCharSequence>)getPageTitleWithInt:(jint)position;

/*!
 @brief Returns the proportional width of a given page as a percentage of the
  ViewPager's measured width from (0.f-1.f]
 @param position The position of the page requested
 @return Proportional width for the given page position
 */
- (jfloat)getPageWidthWithInt:(jint)position;

/*!
 @brief Create the page for the given position.The adapter is responsible
  for adding the view to the container given here, although it only
  must ensure this is done by the time it returns from 
 <code>finishUpdate(ViewGroup)</code>.
 @param container The containing View in which the page will be shown.
 @param position The page position to be instantiated.
 @return Returns an Object representing the new page.  This does not
  need to be a View, but can be some other container of the page.
 */
- (id)instantiateItemWithADView:(ADView *)container
                        withInt:(jint)position;

/*!
 @brief Create the page for the given position.The adapter is responsible
  for adding the view to the container given here, although it only
  must ensure this is done by the time it returns from 
 <code>finishUpdate(ViewGroup)</code>.
 @param container The containing View in which the page will be shown.
 @param position The page position to be instantiated.
 @return Returns an Object representing the new page.  This does not
  need to be a View, but can be some other container of the page.
 */
- (id)instantiateItemWithADViewGroup:(ADViewGroup *)container
                             withInt:(jint)position;

/*!
 @brief Determines whether a page View is associated with a specific key object
  as returned by <code>instantiateItem(ViewGroup, int)</code>.This method is
  required for a PagerAdapter to function properly.
 @param view Page View to check for association with  <code> object </code>
 @param object Object to check for association with  <code> view </code>
 @return true if <code>view</code> is associated with the key object <code>object</code>
 */
- (jboolean)isViewFromObjectWithADView:(ADView *)view
                                withId:(id)object;

/*!
 @brief This method should be called by the application if the data backing this adapter has changed
  and associated views should update.
 */
- (void)notifyDataSetChanged;

/*!
 @brief Register an observer to receive callbacks related to the adapter's data changing.
 @param observer The <code>r.android.database.DataSetObserver</code>  which will receive callbacks.
 */
- (void)registerDataSetObserverWithADDataSetObserver:(ADDataSetObserver *)observer;

/*!
 @brief Restore any instance state associated with this adapter and its pages
  that was previously saved by <code>saveState()</code>.
 @param state State previously saved by a call to <code>saveState()</code>
 @param loader A ClassLoader that should be used to instantiate any restored objects
 */
- (void)restoreStateWithADParcelable:(id<ADParcelable>)state
             withJavaLangClassLoader:(JavaLangClassLoader *)loader;

/*!
 @brief Save any instance state associated with this adapter and its pages that should be
  restored if the current UI state needs to be reconstructed.
 @return Saved state for this adapter
 */
- (id<ADParcelable>)saveState;

/*!
 @brief Called to inform the adapter of which item is currently considered to
  be the "primary", that is the one show to the user as the current page.
 @param container The containing View from which the page will be removed.
 @param position The page position that is now the primary.
 @param object The same object that was returned by  
 <code>instantiateItem(View, int)</code> .
 */
- (void)setPrimaryItemWithADView:(ADView *)container
                         withInt:(jint)position
                          withId:(id)object;

/*!
 @brief Called to inform the adapter of which item is currently considered to
  be the "primary", that is the one show to the user as the current page.
 This method will not be invoked when the adapter contains no items.
 @param container The containing View from which the page will be removed.
 @param position The page position that is now the primary.
 @param object The same object that was returned by  
 <code>instantiateItem(View, int)</code> .
 */
- (void)setPrimaryItemWithADViewGroup:(ADViewGroup *)container
                              withInt:(jint)position
                               withId:(id)object;

/*!
 @brief Called when a change in the shown pages is going to start being made.
 @param container The containing View which is displaying this adapter's  page views.
 */
- (void)startUpdateWithADView:(ADView *)container;

/*!
 @brief Called when a change in the shown pages is going to start being made.
 @param container The containing View which is displaying this adapter's  page views.
 */
- (void)startUpdateWithADViewGroup:(ADViewGroup *)container;

/*!
 @brief Unregister an observer from callbacks related to the adapter's data changing.
 @param observer The <code>r.android.database.DataSetObserver</code>  which will be unregistered.
 */
- (void)unregisterDataSetObserverWithADDataSetObserver:(ADDataSetObserver *)observer;

#pragma mark Package-Private

- (void)setViewPagerObserverWithADDataSetObserver:(ADDataSetObserver *)observer;

@end

J2OBJC_EMPTY_STATIC_INIT(ADXPagerAdapter)

inline jint ADXPagerAdapter_get_POSITION_UNCHANGED(void);
#define ADXPagerAdapter_POSITION_UNCHANGED -1
J2OBJC_STATIC_FIELD_CONSTANT(ADXPagerAdapter, POSITION_UNCHANGED, jint)

inline jint ADXPagerAdapter_get_POSITION_NONE(void);
#define ADXPagerAdapter_POSITION_NONE -2
J2OBJC_STATIC_FIELD_CONSTANT(ADXPagerAdapter, POSITION_NONE, jint)

FOUNDATION_EXPORT void ADXPagerAdapter_init(ADXPagerAdapter *self);

J2OBJC_TYPE_LITERAL_HEADER(ADXPagerAdapter)

@compatibility_alias AndroidxViewpagerWidgetPagerAdapter ADXPagerAdapter;

#endif


#if __has_feature(nullability)
#pragma clang diagnostic pop
#endif
#pragma pop_macro("INCLUDE_ALL_PagerAdapter")
