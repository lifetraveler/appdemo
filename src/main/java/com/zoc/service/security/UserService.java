package com.zoc.service.security;

import java.util.List;

import com.zoc.common.service.SuperService;
import com.zoc.entity.security.User;

public interface UserService  extends SuperService<User, Long> {
	
	User fetchByUserName(String username);
}
