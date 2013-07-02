package com.zoc.service.act.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zoc.common.service.impl.SuperServiceImpl;
import com.zoc.entity.act.CNSZZKZZ;
import com.zoc.repository.act.CNSZZKZZDao;
import com.zoc.service.act.CNSZZKZZService;

@Service
public class CNSZZKZZServiceImpl extends SuperServiceImpl<CNSZZKZZ, Long> implements CNSZZKZZService {


	@Override
	public void initStatements() {
		this.setStatement(CNSZZKZZDao.class.getName());
	}

}
