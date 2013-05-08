package com.zoc.service.act;

import java.util.List;

import com.zoc.entity.act.In_2_2_1;
import com.zoc.entity.act.In_1_1;
import com.zoc.entity.act.Out_1_1;

public interface OutputService {
	/*
	 * Out_1_1
	 */
	List<Out_1_1> queryOut_1_1(Integer c1);

	void batchSaveOut_1_1(List<Out_1_1> lists);

	void addOut_1_1(Out_1_1 data);

	void modifyOut_1_1(Out_1_1 data);

	void removeOut_1_1(Out_1_1 data);

	

}
