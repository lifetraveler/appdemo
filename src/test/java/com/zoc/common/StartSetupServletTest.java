/**   
* @Title: StartSetupServletTest.java
* @Package com.zoc.common
* @Description: TODO
* @author superzoc@gmail.com   
* @date May 5, 2013 5:46:31 PM
* @version   
*/
package com.zoc.common;

import java.lang.reflect.Method;
import java.util.List;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.junit.Test;
import org.nutz.json.Json;
import org.nutz.resource.Scans;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springside.modules.test.spring.SpringTransactionalTestCase;

import com.zoc.repository.security.StandardCodeDaoTest;

/**
 * @author Administrator
 *
 */
@DirtiesContext
@ContextConfiguration(locations = { "/applicationContext.xml" })
public class StartSetupServletTest extends SpringTransactionalTestCase {
	
	private static Logger logger = LoggerFactory.getLogger(StartSetupServletTest.class);

	@Test
	public void testPermissionsScan(){
		logger.debug("测试初始的所有Permission");
		List<Class<?>> controllers = Scans.me().scanPackage("com.zoc.web");
		logger.debug("目前的类数量为:{}",controllers.size());
		for(Class controller : controllers){
			Method[] methods = controller.getMethods();
			for(Method method : methods){
				RequiresPermissions permission = AnnotationUtils.getAnnotation(method, RequiresPermissions.class);
				if(null == permission) continue;
				logger.debug(Json.toJson(permission.value()));
			}
		}
	}
}
