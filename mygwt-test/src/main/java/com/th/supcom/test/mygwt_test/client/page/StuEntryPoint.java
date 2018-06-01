package com.th.supcom.test.mygwt_test.client.page;

import net.carefx.framework.container.client.page.IPageEntryPoint;
import net.carefx.framework.container.client.page.PageContext;
import net.carefx.framework.reflection.shared.annotations.Reflectable;

import com.extjs.gxt.ui.client.mvc.AppEvent;
import com.extjs.gxt.ui.client.mvc.Dispatcher;
import com.th.supcom.test.mygwt_test.client.common.StuEvents;
import com.th.supcom.test.mygwt_test.client.controller.StuController;

@Reflectable
public class StuEntryPoint implements IPageEntryPoint{

	
	private StuController myTest_controller;

    @Override
    public void start (PageContext context)
    {
    	myTest_controller = new StuController ();
        Dispatcher.get ().addController (myTest_controller);
        context.getWorkBench ().getBodyView ().getWorkspace ().getContextView ().asLayoutContainer ().hide ();
        AppEvent appEvent = new AppEvent (StuEvents.INIT_UI, context);
        myTest_controller.handleEvent (appEvent);
    }

    @Override
    public void stop (PageContext context)
    {
        if (myTest_controller != null)
        {
            Dispatcher.get ().removeController (myTest_controller);
        }
    }

    /** 公司版权信息. */
    public static final String copyright = "Copyright 2014, TH Supcom Corporation";

    /** 提交路径. */
    public static final String SCC_BRANCH = "$URL$";

    /** 提交日期. */
    public static final String SCC_LAST_MODIFICATION_DATE = "$Date$";

    /** 最终修改人员. */
    public static final String SCC_LAST_MODIFIER_NAME = "$Author$";

    /** 最终版本号. */
    public static final String SCC_REVISION = "$Revision$";
	
	
}
