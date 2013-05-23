package com.zoc.service.act.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.zoc.common.service.impl.SuperServiceImpl;
import com.zoc.entity.act.UploadParam;
import com.zoc.repository.act.UploadParamDao;
import com.zoc.service.act.UploadParamService;

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
