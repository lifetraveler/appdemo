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

import org.apache.ibatis.annotations.Param;
import com.zoc.common.repository.MyBatisRepository;
import com.zoc.common.repository.SuperDao;
import com.zoc.entity.security.Branch;

/**
 * @author Administrator
 * 
 */
@MyBatisRepository
public interface BranchDao extends SuperDao<Branch> {
	public List<Branch> listChildren(@Param("branch_code") String branch_code);
}
