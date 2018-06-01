package com.th.supcom.test.mygwt_test.client.model;

import com.extjs.gxt.ui.client.data.BaseModelData;


public class StuBaseDataModel  extends BaseModelData implements java.io.Serializable{

	public StuBaseDataModel(String itemCode,String displayName)
	{
		this.setDisplayName(displayName);
		this.setItemCode(itemCode);
	}
	
	
	
	public String getItemCode() {
		return get("itemCode");
	}



	public void setItemCode(String itemCode) {
		set("itemCode",itemCode);
	}



	public String getDisplayName() {
		return get("displayName");
	}



	public void setDisplayName(String displayName) {
		set("displayName",displayName);
	}




	
	
}
