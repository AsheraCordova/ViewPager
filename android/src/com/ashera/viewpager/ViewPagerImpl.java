package com.ashera.viewpager;
// start - imports
import java.util.*;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.view.*;
import android.widget.*;
import android.view.View.*;

import com.ashera.widget.BaseHasWidgets;

import android.annotation.SuppressLint;

import com.ashera.core.IFragment;
import com.ashera.widget.bus.*;
import com.ashera.converter.*;
import com.ashera.widget.bus.Event.*;
import com.ashera.widget.*;
import com.ashera.widget.IWidgetLifeCycleListener.*;
import com.ashera.layout.*;

import android.graphics.Canvas;
import android.widget.*;
import androidx.core.view.*;
import android.view.*;

import static com.ashera.widget.IWidget.*;
//end - imports
import android.graphics.drawable.Drawable;
import androidx.viewpager.widget.ViewPager;

public class ViewPagerImpl extends BaseHasWidgets {
	//start - body
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
Context context = (Context) fragment.getRootActivity();
	viewPager = new ViewPagerExt(context);

		
		nativeCreate(params);
		
		
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
		return remove;
	}
	
	@Override
    public boolean remove(int index) {
		IWidget widget = widgets.get(index);
        boolean remove = super.remove(index);

        if (index + 1 <= viewPager.getChildCount()) {
            viewPager.removeViewAt(index);
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
	
		
	public class ViewPagerExt extends androidx.viewpager.widget.ViewPager implements ILifeCycleDecorator, com.ashera.widget.IMaxDimension{
		private MeasureEvent measureFinished = new MeasureEvent();
		private OnLayoutEvent onLayoutEvent = new OnLayoutEvent();
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

		public ViewPagerExt(Context context) {
			super(context);
			
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
			ViewImpl.nativeMakeFrame(asNativeWidget(), l, t, r, b);
			replayBufferedEvents();
			
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
		public void onDraw(Canvas canvas) {
			Runnable runnable = () -> super.onDraw(canvas);
			executeMethodListeners("onDraw", runnable, canvas);
		}

		@Override
		public void draw(Canvas canvas) {
			Runnable runnable = () -> super.draw(canvas);
			executeMethodListeners("draw", runnable, canvas);
		}

		@SuppressLint("WrongCall")
		@Override
		public void execute(String method, Object... args) {
			switch (method) {
				case "onDraw":
					setOnMethodCalled(true);
					super.onDraw((Canvas) args[0]);
					break;

				case "draw":
					setOnMethodCalled(true);
					super.draw((Canvas) args[0]);
					break;

				default:
					break;
			}
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
        return viewPager;
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
	}

	//start - viewpager
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


	//end - viewpager
	
	private void setCurrentItem(int objValue) {
		if (isInitialised()) {
			viewPager.setCurrentItem(objValue);
		} else {
			viewPager.post(() -> {
				viewPager.setCurrentItem(objValue);
			});
		}
	}
}
