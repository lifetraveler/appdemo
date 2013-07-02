package com.zoc.service.act.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zoc.common.service.impl.SuperServiceImpl;
import com.zoc.entity.act.CNSZZSZX;
import com.zoc.repository.act.CNSZZSZXDao;
import com.zoc.service.act.CNSZZSZXService;

@Service
public class CNSZZSZXServiceImpl extends SuperServiceImpl<CNSZZSZX, Long> implements CNSZZSZXService {

	@Autowired
	CNSZZSZXDao cnszjjsqDao;

	@Override
	public void initStatements() {
		this.setStatement(CNSZZSZXDao.class.getName());
	}

}
