/**   
 * @Title: UserDao.java
 * @Package com.zoc.security.repository.mybatis
 * @Description: TODO
 * @author superzoc@gmail.com   
 * @date Apr 18, 2013 1:35:16 PM
 * @version   
 */
package com.zoc.repository.security;

import com.zoc.common.repository.MyBatisRepository;
import com.zoc.common.repository.SuperDao;
import com.zoc.entity.security.User;
import com.zoc.entity.security.UserRole;


/**
 * @author Administrator
 * 
 */
@MyBatisRepository
public interface UserDao  extends SuperDao<User> {
	User fetchByUserName(String username);
	
	void insertUserRole(UserRole userRole);
}
