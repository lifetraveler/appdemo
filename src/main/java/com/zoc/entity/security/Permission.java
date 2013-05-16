/**   
* @Title: Permissions.java
* @Package com.zoc.entity.security
* @Description: TODO
* @author superzoc@gmail.com   
* @date May 6, 2013 9:28:24 PM
* @version   
*/
package com.zoc.entity.security;

import com.zoc.common.entity.AjaxEntity;

/**
 * @author Administrator
 *
 */
public class Permission extends AjaxEntity{
	
	String permission;
	
	public Permission(){
		
	}
	
	public Permission(String permission){
		this.permission = permission;
	}

	/**
	 * @return the permission
	 */
	public String getPermission() {
		return permission;
	}

	/**
	 * @param permission the permission to set
	 */
	public void setPermission(String permission) {
		this.permission = permission;
	}

	
	

}
