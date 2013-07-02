package com.zoc.service.act.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zoc.common.service.impl.SuperServiceImpl;
import com.zoc.entity.act.CNNSDYTQ;
import com.zoc.repository.act.CNNSDYTQDao;
import com.zoc.service.act.CNNSDYTQService;

@Service
public class CNNSDYTQServiceImpl extends SuperServiceImpl<CNNSDYTQ, Long> implements CNNSDYTQService {

	@Override
	public void initStatements() {
		this.setStatement(CNNSDYTQDao.class.getName());
	}

}
