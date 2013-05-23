package com.zoc.service.act;

import java.util.List;

import com.zoc.common.service.SuperService;
import com.zoc.entity.act.CNSZRRSZ;

public interface CNSZRRSZService extends SuperService<CNSZRRSZ, Long> {
	
	@Override
	public void batchSave(List<CNSZRRSZ> data);

}
