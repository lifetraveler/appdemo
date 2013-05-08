package com.zoc.service.security;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

import com.zoc.common.page.SuperPage;
import com.zoc.common.service.SuperService;
import com.zoc.entity.security.StandardCode;
import com.zoc.entity.security.User;

public interface StandardCodeService {
	
	public List<StandardCode> queryStandardCodeList(StandardCode sc);
	
	public SuperPage<StandardCode> queryStandardCodeListByPage(StandardCode sc,SuperPage<StandardCode> page);
	
	public void addStandardCode(StandardCode sc);
	
	public void modifyStandardCode(StandardCode sc);
	
	public void removeStandardCode(StandardCode sc);
	
}
