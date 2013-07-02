package com.zoc.service.act.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zoc.common.service.impl.SuperServiceImpl;
import com.zoc.entity.act.CNNSDQYQ;
import com.zoc.repository.act.CNNSDQYQDao;
import com.zoc.service.act.CNNSDQYQService;

@Service
public class CNNSDQYQServiceImpl extends SuperServiceImpl<CNNSDQYQ, Long> implements CNNSDQYQService {

	@Override
	public void initStatements() {
		this.setStatement(CNNSDQYQDao.class.getName());
	}

}
