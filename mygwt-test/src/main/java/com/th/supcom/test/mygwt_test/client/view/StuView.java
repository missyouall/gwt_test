package com.th.supcom.test.mygwt_test.client.view;

import net.carefx.framework.container.client.page.PageContext;

import com.extjs.gxt.ui.client.mvc.AppEvent;
import com.extjs.gxt.ui.client.mvc.Controller;
import com.extjs.gxt.ui.client.mvc.View;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.th.supcom.test.mygwt_test.client.common.StuEvents;
import com.th.supcom.test.mygwt_test.client.widget.StuPanel;

public class StuView extends View{

	public StuView(Controller controller) {
		super(controller);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void handleEvent(AppEvent event) {
		// TODO Auto-generated method stub
		if(StuEvents.INIT_UI.equals(event.getType()))
		{
			PageContext context=event.getData();
			initUI(context);
			return ;
		}
	}
	
    /**
     * 初始化容器面板.
     * 
     * @param context
     */
    private void initUI (PageContext context)
    {
        /** 主窗口容器. */
        LayoutContainer mainLayoutContainer = context.getContainer ();
        mainLayoutContainer.setLayout (new FitLayout());
        mainLayoutContainer.add (new StuPanel());
    }

}
