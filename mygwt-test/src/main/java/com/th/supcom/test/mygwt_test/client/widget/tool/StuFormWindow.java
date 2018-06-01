package com.th.supcom.test.mygwt_test.client.widget.tool;


import org.apache.commons.lang.StringUtils;

import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.Style.Scroll;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.mvc.AppEvent;
import com.extjs.gxt.ui.client.widget.Info;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.widget.Window;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.form.FormButtonBinding;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.form.Radio;
import com.extjs.gxt.ui.client.widget.form.RadioGroup;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.layout.FormData;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.th.supcom.test.mygwt_test.client.common.StuEvents;
import com.th.supcom.test.mygwt_test.client.model.StuDisplay;
import com.th.supcom.test.mygwt_test.client.model.StuModel;
import com.th.supcom.test.mygwt_test.client.service.StuRpc;
import com.th.supcom.test.mygwt_test.client.service.StuRpcAsync;

import de.novanic.eventservice.util.StringUtil;

public class StuFormWindow extends Window  {

	//调用后台服务对象
	private StuRpcAsync stuRpc=GWT.create(StuRpc.class);
	
	//更新时使用
	private StuDisplay stumodel;
		
	public StuFormWindow(StuDisplay stumodel)
	{
		this.stumodel = stumodel;
		this.setHeaderVisible(false);
		    setModal (true);
		    this.setLayout(new FitLayout());
	        setPixelSize (500, 250);
	        setBodyBorder (false);
	        setButtonAlign (HorizontalAlignment.RIGHT);
	        initUI();
	}
		
	/**
	 * 页面元素初始化
	 */
	  public void initUI()
	  {
		  createForm1();
	  }
		  
		  
		  /**
		   * 新员工信息录入表单
		   */
		  private void createForm1() {  
			  
			FormData formData=new FormData()  ;  
		    FormPanel simple = new FormPanel(); 
		    simple.setScrollMode(Scroll.AUTOY);
		    simple.setHeading("员工信息录入");  
		    simple.setFrame(true);  
		    simple.setWidth(500);  
		  
		    //用户姓名
		    final TextField<String> firstName = new TextField<String>();  
		    firstName.setFieldLabel("姓名");  
		    firstName.setAllowBlank(false); 
		    firstName.setValue(stumodel.getName());
		    firstName.setData("aria-previous", simple.getButtonBar().getId());  
		    firstName.setWidth(150);
		    simple.add(firstName, formData);  
		   
		    //用户性别
		    final RadioGroup rg=new RadioGroup("sex");
		    Radio male=new Radio() ;
		    male.setBoxLabel("男");
		    male.setValue(true);
		    male.setData("sex", "1");
		    Radio female=new Radio() ;
		    female.setBoxLabel("女");
		    female.setData("sex", "2");
		    if(stumodel.getSex()!=null && stumodel.getSex().equals("男"))
		    {
		    	male.setValue(true);
		    }else if(stumodel.getSex()!=null && stumodel.getSex().equals("女"))
		    {
		    	male.setValue(false);
		    	female.setValue(true);
		    }
		    rg.add(male);
		    rg.add(female);
		    rg.setFieldLabel("性别");
		    simple.add(rg, formData);
		    //年龄
		    final TextField<String> ageText = new TextField<String>(); 
		    ageText.setFieldLabel("年龄");
		    ageText.setAllowBlank(false); 
		    if(stumodel.getAge()==null){
		    	 ageText.setValue("");
		    }else{
		    	 ageText.setValue(stumodel.getAge()+"");
		    }
		    
		    ageText.setData("aria-previous", simple.getButtonBar().getId());  
		    ageText.setWidth(150);
		    simple.add(ageText, formData);  
		    
		    Button bsubmit = new Button("保存"); 
		    Button bCancel =new Button("取消");
		    simple.addButton(bsubmit);  
		    simple.addButton(bCancel);  
		  
		    simple.setButtonAlign(HorizontalAlignment.CENTER);  
		  
		    FormButtonBinding binding = new FormButtonBinding(simple);  
		    binding.addButton(bsubmit);  

		    bsubmit.addSelectionListener (new SelectionListener <ButtonEvent> ()
		            {
		                @Override
		                public void componentSelected (ButtonEvent be)
		                {
		                	//组装用数据
		                	StuModel stuExpamel=new StuModel();
		                	String stuName=firstName.getValue();
		                	String sex=rg.getValue().getData("sex");
		                	String age = ageText.getValue();
		                	stuExpamel.setName(stuName);
		                	stuExpamel.setSex(Integer.parseInt(sex));
		                	if(age==null){
		                		Info.display("提示","请输入正确的年龄");
		                	}else{
		                		if(!age.matches("[0-9]+")){
		                			MessageBox.info("提示", "年龄必须为数字", null);
		                		}
		                		stuExpamel.setAge(Integer.parseInt(age));
		                	}
		                	if(stumodel.getId()!=null)//更新
		                	{
		                		stuExpamel.setId(stumodel.getId());
		                		stuRpc.update(stuExpamel, new AsyncCallback<Integer>()
		        	                	{
		        	                		/**
		        	                		 * 数据提交至后台失败后的回退函数
		        	                		 */
		        							@Override
		        							public void onFailure(Throwable caught) {
		        								// TODO Auto-generated method stub
		        								MessageBox.info("提示", caught.getMessage(), null);
		        							}

		        							/**
		        	                		 * 数据提交至后台成功后的回退函数
		        	                		 */
		        							@Override
		        							public void onSuccess(Integer result) {
		        								if(result>0)
		        								{
			        								Info.display("提示","修改成功");
			        								fireEvent(StuEvents.S_GRID_DATA_LOAD,
			        										new AppEvent (StuEvents.S_GRID_DATA_LOAD));
			        								hide();
		        								}else
		        								{
		        									MessageBox.info("提示", "修改失败", null);
		        								}
		        							}
		        	                		
		        	                	});
		                	}else
		                	{
		                		stuRpc.save(stuExpamel, new AsyncCallback<Integer>()
		                	{
		                		/**
		                		 * 数据提交至后台失败后的回退函数
		                		 */
								@Override
								public void onFailure(Throwable caught) {
									// TODO Auto-generated method stub
									MessageBox.info("提示", caught.getMessage(), null);
								}

								/**
		                		 * 数据提交至后台成功后的回退函数
		                		 */
								@Override
								public void onSuccess(Integer result) {
									// TODO Auto-generated method stub
									Info.display("提示","添加成功");
									fireEvent(StuEvents.S_GRID_DATA_LOAD,
											new AppEvent (StuEvents.S_GRID_DATA_LOAD));
									hide();
								}
		                		
		                	});
		                }
		                }
		            });
		    //this.hide();
		   final Window thisWindow=this;
		    bCancel.addSelectionListener(new SelectionListener <ButtonEvent> ()
	        {
	            @Override
	            public void componentSelected (ButtonEvent be)
	            {
	            	thisWindow.hide();
	            }
	        });
		     
		    this.add(simple);
		  }    
	
}

