/**   
 * @Title: SandardCodeDaoTest.java
 * @Package com.zoc.repository.security
 * @Description: TODO
 * @author superzoc@gmail.com   
 * @date May 4, 2013 1:15:15 AM
 * @version   
 */
package com.zoc.repository.security;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springside.modules.security.utils.Digests;
import org.springside.modules.test.spring.SpringTransactionalTestCase;
import org.springside.modules.utils.Encodes;

import com.alibaba.fastjson.JSON;
import com.zoc.common.SuperUtils;
import com.zoc.entity.security.StandardCode;
import com.zoc.entity.security.User;

/**
 * @author Administrator
 * 
 */
@DirtiesContext
@ContextConfiguration(locations = { "/applicationContext.xml" })
public class StandardCodeDaoTest extends SpringTransactionalTestCase {

	@Autowired
	private StandardCodeDao standardCodeDao;

	@Autowired
	SqlSession sqlSession;

	private static Logger logger = LoggerFactory.getLogger(StandardCodeDaoTest.class);

	@Test
	public void queryStandardCode() {
		FileWriter fw = null;
		try {
			fw = new FileWriter("d:/user.txt");
			List<StandardCode> codes = sqlSession.selectList(StandardCodeDao.class.getName() + ".list");
			for (StandardCode location : codes) {
				User user = new User();
				user.setUsername(location.getCode_value());
				user.setLocation(location.getCode_type());
				user.setPassword("123456");
				user.setPlainPassword(user.getPassword());
				user.setStatus("U");
				user.setRealname(location.getCode_value());
				entryptPassword(user);
				fw.write(user.getUsername() + "," + user.getPassword() + "," + user.getRealname() + ","
						+ user.getSalt() + "," + user.getStatus() + "," + user.getLocation() + "\r\n");
				logger.debug(JSON.toJSONString(user));

			}
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				fw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	/**
	 * 设定安全的密码，生成随机的salt并经过1024次 sha-1 hash
	 */
	private void entryptPassword(User user) {
		byte[] salt = Digests.generateSalt(8);
		user.setSalt(Encodes.encodeHex(salt));
		byte[] hashPassword = Digests.sha1(user.getPlainPassword().getBytes(), salt, SuperUtils.HASH_INTERATIONS);
		user.setPassword(Encodes.encodeHex(hashPassword));
	}
}
