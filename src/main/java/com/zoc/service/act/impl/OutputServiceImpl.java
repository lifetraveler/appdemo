package com.zoc.service.act.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zoc.entity.act.In_1_1;
import com.zoc.entity.act.Out_1_1;
import com.zoc.repository.act.InputDao;
import com.zoc.repository.act.OutputDao;
import com.zoc.service.act.OutputService;

@Service
public class OutputServiceImpl implements OutputService {
	
	private static Logger logger = LoggerFactory.getLogger(OutputServiceImpl.class);

	@Autowired
	private OutputDao outputDao;

	@Override
	public List<Out_1_1> queryOut_1_1(Integer c1) {
		return outputDao.queryOut_1_1(c1);
	}

	@Override
	public void batchSaveOut_1_1(List<Out_1_1> lists) {
		for (Out_1_1 data : lists) {
			String state = data.getState();
			String id = data.getUid();
			if (state.equals("added") || id.equals("")) // 新增：id为空，或_state为added
			{
				addOut_1_1(data);
			} else if (state.equals("removed") || state.equals("deleted")) {
				removeOut_1_1(data);
			} else if (state.equals("modified") || state.equals("")) // 更新：_state为空，或modified
			{
				modifyOut_1_1(data);
			}
		}
	}

	@Override
	public void addOut_1_1(Out_1_1 data) {
		outputDao.insertOut_1_1(data);
	}

	@Override
	public void modifyOut_1_1(Out_1_1 data) {
		outputDao.updateOut_1_1(data);
	}

	@Override
	public void removeOut_1_1(Out_1_1 data) {
		outputDao.deleteOut_1_1(data.getC1());
	}

}
