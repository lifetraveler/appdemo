package com.zoc.repository.act;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zoc.common.repository.MyBatisRepository;
import com.zoc.entity.act.Out_1_1;

@MyBatisRepository
public interface OutputDao {

	List<Out_1_1> queryOut_1_1(@Param(value = "c1") Integer c1);

	void insertOut_1_1(Out_1_1 data);

	void updateOut_1_1(Out_1_1 data);

	void deleteOut_1_1(int c1);
	


}
