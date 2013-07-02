package com.zoc.service.act.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zoc.common.service.impl.SuperServiceImpl;
import com.zoc.entity.act.CNNSDJYQ;
import com.zoc.repository.act.CNNSDJYQDao;
import com.zoc.service.act.CNNSDJYQService;

@Service
public class CNNSDJYQServiceImpl extends SuperServiceImpl<CNNSDJYQ, Long> implements CNNSDJYQService {

	@Override
	public void initStatements() {
		this.setStatement(CNNSDJYQDao.class.getName());
	}

}
