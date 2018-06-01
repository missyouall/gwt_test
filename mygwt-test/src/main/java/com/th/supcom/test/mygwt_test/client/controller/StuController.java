package com.th.supcom.test.mygwt_test.client.controller;

import com.extjs.gxt.ui.client.mvc.AppEvent;
import com.extjs.gxt.ui.client.mvc.Controller;
import com.th.supcom.test.mygwt_test.client.common.StuEvents;
import com.th.supcom.test.mygwt_test.client.view.StuView;

public class StuController extends Controller{
	private final StuView mytestView; //展示的页面

	public StuController() {
		mytestView = new StuView(this);
		this.registerEventTypes(StuEvents.INIT_UI);
	}
	@Override
	public void handleEvent(AppEvent event) {
		// TODO Auto-generated method stub
		this.forwardToView(mytestView, event);
	}

}
