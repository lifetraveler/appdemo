package com.zoc.service.act.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zoc.common.service.impl.SuperServiceImpl;
import com.zoc.entity.act.CNNSQZCB;
import com.zoc.repository.act.CNNSQZCBDao;
import com.zoc.service.act.CNNSQZCBService;

@Service
public class CNNSQZCBServiceImpl extends SuperServiceImpl<CNNSQZCB, Long> implements CNNSQZCBService {

	@Override
	public void initStatements() {
		this.setStatement(CNNSQZCBDao.class.getName());
	}

}
