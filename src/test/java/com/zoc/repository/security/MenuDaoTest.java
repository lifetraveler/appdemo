/**   
* @Title: MenuDaoTest.java
* @Package com.zoc.repository.security
* @Description: TODO
* @author superzoc@gmail.com   
* @date May 7, 2013 10:59:13 AM
* @version   
*/
package com.zoc.repository.security;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springside.modules.test.spring.SpringTransactionalTestCase;

import com.alibaba.fastjson.JSON;
import com.zoc.entity.security.Menu;
import com.zoc.entity.security.Permission;

/**
 * @author Administrator
 *
 */
@DirtiesContext
@ContextConfiguration(locations = { "/applicationContext.xml" })
public class MenuDaoTest extends SpringTransactionalTestCase{
	
	@Autowired
	MenuDao menuDao;
	
	private static Logger logger = LoggerFactory.getLogger(MenuDaoTest.class);
	
	@Test
	public void listTest(){
		List<Menu> menus = menuDao.list(null);
		logger.debug("result is : {}",JSON.toJSONString(menus) );
	}
	
	@Test
	public void fetchByPermissionTest(){
		Menu menu = menuDao.fetchByPermission("role");
		logger.debug("FetchByPermissionTest Result : {}",JSON.toJSONString(menu));
	}
	
	@Test 
	public void insertMenuPermissionTest(){
		logger.debug("Begin insertMenuPermissionTest");
		menuDao.insertMenuPermission("super", "zoc");
	}

}
