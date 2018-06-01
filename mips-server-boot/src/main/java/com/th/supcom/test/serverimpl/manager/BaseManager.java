package com.th.supcom.test.serverimpl.manager;

import java.util.List;

import com.th.supcom.test.serverimpl.pojo.StuBean;

public interface BaseManager {
	 int addStu(Object object);
	 int delStu(String id);
	 int updateStu(Object object);
	 StuBean queryStuById(String id);
	 List<StuBean> queryStuByExample(Object object);
}
