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
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.alibaba.fastjson.JSON;
import com.zoc.entity.security.Menu;
import com.zoc.repository.security.MenuDao;
import com.zoc.service.security.impl.MenuServiceImpl;

/**
 * @author Administrator
 * 
 */
public class MenuServiceImplTest {
	
	private static Logger logger = LoggerFactory.getLogger(MenuServiceImplTest.class);
	
	@InjectMocks
	private MenuServiceImpl menuService;
	
	@Mock
	private MenuDao menuDao;
	
	@Mock
	SqlSession sqlSession;
	

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void addPermissionsTest(){
		logger.debug("Test Batch Insert");
		List<Menu> list = menuService.list(null);
		logger.debug(JSON.toJSONString(list));
	}

}
