package com.th.supcom.test.mygwt_test.client.model;

import java.util.Date;

import com.extjs.gxt.ui.client.data.BeanModel;

public class StuDisplay extends BeanModel implements java.io.Serializable {

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
	public String getSex() {
		return get("sex");
	}
	public void setSex(String i) {
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
	public void setCreateTime(String createTime) {
		set("createTime",createTime);
	}
	
}
