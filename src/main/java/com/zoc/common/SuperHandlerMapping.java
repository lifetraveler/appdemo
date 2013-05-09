/**   
* @Title: SuperHandlerMapping.java
* @Package com.zoc.common
* @Description: TODO
* @author superzoc@gmail.com   
* @date May 5, 2013 7:17:41 PM
* @version   
*/
package com.zoc.common;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.condition.RequestCondition;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import com.alibaba.fastjson.JSON;
import com.zoc.entity.security.Permission;
import com.zoc.repository.security.StandardCodeDaoTest;
import com.zoc.service.security.PermissionService;

/**
 * @author Administrator
 *
 */
public class SuperHandlerMapping extends RequestMappingHandlerMapping {
	
	private static Logger logger = LoggerFactory.getLogger(SuperHandlerMapping.class);
	
	public SuperHandlerMapping(PermissionService permissionService){
		this.permissionService = permissionService;
	}
	
	PermissionService permissionService;
	
	@SuppressWarnings("rawtypes")
	@Override
	public void afterPropertiesSet() {
		super.afterPropertiesSet();
		logger.debug("扩展 HandlerMapping");

		Iterator<Entry<RequestMappingInfo, HandlerMethod>> iter = getHandlerMethods().entrySet().iterator();
		
		
		while(iter.hasNext()){
			Map.Entry entry = (Entry) iter.next();
			
			HandlerMethod handlerMethod = (HandlerMethod) entry.getValue();
			
			RequiresPermissions rp = handlerMethod.getMethodAnnotation(RequiresPermissions.class);
			
			if( rp == null) continue;
			else{
				logger.debug("RequiresPermissions List:{}",JSON.toJSONString(rp.value()));
				for(String value : rp.value()){
					permissionService.addPermissions(new Permission(value));
					
				}
			}
		}
		
		
	}

}