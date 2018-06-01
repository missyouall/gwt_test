package com.th.supcom.test.mygwt_test.client;

import net.carefx.framework.client.Framework;
import net.carefx.framework.client.task.TaskConstants;
import net.carefx.framework.container.client.context.AppContext;
import net.carefx.framework.container.client.plugin.ITabView;
import net.carefx.framework.container.client.plugin.NavigationStyle;
import net.carefx.framework.queue.client.InvokeQueue;

import com.extjs.gxt.ui.client.GXT;
import com.extjs.gxt.ui.client.Style.LayoutRegion;
import com.extjs.gxt.ui.client.widget.TabPanel.TabPosition;
import com.th.supcom.framework.print.client.ActivexCheckInvokeTask;
/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Index extends Framework
{
    @Override
    protected void onFrameworkLoad ()
    {
        super.onFrameworkLoad ();
        
        // 使用电子病历编辑器时，层覆盖问题
        if (GXT.isIE || GXT.isChrome)
        {
            GXT.useShims = true;
        }

        getWorkbench ().getBodyView ().setNavigationStyle (NavigationStyle.MULTIPLE_TREE, LayoutRegion.WEST);
        getWorkbench ().getBodyView ().getWorkspace ().setTabPosition (TabPosition.TOP);

        ITabView tabView = getWorkbench ().getBodyView ().getWorkspace ().getTabView ();
        tabView.setAllowOpenMulitplePage (true);
        getWorkbench ().getBodyView ().getWorkspace ().hideContextView ();
    }

    @Override
    protected void beforeInitInvokeQueueStart (final InvokeQueue initInvokeQueue)
    {
      //如果用到了打印控件，请使用封装好的Task
        initInvokeQueue.insertAfterTask (TaskConstants.LOAD_CONFIGURATION_TASK_ID, new ActivexCheckInvokeTask ());

    }

    protected void onConfigFramework () // 重写onConfigFramework
    {
        AppContext.get ().setSystemName ("TEST_PHARM");// 代表是从index.html进入
    }

}
