package com.zoc.entity.siwc;

import com.zoc.common.entity.AjaxEntity;

public class Person extends AjaxEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String processInstanceId;
	
	private String person_id;
	
	private String person_name;
	
	private String maker_id;

	public String getProcessInstanceId() {
		return processInstanceId;
	}

	public void setProcessInstanceId(String processInstanceId) {
		this.processInstanceId = processInstanceId;
	}

	public String getPerson_id() {
		return person_id;
	}

	public void setPerson_id(String person_id) {
		this.person_id = person_id;
	}

	public String getPerson_name() {
		return person_name;
	}

	public void setPerson_name(String person_name) {
		this.person_name = person_name;
	}

	public String getMaker_id() {
		return maker_id;
	}

	public void setMaker_id(String maker_id) {
		this.maker_id = maker_id;
	}
	
	
	
	
	
	

}
