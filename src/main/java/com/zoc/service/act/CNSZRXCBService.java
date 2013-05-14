package com.zoc.service.act;

import java.util.List;

import com.zoc.common.service.SuperService;
import com.zoc.entity.act.CNSZRRSZ;
import com.zoc.entity.act.CNSZRXCB;

public interface CNSZRXCBService extends SuperService<CNSZRXCB, Long> {
	
	public void batchSave(List<CNSZRXCB> data);

}
