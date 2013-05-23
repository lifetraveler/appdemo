package com.zoc.service.act;

import java.util.List;

import com.zoc.common.service.SuperService;
import com.zoc.entity.act.UploadParam;

public interface UploadParamService extends SuperService<UploadParam, Long> {
	
	@Override
	public void batchSave(List<UploadParam> data);
	
	public UploadParam fetchByMenuId(String menu_id);

}
