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

import com.zoc.common.repository.MyBatisRepository;
import com.zoc.entity.security.User;


/**
 * @author Administrator
 * 
 */
@MyBatisRepository
public interface UserDao  {
	User fetchByUserName(String username);
	
	List<User> queryUsers(User user);
	
	void insertUser(User user);
	
	void updateUser(User user);
	
	void deleteUser(String username);
}
