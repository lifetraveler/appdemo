package com.zoc.service.act;

import java.io.Serializable;
import java.util.List;

import com.zoc.common.entity.AjaxEntity;
import com.zoc.common.service.SuperService;
import com.zoc.entity.act.CNSZJJSQ;
import com.zoc.entity.act.CNSZRRSX;
import com.zoc.entity.act.CNSZRRSZ;

public interface ActService<T extends AjaxEntity,ID extends Serializable> extends SuperService<T, Long> {
	
}
