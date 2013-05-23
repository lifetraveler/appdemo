/**   
 * @Title: PermissionsServiceImplTest.java
 * @Package com.zoc.service.act.impl
 * @Description: TODO
 * @author superzoc@gmail.com   
 * @date May 6, 2013 9:51:39 PM
 * @version   
 */
package com.zoc.service.act.impl;

import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springside.modules.test.security.shiro.ShiroTestUtils;

import com.zoc.entity.security.Permission;
import com.zoc.entity.security.User;
import com.zoc.repository.security.PermissionDao;
import com.zoc.service.security.impl.PermissionServiceImpl;

/**
 * @author Administrator
 * 
 */
public class PermissionsServiceImplTest {
	
	private static Logger logger = LoggerFactory.getLogger(PermissionsServiceImplTest.class);
	
	@InjectMocks
	private PermissionServiceImpl permissionsService;
	
	@Mock
	private PermissionDao permissionDao;
	
	@Mock
	SqlSession sqlSession;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		User user = new User();
		user.setUsername("admin");
		ShiroTestUtils.mockSubject(user);
	}
	
	@Test
	public void addPermissionsTest(){
		logger.debug("Test Batch Insert");
		Permission permission = new Permission("superzoc");
		permissionsService.addPermissions(permission);

	}

}
