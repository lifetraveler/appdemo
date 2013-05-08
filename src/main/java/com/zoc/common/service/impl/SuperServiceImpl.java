package com.zoc.common.service.impl;

import java.io.Serializable;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.zoc.common.repository.SuperDao;
import com.zoc.common.service.SuperService;

public abstract class SuperServiceImpl<T, ID extends Serializable> {

	@Autowired
	public SqlSession sqlSession;

	String statement;

	public SuperServiceImpl() {
		initStatements();
	}

	/**
	 * @return the statement
	 */
	public String getStatement() {
		return statement;
	}

	/**
	 * @param statement
	 *            the statement to set
	 */
	public void setStatement(String statement) {
		this.statement = statement;
	}

	public abstract void initStatements();

	public List<T> list(T t) {
		return sqlSession.selectList(statement + ".list", t);
	}

	public T fetchByName(String name) {
		return sqlSession.selectOne(statement + ".fetchByName", name);
	}

	public int count(T t) {
		return sqlSession.selectOne(statement + ".count", t);
	}

	public void add(T t) {
		sqlSession.insert(statement + ".insert", t);

	}

	public void modify(T t) {
		sqlSession.update(statement + ".update", t);

	}

	public void remove(T t) {
		sqlSession.delete(statement + ".delete", t);

	}

}
