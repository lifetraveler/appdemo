package com.zoc.service.act.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.zoc.entity.act.In_2_2_1;
import com.zoc.entity.act.In_1_1;
import com.zoc.repository.act.InputDao;
import com.zoc.service.act.InputService;

@Service
public class InputServiceImpl implements InputService {

	private static Logger logger = LoggerFactory.getLogger(InputServiceImpl.class);

	private InputDao inputDao;

	/**
	 * @param inputDao
	 *            the inputDao to set
	 */
	@Autowired
	public void setInputDao(InputDao inputDao) {
		this.inputDao = inputDao;
	}

	@Override
	public List<In_1_1> queryIn_1_1(Integer c1) {
		return inputDao.queryIn_1_1(c1);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.zoc.service.act.InputService#batchSaveIn_1_1(java.util.List)
	 */
	@Override
	@Transactional
	public void batchSaveIn_1_1(List<In_1_1> lists) {
		for (In_1_1 data : lists) {
			String state = data.getState();
			String id = data.getUid();
			if (state.equals("added") || id.equals("")) // 新增：id为空，或_state为added
			{
				addIn_1_1(data);
			} else if (state.equals("removed") || state.equals("deleted")) {
				removeIn_1_1(data);
			} else if (state.equals("modified") || state.equals("")) // 更新：_state为空，或modified
			{
				modifyIn_1_1(data);
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.zoc.service.act.InputService#addIn_1_1(com.zoc.entity.act.
	 * In__1_1)
	 */
	@Override
	@Transactional
	public void addIn_1_1(In_1_1 data) {
		inputDao.insertIn_1_1(data);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.zoc.service.act.InputService#modifyIn_1_1(com.zoc.entity.act
	 * .In__1_1)
	 */
	@Override
	@Transactional
	public void modifyIn_1_1(In_1_1 data) {
		inputDao.updateIn_1_1(data);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.zoc.service.act.InputService#removeIn_1_1(com.zoc.entity.act
	 * .In__1_1)
	 */
	@Override
	@Transactional
	public void removeIn_1_1(In_1_1 data) {
		inputDao.deleteIn_1_1(data.getC1());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.zoc.service.act.InputService#queryIn_2_2_1()
	 */
	@Override
	public List<In_2_2_1> queryIn_2_2_1(In_2_2_1 data) {
		return inputDao.queryIn_2_2_1(data);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.zoc.service.act.InputService#batchSaveIn_2_2_1(java.util.List)
	 */
	@Override
	public void batchSaveIn_2_2_1(List<In_2_2_1> lists) {
		for (In_2_2_1 data : lists) {
			String state = data.getState();
			String id = data.getUid();
			if (state.equals("added") || id.equals("")) // 新增：id为空，或_state为added
			{
				addIn_2_2_1(data);
			} else if (state.equals("removed") || state.equals("deleted")) {
				removeIn_2_2_1(data);
			} else if (state.equals("modified") || state.equals("")) // 更新：_state为空，或modified
			{
				modifyIn_2_2_1(data);
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.zoc.service.act.InputService#addIn_2_2_1(com.zoc.entity.act.
	 * In__2_1)
	 */
	@Override
	public void addIn_2_2_1(In_2_2_1 data) {
		inputDao.insertIn_2_2_1(data);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.zoc.service.act.InputService#modifyIn_2_2_1(com.zoc.entity.act
	 * .In__2_1)
	 */
	@Override
	public void modifyIn_2_2_1(In_2_2_1 data) {
		inputDao.updateIn_2_2_1(data);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.zoc.service.act.InputService#removeIn_2_2_1(com.zoc.entity.act
	 * .In__2_1)
	 */
	@Override
	public void removeIn_2_2_1(In_2_2_1 data) {
		inputDao.deleteIn_2_2_1(data);
	}

}
