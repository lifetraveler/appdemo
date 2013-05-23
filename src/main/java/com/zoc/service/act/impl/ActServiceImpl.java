package com.zoc.service.act.impl;

import java.io.Serializable;
import org.springframework.stereotype.Service;
import com.zoc.common.entity.AjaxEntity;
import com.zoc.common.service.impl.SuperServiceImpl;
import com.zoc.service.act.ActService;

@Service
public class ActServiceImpl<T extends AjaxEntity, ID extends Serializable> extends SuperServiceImpl<T, Long> implements
		ActService<T, Serializable> {

	private Class<T> classzz;

	public ActServiceImpl(Class<T> classzz) {
		this.classzz = classzz;

	}

	@Override
	public void initStatements() {
		this.setStatement(classzz.getName());
	}

}
