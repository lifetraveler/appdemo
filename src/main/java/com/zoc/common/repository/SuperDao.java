/**   
 * @Title: SuperDao.java
 * @Package com.zoc.common.repository
 * @Description: TODO
 * @author superzoc@gmail.com   
 * @date May 7, 2013 10:47:15 AM
 * @version   
 */
package com.zoc.common.repository;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

/**
 * @author Administrator
 * 
 */
public interface SuperDao<T> {

	List<T> list(T t);
	
	List<T> listByPage(T t, RowBounds pageBounds);

	void insert(T t);

	void update(T t);

	void modify(T t);

	void delete(T t);
}
