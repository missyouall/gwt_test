package com.th.supcom.test.mygwt_test.client.model;


import java.util.Date;

import net.carefx.framework.translate.Translatable;

import com.extjs.gxt.ui.client.data.BeanModel;

public class StuModel extends BeanModel implements java.io.Serializable{

	public String getId()
	{
		return get("id");
	}
	public void setId(String id)
	{
		set("id",id);
	}
	public String getName() {
		return get("name");
	}
	public void setName(String name) {
		set("name",name);
	}
	public Integer getSex() {
		return get("sex");
	}
	public void setSex(Integer i) {
		set("sex",i);
	}
	
	public Integer getAge() {
		return get("age");
	}
	public void setAge(Integer age) {
		set("age",age);
	}
	public Date getCreateTime() {
		return get("createTime");
	}
	public void setCreateTime(Date createTime) {
		set("createTime",createTime);
	}
}
