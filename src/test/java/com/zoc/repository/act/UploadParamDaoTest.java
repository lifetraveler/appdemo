package com.zoc.repository.act;

import java.util.List;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springside.modules.test.spring.SpringTransactionalTestCase;

import com.alibaba.fastjson.JSON;
import com.zoc.entity.act.UploadParam;

@DirtiesContext
@ContextConfiguration(locations = { "/applicationContext.xml" })
public class UploadParamDaoTest extends SpringTransactionalTestCase {
	
	@Autowired
	UploadParamDao uploadParamDao;

	private static Logger logger = LoggerFactory.getLogger(UploadParamDaoTest.class);

	@Test
	public void listTest() {
		List<UploadParam> lists = uploadParamDao.list(null);
		
		logger.debug("UploadParam List Test : {}",JSON.toJSONString(lists));
	}
	
	@Test
	public void listByMenuId(){
		UploadParam up = uploadParamDao.fetchByMenuId("CNSZRRSZ");
		
		logger.debug("UploadParam Fetch Test : {}",JSON.toJSONString(up));
		
	}

}
