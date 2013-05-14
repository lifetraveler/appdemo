package com.zoc.service.act;

import java.util.List;

import com.zoc.common.service.SuperService;
import com.zoc.entity.act.CNSZRRSX;
import com.zoc.entity.act.CNSZRRSZ;

public interface CNSZRRSXService extends SuperService<CNSZRRSX, Long> {
	
	public void batchSave(List<CNSZRRSX> data);

}
