package com.zoc.service.act.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zoc.common.service.impl.SuperServiceImpl;
import com.zoc.entity.act.CNNSDJFQ;
import com.zoc.repository.act.CNNSDJFQDao;
import com.zoc.service.act.CNNSDJFQService;

@Service
public class CNNSDJFQServiceImpl extends SuperServiceImpl<CNNSDJFQ, Long> implements CNNSDJFQService {

	@Override
	public void initStatements() {
		this.setStatement(CNNSDJFQDao.class.getName());
	}

}
