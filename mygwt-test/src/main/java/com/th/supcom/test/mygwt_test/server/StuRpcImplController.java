package com.th.supcom.test.mygwt_test.server;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.th.supcom.test.mygwt_test.client.model.StuModel;
import com.th.supcom.test.mygwt_test.client.service.StuRpc;
import com.th.supcom.test.serverimpl.pojo.StuBean;

import net.carefx.framework.util.ConvertUtils;
import net.carefx.framework.web.gwt.server.GwtController;


public class StuRpcImplController extends GwtController implements StuRpc{

private com.th.supcom.test.serverimpl.service.StuService stuService;
	
	public com.th.supcom.test.serverimpl.service.StuService getStuService() {
		return stuService;
	}

	public void setStuService(com.th.supcom.test.serverimpl.service.StuService stuService) {
		this.stuService = stuService;
	}

	@Override
	public Integer save(StuModel model) {
		StuBean cb = new StuBean();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		cb.setId(sdf.format(new Date()));
		cb.setSex(model.getSex());
		cb.setName(model.getName());
		cb.setAge(model.getAge());
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		cb.setCreateTime(new Date());
		return stuService.addStu(cb);
	}
	
	/**
	* 查询GRID
	*/
	@Override
	public List<StuModel> findStuByExample(StuModel cm) {
		StuBean cb = ConvertUtils.convert(StuBean.class,cm);
		List<StuBean> StuBeanList = stuService.queryStuByExample(cb);
		List<StuModel> result=ConvertUtils.convert(StuModel.class, StuBeanList);
		return result;
	}
	
	@Override
	public Integer delete(String id) {
		return stuService.delStu(id);
	}
	
	@Override
	public Integer update(StuModel model) {
		StuBean updateBean=ConvertUtils.convert(StuBean.class, model);
		return stuService.updateStu(updateBean);
	}


}
