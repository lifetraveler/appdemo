package com.zoc.service.siwc.impl;

import org.springframework.stereotype.Service;

import com.zoc.common.service.impl.SuperServiceImpl;
import com.zoc.entity.siwc.Person;
import com.zoc.repository.siwc.PersonDao;
import com.zoc.service.siwc.PersonService;

@Service
public class PersonServiceImpl extends SuperServiceImpl<Person, Long> implements PersonService {

	@Override
	public void initStatements() {
		this.setStatement(PersonDao.class.getName());
	}
}
