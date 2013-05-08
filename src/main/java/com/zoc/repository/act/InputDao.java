package com.zoc.repository.act;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zoc.common.repository.MyBatisRepository;
import com.zoc.entity.act.In_2_2_1;
import com.zoc.entity.act.In_1_1;

@MyBatisRepository
public interface InputDao {

	List<In_1_1> queryIn_1_1(@Param(value = "c1") Integer c1);

	void insertIn_1_1(In_1_1 data);

	void updateIn_1_1(In_1_1 data);

	void deleteIn_1_1(int c1);
	
	List<In_2_2_1> queryIn_2_2_1(In_2_2_1 data);
	
	void insertIn_2_2_1(In_2_2_1 data);

	void updateIn_2_2_1(In_2_2_1 data);

	void deleteIn_2_2_1(In_2_2_1 data);

}
