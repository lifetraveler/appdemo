/**   
* @Title: SuperService.java
* @Package com.zoc.service
* @Description: TODO
* @author superzoc@gmail.com   
* @date Apr 12, 2013 2:44:47 PM
* @version   
*/
package com.zoc.common.service;

import java.io.Serializable;
import java.util.List;

import com.zoc.common.entity.AjaxEntity;
import com.zoc.common.page.SuperPage;

/**
 * @author Administrator
 *
 */
public interface SuperService<T extends AjaxEntity, ID extends Serializable> {
	
	
	public void initStatements();
	
	public List<T> list(T t);
	
	public SuperPage<T> listByPage(T t,SuperPage<T> page);
	
	public int count(T t);
	
	public void add(T t);
	
	public void modify(T t);
	
	public void remove(T t);
	
	public void batchSave(List<T> data);
	
	public void save(T t, String state);
	
	public void upload(List<T> lists);

}
