/**   
 * @Title: UserDao.java
 * @Package com.zoc.security.repository.mybatis
 * @Description: TODO
 * @author superzoc@gmail.com   
 * @date Apr 18, 2013 1:35:16 PM
 * @version   
 */
package com.zoc.repository.act;

import org.apache.ibatis.annotations.Param;
import com.zoc.common.repository.MyBatisRepository;
import com.zoc.common.repository.SuperDao;
import com.zoc.entity.act.UploadParam;

/**
 * @author Administrator
 * 
 */
@MyBatisRepository
public interface UploadParamDao extends SuperDao<UploadParam> {

	public UploadParam fetchByMenuId(@Param(value = "menu_id") String menu_id);
}
