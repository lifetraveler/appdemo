package com.zoc.service.act;

import java.util.List;

import com.zoc.common.service.SuperService;
import com.zoc.entity.act.CNSZJZSX;
import com.zoc.entity.act.CNSZRRSX;
import com.zoc.entity.act.CNSZRRSZ;

public interface CNSZJZSXService extends SuperService<CNSZJZSX, Long> {
	
	public void batchSave(List<CNSZJZSX> data);

}
