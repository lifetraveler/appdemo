package com.zoc.service.act.impl;

import java.io.OutputStream;
import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zoc.common.entity.AjaxEntity;
import com.zoc.common.poi.ExportExcel;
import com.zoc.common.service.impl.SuperServiceImpl;
import com.zoc.entity.act.CNNSDDYQ;
import com.zoc.entity.act.UploadParam;
import com.zoc.service.act.ActService;
import com.zoc.service.act.BatchService;
import com.zoc.service.act.CNNSDDYQService;
import com.zoc.service.act.UploadParamService;

@Service
public class BatchServiceImpl<T extends AjaxEntity, ID extends Serializable> extends SuperServiceImpl<T, Long> implements
		BatchService<T, Serializable> {

	private Class<T> classzz;
	
	@Autowired
	UploadParamService uploadParamService;
	
	@Autowired
	CNNSDDYQService cnnsddyqService;
	
	
	

	public BatchServiceImpl(Class<T> classzz) {
		this.classzz = classzz;

	}

	@Override
	public void initStatements() {
		this.setStatement(classzz.getName());
	}

	@Override
	public void batchDownload(OutputStream os) {
		//CNNSDDYQ
	}
	
	

}
