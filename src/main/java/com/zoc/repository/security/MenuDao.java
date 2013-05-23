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
import com.zoc.entity.security.Menu;

/**
 * @author Administrator
 * 
 */
@MyBatisRepository
public interface MenuDao extends SuperDao<Menu> {

	public List<Menu> listChildren(Menu menu);

	public Menu fetchByPermission(@Param("menu_id") String menu_id);

	public List<Menu> listByRoleId(String role_id);

	public void insertMenuPermission(String menu_id, String permission);

	public void deleteMenuPermission(String menu_id);

}
