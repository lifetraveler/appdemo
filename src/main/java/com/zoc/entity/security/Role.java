/**   
* @Title: Menu.java
* @Package com.zoc.entity.security
* @Description: TODO
* @author superzoc@gmail.com   
* @date May 7, 2013 10:29:52 AM
* @version   
*/
package com.zoc.entity.security;

import java.util.List;

import com.zoc.common.entity.AjaxEntity;

/**
 * @author Administrator
 *
 */
public class Role extends AjaxEntity {
	
	String role_id;
	String role_desc;
	
	List<Menu> menus ;
	/**
	 * @return the role_id
	 */
	public String getRole_id() {
		return role_id;
	}
	/**
	 * @param role_id the role_id to set
	 */
	public void setRole_id(String role_id) {
		this.role_id = role_id;
	}
	/**
	 * @return the role_desc
	 */
	public String getRole_desc() {
		return role_desc;
	}
	/**
	 * @param role_desc the role_desc to set
	 */
	public void setRole_desc(String role_desc) {
		this.role_desc = role_desc;
	}
	public List<Menu> getMenus() {
		return menus;
	}
	public void setMenus(List<Menu> menus) {
		this.menus = menus;
	}
	
	
	
	
	
	

}
