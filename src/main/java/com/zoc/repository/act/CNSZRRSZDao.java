/**   
 * @Title: UserDao.java
 * @Package com.zoc.security.repository.mybatis
 * @Description: TODO
 * @author superzoc@gmail.com   
 * @date Apr 18, 2013 1:35:16 PM
 * @version   
 */
package com.zoc.repository.act;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

import com.zoc.common.repository.MyBatisRepository;
import com.zoc.common.repository.SuperDao;
import com.zoc.entity.act.CNSZRRSZ;
import com.zoc.entity.security.Menu;
import com.zoc.entity.security.Permission;
import com.zoc.entity.security.StandardCode;
import com.zoc.entity.security.User;

/**
 * @author Administrator
 * 
 */
@MyBatisRepository
public interface CNSZRRSZDao extends SuperDao<CNSZRRSZ>{
	
//	List<In_1_1> queryIn_1_1(@Param(value = "c1") Integer c1);

}
