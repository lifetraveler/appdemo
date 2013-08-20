package com.zoc.service.act.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zoc.common.service.impl.SuperServiceImpl;
import com.zoc.entity.act.CNNSDYSQ;
import com.zoc.repository.act.CNNSDYSQDao;
import com.zoc.service.act.CNNSDYSQService;

@Service
public class CNNSDYSQServiceImpl extends SuperServiceImpl<CNNSDYSQ, Long> implements CNNSDYSQService {

	@Override
	public void initStatements() {
		this.setStatement(CNNSDYSQDao.class.getName());
	}

}
