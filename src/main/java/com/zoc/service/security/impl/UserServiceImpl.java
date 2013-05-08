package com.zoc.service.security.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springside.modules.security.utils.Digests;
import org.springside.modules.utils.Encodes;

import com.zoc.common.SuperUtils;
import com.zoc.entity.act.In_2_2_1;
import com.zoc.entity.security.User;
import com.zoc.repository.security.UserDao;
import com.zoc.service.security.UserService;



@Service
public class UserServiceImpl implements UserService {
	

	private static final int SALT_SIZE = 8;
	
	@Autowired
	private UserDao userDao;

	public User fetchByUserName(String username) {
		return userDao.fetchByUserName(username);
	}

	
	@Override
	public List<User> queryUsers(User user) {
		return userDao.queryUsers(user);
	}

	@Override
	public void saveUser(List<User> users) {
		for (User user : users) {
			String state = user.getState();
			String id = user.getUid();
			if (state.equals("added") || id.equals("")) // 新增：id为空，或_state为added
			{
				addUser(user);
			} else if (state.equals("removed") || state.equals("deleted")) {
				modifyUser(user);
			} else if (state.equals("modified") || state.equals("")) // 更新：_state为空，或modified
			{
				removeUser(user);
			}
		}			
	}
	
	@Override
	public void addUser(User user) {
		user.setPlainPassword(user.getPassword());
		user.setStatus("U");
		entryptPassword(user);
		userDao.insertUser(user);
	}

	@Override
	public void modifyUser(User user) {
		if (StringUtils.isNotBlank(user.getPassword())) {
			entryptPassword(user);
		}
		userDao.updateUser(user);
	}

	
	@Override
	public void removeUser(User user) {
		userDao.deleteUser(user.getUsername());
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
