package com.zoc.service.act;

import java.util.List;

import com.zoc.common.service.SuperService;
import com.zoc.entity.act.CNSZJZSX;

public interface CNSZJZSXService extends SuperService<CNSZJZSX, Long> {
	
	@Override
	public void batchSave(List<CNSZJZSX> data);

}
