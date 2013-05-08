package com.zoc.common.page.dialect;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * A dialect compatible with the H2 database.
 * 
 * @author Thomas Mueller
 * 
 */
public class H2Dialect implements Dialect {

	@Override
	public void setLimitParamters(PreparedStatement ps, int parameterSize, int offset, int limit) throws SQLException {
		ps.setInt(1, limit);
		if (offset > 0) {
			ps.setInt(2, offset);
		}

	}

	@Override
	public String getLimitString(String sql, boolean hasOffset) {
		return new StringBuilder(sql.length() + 20).append(sql).append(hasOffset ? " limit ? offset ?" : " limit ?")
				.toString();
	}

	@Override
	public String getLimitString(String sql, int offset, int limit) {
		return sql + " limit " + limit + " offset " + offset;
	}

}