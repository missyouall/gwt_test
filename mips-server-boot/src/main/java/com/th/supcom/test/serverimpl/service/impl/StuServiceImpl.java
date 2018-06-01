package com.th.supcom.test.serverimpl.service.impl;

import java.util.List;

import com.th.supcom.test.serverimpl.manager.StuManager;
import com.th.supcom.test.serverimpl.pojo.StuBean;
import com.th.supcom.test.serverimpl.service.StuService;

public class StuServiceImpl implements StuService {
	
	private StuManager manager;
	
	public StuManager getManager() {
		return manager;
	}

	public void setManager(StuManager manager) {
		this.manager = manager;
	}
	
	public void initTest()
	{
		System.out.println("StuService初始化。。。。。。");
	}

	public int addStu(StuBean bean) {
		return manager.addStu(bean);
	}

	public int delStu(String id) {
		return manager.delStu(id);
	}

	public int updateStu(StuBean bean) {
		return manager.updateStu(bean);
	}

	public StuBean queryStuById(String id) {
		return manager.queryStuById(id);
	}

	public List<StuBean> queryStuByExample(StuBean bean) {
		return manager.queryStuByExample(bean);
	}
}
