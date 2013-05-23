package com.zoc.service.act;

import java.util.List;

import com.zoc.common.service.SuperService;
import com.zoc.entity.act.CNSZRRSX;

public interface CNSZRRSXService extends SuperService<CNSZRRSX, Long> {
	
	@Override
	public void batchSave(List<CNSZRRSX> data);

}
