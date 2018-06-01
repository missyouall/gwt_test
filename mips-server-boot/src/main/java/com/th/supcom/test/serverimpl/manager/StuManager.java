package com.th.supcom.test.serverimpl.manager;

import java.util.List;

import com.th.supcom.test.serverimpl.pojo.StuBean;

public interface StuManager extends BaseManager{
	 int addStu(StuBean bean);
	 int delStu(String id);
	 int updateStu(StuBean bean);
	 StuBean queryStuById(String id);
	 List<StuBean> queryStuByExample(StuBean bean);
}
