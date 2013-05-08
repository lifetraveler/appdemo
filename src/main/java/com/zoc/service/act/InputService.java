package com.zoc.service.act;

import java.util.List;

import com.zoc.entity.act.In_2_2_1;
import com.zoc.entity.act.In_1_1;

public interface InputService {
	/*
	 * In__1_1
	 */
	List<In_1_1> queryIn_1_1(Integer c1);

	void batchSaveIn_1_1(List<In_1_1> lists);

	void addIn_1_1(In_1_1 data);

	void modifyIn_1_1(In_1_1 data);

	void removeIn_1_1(In_1_1 data);

	/*
	 * In__2_1
	 */
	List<In_2_2_1> queryIn_2_2_1(In_2_2_1 data);

	void batchSaveIn_2_2_1(List<In_2_2_1> lists);

	void addIn_2_2_1(In_2_2_1 data);

	void modifyIn_2_2_1(In_2_2_1 data);

	void removeIn_2_2_1(In_2_2_1 data);

}
