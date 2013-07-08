/**   
 * @Title: SuperUtils.java
 * @Package com.zoc.common
 * @Description: TODO
 * @author superzoc@gmail.com   
 * @date May 2, 2013 2:33:32 PM
 * @version   
 */
package com.zoc.common;

import java.lang.reflect.Field;
import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.util.ReflectionUtils;

import com.alibaba.fastjson.JSON;
import com.zoc.entity.security.User;

/**
 * @author Administrator
 * 
 */
public abstract class SuperUtils {
	
	public static final String HASH_ALGORITHM = "SHA-1";
	public static final int HASH_INTERATIONS = 1024;
	public static final String GBL_LOCATION = "100000";
	public static final int DEFAULT_YEAR = 2011;

	public static final <T> List<T> parseArray(String text, Class<T> clazz) {
		return JSON.parseArray(text.replace("_state", "state").replace("_uid", "uid").replace("_index", "index"), clazz);
	}
	
	public static final <T> T parseObject(String text,Class<T> clazz){
		return JSON.parseObject(text, clazz);
	}
	
	public static boolean isNullOrEmpty(Object obj) {	
		return obj == null || "".equals(obj.toString());
	}

	/**
	 * Field Utils
	 */
	public static boolean hasField(Object target, String fieldName, Class<?> type) {  
        return ReflectionUtils.findField(target.getClass(), fieldName, type) == null;  
    }  
  
    public static Object getFieldValue(Object target, String fieldName) {  
        Field field = ReflectionUtils.findField(target.getClass(), fieldName);  
        ReflectionUtils.makeAccessible(field);  
        return ReflectionUtils.getField(field, target);  
    }  
      
    public static void setFieldValue(Object target, String fieldName, Object value) {  
        Field field = ReflectionUtils.findField(target.getClass(), fieldName);  
        ReflectionUtils.makeAccessible(field);  
        ReflectionUtils.setField(field, target, value);  
    }  
    
    public static User getSubjectUser(){
    	Subject currentUser = SecurityUtils.getSubject();
		return (User) currentUser.getPrincipal();
    }
}
