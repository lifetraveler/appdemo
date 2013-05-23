package com.zoc.service.act.impl;

import org.springframework.stereotype.Service;
import com.zoc.common.service.impl.SuperServiceImpl;
import com.zoc.entity.act.CWSJRKSJ;
import com.zoc.repository.act.CWSJRKSJDao;
import com.zoc.service.act.CWSJRKSJService;

@Service
public class CWSJRKSJServiceImpl extends SuperServiceImpl<CWSJRKSJ, Long> implements CWSJRKSJService {

	@Override
	public void initStatements() {
		this.setStatement(CWSJRKSJDao.class.getName());
	}

}
