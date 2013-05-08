/**   
* @Title: SandardCodeDaoTest.java
* @Package com.zoc.repository.security
* @Description: TODO
* @author superzoc@gmail.com   
* @date May 4, 2013 1:15:15 AM
* @version   
*/
package com.zoc.repository.security;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springside.modules.test.spring.SpringTransactionalTestCase;

import com.alibaba.fastjson.JSON;
import com.zoc.entity.security.StandardCode;

/**
 * @author Administrator
 *
 */
@DirtiesContext
@ContextConfiguration(locations = { "/applicationContext.xml" })
public class StandardCodeDaoTest extends SpringTransactionalTestCase {
	
	@Autowired
	private StandardCodeDao standardCodeDao;
	
	private static Logger logger = LoggerFactory.getLogger(StandardCodeDaoTest.class);
	
	@Test
	public void queryStandardCode(){
		List<StandardCode> codes = standardCodeDao.queryStandardCodeListByPage(null,new RowBounds(20,20));
		logger.debug(JSON.toJSONString(codes));
		assertNotNull(codes);
	}

}
