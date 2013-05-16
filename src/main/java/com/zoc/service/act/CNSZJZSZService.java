package com.zoc.service.act;

import java.util.List;

import com.zoc.common.service.SuperService;
import com.zoc.entity.act.CNSZJZSZ;
import com.zoc.entity.act.CNSZRRSX;
import com.zoc.entity.act.CNSZRRSZ;

public interface CNSZJZSZService extends SuperService<CNSZJZSZ, Long> {
	
	public void batchSave(List<CNSZJZSZ> data);

}
