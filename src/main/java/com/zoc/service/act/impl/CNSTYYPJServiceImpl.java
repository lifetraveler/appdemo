package com.zoc.service.act.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zoc.common.service.impl.SuperServiceImpl;
import com.zoc.entity.act.CNSTYYPJ;
import com.zoc.repository.act.CNSTYYPJDao;
import com.zoc.service.act.CNSTYYPJService;

@Service
public class CNSTYYPJServiceImpl extends SuperServiceImpl<CNSTYYPJ, Long> implements CNSTYYPJService {

	@Override
	public void initStatements() {
		this.setStatement(CNSTYYPJDao.class.getName());
	}

}
