package com.zoc.service.act.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zoc.common.service.impl.SuperServiceImpl;
import com.zoc.entity.act.CNSZJZSX;
import com.zoc.repository.act.CNSZJZSXDao;
import com.zoc.service.act.CNSZJZSXService;

@Service
public class CNSZJZSXServiceImpl extends SuperServiceImpl<CNSZJZSX, Long> implements CNSZJZSXService {

	@Autowired
	CNSZJZSXDao cnszjzsxDao;

	@Override
	public void initStatements() {
		this.setStatement(CNSZJZSXDao.class.getName());
	}

	
	
	
	
	
	
	

}
