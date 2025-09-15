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

import org.teavm.jso.dom.html.HTMLElement;

import static com.ashera.widget.IWidget.*;
//end - imports
import r.android.graphics.drawable.Drawable;
import androidx.viewpager.widget.ViewPager;

public class ViewPagerImpl extends BaseHasWidgets {
	//start - body
	private HTMLElement htmlElement;
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

	}

	@Override
	public Object asWidget() {
		return viewPager;
	}

	@Override
	public boolean remove(IWidget w) {
		boolean remove = super.remove(w);
		viewPager.removeView((View) w.asWidget());
		 nativeRemoveView(w);            
		return remove;
	}
	
	@Override
    public boolean remove(int index) {
		IWidget widget = widgets.get(index);
        boolean remove = super.remove(index);

        if (index + 1 <= viewPager.getChildCount()) {
            viewPager.removeViewAt(index);
            nativeRemoveView(widget);
        }    
        return remove;
    }

	private void nativeRemoveView(IWidget widget) {
		r.android.animation.LayoutTransition layoutTransition = viewPager.getLayoutTransition();
		if (layoutTransition != null && (
				layoutTransition.isTransitionTypeEnabled(r.android.animation.LayoutTransition.CHANGE_DISAPPEARING) ||
				layoutTransition.isTransitionTypeEnabled(r.android.animation.LayoutTransition.DISAPPEARING)
				)) {
			addToBufferedRunnables(() -> ViewGroupImpl.nativeRemoveView(widget));          
		} else {
			ViewGroupImpl.nativeRemoveView(widget);
		}
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
	
		
	public class ViewPagerExt extends androidx.viewpager.widget.ViewPager implements ILifeCycleDecorator, com.ashera.widget.IMaxDimension{
		private MeasureEvent measureFinished = new MeasureEvent();
		private OnLayoutEvent onLayoutEvent = new OnLayoutEvent();
		private List<IWidget> overlays;
		public IWidget getWidget() {
			return ViewPagerImpl.this;
		}
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
			if (!isOverlay()) {
			ViewImpl.nativeMakeFrame(asNativeWidget(), l, t, getAdjustedRight(r, l), b);updateBounds(l, t, r, b);
			}
			replayBufferedEvents();
			canvas.reset();
			onDraw(canvas);
	        ViewImpl.redrawDrawables(ViewPagerImpl.this);
	        overlays = ViewImpl.drawOverlay(ViewPagerImpl.this, overlays);
			
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
        	if (!isWidgetDisposed()) {
        		ViewImpl.drawableStateChanged(ViewPagerImpl.this);
        	}
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
    		
    		IWidget widget = template.loadLazyWidgets(ViewPagerImpl.this);
			return (View) widget.asWidget();
    	}   
        
    	@Override
		public void remeasure() {
    		if (getFragment() != null) {
    			getFragment().remeasure();
    		}
		}
    	
        @Override
		public void removeFromParent() {
        	ViewPagerImpl.this.getParent().remove(ViewPagerImpl.this);
		}
        @Override
        public void getLocationOnScreen(int[] appScreenLocation) {
        	appScreenLocation[0] = htmlElement.getBoundingClientRect().getLeft();
        	appScreenLocation[1] = htmlElement.getBoundingClientRect().getTop();
        }
        @Override
        public void getWindowVisibleDisplayFrame(r.android.graphics.Rect displayFrame){
        	
        	org.teavm.jso.dom.html.TextRectangle boundingClientRect = htmlElement.getBoundingClientRect();
			displayFrame.top = boundingClientRect.getTop();
        	displayFrame.left = boundingClientRect.getLeft();
        	displayFrame.bottom = boundingClientRect.getBottom();
        	displayFrame.right = boundingClientRect.getRight();
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
			if (name.equals("state0")) {
				setState0(value);
				return;
			}
			if (name.equals("state1")) {
				setState1(value);
				return;
			}
			if (name.equals("state2")) {
				setState2(value);
				return;
			}
			if (name.equals("state3")) {
				setState3(value);
				return;
			}
			if (name.equals("state4")) {
				setState4(value);
				return;
			}
			ViewPagerImpl.this.setAttribute(name, value, !(value instanceof String));
		}
        @Override
        public void setVisibility(int visibility) {
            super.setVisibility(visibility);
            ((HTMLElement)asNativeWidget()).getStyle().setProperty("display", visibility != View.VISIBLE ? "none" : "block");
            
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
        
    	public void setState0(Object value) {
    		ViewImpl.setState(ViewPagerImpl.this, 0, value);
    	}
    	public void setState1(Object value) {
    		ViewImpl.setState(ViewPagerImpl.this, 1, value);
    	}
    	public void setState2(Object value) {
    		ViewImpl.setState(ViewPagerImpl.this, 2, value);
    	}
    	public void setState3(Object value) {
    		ViewImpl.setState(ViewPagerImpl.this, 3, value);
    	}
    	public void setState4(Object value) {
    		ViewImpl.setState(ViewPagerImpl.this, 4, value);
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
     
		@Override
		public void endViewTransition(r.android.view.View view) {
			super.endViewTransition(view);
			runBufferedRunnables();
		}
	
	}
	@Override
	public Class getViewClass() {
		return ViewPagerExt.class;
	}
	
	@SuppressLint("NewApi")
	@Override
	public void setAttribute(WidgetAttribute key, String strValue, Object objValue, ILifeCycleDecorator decorator) {
				ViewGroupImpl.setAttribute(this,  key, strValue, objValue, decorator);
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
        return htmlElement;
    }
    
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
		ViewImpl.translateWithAnimation(asNativeWidget(), -x, ViewImpl.getY(asNativeWidget()), animationDurationInMs, (tX, tY) -> {
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
	


	private final static class CanvasImpl implements r.android.graphics.Canvas {
		private boolean requiresAttrChangeListener = false;
		private boolean canvasReset = false;
		private List<HTMLElement> dividers = new java.util.ArrayList<>();
		private IWidget widget;
		public CanvasImpl(IWidget widget) {
			this.widget = widget;
		}
		@Override
		public void draw(r.android.graphics.drawable.Drawable mDivider) {
			for (HTMLElement divider : dividers) {
				if (ViewImpl.getPropertyValueAsInt(divider, "left") == mDivider.getLeft() && ViewImpl.getPropertyValueAsInt(divider, "top") == mDivider.getTop()) {
					return;
				}
			}
			HTMLElement imageElement = org.teavm.jso.dom.html.HTMLDocument.current().createElement("img");
			dividers.add(imageElement);
			ViewImpl.nativeMakeFrame(imageElement, mDivider.getLeft(), mDivider.getTop(), mDivider.getRight(),
					mDivider.getBottom());
			ViewGroupImpl.nativeAddView((HTMLElement) widget.asNativeWidget(), imageElement);
			
			if (requiresAttrChangeListener) {
				mDivider.setAttributeChangeListener((name, value) -> {
					switch (name) {
					case "bounds":
						r.android.graphics.Rect rect = (r.android.graphics.Rect) value;
						ViewImpl.nativeMakeFrame(imageElement, rect.left, rect.top, rect.right, rect.bottom);
						break;
					case "alpha":
						int alpha = (int) value;
						imageElement.getStyle().setProperty("opacity", (alpha/255f) + "");
						break;
					default:
						break;
					}
				});
			}
			Object drawable = mDivider.getDrawable();
			if (drawable instanceof String) {
				String drawableStr = (String) drawable;
				if (drawableStr.startsWith("#")) {
					imageElement.removeAttribute("src");
					imageElement.getStyle().setProperty("background-color", drawableStr);
				} else {
					imageElement.setAttribute("src", drawableStr);
					imageElement.getStyle().removeProperty("background-color");
				}
			} else if (drawable instanceof Integer){
				imageElement.getStyle().setProperty("background-color", (String) ViewImpl.getColor(drawable));
			}
		}

		@Override
		public void reset() {
			if (canvasReset) {
				for (HTMLElement divider : dividers) {
					divider.getParentNode().removeChild(divider);
				}
				dividers.clear();
			}
		}
	}

	private void createCanvas() {
		canvas= new CanvasImpl(this);
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
		    if (activity != null) {
		    	activity.sendEventMessage(obj);
		    }
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
    obj.put("namespace", w.getFragment().getNamespace());
    
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
		    if (activity != null) {
		    	activity.sendEventMessage(obj);
		    }
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
    obj.put("namespace", w.getFragment().getNamespace());
    
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
		    if (activity != null) {
		    	activity.sendEventMessage(obj);
		    }
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
    obj.put("namespace", w.getFragment().getNamespace());
    
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

		//end - body


	private void nativeCreate(Map<String, Object> params) {
		viewPager.setAdapter(new CustomPagerAdapter());
		storeInTempCache("onKeypreventDefault37", "onKeypreventDefault");
		storeInTempCache("onKeypreventDefault39", "onKeypreventDefault");
		htmlElement = org.teavm.jso.dom.html.HTMLDocument.current().createElement("div");
    	htmlElement.getStyle().setProperty("box-sizing", "border-box");
    	htmlElement.setAttribute("tabindex", "0");
    	addListeners();
	}
	
	

	public int getAbsX(Object eventWidget, int x, int y) {
		return x;
	}
	

	private boolean isRightPressed(int keyCode) {
		return keyCode == 39;
	}

	private boolean isLeftPressed(int keyCode) {
		return keyCode == 37;
	}
}
