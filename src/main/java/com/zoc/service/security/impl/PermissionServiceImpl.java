/**   
* @Title: PermissionsServiceImpl.java
* @Package com.zoc.service.act.impl
* @Description: TODO
* @author superzoc@gmail.com   
* @date May 6, 2013 9:39:36 PM
* @version   
*/
package com.zoc.service.security.impl;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.zoc.entity.security.Permission;
import com.zoc.repository.security.PermissionDao;
import com.zoc.service.security.PermissionService;
import com.zoc.common.service.impl.SuperServiceImpl;

/**
 * @author Administrator
 *
 */
public class PermissionServiceImpl extends SuperServiceImpl<Permission,Long> implements PermissionService {
	
	

	
	@Override
	@Transactional
	public void addPermissions(Permission permission) {
		sqlSession.insert("com.zoc.repository.security.PermissionDao.insertPermission",permission);
	}

	@Override
	public void initStatements() {
		this.setStatement(PermissionDao.class.getName());
		
	}

}
