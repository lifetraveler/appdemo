/**   
 * @Title: UserDao.java
 * @Package com.zoc.security.repository.mybatis
 * @Description: TODO
 * @author superzoc@gmail.com   
 * @date Apr 18, 2013 1:35:16 PM
 * @version   
 */
package com.zoc.repository.security;

import org.apache.ibatis.annotations.Param;
import com.zoc.common.repository.MyBatisRepository;
import com.zoc.common.repository.SuperDao;
import com.zoc.entity.security.Role;

/**
 * @author Administrator
 * 
 */
@MyBatisRepository
public interface RoleDao extends SuperDao<Role> {

	public void deleteRoleMenuPermissionByRoleId(String role_id);

	public void insertRoleMenuPermission(@Param("role_id") String role_id, @Param("menu_id") String menu_id,
			@Param("permission") String permission);
}
