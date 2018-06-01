package com.th.supcom.test.mygwt_test.client.service;

import java.util.List;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.th.supcom.test.mygwt_test.client.model.StuModel;

public interface StuRpcAsync {
	public void save(StuModel model,AsyncCallback <Integer> callback);

	public void findStuByExample(StuModel model,AsyncCallback<List<StuModel>> callback);

	public  void delete(String id,AsyncCallback <Integer> callback);
	
	public void update(StuModel model,AsyncCallback<Integer> callback);
}
