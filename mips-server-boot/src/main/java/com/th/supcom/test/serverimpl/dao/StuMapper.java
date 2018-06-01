package com.th.supcom.test.serverimpl.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.extjs.gxt.ui.client.data.BeanModelMarker.BEAN;
import com.th.supcom.test.serverimpl.pojo.StuBean;

@Component
public interface StuMapper {
	 int addStu(StuBean bean);
	 int delStu(String id);
	 int updateStu(StuBean bean);
	 StuBean queryStuById(String id);
	 List<StuBean> queryStuByExample(StuBean bean);
}
