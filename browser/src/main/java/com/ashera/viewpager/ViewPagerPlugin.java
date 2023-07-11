package com.ashera.viewpager;

import com.ashera.widget.WidgetFactory;

public class ViewPagerPlugin  {
    public static void initPlugin() {
    	//start - widgets
        WidgetFactory.register(new com.ashera.viewpager.ViewPagerImpl());
        WidgetFactory.register(new com.ashera.viewpager.PagerTitleStripImpl());
        WidgetFactory.register(new com.ashera.viewpager.PagerTabStripImpl());
        //end - widgets
    }
}
