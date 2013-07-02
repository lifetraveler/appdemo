package com.zoc.service.act.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zoc.common.service.impl.SuperServiceImpl;
import com.zoc.entity.act.CNNSDDYQ;
import com.zoc.repository.act.CNNSDDYQDao;
import com.zoc.service.act.CNNSDDYQService;

@Service
public class CNNSDDYQServiceImpl extends SuperServiceImpl<CNNSDDYQ, Long> implements CNNSDDYQService {

	@Override
	public void initStatements() {
		this.setStatement(CNNSDDYQDao.class.getName());
	}

}
