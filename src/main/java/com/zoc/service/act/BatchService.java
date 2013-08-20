package com.zoc.service.act;

import java.io.OutputStream;
import java.io.Serializable;
import com.zoc.common.entity.AjaxEntity;
import com.zoc.common.service.SuperService;

public interface BatchService<T extends AjaxEntity,ID extends Serializable> extends SuperService<T, Long> {
	public void batchDownload(OutputStream os);
}
