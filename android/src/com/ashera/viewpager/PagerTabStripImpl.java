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
public class PagerTabStripImpl extends BaseWidget {
	//start - body
	public final static String LOCAL_NAME = "androidx.viewpager.widget.PagerTabStrip"; 
	public final static String GROUP_NAME = "androidx.viewpager.widget.PagerTabStrip";

	protected androidx.viewpager.widget.PagerTabStrip pagerTabStrip;
	
	
	@Override
	public void loadAttributes(String attributeName) {
		ViewImpl.register(attributeName);


		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("tabIndicatorColor").withType("color"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("textSpacing").withType("dimension"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("drawFullUnderline").withType("boolean"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("nonPrimaryAlpha").withType("float"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("textColor").withType("color"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("gravity").withType("gravity"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("textSize").withType("dimensionsp"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("textAppearance").withType("style"));
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

		
	public class PagerTabStripExt extends androidx.viewpager.widget.PagerTabStrip implements ILifeCycleDecorator, com.ashera.widget.IMaxDimension{
		private MeasureEvent measureFinished = new MeasureEvent();
		private OnLayoutEvent onLayoutEvent = new OnLayoutEvent();
		
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

		public PagerTabStripExt(Context context) {
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
				PagerTabStripImpl.this.invalidate();
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
        	if (!isWidgetDisposed()) {
        		ViewImpl.drawableStateChanged(PagerTabStripImpl.this);
        	}
        }
        
    	public void setState0(float value) {
    		ViewImpl.setState(PagerTabStripImpl.this, 0, value);
    	}
    	public void setState0(int value) {
    		ViewImpl.setState(PagerTabStripImpl.this, 0, value);
    	}
    	public void setState0(double value) {
    		ViewImpl.setState(PagerTabStripImpl.this, 0, value);
    	}
    	
    	public void setState0(Float value) {
    		ViewImpl.setState(PagerTabStripImpl.this, 0, value);
    	}
    	public void setState0(Integer value) {
    		ViewImpl.setState(PagerTabStripImpl.this, 0, value);
    	}
    	public void setState0(Double value) {
    		ViewImpl.setState(PagerTabStripImpl.this, 0, value);
    	}
    	public void setState0(Object value) {
    		ViewImpl.setState(PagerTabStripImpl.this, 0, value);
    	}
    	public void setState1(float value) {
    		ViewImpl.setState(PagerTabStripImpl.this, 1, value);
    	}
    	public void setState1(int value) {
    		ViewImpl.setState(PagerTabStripImpl.this, 1, value);
    	}
    	public void setState1(double value) {
    		ViewImpl.setState(PagerTabStripImpl.this, 1, value);
    	}
    	
    	public void setState1(Float value) {
    		ViewImpl.setState(PagerTabStripImpl.this, 1, value);
    	}
    	public void setState1(Integer value) {
    		ViewImpl.setState(PagerTabStripImpl.this, 1, value);
    	}
    	public void setState1(Double value) {
    		ViewImpl.setState(PagerTabStripImpl.this, 1, value);
    	}
    	public void setState1(Object value) {
    		ViewImpl.setState(PagerTabStripImpl.this, 1, value);
    	}
    	public void setState2(float value) {
    		ViewImpl.setState(PagerTabStripImpl.this, 2, value);
    	}
    	public void setState2(int value) {
    		ViewImpl.setState(PagerTabStripImpl.this, 2, value);
    	}
    	public void setState2(double value) {
    		ViewImpl.setState(PagerTabStripImpl.this, 2, value);
    	}
    	
    	public void setState2(Float value) {
    		ViewImpl.setState(PagerTabStripImpl.this, 2, value);
    	}
    	public void setState2(Integer value) {
    		ViewImpl.setState(PagerTabStripImpl.this, 2, value);
    	}
    	public void setState2(Double value) {
    		ViewImpl.setState(PagerTabStripImpl.this, 2, value);
    	}
    	public void setState2(Object value) {
    		ViewImpl.setState(PagerTabStripImpl.this, 2, value);
    	}
    	public void setState3(float value) {
    		ViewImpl.setState(PagerTabStripImpl.this, 3, value);
    	}
    	public void setState3(int value) {
    		ViewImpl.setState(PagerTabStripImpl.this, 3, value);
    	}
    	public void setState3(double value) {
    		ViewImpl.setState(PagerTabStripImpl.this, 3, value);
    	}
    	
    	public void setState3(Float value) {
    		ViewImpl.setState(PagerTabStripImpl.this, 3, value);
    	}
    	public void setState3(Integer value) {
    		ViewImpl.setState(PagerTabStripImpl.this, 3, value);
    	}
    	public void setState3(Double value) {
    		ViewImpl.setState(PagerTabStripImpl.this, 3, value);
    	}
    	public void setState3(Object value) {
    		ViewImpl.setState(PagerTabStripImpl.this, 3, value);
    	}
    	public void setState4(float value) {
    		ViewImpl.setState(PagerTabStripImpl.this, 4, value);
    	}
    	public void setState4(int value) {
    		ViewImpl.setState(PagerTabStripImpl.this, 4, value);
    	}
    	public void setState4(double value) {
    		ViewImpl.setState(PagerTabStripImpl.this, 4, value);
    	}
    	
    	public void setState4(Float value) {
    		ViewImpl.setState(PagerTabStripImpl.this, 4, value);
    	}
    	public void setState4(Integer value) {
    		ViewImpl.setState(PagerTabStripImpl.this, 4, value);
    	}
    	public void setState4(Double value) {
    		ViewImpl.setState(PagerTabStripImpl.this, 4, value);
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
     
	
	}	@Override
	public Class getViewClass() {
		return PagerTabStripExt.class;
	}

	@Override
	public IWidget newInstance() {
		return new PagerTabStripImpl(groupName, localName);
	}
	
	@SuppressLint("NewApi")
	@Override
	public void create(IFragment fragment, Map<String, Object> params) {
		super.create(fragment, params);
Context context = (Context) fragment.getRootActivity();
	pagerTabStrip = new PagerTabStripExt(context);

		nativeCreate(params);	
		ViewImpl.registerCommandConveter(this);
	}

	@Override
	@SuppressLint("NewApi")
	public void setAttribute(WidgetAttribute key, String strValue, Object objValue, ILifeCycleDecorator decorator) {
		Object nativeWidget = asNativeWidget();
		ViewImpl.setAttribute(this,  key, strValue, objValue, decorator);
		
		switch (key.getAttributeName()) {
			case "tabIndicatorColor": {
				


	pagerTabStrip.setTabIndicatorColor((int)objValue);



			}
			break;
			case "textSpacing": {
				


	pagerTabStrip.setTextSpacing((int)objValue);



			}
			break;
			case "drawFullUnderline": {
				


	pagerTabStrip.setDrawFullUnderline((boolean)objValue);



			}
			break;
			case "nonPrimaryAlpha": {
				


	pagerTabStrip.setNonPrimaryAlpha((float)objValue);



			}
			break;
			case "textColor": {
				


	pagerTabStrip.setTextColor((int)objValue);



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
		return pagerTabStrip;
	}

	

	private void setTextSize(Object objValue) {
		pagerTabStrip.setTextSize(android.util.TypedValue.COMPLEX_UNIT_PX, (float) objValue);
	}
	
	private void setTextAppearance(Object objValue) {
		TextView mPrevText = (TextView) getFieldValueUsingReflection(pagerTabStrip, "mPrevText");
		TextView mCurrText = (TextView) getFieldValueUsingReflection(pagerTabStrip, "mCurrText");
		TextView mNextText = (TextView) getFieldValueUsingReflection(pagerTabStrip, "mNextText");
		int style = (int) objValue;
		if (style != 0) {
			androidx.core.widget.TextViewCompat.setTextAppearance(mPrevText, style);
			androidx.core.widget.TextViewCompat.setTextAppearance(mCurrText, style);
			androidx.core.widget.TextViewCompat.setTextAppearance(mNextText, style);
		}
	}
	

	
	    @Override
	    public Object asNativeWidget() {
	        return pagerTabStrip;
	    }

	    private void nativeCreate(Map<String, Object> params) {
	    }
	@Override
	public void setId(String id){
		if (id != null && !id.equals("")){
			super.setId(id);
			pagerTabStrip.setId((int) quickConvert(id, "id"));
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

	
		//end - body

}
