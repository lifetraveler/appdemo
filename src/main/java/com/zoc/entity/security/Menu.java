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
public class Menu extends AjaxEntity {
	
	String menu_id;
	String menu_desc;
	String parent_id;
	Integer menu_order;
	String menu_url;
	
	List<Permission> permissions;
	
	
	public List<Permission> getPermissions() {
		return permissions;
	}
	public void setPermissions(List<Permission> permissions) {
		this.permissions = permissions;
	}
	/**
	 * @return the menu_id
	 */
	public String getMenu_id() {
		return menu_id;
	}
	/**
	 * @param menu_id the menu_id to set
	 */
	public void setMenu_id(String menu_id) {
		this.menu_id = menu_id;
	}
	/**
	 * @return the menu_desc
	 */
	public String getMenu_desc() {
		return menu_desc;
	}
	/**
	 * @param menu_desc the menu_desc to set
	 */
	public void setMenu_desc(String menu_desc) {
		this.menu_desc = menu_desc;
	}
	/**
	 * @return the parent_id
	 */
	public String getParent_id() {
		return parent_id;
	}
	/**
	 * @param parent_id the parent_id to set
	 */
	public void setParent_id(String parent_id) {
		this.parent_id = parent_id;
	}
	/**
	 * @return the menu_order
	 */
	public Integer getMenu_order() {
		return menu_order;
	}
	/**
	 * @param menu_order the menu_order to set
	 */
	public void setMenu_order(Integer menu_order) {
		this.menu_order = menu_order;
	}
	/**
	 * @return the menu_url
	 */
	public String getMenu_url() {
		return menu_url;
	}
	/**
	 * @param menu_url the menu_url to set
	 */
	public void setMenu_url(String menu_url) {
		this.menu_url = menu_url;
	}
	
	

}
