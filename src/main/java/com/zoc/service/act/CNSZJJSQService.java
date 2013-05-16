package com.zoc.service.act;

import java.util.List;

import com.zoc.common.service.SuperService;
import com.zoc.entity.act.CNSZJJSQ;
import com.zoc.entity.act.CNSZRRSX;
import com.zoc.entity.act.CNSZRRSZ;

public interface CNSZJJSQService extends SuperService<CNSZJJSQ, Long> {
	
	public void batchSave(List<CNSZJJSQ> data);

}
