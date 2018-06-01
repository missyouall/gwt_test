package com.th.supcom.test.serverimpl.manager.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.th.supcom.test.serverimpl.dao.StuMapper;
import com.th.supcom.test.serverimpl.manager.StuManager;
import com.th.supcom.test.serverimpl.pojo.StuBean;



public class StuManagerImpl extends BaseManagerImpl implements StuManager{
	private StuMapper mapper;
	
	public StuMapper getMapper() {
		return mapper;
	}

	public void setMapper(StuMapper mapper) {
		this.mapper = mapper;
	}

	public int addStu(StuBean bean) {
		return mapper.addStu(bean);
	}

	public int delStu(String id) {
		return mapper.delStu(id);
	}

	public int updateStu(StuBean bean) {
		return mapper.updateStu(bean);
	}

	public StuBean queryStuById(String id) {
		return mapper.queryStuById(id);
	}

	public List<StuBean> queryStuByExample(StuBean bean) {
		return mapper.queryStuByExample(bean);
	}

}
