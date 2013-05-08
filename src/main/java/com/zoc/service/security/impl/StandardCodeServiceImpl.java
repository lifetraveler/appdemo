package com.zoc.service.security.impl;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zoc.common.page.SuperPage;
import com.zoc.entity.security.StandardCode;
import com.zoc.entity.security.User;
import com.zoc.repository.security.StandardCodeDao;
import com.zoc.service.security.StandardCodeService;
import com.zoc.service.security.UserService;



@Service
public class StandardCodeServiceImpl implements StandardCodeService {
	
	private StandardCodeDao standardCodeDao ;

	/**
	 * @param standardCodeDao the standardCodeDao to set
	 */
	@Autowired
	public void setStandardCodeDao(StandardCodeDao standardCodeDao) {
		this.standardCodeDao = standardCodeDao;
	}

	/* (non-Javadoc)
	 * @see com.zoc.service.security.StandardCodeService#queryStandardCodeList(com.zoc.entity.security.StandardCode)
	 */
	@Override
	public List<StandardCode> queryStandardCodeList(StandardCode sc) {
		return standardCodeDao.queryStandardCodeList(sc);
	}

	/* (non-Javadoc)
	 * @see com.zoc.service.security.StandardCodeService#addStandardCode(com.zoc.entity.security.StandardCode)
	 */
	@Override
	public void addStandardCode(StandardCode sc) {
		standardCodeDao.insertStandardCode(sc);
	}

	/* (non-Javadoc)
	 * @see com.zoc.service.security.StandardCodeService#modifyStandardCode(com.zoc.entity.security.StandardCode)
	 */
	@Override
	public void modifyStandardCode(StandardCode sc) {
		standardCodeDao.updateStandardCode(sc);
	}

	/* (non-Javadoc)
	 * @see com.zoc.service.security.StandardCodeService#removeStandardCode(com.zoc.entity.security.StandardCode)
	 */
	@Override
	public void removeStandardCode(StandardCode sc) {
		standardCodeDao.deleteStandardCode(sc);
	}

	/* (non-Javadoc)
	 * @see com.zoc.service.security.StandardCodeService#queryStandardCodeListByPage(com.zoc.entity.security.StandardCode, com.zoc.common.page.SuperPage)
	 */
	@Override
	public SuperPage<StandardCode> queryStandardCodeListByPage(StandardCode sc, SuperPage<StandardCode> page) {
		page.setData(standardCodeDao.queryStandardCodeListByPage(null, new RowBounds(page.getPageOffset(),page.getPageSize())));
		page.setTotal(100);
		return page;
	}
	
	
	

}
