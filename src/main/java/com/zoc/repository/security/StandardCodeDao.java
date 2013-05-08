/**   
 * @Title: UserDao.java
 * @Package com.zoc.security.repository.mybatis
 * @Description: TODO
 * @author superzoc@gmail.com   
 * @date Apr 18, 2013 1:35:16 PM
 * @version   
 */
package com.zoc.repository.security;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

import com.zoc.common.repository.MyBatisRepository;
import com.zoc.entity.security.StandardCode;
import com.zoc.entity.security.User;

/**
 * @author Administrator
 * 
 */
@MyBatisRepository
public interface StandardCodeDao {
	public List<StandardCode> queryStandardCodeList(StandardCode sc);
	
	public List<StandardCode> queryStandardCodeListByPage(StandardCode sc,RowBounds pageBounds);

	public void insertStandardCode(StandardCode sc);

	public void updateStandardCode(StandardCode sc);

	public void deleteStandardCode(StandardCode sc);
}
