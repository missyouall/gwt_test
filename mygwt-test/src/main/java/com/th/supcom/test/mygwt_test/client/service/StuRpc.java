package com.th.supcom.test.mygwt_test.client.service;

import java.util.List;




import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.th.supcom.test.mygwt_test.client.model.StuModel;

@RemoteServiceRelativePath ("../StuTest.do")
public interface StuRpc extends RemoteService{

	public Integer save(StuModel model);
	
	public Integer delete(String id);
	
	public List<StuModel> findStuByExample(StuModel model);
	
	public Integer update(StuModel model);

}
