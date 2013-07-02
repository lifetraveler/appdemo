package com.zoc.service.act.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zoc.common.service.impl.SuperServiceImpl;
import com.zoc.entity.act.CNSTRNMQ;
import com.zoc.repository.act.CNSTRNMQDao;
import com.zoc.service.act.CNSTRNMQService;

@Service
public class CNSTRNMQServiceImpl extends SuperServiceImpl<CNSTRNMQ, Long> implements CNSTRNMQService {

	@Override
	public void initStatements() {
		this.setStatement(CNSTRNMQDao.class.getName());
	}

}
