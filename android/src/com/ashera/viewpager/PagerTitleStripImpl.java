package com.ashera.viewpager;
//start - imports

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;

import android.content.Context;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.widget.*;
import androidx.core.view.*;
import android.view.*;
import android.graphics.drawable.*;


import android.os.Build;
import android.view.View;
import android.text.*;

import com.ashera.core.IFragment;
import com.ashera.converter.*;

import android.annotation.SuppressLint;

import com.ashera.layout.*;
import com.ashera.plugin.*;
import com.ashera.widget.bus.*;
import com.ashera.widget.*;
import com.ashera.widget.bus.Event.*;
import com.ashera.widget.IWidgetLifeCycleListener.EventId;
import com.ashera.widget.IWidgetLifeCycleListener.EventId.*;


import static com.ashera.widget.IWidget.*;
//end - imports
@SuppressLint("NewApi")
public class PagerTitleStripImpl extends BaseWidget {
	//start - body
	public final static String LOCAL_NAME = "androidx.viewpager.widget.PagerTitleStrip"; 
	public final static String GROUP_NAME = "androidx.viewpager.widget.PagerTitleStrip";

	protected androidx.viewpager.widget.PagerTitleStrip pagerTitleStrip;
	
	
	@Override
	public void loadAttributes(String attributeName) {
		ViewImpl.register(attributeName);


		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("textSpacing").withType("dimension"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("nonPrimaryAlpha").withType("float"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("textColor").withType("color"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("gravity").withType("gravity"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("textSize").withType("dimensionsp"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("textAppearance").withType("style"));
	}
	
	public PagerTitleStripImpl() {
		super(GROUP_NAME, LOCAL_NAME);
	}
	public  PagerTitleStripImpl(String localname) {
		super(GROUP_NAME, localname);
	}
	public  PagerTitleStripImpl(String groupName, String localname) {
		super(groupName, localname);
	}

		
	public class PagerTitleStripExt extends androidx.viewpager.widget.PagerTitleStrip implements ILifeCycleDecorator, com.ashera.widget.IMaxDimension{
		private MeasureEvent measureFinished = new MeasureEvent();
		private OnLayoutEvent onLayoutEvent = new OnLayoutEvent();
		
		public IWidget getWidget() {
			return PagerTitleStripImpl.this;
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

		public PagerTitleStripExt(Context context) {
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
				PagerTitleStripImpl.this.invalidate();
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
        	ViewImpl.drawableStateChanged(PagerTitleStripImpl.this);
        }
        
    	public void setState0(float value) {
    		ViewImpl.setState(PagerTitleStripImpl.this, 0, value);
    	}
    	public void setState0(int value) {
    		ViewImpl.setState(PagerTitleStripImpl.this, 0, value);
    	}
    	public void setState0(double value) {
    		ViewImpl.setState(PagerTitleStripImpl.this, 0, value);
    	}
    	
    	public void setState0(Float value) {
    		ViewImpl.setState(PagerTitleStripImpl.this, 0, value);
    	}
    	public void setState0(Integer value) {
    		ViewImpl.setState(PagerTitleStripImpl.this, 0, value);
    	}
    	public void setState0(Double value) {
    		ViewImpl.setState(PagerTitleStripImpl.this, 0, value);
    	}
    	public void setState0(Object value) {
    		ViewImpl.setState(PagerTitleStripImpl.this, 0, value);
    	}
    	public void setState1(float value) {
    		ViewImpl.setState(PagerTitleStripImpl.this, 1, value);
    	}
    	public void setState1(int value) {
    		ViewImpl.setState(PagerTitleStripImpl.this, 1, value);
    	}
    	public void setState1(double value) {
    		ViewImpl.setState(PagerTitleStripImpl.this, 1, value);
    	}
    	
    	public void setState1(Float value) {
    		ViewImpl.setState(PagerTitleStripImpl.this, 1, value);
    	}
    	public void setState1(Integer value) {
    		ViewImpl.setState(PagerTitleStripImpl.this, 1, value);
    	}
    	public void setState1(Double value) {
    		ViewImpl.setState(PagerTitleStripImpl.this, 1, value);
    	}
    	public void setState1(Object value) {
    		ViewImpl.setState(PagerTitleStripImpl.this, 1, value);
    	}
    	public void setState2(float value) {
    		ViewImpl.setState(PagerTitleStripImpl.this, 2, value);
    	}
    	public void setState2(int value) {
    		ViewImpl.setState(PagerTitleStripImpl.this, 2, value);
    	}
    	public void setState2(double value) {
    		ViewImpl.setState(PagerTitleStripImpl.this, 2, value);
    	}
    	
    	public void setState2(Float value) {
    		ViewImpl.setState(PagerTitleStripImpl.this, 2, value);
    	}
    	public void setState2(Integer value) {
    		ViewImpl.setState(PagerTitleStripImpl.this, 2, value);
    	}
    	public void setState2(Double value) {
    		ViewImpl.setState(PagerTitleStripImpl.this, 2, value);
    	}
    	public void setState2(Object value) {
    		ViewImpl.setState(PagerTitleStripImpl.this, 2, value);
    	}
    	public void setState3(float value) {
    		ViewImpl.setState(PagerTitleStripImpl.this, 3, value);
    	}
    	public void setState3(int value) {
    		ViewImpl.setState(PagerTitleStripImpl.this, 3, value);
    	}
    	public void setState3(double value) {
    		ViewImpl.setState(PagerTitleStripImpl.this, 3, value);
    	}
    	
    	public void setState3(Float value) {
    		ViewImpl.setState(PagerTitleStripImpl.this, 3, value);
    	}
    	public void setState3(Integer value) {
    		ViewImpl.setState(PagerTitleStripImpl.this, 3, value);
    	}
    	public void setState3(Double value) {
    		ViewImpl.setState(PagerTitleStripImpl.this, 3, value);
    	}
    	public void setState3(Object value) {
    		ViewImpl.setState(PagerTitleStripImpl.this, 3, value);
    	}
    	public void setState4(float value) {
    		ViewImpl.setState(PagerTitleStripImpl.this, 4, value);
    	}
    	public void setState4(int value) {
    		ViewImpl.setState(PagerTitleStripImpl.this, 4, value);
    	}
    	public void setState4(double value) {
    		ViewImpl.setState(PagerTitleStripImpl.this, 4, value);
    	}
    	
    	public void setState4(Float value) {
    		ViewImpl.setState(PagerTitleStripImpl.this, 4, value);
    	}
    	public void setState4(Integer value) {
    		ViewImpl.setState(PagerTitleStripImpl.this, 4, value);
    	}
    	public void setState4(Double value) {
    		ViewImpl.setState(PagerTitleStripImpl.this, 4, value);
    	}
    	public void setState4(Object value) {
    		ViewImpl.setState(PagerTitleStripImpl.this, 4, value);
    	}
        	public void state0() {
        		ViewImpl.state(PagerTitleStripImpl.this, 0);
        	}
        	public void state1() {
        		ViewImpl.state(PagerTitleStripImpl.this, 1);
        	}
        	public void state2() {
        		ViewImpl.state(PagerTitleStripImpl.this, 2);
        	}
        	public void state3() {
        		ViewImpl.state(PagerTitleStripImpl.this, 3);
        	}
        	public void state4() {
        		ViewImpl.state(PagerTitleStripImpl.this, 4);
        	}
                        
        public void stateYes() {
        	ViewImpl.stateYes(PagerTitleStripImpl.this);
        	
        }
        
        public void stateNo() {
        	ViewImpl.stateNo(PagerTitleStripImpl.this);
        }
     
	}	@Override
	public Class getViewClass() {
		return PagerTitleStripExt.class;
	}

	@Override
	public IWidget newInstance() {
		return new PagerTitleStripImpl(groupName, localName);
	}
	
	@SuppressLint("NewApi")
	@Override
	public void create(IFragment fragment, Map<String, Object> params) {
		super.create(fragment, params);
Context context = (Context) fragment.getRootActivity();
	pagerTitleStrip = new PagerTitleStripExt(context);

		nativeCreate(params);	
		ViewImpl.registerCommandConveter(this);
	}

	@Override
	@SuppressLint("NewApi")
	public void setAttribute(WidgetAttribute key, String strValue, Object objValue, ILifeCycleDecorator decorator) {
		Object nativeWidget = asNativeWidget();
		ViewImpl.setAttribute(this,  key, strValue, objValue, decorator);
		
		switch (key.getAttributeName()) {
			case "textSpacing": {
				


	pagerTitleStrip.setTextSpacing((int)objValue);



			}
			break;
			case "nonPrimaryAlpha": {
				


	pagerTitleStrip.setNonPrimaryAlpha((float)objValue);



			}
			break;
			case "textColor": {
				


	pagerTitleStrip.setTextColor((int)objValue);



			}
			break;
			case "gravity": {
				


	pagerTitleStrip.setGravity((int)objValue);



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
		default:
			break;
		}
		
	}
	
	@Override
	@SuppressLint("NewApi")
	public Object getAttribute(WidgetAttribute key, ILifeCycleDecorator decorator) {
		Object nativeWidget = asNativeWidget();
		Object attributeValue = ViewImpl.getAttribute(this, nativeWidget, key, decorator);
		if (attributeValue != null) {
			return attributeValue;
		}
		switch (key.getAttributeName()) {
		}
		
		return null;
	}
	
	@Override
	public Object asWidget() {
		return pagerTitleStrip;
	}

	
	
	    @Override
	    public Object asNativeWidget() {
	        return pagerTitleStrip;
	    }

	    private void nativeCreate(Map<String, Object> params) {
	    }
	@Override
	public void setId(String id){
		if (id != null && !id.equals("")){
			super.setId(id);
			pagerTitleStrip.setId((int) quickConvert(id, "id"));
		}
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
	
private PagerTitleStripCommandBuilder builder;
private PagerTitleStripBean bean;
public Object getPlugin(String plugin) {
	return WidgetFactory.getAttributable(plugin).newInstance(this);
}
public PagerTitleStripBean getBean() {
	if (bean == null) {
		bean = new PagerTitleStripBean();
	}
	return bean;
}
public PagerTitleStripCommandBuilder getBuilder() {
	if (builder == null) {
		builder = new PagerTitleStripCommandBuilder();
	}
	return builder;
}


public  class PagerTitleStripCommandBuilder extends com.ashera.layout.ViewImpl.ViewCommandBuilder <PagerTitleStripCommandBuilder> {
    public PagerTitleStripCommandBuilder() {
	}
	
	public PagerTitleStripCommandBuilder execute(boolean setter) {
		if (setter) {
			executeCommand(command, null, IWidget.COMMAND_EXEC_SETTER_METHOD);
			getFragment().remeasure();
		}
		executeCommand(command, null, IWidget.COMMAND_EXEC_GETTER_METHOD);
return this;	}

public PagerTitleStripCommandBuilder setTextSpacing(String value) {
	Map<String, Object> attrs = initCommand("textSpacing");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public PagerTitleStripCommandBuilder setNonPrimaryAlpha(float value) {
	Map<String, Object> attrs = initCommand("nonPrimaryAlpha");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public PagerTitleStripCommandBuilder setTextColor(String value) {
	Map<String, Object> attrs = initCommand("textColor");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public PagerTitleStripCommandBuilder setGravity(String value) {
	Map<String, Object> attrs = initCommand("gravity");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public PagerTitleStripCommandBuilder setTextSize(String value) {
	Map<String, Object> attrs = initCommand("textSize");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public PagerTitleStripCommandBuilder setTextAppearance(String value) {
	Map<String, Object> attrs = initCommand("textAppearance");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
}
public class PagerTitleStripBean extends com.ashera.layout.ViewImpl.ViewBean{
		public PagerTitleStripBean() {
			super(PagerTitleStripImpl.this);
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

}


	
	//end - body

	//start - pagetitle
	private void setTextSize(Object objValue) {
		pagerTitleStrip.setTextSize(android.util.TypedValue.COMPLEX_UNIT_PX, (float) objValue);
	}
	
	private void setTextAppearance(Object objValue) {
		TextView mPrevText = (TextView) getFieldValueUsingReflection(pagerTitleStrip, "mPrevText");
		TextView mCurrText = (TextView) getFieldValueUsingReflection(pagerTitleStrip, "mCurrText");
		TextView mNextText = (TextView) getFieldValueUsingReflection(pagerTitleStrip, "mNextText");
		int style = (int) objValue;
		if (style != 0) {
			androidx.core.widget.TextViewCompat.setTextAppearance(mPrevText, style);
			androidx.core.widget.TextViewCompat.setTextAppearance(mCurrText, style);
			androidx.core.widget.TextViewCompat.setTextAppearance(mNextText, style);
		}
	}
	//end - pagetitle
}
