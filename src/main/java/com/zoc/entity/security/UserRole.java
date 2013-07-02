package com.zoc.entity.security;

import com.zoc.common.entity.AjaxEntity;

public class UserRole extends AjaxEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String username;
	
	private String branch_code;
	
	private String role_id;
	
	private String role_desc;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getBranch_code() {
		return branch_code;
	}

	public void setBranch_code(String branch_code) {
		this.branch_code = branch_code;
	}

	public String getRole_id() {
		return role_id;
	}

	public void setRole_id(String role_id) {
		this.role_id = role_id;
	}

	public String getRole_desc() {
		return role_desc;
	}

	public void setRole_desc(String role_desc) {
		this.role_desc = role_desc;
	}
	
	

}
