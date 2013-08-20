package com.zoc.service.act.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zoc.common.service.impl.SuperServiceImpl;
import com.zoc.entity.act.CNNSDYSF;
import com.zoc.repository.act.CNNSDYSFDao;
import com.zoc.service.act.CNNSDYSFService;

@Service
public class CNNSDYSFServiceImpl extends SuperServiceImpl<CNNSDYSF, Long> implements CNNSDYSFService {

	@Override
	public void initStatements() {
		this.setStatement(CNNSDYSFDao.class.getName());
	}

}
