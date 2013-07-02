package com.zoc.entity.security;

import java.util.Map;

import com.zoc.common.entity.AjaxEntity;

public class Lov extends AjaxEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String lov_id;

	private Map<String, String> fields;

	private String lov_url;

	public String getLov_id() {
		return lov_id;
	}

	public void setLov_id(String lov_id) {
		this.lov_id = lov_id;
	}

	public Map<String, String> getFields() {
		return fields;
	}

	public void setFields(Map<String, String> fields) {
		this.fields = fields;
	}

	public String getLov_url() {
		return lov_url;
	}

	public void setLov_url(String lov_url) {
		this.lov_url = lov_url;
	}
	
	

}
