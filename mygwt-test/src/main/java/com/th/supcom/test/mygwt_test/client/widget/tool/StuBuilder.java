package com.th.supcom.test.mygwt_test.client.widget.tool;

import java.util.ArrayList;
import java.util.List;
import com.google.gwt.i18n.client.DateTimeFormat;

import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.th.supcom.test.mygwt_test.client.model.StuDisplay;
import com.th.supcom.test.mygwt_test.client.model.StuModel;
import com.th.supcom.test.mygwt_test.client.service.StuRpc;
import com.th.supcom.test.mygwt_test.client.service.StuRpcAsync;

public class StuBuilder {
	StuRpcAsync stuRpc=GWT.create(StuRpc.class);

	//存放GRID数据
    private final ListStore <StuDisplay> m_listStore = new ListStore <StuDisplay> ();
    public ListStore<StuDisplay> getM_listStore() {
		return m_listStore;
	}


	/**
     * 加载GRID数据
     * @param panel
     * @param model
     */
    public void loadGridData (final ContentPanel panel, ModelData model)
    {
    	   panel.mask ("loding...");
           System.out.println(panel);
		  // final SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
           final DateTimeFormat df = DateTimeFormat.getFormat("yyyy-MM-dd HH:mm:ss");  
           stuRpc.findStuByExample((StuModel) model,new AsyncCallback <List <StuModel>> (){
					@Override
					public void onSuccess(List<StuModel> result) {
						List<StuDisplay> list=new ArrayList<StuDisplay>();
						if(result!=null && result.size()>0){
							for(int i=0;i<result.size();i++){
								StuModel Stu = result.get(i);
								StuDisplay ed = new StuDisplay();
								ed.setId(Stu.getId());
								ed.setName(Stu.getName());
								ed.setAge(Stu.getAge());
								ed.setCreateTime(df.format(Stu.getCreateTime()));
								if(Stu.getSex()==1){
									ed.setSex("男");
								}else{
									ed.setSex("女");
								}
								list.add(ed);
							}
						}
						panel.unmask();
						m_listStore.removeAll();
						if (result == null || result.isEmpty()) {
							return;
						}
						m_listStore.add(list);
					}

					@Override
					public void onFailure(Throwable caught) {
						MessageBox.info("提示",
								"" + caught.getLocalizedMessage(), null);
					}
           });
    }
}
