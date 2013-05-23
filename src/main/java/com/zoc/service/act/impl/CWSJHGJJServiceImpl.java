package com.zoc.service.act.impl;

import org.springframework.stereotype.Service;
import com.zoc.common.service.impl.SuperServiceImpl;
import com.zoc.entity.act.CWSJHGJJ;
import com.zoc.repository.act.CWSJHGJJDao;
import com.zoc.service.act.CWSJHGJJService;

@Service
public class CWSJHGJJServiceImpl extends SuperServiceImpl<CWSJHGJJ, Long> implements CWSJHGJJService {

	@Override
	public void initStatements() {
		this.setStatement(CWSJHGJJDao.class.getName());
	}

}
