package com.zoc.service.act;

import java.util.List;

import com.zoc.common.service.SuperService;
import com.zoc.entity.act.CNSZJZSZ;

public interface CNSZJZSZService extends SuperService<CNSZJZSZ, Long> {
	
	@Override
	public void batchSave(List<CNSZJZSZ> data);

}
