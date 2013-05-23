package com.zoc.service.security.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zoc.common.service.impl.SuperServiceImpl;
import com.zoc.entity.security.Branch;
import com.zoc.repository.security.BranchDao;
import com.zoc.service.security.BranchService;

@Service
public class BranchServiceImpl extends SuperServiceImpl<Branch, Long> implements BranchService {

	@Autowired
	BranchDao branchDao;

	@Override
	public void initStatements() {
		this.setStatement(BranchDao.class.getName());
	}

	@Override
	public void remove(Branch branch) {
		branchDao.delete(branch);
		List<Branch> childrens = branchDao.listChildren(branch.getBranch_code());
		for (Branch children : childrens) {
			remove(children);
		}
	}
}
