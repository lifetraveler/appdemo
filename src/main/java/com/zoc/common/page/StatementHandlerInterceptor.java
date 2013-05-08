package com.zoc.common.page;

import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Properties;

import org.apache.ibatis.executor.statement.PreparedStatementHandler;
import org.apache.ibatis.executor.statement.RoutingStatementHandler;
import org.apache.ibatis.executor.statement.SimpleStatementHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.session.RowBounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zoc.common.SuperUtils;
import com.zoc.common.page.dialect.Dialect;

/**
 * @author Administrator
 * 
 */
@Intercepts({ @Signature(type = StatementHandler.class, method = "prepare", args = { Connection.class }),
		@Signature(type = StatementHandler.class, method = "parameterize", args = { Statement.class }) })
public class StatementHandlerInterceptor implements Interceptor {

	private static Logger logger = LoggerFactory.getLogger(StatementHandlerInterceptor.class);

	Dialect dialect;

	@Override
	public Object intercept(Invocation invocation) throws Throwable {
		Method m = invocation.getMethod();
		if ("prepare".equals(m.getName())) {
			return prepare(invocation);
		} else if ("parameterize".equals(m.getName())) {
			return parameterize(invocation);
		}
		return invocation.proceed();
	}

	private Object prepare(Invocation invocation) throws Throwable {
		logger.debug("prepare begin");
		StatementHandler statement = getStatementHandler(invocation);
		if (statement instanceof SimpleStatementHandler || statement instanceof PreparedStatementHandler) {
			RowBounds rowBounds = getRowBounds(statement);

			if (hasBounds(rowBounds)) {
				BoundSql boundSql = statement.getBoundSql();
				String sql = boundSql.getSql();
				if (statement instanceof SimpleStatementHandler) {
					sql = dialect.getLimitString(sql, rowBounds.getOffset(), rowBounds.getLimit());
				} else if (statement instanceof PreparedStatementHandler) {
					sql = dialect.getLimitString(sql, rowBounds.getOffset() > 0);
				}
				SuperUtils.setFieldValue(boundSql, "sql", sql);
			}
		}
		return invocation.proceed();

	}

	private Object parameterize(Invocation invocation) throws Throwable {
		Statement statement = (Statement) invocation.getArgs()[0];
		if (statement instanceof PreparedStatement) {
			PreparedStatement ps = (PreparedStatement) statement;

			StatementHandler statementHandler = getStatementHandler(invocation);
			RowBounds rowBounds = getRowBounds(statementHandler);

			if (hasBounds(rowBounds)) {
				BoundSql boundSql = statementHandler.getBoundSql();
				int parameterSize = boundSql.getParameterMappings().size();
				dialect.setLimitParamters(ps, parameterSize, rowBounds.getOffset(), rowBounds.getLimit());
			}
		}

		return invocation.proceed();

	}

	@Override
	public Object plugin(Object target) {
		return Plugin.wrap(target, this);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.apache.ibatis.plugin.Interceptor#setProperties(java.util.Properties)
	 */
	@Override
	public void setProperties(Properties properties) {
		String dialectClass = properties.getProperty("dialectClass");
		try {
			dialect = (Dialect)Class.forName(dialectClass).newInstance();
		} catch (Exception e) {
			throw new RuntimeException("cannot create dialect instance by dialectClass:"+dialectClass,e);
		} 
	}

	protected StatementHandler getStatementHandler(Invocation invocation) {
		StatementHandler statement = (StatementHandler) invocation.getTarget();
		if (statement instanceof RoutingStatementHandler) {
			statement = (StatementHandler) SuperUtils.getFieldValue(statement, "delegate");
		}
		return statement;
	}

	protected RowBounds getRowBounds(StatementHandler statement) {
		return (RowBounds) SuperUtils.getFieldValue(statement, "rowBounds");
	}

	protected boolean hasBounds(RowBounds rowBounds) {
		return (rowBounds != null && rowBounds.getLimit() > 0 && rowBounds.getLimit() < RowBounds.NO_ROW_LIMIT);
	}

}
