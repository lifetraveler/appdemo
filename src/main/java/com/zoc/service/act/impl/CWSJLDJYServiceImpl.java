package com.zoc.service.act.impl;

import org.springframework.stereotype.Service;
import com.zoc.common.service.impl.SuperServiceImpl;
import com.zoc.entity.act.CWSJLDJY;
import com.zoc.repository.act.CWSJLDJYDao;
import com.zoc.service.act.CWSJLDJYService;

@Service
public class CWSJLDJYServiceImpl extends SuperServiceImpl<CWSJLDJY, Long> implements CWSJLDJYService {

	@Override
	public void initStatements() {
		this.setStatement(CWSJLDJYDao.class.getName());
	}

}
