package com.zoc.service.act.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zoc.common.service.impl.SuperServiceImpl;
import com.zoc.entity.act.CNSZZKZX;
import com.zoc.repository.act.CNSZZKZXDao;
import com.zoc.service.act.CNSZZKZXService;

@Service
public class CNSZZKZXServiceImpl extends SuperServiceImpl<CNSZZKZX, Long> implements CNSZZKZXService {

	@Autowired
	CNSZZKZXDao cnszjjsqDao;

	@Override
	public void initStatements() {
		this.setStatement(CNSZZKZXDao.class.getName());
	}

}
