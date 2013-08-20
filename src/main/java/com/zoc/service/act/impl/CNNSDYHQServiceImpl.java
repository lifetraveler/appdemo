package com.zoc.service.act.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zoc.common.service.impl.SuperServiceImpl;
import com.zoc.entity.act.CNNSDYHQ;
import com.zoc.repository.act.CNNSDYHQDao;
import com.zoc.service.act.CNNSDYHQService;

@Service
public class CNNSDYHQServiceImpl extends SuperServiceImpl<CNNSDYHQ, Long> implements CNNSDYHQService {

	@Override
	public void initStatements() {
		this.setStatement(CNNSDYHQDao.class.getName());
	}

}
