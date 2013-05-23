package com.zoc.service.act.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zoc.common.service.impl.SuperServiceImpl;
import com.zoc.entity.act.CNSZJZSZ;
import com.zoc.repository.act.CNSZJZSZDao;
import com.zoc.service.act.CNSZJZSZService;

@Service
public class CNSZJZSZServiceImpl extends SuperServiceImpl<CNSZJZSZ, Long> implements CNSZJZSZService {

	@Autowired
	CNSZJZSZDao cnszjzszDao;

	@Override
	public void initStatements() {
		this.setStatement(CNSZJZSZDao.class.getName());
	}

	
	
	
	
	
	

}
