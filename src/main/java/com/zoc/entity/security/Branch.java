/**   
* @Title: Menu.java
* @Package com.zoc.entity.security
* @Description: TODO
* @author superzoc@gmail.com   
* @date May 7, 2013 10:29:52 AM
* @version   
*/
package com.zoc.entity.security;

import com.zoc.common.entity.AjaxEntity;

/**
 * @author Administrator
 *
 */
public class Branch extends AjaxEntity {
	
	String branch_code;
	String branch_name;
	String parent_branch;
	Integer branch_order;
	
	public String getBranch_code() {
		return branch_code;
	}
	public void setBranch_code(String branch_code) {
		this.branch_code = branch_code;
	}
	public String getBranch_name() {
		return branch_name;
	}
	public void setBranch_name(String branch_name) {
		this.branch_name = branch_name;
	}
	public String getParent_branch() {
		return parent_branch;
	}
	public void setParent_branch(String parent_branch) {
		this.parent_branch = parent_branch;
	}
	public Integer getBranch_order() {
		return branch_order;
	}
	public void setBranch_order(Integer branch_order) {
		this.branch_order = branch_order;
	}
	
	
}
