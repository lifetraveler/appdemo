/**   
* @Title: StandardCode.java
* @Package com.zoc.entity.security
* @Description: TODO
* @author superzoc@gmail.com   
* @date May 1, 2013 9:41:39 PM
* @version   
*/
package com.zoc.entity.security;

import com.zoc.common.SuperUtils;

/**
 * @author Administrator
 *
 */
public class StandardCode {
	
	String code_name;
	
	String code_type;
	
	String code_value;
	
	Integer code_order;
	
	public StandardCode(){
		super();
	}
	
	public StandardCode(String code_name){
		if(!SuperUtils.isNullOrEmpty(code_name)){
			this.code_name = code_name;
		}
	}

	/**
	 * @return the code_name
	 */
	public String getCode_name() {
		return code_name;
	}

	/**
	 * @param code_name the code_name to set
	 */
	public void setCode_name(String code_name) {
		this.code_name = code_name;
	}

	/**
	 * @return the code_type
	 */
	public String getCode_type() {
		return code_type;
	}

	/**
	 * @param code_type the code_type to set
	 */
	public void setCode_type(String code_type) {
		this.code_type = code_type;
	}

	/**
	 * @return the code_value
	 */
	public String getCode_value() {
		return code_value;
	}

	/**
	 * @param code_value the code_value to set
	 */
	public void setCode_value(String code_value) {
		this.code_value = code_value;
	}

	/**
	 * @return the code_order
	 */
	public Integer getCode_order() {
		return code_order;
	}

	/**
	 * @param code_order the code_order to set
	 */
	public void setCode_order(Integer code_order) {
		this.code_order = code_order;
	}
	
	
	
	

}
