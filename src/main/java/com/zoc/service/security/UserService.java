package com.zoc.service.security;

import java.util.List;

import com.zoc.common.service.SuperService;
import com.zoc.entity.security.User;

public interface UserService  {
	
	User fetchByUserName(String username);
	
	List<User> queryUsers(User user);
	
	void saveUser(List<User> users);
	
	void addUser(User user);
	
	void modifyUser(User user);
	
	void removeUser(User user);

}
