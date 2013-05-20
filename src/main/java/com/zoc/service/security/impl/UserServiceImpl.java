package com.zoc.service.security.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springside.modules.security.utils.Digests;
import org.springside.modules.utils.Encodes;

import com.zoc.common.SuperUtils;
import com.zoc.common.service.impl.SuperServiceImpl;
import com.zoc.entity.security.User;
import com.zoc.repository.security.UserDao;
import com.zoc.service.security.UserService;



@Service
public class UserServiceImpl extends SuperServiceImpl<User, Long> implements UserService {
	

	private static final int SALT_SIZE = 8;
	
	@Autowired
	private UserDao userDao;
	
	@Override
	public void initStatements() {
		this.setStatement(UserDao.class.getName());
	}

	public User fetchByUserName(String username) {
		return userDao.fetchByUserName(username);
	}

	@Override
	public void add(User user) {
		user.setPlainPassword(user.getPassword());
		user.setStatus("U");
		entryptPassword(user);
		userDao.insert(user);
	}

	@Override
	public void modify(User user) {
		if (StringUtils.isNotBlank(user.getPassword())) {
			user.setPlainPassword(user.getPassword());
			entryptPassword(user);
		}
		userDao.update(user);
	}

	
	@Override
	public void remove(User user) {
		userDao.delete(user);
	}
	
	/**
	 * 设定安全的密码，生成随机的salt并经过1024次 sha-1 hash
	 */
	private void entryptPassword(User user) {
		byte[] salt = Digests.generateSalt(SALT_SIZE);
		user.setSalt(Encodes.encodeHex(salt));
		byte[] hashPassword = Digests.sha1(user.getPlainPassword().getBytes(), salt, SuperUtils.HASH_INTERATIONS);
		user.setPassword(Encodes.encodeHex(hashPassword));
	}


	


	
	

	
	

}
