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

import org.apache.ibatis.session.RowBounds;

import com.zoc.common.repository.MyBatisRepository;
import com.zoc.common.repository.SuperDao;
import com.zoc.entity.security.Menu;
import com.zoc.entity.security.Permission;
import com.zoc.entity.security.StandardCode;
import com.zoc.entity.security.User;

/**
 * @author Administrator
 * 
 */
@MyBatisRepository
public interface MenuDao extends SuperDao<Menu>{
	
	public List<Menu> listChildren(Menu menu);
	
	public Menu fetchByPermission(String menu_id);
	
	public void insertMenuPermission(String menu_id,String permission);
	
	public void deleteMenuPermission(String menu_id);

}
