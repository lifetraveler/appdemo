package com.zoc.common.entity;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import com.zoc.common.SuperUtils;

public class BooleanTypeHandler implements TypeHandler<Boolean> {
	
	private Boolean valueOf(String value){
		if(SuperUtils.isNullOrEmpty(value)){
			return new Boolean(false);
		}else{
			return new Boolean(true);
		}
	}

	@Override
	public void setParameter(PreparedStatement ps, int i, Boolean parameter, JdbcType jdbcType) throws SQLException {
	}

	@Override
	public Boolean getResult(ResultSet rs, String columnName) throws SQLException {
		// TODO Auto-generated method stub
		return valueOf(rs.getString(columnName));
	}

	@Override
	public Boolean getResult(ResultSet rs, int columnIndex) throws SQLException {
		return valueOf(rs.getString(columnIndex));
	}

	@Override
	public Boolean getResult(CallableStatement cs, int columnIndex) throws SQLException {
		return valueOf(cs.getString(columnIndex));
	}

}
