/**   
 * @Title: PermissionsServiceImplTest.java
 * @Package com.zoc.service.act.impl
 * @Description: TODO
 * @author superzoc@gmail.com   
 * @date May 6, 2013 9:51:39 PM
 * @version   
 */
package com.zoc.service.act.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springside.modules.test.security.shiro.ShiroTestUtils;
import org.springside.modules.test.spring.SpringTransactionalTestCase;

import com.alibaba.fastjson.JSON;
import com.zoc.entity.security.Menu;
import com.zoc.entity.security.Permission;
import com.zoc.entity.security.StandardCode;
import com.zoc.entity.security.User;
import com.zoc.repository.security.MenuDao;
import com.zoc.repository.security.PermissionDao;
import com.zoc.repository.security.StandardCodeDao;
import com.zoc.repository.security.UserDao;
import com.zoc.service.security.PermissionService;
import com.zoc.service.security.impl.MenuServiceImpl;
import com.zoc.service.security.impl.StandardCodeServiceImpl;
import com.zoc.service.security.impl.UserServiceImpl;

/**
 * @author Administrator
 * 
 */
@DirtiesContext
@ContextConfiguration(locations = { "/applicationContext.xml" })
public class UserServiceImplTest extends SpringTransactionalTestCase {
	
	private static Logger logger = LoggerFactory.getLogger(UserServiceImplTest.class);
	
	@InjectMocks
	private UserServiceImpl userService;
	
	@InjectMocks
	private StandardCodeServiceImpl standardCodeService;
	
	@Mock
	private UserDao userDao;
	
	@Mock
	private StandardCodeDao standardCodeDao;
	
	@Mock
	SqlSession sqlSession;
	
	

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void addPermissionsTest(){
		logger.debug("Test Batch Insert");
		List<StandardCode> locations = sqlSession.selectList(StandardCodeDao.class.getName() + ".list");
		
		logger.debug("locations size {}",locations.size());
		
		for (StandardCode location : locations){
			User user = new User();
			user.setUsername(location.getCode_type());
			user.setLocation(location.getCode_value());
			user.setPassword("123456");
			user.setRealname(location.getCode_type());
			userService.addUser(user);
			logger.debug(JSON.toJSONString(user));
		}
		
	}

}
