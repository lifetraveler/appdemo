package com.zoc.service.act;

import java.util.List;

import com.zoc.common.service.SuperService;
import com.zoc.entity.act.CNNSDYSQ;

public interface CNNSDYSQService extends SuperService<CNNSDYSQ, Long> {
	
	@Override
	public void batchSave(List<CNNSDYSQ> data);

}
