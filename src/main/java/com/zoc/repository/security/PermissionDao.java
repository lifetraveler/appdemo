/**   
 * @Title: UserDao.java
 * @Package com.zoc.security.repository.mybatis
 * @Description: TODO
 * @author superzoc@gmail.com   
 * @date Apr 18, 2013 1:35:16 PM
 * @version   
 */
package com.zoc.repository.security;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import com.zoc.common.repository.MyBatisRepository;
import com.zoc.common.repository.SuperDao;
import com.zoc.entity.security.Permission;

/**
 * @author Administrator
 * 
 */
@MyBatisRepository
public interface PermissionDao extends SuperDao<Permission> {
	public void insertPermission(Permission permission);
	
	public List<Permission> listPermissionByRoleIdMenuId(@Param("menu_id") String menu_id,@Param("role_id") String role_id);
	
}
