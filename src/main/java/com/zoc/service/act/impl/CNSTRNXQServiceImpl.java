package com.zoc.service.act.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zoc.common.service.impl.SuperServiceImpl;
import com.zoc.entity.act.CNSTRNXQ;
import com.zoc.repository.act.CNSTRNXQDao;
import com.zoc.service.act.CNSTRNXQService;

@Service
public class CNSTRNXQServiceImpl extends SuperServiceImpl<CNSTRNXQ, Long> implements CNSTRNXQService {

	@Override
	public void initStatements() {
		this.setStatement(CNSTRNXQDao.class.getName());
	}

}
