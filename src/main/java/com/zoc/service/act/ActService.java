package com.zoc.service.act;

import java.io.Serializable;
import com.zoc.common.entity.AjaxEntity;
import com.zoc.common.service.SuperService;

public interface ActService<T extends AjaxEntity,ID extends Serializable> extends SuperService<T, Long> {
	
}
