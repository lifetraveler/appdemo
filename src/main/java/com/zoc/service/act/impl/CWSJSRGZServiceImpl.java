package com.zoc.service.act.impl;

import org.springframework.stereotype.Service;
import com.zoc.common.service.impl.SuperServiceImpl;
import com.zoc.entity.act.CWSJSRGZ;
import com.zoc.repository.act.CWSJSRGZDao;
import com.zoc.service.act.CWSJSRGZService;

@Service
public class CWSJSRGZServiceImpl extends SuperServiceImpl<CWSJSRGZ, Long> implements CWSJSRGZService {


	@Override
	public void initStatements() {
		this.setStatement(CWSJSRGZDao.class.getName());
	}

}
