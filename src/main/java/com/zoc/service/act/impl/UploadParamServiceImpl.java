package com.zoc.service.act.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springside.modules.security.utils.Digests;
import org.springside.modules.utils.Encodes;

import com.zoc.common.SuperUtils;
import com.zoc.common.service.impl.SuperServiceImpl;
import com.zoc.entity.act.CNSZRRSZ;
import com.zoc.entity.act.UploadParam;
import com.zoc.entity.security.Menu;
import com.zoc.entity.security.Permission;
import com.zoc.entity.security.User;
import com.zoc.repository.act.CNSZRRSZDao;
import com.zoc.repository.act.UploadParamDao;
import com.zoc.repository.security.MenuDao;
import com.zoc.repository.security.PermissionDao;
import com.zoc.repository.security.UserDao;
import com.zoc.service.act.CNSZRRSZService;
import com.zoc.service.act.UploadParamService;
import com.zoc.service.security.MenuService;
import com.zoc.service.security.UserService;

@Service
public class UploadParamServiceImpl extends SuperServiceImpl<UploadParam, Long> implements UploadParamService {

	@Autowired
	UploadParamDao uploadParamDao;

	@Override
	public void initStatements() {
		this.setStatement(UploadParamDao.class.getName());
	}
	
	@Override
	public void batchSave(List<UploadParam> data) {
		for(UploadParam entity : data){
			this.save(entity);
		}
	}

	@Override
	@Transactional(readOnly = true)
	public UploadParam fetchByMenuId(String menu_id) {
		return uploadParamDao.fetchByMenuId(menu_id);
	}
	
	
	
	
	
	
	
	

}
