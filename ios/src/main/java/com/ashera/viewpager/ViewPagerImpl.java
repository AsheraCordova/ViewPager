package com.ashera.viewpager;
// start - imports
import java.util.*;

import r.android.annotation.SuppressLint;
import r.android.content.Context;
import r.android.os.Build;
import r.android.view.*;
import r.android.widget.*;
import r.android.view.View.*;

import com.ashera.widget.BaseHasWidgets;

import r.android.annotation.SuppressLint;

import com.ashera.core.IFragment;
import com.ashera.widget.bus.*;
import com.ashera.converter.*;
import com.ashera.widget.bus.Event.*;
import com.ashera.widget.*;
import com.ashera.widget.IWidgetLifeCycleListener.*;
import com.ashera.layout.*;

/*-[
#include <UIKit/UIKit.h>
#include "ASUIView.h"
#include "HasLifeCycleDecorators.h"
]-*/
import com.google.j2objc.annotations.Property;
import androidx.core.view.*;

import static com.ashera.widget.IWidget.*;
//end - imports

import r.android.graphics.drawable.Drawable;
import androidx.viewpager.widget.ViewPager;
/*-[
#include "ASUIImageView.h"
]-*/
public class ViewPagerImpl extends BaseHasWidgets {
	//start - body
	private @Property Object uiView;
	private r.android.graphics.Canvas canvas;
	public final static String LOCAL_NAME = "androidx.viewpager.widget.ViewPager"; 
	public final static String GROUP_NAME = "androidx.viewpager.widget.ViewPager";
	private androidx.viewpager.widget.ViewPager viewPager;
	

	
	@Override
	public void loadAttributes(String localName) {
		ViewGroupImpl.register(localName);

		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("currentItem").withType("int"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("offscreenPageLimit").withType("int"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("pageMargin").withType("dimension"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("pageMarginDrawable").withType("drawable"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("onPageScrolled").withType("string"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("onPageSelected").withType("string"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("onPageScrollStateChange").withType("string"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("pageWidth").withType("float"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("pageTitles").withType("array").withArrayType("resourcestring"));
	
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("layout_gravity").withType("gravity").forChild());
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("layout_isdecor").withType("boolean").forChild());
	}
	
	public ViewPagerImpl() {
		super(GROUP_NAME, LOCAL_NAME);
	}
	public  ViewPagerImpl(String localname) {
		super(GROUP_NAME, localname);
	}
	public  ViewPagerImpl(String groupName, String localname) {
		super(groupName, localname);
	}

	@Override
	public IWidget newInstance() {
		return new ViewPagerImpl(groupName, localName);
	}
	
	@SuppressLint("NewApi")
	@Override
	public void create(IFragment fragment, Map<String, Object> params) {
		super.create(fragment, params);
		viewPager = new ViewPagerExt();
		
		nativeCreate(params);
        createCanvas();
		
		
		ViewGroupImpl.registerCommandConveter(this);
		setWidgetOnNativeClass();
	}
	private native void setWidgetOnNativeClass() /*-[
		((ASUIView*) [self asNativeWidget]).widget = self;
	]-*/;

	@Override
	public Object asWidget() {
		return viewPager;
	}

	@Override
	public boolean remove(IWidget w) {		
		boolean remove = super.remove(w);
		viewPager.removeView((View) w.asWidget());
         ViewGroupImpl.nativeRemoveView(w);            
		return remove;
	}
	
	@Override
    public boolean remove(int index) {
		IWidget widget = widgets.get(index);
        boolean remove = super.remove(index);

        if (index + 1 <= viewPager.getChildCount()) {
            viewPager.removeViewAt(index);
            ViewGroupImpl.nativeRemoveView(widget);            
        }    
        return remove;
    }
	
	@Override
	public void add(IWidget w, int index) {
		if (index != -2) {
			View view = (View) w.asWidget();
			createLayoutParams(view);
			    if (index == -1) {
			        viewPager.addView(view);
			    } else {
			        viewPager.addView(view, index);
			    }
		}
		
		ViewGroupImpl.nativeAddView(asNativeWidget(), w.asNativeWidget());
		super.add(w, index);
	}
	
	private void createLayoutParams(View view) {
		androidx.viewpager.widget.ViewPager.LayoutParams layoutParams = (androidx.viewpager.widget.ViewPager.LayoutParams) view.getLayoutParams();
		
		layoutParams = (androidx.viewpager.widget.ViewPager.LayoutParams) view.getLayoutParams();
		if (layoutParams == null) {
			layoutParams = new androidx.viewpager.widget.ViewPager.LayoutParams();
			view.setLayoutParams(layoutParams);
		}  else {
			layoutParams.height = -1;
			layoutParams.width = -1;
		}
	}
	
	private androidx.viewpager.widget.ViewPager.LayoutParams getLayoutParams(View view) {
		return (androidx.viewpager.widget.ViewPager.LayoutParams) view.getLayoutParams();		
	}
	
	@SuppressLint("NewApi")
	@Override
	public void setChildAttribute(IWidget w, WidgetAttribute key, String strValue, Object objValue) {
		View view = (View) w.asWidget();
		androidx.viewpager.widget.ViewPager.LayoutParams layoutParams = getLayoutParams(view);
		ViewGroupImpl.setChildAttribute(w, key, objValue, layoutParams);		
		
		switch (key.getAttributeName()) {
		case "layout_width":
			layoutParams.width = (int) objValue;
			break;	
		case "layout_height":
			layoutParams.height = (int) objValue;
			break;
			case "layout_gravity": {
				
							layoutParams.gravity =((int)objValue);
				
			}
			break;
			case "layout_isdecor": {
				
							layoutParams.isDecor =((boolean)objValue);
				
			}
			break;
		default:
			break;
		}
		
		
		view.setLayoutParams(layoutParams);		
	}
	
	@SuppressLint("NewApi")
	@Override
	public Object getChildAttribute(IWidget w, WidgetAttribute key) {
		Object attributeValue = ViewGroupImpl.getChildAttribute(w, key);		
		if (attributeValue != null) {
			return attributeValue;
		}
		View view = (View) w.asWidget();
		androidx.viewpager.widget.ViewPager.LayoutParams layoutParams = getLayoutParams(view);

		switch (key.getAttributeName()) {
		case "layout_width":
			return layoutParams.width;
		case "layout_height":
			return layoutParams.height;


		}
		
		return null;

	}
	
@com.google.j2objc.annotations.WeakOuter		
	public class ViewPagerExt extends androidx.viewpager.widget.ViewPager implements ILifeCycleDecorator, com.ashera.widget.IMaxDimension{
		private MeasureEvent measureFinished = new MeasureEvent();
		private OnLayoutEvent onLayoutEvent = new OnLayoutEvent();
		private int mMaxWidth = -1;
		private int mMaxHeight = -1;
		@Override
		public void setMaxWidth(int width) {
			mMaxWidth = width;
		}
		@Override
		public void setMaxHeight(int height) {
			mMaxHeight = height;
		}
		@Override
		public int getMaxWidth() {
			return mMaxWidth;
		}
		@Override
		public int getMaxHeight() {
			return mMaxHeight;
		}

		public ViewPagerExt() {
			super();
			
		}
		
		@Override
		public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

			if(mMaxWidth > 0) {
	        	widthMeasureSpec = MeasureSpec.makeMeasureSpec(mMaxWidth, MeasureSpec.AT_MOST);
	        }
	        if(mMaxHeight > 0) {
	            heightMeasureSpec = MeasureSpec.makeMeasureSpec(mMaxHeight, MeasureSpec.AT_MOST);

	        }

	        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
			IWidgetLifeCycleListener listener = (IWidgetLifeCycleListener) getListener();
			if (listener != null) {
			    measureFinished.setWidth(getMeasuredWidth());
			    measureFinished.setHeight(getMeasuredHeight());
				listener.eventOccurred(EventId.measureFinished, measureFinished);
			}
		}
		
		@Override
		protected void onLayout(boolean changed, int l, int t, int r, int b) {
			super.onLayout(changed, l, t, r, b);
			ViewImpl.setDrawableBounds(ViewPagerImpl.this, l, t, r, b);
			ViewImpl.nativeMakeFrame(asNativeWidget(), l, t, getAdjustedRight(r, l), b);updateBounds(l, t, r, b);
			replayBufferedEvents();
			canvas.reset();
			onDraw(canvas);
	        ViewImpl.redrawDrawables(ViewPagerImpl.this);
			
			IWidgetLifeCycleListener listener = (IWidgetLifeCycleListener) getListener();
			if (listener != null) {
				onLayoutEvent.setB(b);
				onLayoutEvent.setL(l);
				onLayoutEvent.setR(r);
				onLayoutEvent.setT(t);
				onLayoutEvent.setChanged(changed);
				listener.eventOccurred(EventId.onLayout, onLayoutEvent);
			}
			
			if (isInvalidateOnFrameChange() && isInitialised()) {
				ViewPagerImpl.this.invalidate();
			}
		}	
		
		@Override
		public void execute(String method, Object... canvas) {
			
		}

		public void updateMeasuredDimension(int width, int height) {
			setMeasuredDimension(width, height);
		}


		@Override
		public ILifeCycleDecorator newInstance(IWidget widget) {
			throw new UnsupportedOperationException();
		}

		@Override
		public void setAttribute(WidgetAttribute widgetAttribute,
				String strValue, Object objValue) {
			throw new UnsupportedOperationException();
		}		
		

		@Override
		public List<String> getMethods() {
			throw new UnsupportedOperationException();
		}
		
		@Override
		public void initialized() {
			throw new UnsupportedOperationException();
		}
		
        @Override
        public Object getAttribute(WidgetAttribute widgetAttribute) {
            throw new UnsupportedOperationException();
        }
        @Override
        public void drawableStateChanged() {
        	super.drawableStateChanged();
        	ViewImpl.drawableStateChanged(ViewPagerImpl.this);
        }
        private Map<String, IWidget> templates;
    	@Override
    	public r.android.view.View inflateView(java.lang.String layout) {
    		if (templates == null) {
    			templates = new java.util.HashMap<String, IWidget>();
    		}
    		IWidget template = templates.get(layout);
    		if (template == null) {
    			template = (IWidget) quickConvert(layout, "template");
    			templates.put(layout, template);
    		}
    		IWidget widget = template.loadLazyWidgets(ViewPagerImpl.this.getParent());
    		return (View) widget.asWidget();
    	}        
        
    	@Override
		public void remeasure() {
			getFragment().remeasure();
		}
    	
        @Override
		public void removeFromParent() {
        	ViewPagerImpl.this.getParent().remove(ViewPagerImpl.this);
		}
        @Override
        public void getLocationOnScreen(int[] appScreenLocation) {
        	appScreenLocation[0] = ViewImpl.getLocationXOnScreen(asNativeWidget());
        	appScreenLocation[1] = ViewImpl.getLocationYOnScreen(asNativeWidget());
        }
        @Override
        public void getWindowVisibleDisplayFrame(r.android.graphics.Rect displayFrame){
        	
        	displayFrame.left = ViewImpl.getLocationXOnScreen(asNativeWidget());
        	displayFrame.top = ViewImpl.getLocationYOnScreen(asNativeWidget());
        	displayFrame.right = displayFrame.left + getWidth();
        	displayFrame.bottom = displayFrame.top + getHeight();
        }
        @Override
		public void offsetTopAndBottom(int offset) {
			super.offsetTopAndBottom(offset);
			ViewImpl.nativeMakeFrame(asNativeWidget(), getLeft(), getTop(), getRight(), getBottom());
		}
		@Override
		public void offsetLeftAndRight(int offset) {
			super.offsetLeftAndRight(offset);
			ViewImpl.nativeMakeFrame(asNativeWidget(), getLeft(), getTop(), getRight(), getBottom());
		}
		@Override
		public void setMyAttribute(String name, Object value) {
			ViewPagerImpl.this.setAttribute(name, value, true);
		}
        @Override
        public void setVisibility(int visibility) {
            super.setVisibility(visibility);
            ViewImpl.nativeSetVisibility(asNativeWidget(), visibility != View.VISIBLE);
            
        }
        @Override
        protected void smoothScrollTo(int x, int y, int velocity) {
        	ViewPagerImpl.this.smoothScrollTo(x, y, velocity);
        }
        
        @Override
        public int getScrollX() {
        	return ViewPagerImpl.this.getScrollX();
        }
        
        @Override
        protected void scrollTo(int x, int y) {
        	ViewPagerImpl.this.scrollTo(x, y);
        }
        
        	public void state0() {
        		ViewImpl.state(ViewPagerImpl.this, 0);
        	}
        	public void state1() {
        		ViewImpl.state(ViewPagerImpl.this, 1);
        	}
        	public void state2() {
        		ViewImpl.state(ViewPagerImpl.this, 2);
        	}
        	public void state3() {
        		ViewImpl.state(ViewPagerImpl.this, 3);
        	}
        	public void state4() {
        		ViewImpl.state(ViewPagerImpl.this, 4);
        	}
                        
        public void stateYes() {
        	ViewImpl.stateYes(ViewPagerImpl.this);
        	
        }
        
        public void stateNo() {
        	ViewImpl.stateNo(ViewPagerImpl.this);
        }
	}
	@Override
	public Class getViewClass() {
		return ViewPagerExt.class;
	}
	
	@SuppressLint("NewApi")
	@Override
	public void setAttribute(WidgetAttribute key, String strValue, Object objValue, ILifeCycleDecorator decorator) {
		ViewGroupImpl.setAttribute(this, key, strValue, objValue, decorator);
		Object nativeWidget = asNativeWidget();
		switch (key.getAttributeName()) {
			case "currentItem": {


		setCurrentItem((int) objValue);



			}
			break;
			case "offscreenPageLimit": {


	viewPager.setOffscreenPageLimit((int)objValue);



			}
			break;
			case "pageMargin": {


	viewPager.setPageMargin((int)objValue);



			}
			break;
			case "pageMarginDrawable": {


	viewPager.setPageMarginDrawable((Drawable)objValue);



			}
			break;
			case "onPageScrolled": {


		if (objValue instanceof String) {viewPager.setOnPageChangeListener(new OnPageChangeListener(this, strValue, "onPageScrolled"));} else {viewPager.setOnPageChangeListener((ViewPager.OnPageChangeListener) objValue);}



			}
			break;
			case "onPageSelected": {


		if (objValue instanceof String) {viewPager.setOnPageChangeListener(new OnPageChangeListener(this, strValue, "onPageSelected"));} else {viewPager.setOnPageChangeListener((ViewPager.OnPageChangeListener) objValue);}



			}
			break;
			case "onPageScrollStateChange": {


		if (objValue instanceof String) {viewPager.setOnPageChangeListener(new OnPageChangeListener(this, strValue, "onPageScrollStateChange"));} else {viewPager.setOnPageChangeListener((ViewPager.OnPageChangeListener) objValue);}



			}
			break;
			case "pageWidth": {


		setPageWidth(objValue);



			}
			break;
			case "pageTitles": {


		setPageTitles(objValue);



			}
			break;
		default:
			break;
		}
		
	}
	
	@Override
	@SuppressLint("NewApi")
	public Object getAttribute(WidgetAttribute key, ILifeCycleDecorator decorator) {
		Object attributeValue = ViewGroupImpl.getAttribute(this, key, decorator);
		if (attributeValue != null) {
			return attributeValue;
		}
		Object nativeWidget = asNativeWidget();
		switch (key.getAttributeName()) {
		}
		return null;
	}


	@Override
    public Object asNativeWidget() {
        return uiView;
    }
    public native boolean checkIosVersion(String v) /*-[
		return ([[[UIDevice currentDevice] systemVersion] compare:v options:NSNumericSearch] == NSOrderedDescending);
	]-*/;
    
    @Override
    public void requestLayout() {
    	if (isInitialised()) {
    		ViewImpl.requestLayout(this, asNativeWidget());
    	}
    }
    
    @Override
    public void invalidate() {
    	if (isInitialised()) {
    		ViewImpl.invalidate(this, asNativeWidget());
    	}
    }
    
	

	public class CustomPagerAdapter extends androidx.viewpager.widget.PagerAdapter {
	    public CustomPagerAdapter() {
	    }

	    @Override
	    public Object instantiateItem(ViewGroup collection, int position) {
	    	com.ashera.model.LoopParam model = dataList.get(position);
            IWidget myWidget = (IWidget) getListItem().loadLazyWidgets(ViewPagerImpl.this, -1, "", model);
            updateModelRecurse(myWidget, model);
            View layout = (View) myWidget.asWidget();
            layout.setTag(position);
	        return layout;
	    }

	    @Override
	    public void destroyItem(ViewGroup collection, int position, Object view) {
			for (IWidget w : widgets) {
				View myview = (View) w.asWidget();
				if (myview == view) {
					ViewGroupImpl.nativeRemoveView(w);
					break;
				}
			}
			viewPager.removeView((View) view);
	    }

		@Override
	    public int getCount() {
	        return dataList.size();
	    }

	    @Override
	    public boolean isViewFromObject(View view, Object object) {
	        return view == object;
	    }

	    @Override
	    public CharSequence getPageTitle(int position) {
	    	if (pageTitles != null && position < pageTitles.size()) {
	    		return pageTitles.get(position);
	    	}
	        return "";
	    }
	    
		@Override
		public float getPageWidth(int position) {
			return pageWidth;
		}
	}
	

	@Override
	public void initialized() {
		super.initialized();
		viewPager.getAdapter().notifyDataSetChanged();
	}
	
	@Override
	protected void addItemToParent(int index, java.lang.String id, com.ashera.model.LoopParam childModel) {
	}
	
	private float pageWidth = 1.0f;
	private List<String> pageTitles;
	private void setPageTitles(Object objValue) {
		pageTitles = (List<String>) objValue;
	}

	private void setPageWidth(Object objValue) {
		pageWidth = (float) objValue;
	}


	


	private void addListeners() {
		addOnKeyListener();
        ViewPagerPanListener listener = new ViewPagerPanListener();
        ViewImpl.addPanListener(this, asNativeWidget(), listener);
	}
	private void addOnKeyListener() {
		setAttribute("onKey", new View.OnKeyListener() {
			@Override
			public boolean onKey(View v, int keyCode, KeyEvent event) {
				if (isLeftPressed(keyCode)) {
					viewPager.arrowScroll(View.FOCUS_LEFT);
				}
				if (isRightPressed(keyCode)) {
					viewPager.arrowScroll(View.FOCUS_RIGHT);
				}
				return false;
			}
        	
        }, true);
	}
	
	private int animationDurationInMs = 200;
	private int currentX = -1;
	private void smoothScrollTo(int x, int y, int velocity) {
		int currentX = ViewImpl.getX(asNativeWidget());
		if (-currentX == x) {
			return;
		}
		this.currentX = currentX;
		getFragment().remeasure();
		ViewImpl.updateBoundsX(asNativeWidget(), currentX);
		this.currentX = -1;
		ViewImpl.translateWithAnimation(asNativeWidget(), -x, y, animationDurationInMs, (tX, tY) -> {
			int mycurrentX = ViewImpl.getX(asNativeWidget());
			viewPager.pageScrolled(-mycurrentX);
			ViewImpl.updateBoundsX(asNativeWidget(), mycurrentX);
		});
	}
	
	private void scrollTo(int x, int y) {
		ViewImpl.updateBoundsX(asNativeWidget(), -x);
	}

	private int getScrollX() {
		if (this.currentX != -1) {
			return -this.currentX;
		}
		int currentX = ViewImpl.getX(asNativeWidget());
		return -currentX;
	}
	
	private int lastValue;  
	private int startX = -1;
	private void handlePanStart(int eventX) {
		lastValue = eventX;
		startX = eventX;
		if (!viewPager.isEmpty()) {
			viewPager.beginFakeDrag();
		}
	}
	
	
	private void handlePanEnd(int eventX) {
		startX = -1;
		if (!viewPager.isEmpty()) {
			viewPager.endFakeDrag();
		}
	}

	private void handlePanDrag(int eventX) {
		if (startX != -1) {
			int delta = eventX - lastValue;
			if (!viewPager.isEmpty()) {
				viewPager.fakeDragBy(delta);
			}
			lastValue = eventX;
		}
	}
	
	private int prevWidth = -1; 
	private int prevHeight = -1;
	private void updateBounds(int l, int t, int r, int b) {
		if (viewPager.getCurrentItem() != 0 && currentX == -1) {
			viewPager.scrollToItem(viewPager.getCurrentItem(), false, 0, false);
		}

		if (isInitialised() && ((prevWidth != -1 && prevWidth != (r - l)) || prevHeight != -1 && prevHeight != (b - t))) {
			((CanvasImpl) canvas).canvasReset = true;
			canvas.reset();
			((CanvasImpl) canvas).canvasReset = false;
		}
		prevWidth = r - l;
		prevHeight = b - t;
	}
	
	private class ViewPagerPanListener implements ViewImpl.PanCallBack {
		public ViewPagerPanListener() {
		}
	
		@Override
		public void handlePanStart(IWidget widget, Object eventWidget, int x, int y) {
			int eventX = getAbsX(eventWidget, x, y);
			ViewPagerImpl.this.handlePanStart(eventX);
		}

		@Override
		public void handlePanDrag(IWidget widget, Object eventWidget, int x, int y) {
			int eventX = getAbsX(eventWidget, x, y);
			ViewPagerImpl.this.handlePanDrag(eventX);
			
		}

		@Override
		public void handlePanEnd(IWidget widget, Object eventWidget, int x, int y) {
			int eventX = getAbsX(eventWidget, x, y);
			ViewPagerImpl.this.handlePanEnd(eventX);
		}
	}
	
	

	private void setCurrentItem(int currentItem) {
		if (isInitialised()) {
			viewPager.setCurrentItem(currentItem);
		} else {
			viewPager.setVisibility(View.INVISIBLE);
			viewPager.post(() -> {
				viewPager.setCurrentItem(currentItem, false);
				viewPager.setVisibility(View.VISIBLE);
				viewPager.requestLayout();
				viewPager.remeasure();
			});
		}
	}

	private int getAdjustedRight(int r, int l) {
		return (dataList.size() * (r - l)) + (viewPager.getPageMargin() * 2 * viewPager.getChildCount());
	}
	


	@com.google.j2objc.annotations.WeakOuter
	private static final class CanvasImpl implements r.android.graphics.Canvas {
		private boolean canvasReset = false;
		private List<Object> imageViews = new java.util.ArrayList<Object>();
		@com.google.j2objc.annotations.Weak private IWidget widget;
		public CanvasImpl(IWidget widget) {
			this.widget = widget;
		}

		@Override
		public void draw(r.android.graphics.drawable.Drawable mDivider) {
			for (Object divider : imageViews) {
				if (ViewImpl.getX(divider) == mDivider.getLeft() && ViewImpl.getY(divider) == mDivider.getTop()) {
					return;
				}
			}
			if (mDivider.getDrawable() != null) {
				Object imageView = nativeCreateImageView(mDivider.getDrawable());
				ViewImpl.nativeMakeFrame(imageView, mDivider.getLeft(), mDivider.getTop(), mDivider.getRight(), mDivider.getBottom());
				imageViews.add(imageView);				
				ViewGroupImpl.nativeAddView(widget.asNativeWidget(), imageView);
			}
		}

		@Override
		public void reset() {
			if (canvasReset) {
				for (Object imageView : imageViews) {
					ViewGroupImpl.removeView(imageView);
				}
				imageViews.clear();
			}
		}
		
		public native Object nativeCreateImageView(Object image)/*-[
			ASUIImageView* imageView = [ASUIImageView new];
			if ([image isKindOfClass:[UIImage class]]) {
				imageView.image = image;
				imageView.backgroundColor = nil;
			}else if ([image isKindOfClass:[UIColor class]]) {
				imageView.backgroundColor = image;
				imageView.image = nil;
			}
			return imageView;
		]-*/;
	}

	private void createCanvas() {
		canvas = new CanvasImpl(this);
		
	}
	

	@SuppressLint("NewApi")
private static class OnPageChangeListener implements ViewPager.OnPageChangeListener, com.ashera.widget.IListener{
private IWidget w; private View view; private String strValue; private String action;
public String getAction() {return action;}
public OnPageChangeListener(IWidget w, String strValue)  {
this.w = w; this.strValue = strValue;
}
public OnPageChangeListener(IWidget w, String strValue, String action)  {
this.w = w; this.strValue = strValue;this.action=action;
}
public void onPageScrolled(int position,float positionOffset,int positionOffsetPixels){
    
	if (action == null || action.equals("onPageScrolled")) {
		// populate the data from ui to pojo
		w.syncModelFromUiToPojo("onPageScrolled");
	    java.util.Map<String, Object> obj = getOnPageScrolledEventObj(position,positionOffset,positionOffsetPixels);
	    String commandName =  (String) obj.get(EventExpressionParser.KEY_COMMAND_NAME);
	    
	    // execute command based on command type
	    String commandType = (String)obj.get(EventExpressionParser.KEY_COMMAND_TYPE);
		switch (commandType) {
		case "+":
		    if (EventCommandFactory.hasCommand(commandName)) {
		    	 EventCommandFactory.getCommand(commandName).executeCommand(w, obj, position,positionOffset,positionOffsetPixels);
		    }

			break;
		default:
			break;
		}
		
		if (obj.containsKey("refreshUiFromModel")) {
			Object widgets = obj.remove("refreshUiFromModel");
			com.ashera.layout.ViewImpl.refreshUiFromModel(w, widgets, true);
		}
		if (w.getModelUiToPojoEventIds() != null) {
			com.ashera.layout.ViewImpl.refreshUiFromModel(w, w.getModelUiToPojoEventIds(), true);
		}
		if (strValue != null && !strValue.isEmpty() && !strValue.trim().startsWith("+")) {
		    com.ashera.core.IActivity activity = (com.ashera.core.IActivity)w.getFragment().getRootActivity();
		    activity.sendEventMessage(obj);
		}
	}
    return;
}//#####

public java.util.Map<String, Object> getOnPageScrolledEventObj(int position,float positionOffset,int positionOffsetPixels) {
	java.util.Map<String, Object> obj = com.ashera.widget.PluginInvoker.getJSONCompatMap();
    obj.put("action", "action");
    obj.put("eventType", "pagescrolled");
    obj.put("fragmentId", w.getFragment().getFragmentId());
    obj.put("actionUrl", w.getFragment().getActionUrl());
    
    if (w.getComponentId() != null) {
    	obj.put("componentId", w.getComponentId());
    }
    
    PluginInvoker.putJSONSafeObjectIntoMap(obj, "id", w.getId());
     
        PluginInvoker.putJSONSafeObjectIntoMap(obj, "position", position);
        PluginInvoker.putJSONSafeObjectIntoMap(obj, "positionOffset", positionOffset);
        PluginInvoker.putJSONSafeObjectIntoMap(obj, "positionOffsetPixels", positionOffsetPixels);
    
    // parse event info into the map
    EventExpressionParser.parseEventExpression(strValue, obj);
    
    // update model data into map
    w.updateModelToEventMap(obj, "onPageScrolled", (String)obj.get(EventExpressionParser.KEY_EVENT_ARGS));
    return obj;
}public void onPageSelected(int position){
    
	if (action == null || action.equals("onPageSelected")) {
		// populate the data from ui to pojo
		w.syncModelFromUiToPojo("onPageSelected");
	    java.util.Map<String, Object> obj = getOnPageSelectedEventObj(position);
	    String commandName =  (String) obj.get(EventExpressionParser.KEY_COMMAND_NAME);
	    
	    // execute command based on command type
	    String commandType = (String)obj.get(EventExpressionParser.KEY_COMMAND_TYPE);
		switch (commandType) {
		case "+":
		    if (EventCommandFactory.hasCommand(commandName)) {
		    	 EventCommandFactory.getCommand(commandName).executeCommand(w, obj, position);
		    }

			break;
		default:
			break;
		}
		
		if (obj.containsKey("refreshUiFromModel")) {
			Object widgets = obj.remove("refreshUiFromModel");
			com.ashera.layout.ViewImpl.refreshUiFromModel(w, widgets, true);
		}
		if (w.getModelUiToPojoEventIds() != null) {
			com.ashera.layout.ViewImpl.refreshUiFromModel(w, w.getModelUiToPojoEventIds(), true);
		}
		if (strValue != null && !strValue.isEmpty() && !strValue.trim().startsWith("+")) {
		    com.ashera.core.IActivity activity = (com.ashera.core.IActivity)w.getFragment().getRootActivity();
		    activity.sendEventMessage(obj);
		}
	}
    return;
}//#####

public java.util.Map<String, Object> getOnPageSelectedEventObj(int position) {
	java.util.Map<String, Object> obj = com.ashera.widget.PluginInvoker.getJSONCompatMap();
    obj.put("action", "action");
    obj.put("eventType", "pageselected");
    obj.put("fragmentId", w.getFragment().getFragmentId());
    obj.put("actionUrl", w.getFragment().getActionUrl());
    
    if (w.getComponentId() != null) {
    	obj.put("componentId", w.getComponentId());
    }
    
    PluginInvoker.putJSONSafeObjectIntoMap(obj, "id", w.getId());
     
        PluginInvoker.putJSONSafeObjectIntoMap(obj, "position", position);
    
    // parse event info into the map
    EventExpressionParser.parseEventExpression(strValue, obj);
    
    // update model data into map
    w.updateModelToEventMap(obj, "onPageSelected", (String)obj.get(EventExpressionParser.KEY_EVENT_ARGS));
    return obj;
}public void onPageScrollStateChanged(int state){
    
	if (action == null || action.equals("onPageScrollStateChanged")) {
		// populate the data from ui to pojo
		w.syncModelFromUiToPojo("onPageScrollStateChanged");
	    java.util.Map<String, Object> obj = getOnPageScrollStateChangedEventObj(state);
	    String commandName =  (String) obj.get(EventExpressionParser.KEY_COMMAND_NAME);
	    
	    // execute command based on command type
	    String commandType = (String)obj.get(EventExpressionParser.KEY_COMMAND_TYPE);
		switch (commandType) {
		case "+":
		    if (EventCommandFactory.hasCommand(commandName)) {
		    	 EventCommandFactory.getCommand(commandName).executeCommand(w, obj, state);
		    }

			break;
		default:
			break;
		}
		
		if (obj.containsKey("refreshUiFromModel")) {
			Object widgets = obj.remove("refreshUiFromModel");
			com.ashera.layout.ViewImpl.refreshUiFromModel(w, widgets, true);
		}
		if (w.getModelUiToPojoEventIds() != null) {
			com.ashera.layout.ViewImpl.refreshUiFromModel(w, w.getModelUiToPojoEventIds(), true);
		}
		if (strValue != null && !strValue.isEmpty() && !strValue.trim().startsWith("+")) {
		    com.ashera.core.IActivity activity = (com.ashera.core.IActivity)w.getFragment().getRootActivity();
		    activity.sendEventMessage(obj);
		}
	}
    return;
}//#####

public java.util.Map<String, Object> getOnPageScrollStateChangedEventObj(int state) {
	java.util.Map<String, Object> obj = com.ashera.widget.PluginInvoker.getJSONCompatMap();
    obj.put("action", "action");
    obj.put("eventType", "pagescrollstatechanged");
    obj.put("fragmentId", w.getFragment().getFragmentId());
    obj.put("actionUrl", w.getFragment().getActionUrl());
    
    if (w.getComponentId() != null) {
    	obj.put("componentId", w.getComponentId());
    }
    
    PluginInvoker.putJSONSafeObjectIntoMap(obj, "id", w.getId());
     
        PluginInvoker.putJSONSafeObjectIntoMap(obj, "state", state);
    
    // parse event info into the map
    EventExpressionParser.parseEventExpression(strValue, obj);
    
    // update model data into map
    w.updateModelToEventMap(obj, "onPageScrollStateChanged", (String)obj.get(EventExpressionParser.KEY_EVENT_ARGS));
    return obj;
}
}


	@Override
	public void setId(String id){
		if (id != null && !id.equals("")){
			super.setId(id);
			viewPager.setId((int) quickConvert(id, "id"));
		}
	}
	
    
    @Override
    public void setVisible(boolean b) {
        ((View)asWidget()).setVisibility(b ? View.VISIBLE : View.GONE);
    }

	
private ViewPagerCommandBuilder builder;
private ViewPagerBean bean;
public Object getPlugin(String plugin) {
	return WidgetFactory.getAttributable(plugin).newInstance(this);
}
public ViewPagerBean getBean() {
	if (bean == null) {
		bean = new ViewPagerBean();
	}
	return bean;
}
public ViewPagerCommandBuilder getBuilder() {
	if (builder == null) {
		builder = new ViewPagerCommandBuilder();
	}
	return builder;
}


public  class ViewPagerCommandBuilder extends com.ashera.layout.ViewGroupImpl.ViewGroupCommandBuilder <ViewPagerCommandBuilder> {
    public ViewPagerCommandBuilder() {
	}
	
	public ViewPagerCommandBuilder execute(boolean setter) {
		if (setter) {
			executeCommand(command, null, IWidget.COMMAND_EXEC_SETTER_METHOD);
			getFragment().remeasure();
		}
		executeCommand(command, null, IWidget.COMMAND_EXEC_GETTER_METHOD);
return this;	}

public ViewPagerCommandBuilder setCurrentItem(int value) {
	Map<String, Object> attrs = initCommand("currentItem");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ViewPagerCommandBuilder setOffscreenPageLimit(int value) {
	Map<String, Object> attrs = initCommand("offscreenPageLimit");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ViewPagerCommandBuilder setPageMargin(String value) {
	Map<String, Object> attrs = initCommand("pageMargin");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ViewPagerCommandBuilder setPageMarginDrawable(String value) {
	Map<String, Object> attrs = initCommand("pageMarginDrawable");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ViewPagerCommandBuilder setOnPageScrolled(String value) {
	Map<String, Object> attrs = initCommand("onPageScrolled");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ViewPagerCommandBuilder setOnPageSelected(String value) {
	Map<String, Object> attrs = initCommand("onPageSelected");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ViewPagerCommandBuilder setOnPageScrollStateChange(String value) {
	Map<String, Object> attrs = initCommand("onPageScrollStateChange");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ViewPagerCommandBuilder setPageWidth(float value) {
	Map<String, Object> attrs = initCommand("pageWidth");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ViewPagerCommandBuilder setPageTitles(String value) {
	Map<String, Object> attrs = initCommand("pageTitles");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
}
public class ViewPagerBean extends com.ashera.layout.ViewGroupImpl.ViewGroupBean{
		public ViewPagerBean() {
			super(ViewPagerImpl.this);
		}
public void setCurrentItem(int value) {
	getBuilder().reset().setCurrentItem(value).execute(true);
}

public void setOffscreenPageLimit(int value) {
	getBuilder().reset().setOffscreenPageLimit(value).execute(true);
}

public void setPageMargin(String value) {
	getBuilder().reset().setPageMargin(value).execute(true);
}

public void setPageMarginDrawable(String value) {
	getBuilder().reset().setPageMarginDrawable(value).execute(true);
}

public void setOnPageScrolled(String value) {
	getBuilder().reset().setOnPageScrolled(value).execute(true);
}

public void setOnPageSelected(String value) {
	getBuilder().reset().setOnPageSelected(value).execute(true);
}

public void setOnPageScrollStateChange(String value) {
	getBuilder().reset().setOnPageScrollStateChange(value).execute(true);
}

public void setPageWidth(float value) {
	getBuilder().reset().setPageWidth(value).execute(true);
}

public void setPageTitles(String value) {
	getBuilder().reset().setPageTitles(value).execute(true);
}

}


private ViewPagerCommandParamsBuilder paramsBuilder;
private ViewPagerParamsBean paramsBean;

public ViewPagerParamsBean getParamsBean() {
	if (paramsBean == null) {
		paramsBean = new ViewPagerParamsBean();
	}
	return paramsBean;
}
public ViewPagerCommandParamsBuilder getParamsBuilder() {
	if (paramsBuilder == null) {
		paramsBuilder = new ViewPagerCommandParamsBuilder();
	}
	return paramsBuilder;
}



public class ViewPagerParamsBean extends com.ashera.layout.ViewGroupImpl.ViewGroupParamsBean{
public void setLayoutGravity(IWidget w, String value) {
	java.util.Map<String, Object> layoutParams = new java.util.HashMap<String, Object>();
	layoutParams.put("layoutParams", getParamsBuilder().reset().setLayoutGravity(value).getCommand());
	w.executeCommand(layoutParams, null, COMMAND_EXEC_SETTER_METHOD);
	w.getFragment().remeasure();
}

public void setLayoutIsdecor(IWidget w, boolean value) {
	java.util.Map<String, Object> layoutParams = new java.util.HashMap<String, Object>();
	layoutParams.put("layoutParams", getParamsBuilder().reset().setLayoutIsdecor(value).getCommand());
	w.executeCommand(layoutParams, null, COMMAND_EXEC_SETTER_METHOD);
	w.getFragment().remeasure();
}

}





public class ViewPagerCommandParamsBuilder extends com.ashera.layout.ViewGroupImpl.ViewGroupCommandParamsBuilder<ViewPagerCommandParamsBuilder>{
public ViewPagerCommandParamsBuilder setLayoutGravity(String value) {
	Map<String, Object> attrs = initCommand("layout_gravity");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ViewPagerCommandParamsBuilder setLayoutIsdecor(boolean value) {
	Map<String, Object> attrs = initCommand("layout_isdecor");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
}

	//end - body
	private void nativeCreate(Map<String, Object> params) {
		viewPager.setAdapter(new CustomPagerAdapter());
		uiView = createView(params);
        addListeners();
	}
	private native Object createView(Map<String, Object> params)/*-[
		ASUIView* uiView = [ASUIView new];
		uiView.backgroundColor = [UIColor clearColor];
		return uiView;
	]-*/;
	

	private boolean isRightPressed(int keyCode) {
		return false;
	}

	private boolean isLeftPressed(int keyCode) {
		return false;
	}
	

	private native int getAbsX(Object eventWidget, int x, int y)/*-[
		return [self->uiView_ convertRect:CGRectMake(x, y, ((UIView*)self->uiView_).frame.size.width, ((UIView*)self->uiView_).frame.size.height) toView:nil].origin.x;
	]-*/;

}
