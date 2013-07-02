/**   
 * @Title: PermissionsService.java
 * @Package com.zoc.service.security
 * @Description: TODO
 * @author superzoc@gmail.com   
 * @date May 6, 2013 9:34:43 PM
 * @version   
 */
package com.zoc.service.security;

import java.util.List;

import com.zoc.common.service.SuperService;
import com.zoc.entity.security.Permission;

/**
 * @author Administrator
 * 
 */
public interface PermissionService extends SuperService<Permission, Long> {

	public void addPermissions(Permission permission);
	
	public List<Permission> listPermissionByRoleIdMenuId(String menu_id,String role_id);
	
	public void deleteAll();

}
