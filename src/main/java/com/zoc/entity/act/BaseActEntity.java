package com.zoc.entity.act;

import com.zoc.common.entity.AjaxEntity;
/**
 * 
 * @author superzoc
 * 精算表基类，统一年份和地区的entity
 *
 */
public class BaseActEntity extends AjaxEntity {
	
	public Integer year;
	
	public String location;
	
	public Integer c0;
	

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Integer getC0() {
		return c0;
	}

	public void setC0(Integer c0) {
		this.c0 = c0;
	}

	

	
}
