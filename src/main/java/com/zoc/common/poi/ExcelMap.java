package com.zoc.common.poi;

import java.lang.reflect.Method;
import java.lang.reflect.Type;

public class ExcelMap {
	Integer index;
	
	Method method;
	
	Type colType;
	
	public ExcelMap(Integer index,Method method,Type colType){
		this.index = index;
		this.method = method;
		this.colType = colType;
	}

	/**
	 * @return the index
	 */
	public Integer getIndex() {
		return index;
	}

	/**
	 * @param index the index to set
	 */
	public void setIndex(Integer index) {
		this.index = index;
	}

	/**
	 * @return the method
	 */
	public Method getMethod() {
		return method;
	}

	/**
	 * @param method the method to set
	 */
	public void setMethod(Method method) {
		this.method = method;
	}

	/**
	 * @return the colType
	 */
	public Type getColType() {
		return colType;
	}

	/**
	 * @param colType the colType to set
	 */
	public void setColType(Type colType) {
		this.colType = colType;
	}

	
	
	

}
