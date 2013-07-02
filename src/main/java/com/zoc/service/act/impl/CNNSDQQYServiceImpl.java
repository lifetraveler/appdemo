package com.zoc.service.act.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zoc.common.service.impl.SuperServiceImpl;
import com.zoc.entity.act.CNNSDQQY;
import com.zoc.repository.act.CNNSDQQYDao;
import com.zoc.service.act.CNNSDQQYService;

@Service
public class CNNSDQQYServiceImpl extends SuperServiceImpl<CNNSDQQY, Long> implements CNNSDQQYService {

	@Override
	public void initStatements() {
		this.setStatement(CNNSDQQYDao.class.getName());
	}

}
