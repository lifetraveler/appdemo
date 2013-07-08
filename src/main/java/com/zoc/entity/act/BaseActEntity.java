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
	
	private String c1; 
	
	public String yearSection;
	
	public String locationSection;
	

	public String getLocationSection() {
		return locationSection;
	}

	public void setLocationSection(String locationSection) {
		this.locationSection = locationSection;
	}

	public String getYearSection() {
		return yearSection;
	}

	public void setYearSection(String yearSection) {
		this.yearSection = yearSection;
	}

	public String getC1() {
		return c1;
	}

	public void setC1(String c1) {
		this.c1 = c1;
	}

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
