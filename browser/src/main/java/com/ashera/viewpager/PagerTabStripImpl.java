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

public class PagerTabStripImpl extends BaseHasWidgets {
	//start - body
	private HTMLElement htmlElement;
	public final static String LOCAL_NAME = "androidx.viewpager.widget.PagerTabStrip"; 
	public final static String GROUP_NAME = "androidx.viewpager.widget.PagerTabStrip";
	private androidx.viewpager.widget.PagerTabStrip pagerTabStrip;
	

	
	@Override
	public void loadAttributes(String localName) {
		ViewGroupImpl.register(localName);

		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("textSpacing").withType("dimension"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("nonPrimaryAlpha").withType("float"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("textColor").withType("color"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("gravity").withType("gravity"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("textSize").withType("dimensionsp"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("textAppearance").withType("style"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("tabIndicatorColor").withType("color"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("drawFullUnderline").withType("boolean"));
	
	}
	
	public PagerTabStripImpl() {
		super(GROUP_NAME, LOCAL_NAME);
	}
	public  PagerTabStripImpl(String localname) {
		super(GROUP_NAME, localname);
	}
	public  PagerTabStripImpl(String groupName, String localname) {
		super(groupName, localname);
	}

	@Override
	public IWidget newInstance() {
		return new PagerTabStripImpl(groupName, localName);
	}
	
	@SuppressLint("NewApi")
	@Override
	public void create(IFragment fragment, Map<String, Object> params) {
		super.create(fragment, params);
		pagerTabStrip = new PagerTabStripExt();
		
		nativeCreate(params);
		
		
		ViewGroupImpl.registerCommandConveter(this);
	}

	@Override
	public Object asWidget() {
		return pagerTabStrip;
	}

	@Override
	public boolean remove(IWidget w) {
		boolean remove = super.remove(w);
		pagerTabStrip.removeView((View) w.asWidget());
		 nativeRemoveView(w);            
		return remove;
	}
	
	@Override
    public boolean remove(int index) {
		IWidget widget = widgets.get(index);
        boolean remove = super.remove(index);

        if (index + 1 <= pagerTabStrip.getChildCount()) {
            pagerTabStrip.removeViewAt(index);
            nativeRemoveView(widget);
        }    
        return remove;
    }

	private void nativeRemoveView(IWidget widget) {
		r.android.animation.LayoutTransition layoutTransition = pagerTabStrip.getLayoutTransition();
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
			        pagerTabStrip.addView(view);
			    } else {
			        pagerTabStrip.addView(view, index);
			    }
		}
		
		ViewGroupImpl.nativeAddView(asNativeWidget(), w.asNativeWidget());
		super.add(w, index);
	}
	
	private void createLayoutParams(View view) {
		androidx.viewpager.widget.PagerTabStrip.LayoutParams layoutParams = (androidx.viewpager.widget.PagerTabStrip.LayoutParams) view.getLayoutParams();
		
		layoutParams = (androidx.viewpager.widget.PagerTabStrip.LayoutParams) view.getLayoutParams();
		if (layoutParams == null) {
			layoutParams = new androidx.viewpager.widget.PagerTabStrip.LayoutParams(-2, -2);
			view.setLayoutParams(layoutParams);
		}  else {
			layoutParams.height = -2;
			layoutParams.width = -2;
		}
	}
	
	private androidx.viewpager.widget.PagerTabStrip.LayoutParams getLayoutParams(View view) {
		return (androidx.viewpager.widget.PagerTabStrip.LayoutParams) view.getLayoutParams();		
	}
	
	@SuppressLint("NewApi")
	@Override
	public void setChildAttribute(IWidget w, WidgetAttribute key, String strValue, Object objValue) {
		View view = (View) w.asWidget();
		androidx.viewpager.widget.PagerTabStrip.LayoutParams layoutParams = getLayoutParams(view);
		ViewGroupImpl.setChildAttribute(w, key, objValue, layoutParams);		
		
		switch (key.getAttributeName()) {
		case "layout_width":
			layoutParams.width = (int) objValue;
			break;	
		case "layout_height":
			layoutParams.height = (int) objValue;
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
		androidx.viewpager.widget.PagerTabStrip.LayoutParams layoutParams = getLayoutParams(view);

		switch (key.getAttributeName()) {
		case "layout_width":
			return layoutParams.width;
		case "layout_height":
			return layoutParams.height;
		}
		
		return null;

	}
	
		
	public class PagerTabStripExt extends androidx.viewpager.widget.PagerTabStrip implements ILifeCycleDecorator, com.ashera.widget.IMaxDimension{
		private MeasureEvent measureFinished = new MeasureEvent();
		private OnLayoutEvent onLayoutEvent = new OnLayoutEvent();
		private List<IWidget> overlays;
		public IWidget getWidget() {
			return PagerTabStripImpl.this;
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

		public PagerTabStripExt() {
			super(PagerTabStripImpl.this);
			
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
			ViewImpl.setDrawableBounds(PagerTabStripImpl.this, l, t, r, b);
			if (!isOverlay()) {
			ViewImpl.nativeMakeFrame(asNativeWidget(), l, t, r, b);
			}
			replayBufferedEvents();
	        ViewImpl.redrawDrawables(PagerTabStripImpl.this);
	        overlays = ViewImpl.drawOverlay(PagerTabStripImpl.this, overlays);
			
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
				PagerTabStripImpl.this.invalidate();
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
        		ViewImpl.drawableStateChanged(PagerTabStripImpl.this);
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
    		
    		IWidget widget = template.loadLazyWidgets(PagerTabStripImpl.this);
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
        	PagerTabStripImpl.this.getParent().remove(PagerTabStripImpl.this);
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
			PagerTabStripImpl.this.setAttribute(name, value, !(value instanceof String));
		}
        @Override
        public void setVisibility(int visibility) {
            super.setVisibility(visibility);
            ((HTMLElement)asNativeWidget()).getStyle().setProperty("display", visibility != View.VISIBLE ? "none" : "block");
            
        }
        
    	public void setState0(Object value) {
    		ViewImpl.setState(PagerTabStripImpl.this, 0, value);
    	}
    	public void setState1(Object value) {
    		ViewImpl.setState(PagerTabStripImpl.this, 1, value);
    	}
    	public void setState2(Object value) {
    		ViewImpl.setState(PagerTabStripImpl.this, 2, value);
    	}
    	public void setState3(Object value) {
    		ViewImpl.setState(PagerTabStripImpl.this, 3, value);
    	}
    	public void setState4(Object value) {
    		ViewImpl.setState(PagerTabStripImpl.this, 4, value);
    	}
        	public void state0() {
        		ViewImpl.state(PagerTabStripImpl.this, 0);
        	}
        	public void state1() {
        		ViewImpl.state(PagerTabStripImpl.this, 1);
        	}
        	public void state2() {
        		ViewImpl.state(PagerTabStripImpl.this, 2);
        	}
        	public void state3() {
        		ViewImpl.state(PagerTabStripImpl.this, 3);
        	}
        	public void state4() {
        		ViewImpl.state(PagerTabStripImpl.this, 4);
        	}
                        
        public void stateYes() {
        	ViewImpl.stateYes(PagerTabStripImpl.this);
        	
        }
        
        public void stateNo() {
        	ViewImpl.stateNo(PagerTabStripImpl.this);
        }
     
		@Override
		public void endViewTransition(r.android.view.View view) {
			super.endViewTransition(view);
			runBufferedRunnables();
		}
	
	}
	@Override
	public Class getViewClass() {
		return PagerTabStripExt.class;
	}
	
	@SuppressLint("NewApi")
	@Override
	public void setAttribute(WidgetAttribute key, String strValue, Object objValue, ILifeCycleDecorator decorator) {
				ViewGroupImpl.setAttribute(this, key, strValue, objValue, decorator);
		Object nativeWidget = asNativeWidget();
		switch (key.getAttributeName()) {
			case "textSpacing": {


	pagerTabStrip.setTextSpacing((int)objValue);



			}
			break;
			case "nonPrimaryAlpha": {


	pagerTabStrip.setNonPrimaryAlpha((float)objValue);



			}
			break;
			case "textColor": {


	pagerTabStrip.setTextColor(objValue);



			}
			break;
			case "gravity": {


	pagerTabStrip.setGravity((int)objValue);



			}
			break;
			case "textSize": {


		setTextSize(objValue);



			}
			break;
			case "textAppearance": {


		setTextAppearance(objValue);



			}
			break;
			case "tabIndicatorColor": {


	pagerTabStrip.setTabIndicatorColor(objValue);



			}
			break;
			case "drawFullUnderline": {


	pagerTabStrip.setDrawFullUnderline((boolean)objValue);



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
    
	

	private void nativeCreate(Map<String, Object> params) {
		createPane(params);
		pagerTabStrip.init(this);
	}

	private void setTextSize(Object objValue) {
		pagerTabStrip.setTextSize(0, (float) objValue);		
	}
	
	
	private void setTextAppearance(Object objValue) {
		pagerTabStrip.setTextAppearance(objValue);
	}
	


	@Override
	public void setId(String id){
		if (id != null && !id.equals("")){
			super.setId(id);
			pagerTabStrip.setId((int) quickConvert(id, "id"));
		}
	}
	
    
    @Override
    public void setVisible(boolean b) {
        ((View)asWidget()).setVisibility(b ? View.VISIBLE : View.GONE);
    }

	
private PagerTabStripCommandBuilder builder;
private PagerTabStripBean bean;
public Object getPlugin(String plugin) {
	return WidgetFactory.getAttributable(plugin).newInstance(this);
}
public PagerTabStripBean getBean() {
	if (bean == null) {
		bean = new PagerTabStripBean();
	}
	return bean;
}
public PagerTabStripCommandBuilder getBuilder() {
	if (builder == null) {
		builder = new PagerTabStripCommandBuilder();
	}
	return builder;
}


public  class PagerTabStripCommandBuilder extends com.ashera.layout.ViewGroupImpl.ViewGroupCommandBuilder <PagerTabStripCommandBuilder> {
    public PagerTabStripCommandBuilder() {
	}
	
	public PagerTabStripCommandBuilder execute(boolean setter) {
		if (setter) {
			executeCommand(command, null, IWidget.COMMAND_EXEC_SETTER_METHOD);
			getFragment().remeasure();
		}
		executeCommand(command, null, IWidget.COMMAND_EXEC_GETTER_METHOD);
return this;	}

public PagerTabStripCommandBuilder setTextSpacing(String value) {
	Map<String, Object> attrs = initCommand("textSpacing");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public PagerTabStripCommandBuilder setNonPrimaryAlpha(float value) {
	Map<String, Object> attrs = initCommand("nonPrimaryAlpha");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public PagerTabStripCommandBuilder setTextColor(String value) {
	Map<String, Object> attrs = initCommand("textColor");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public PagerTabStripCommandBuilder setGravity(String value) {
	Map<String, Object> attrs = initCommand("gravity");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public PagerTabStripCommandBuilder setTextSize(String value) {
	Map<String, Object> attrs = initCommand("textSize");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public PagerTabStripCommandBuilder setTextAppearance(String value) {
	Map<String, Object> attrs = initCommand("textAppearance");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public PagerTabStripCommandBuilder setTabIndicatorColor(String value) {
	Map<String, Object> attrs = initCommand("tabIndicatorColor");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public PagerTabStripCommandBuilder setDrawFullUnderline(boolean value) {
	Map<String, Object> attrs = initCommand("drawFullUnderline");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
}
public class PagerTabStripBean extends com.ashera.layout.ViewGroupImpl.ViewGroupBean{
		public PagerTabStripBean() {
			super(PagerTabStripImpl.this);
		}
public void setTextSpacing(String value) {
	getBuilder().reset().setTextSpacing(value).execute(true);
}

public void setNonPrimaryAlpha(float value) {
	getBuilder().reset().setNonPrimaryAlpha(value).execute(true);
}

public void setTextColor(String value) {
	getBuilder().reset().setTextColor(value).execute(true);
}

public void setGravity(String value) {
	getBuilder().reset().setGravity(value).execute(true);
}

public void setTextSize(String value) {
	getBuilder().reset().setTextSize(value).execute(true);
}

public void setTextAppearance(String value) {
	getBuilder().reset().setTextAppearance(value).execute(true);
}

public void setTabIndicatorColor(String value) {
	getBuilder().reset().setTabIndicatorColor(value).execute(true);
}

public void setDrawFullUnderline(boolean value) {
	getBuilder().reset().setDrawFullUnderline(value).execute(true);
}

}


private PagerTabStripCommandParamsBuilder paramsBuilder;
private PagerTabStripParamsBean paramsBean;

public PagerTabStripParamsBean getParamsBean() {
	if (paramsBean == null) {
		paramsBean = new PagerTabStripParamsBean();
	}
	return paramsBean;
}
public PagerTabStripCommandParamsBuilder getParamsBuilder() {
	if (paramsBuilder == null) {
		paramsBuilder = new PagerTabStripCommandParamsBuilder();
	}
	return paramsBuilder;
}



public class PagerTabStripParamsBean extends com.ashera.layout.ViewGroupImpl.ViewGroupParamsBean{
}





public class PagerTabStripCommandParamsBuilder extends com.ashera.layout.ViewGroupImpl.ViewGroupCommandParamsBuilder<PagerTabStripCommandParamsBuilder>{
}

	//end - body
	private void createPane(Map<String, Object> params) {
		htmlElement = org.teavm.jso.dom.html.HTMLDocument.current().createElement("div");
		htmlElement.getStyle().setProperty("box-sizing", "border-box");
	}
}
