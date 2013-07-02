/**   
* @Title: Use.java
* @Package com.zoc.security.entity
* @Description: TODO
* @author superzoc@gmail.com   
* @date Apr 18, 2013 12:10:39 PM
* @version   
*/
package com.zoc.entity.security;

import java.io.Serializable;
import java.util.List;

import com.zoc.common.entity.AjaxEntity;

/**
 * @author Administrator
 *
 */
public class User  extends AjaxEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String username;
	
	private String  password;
	
	private String plainPassword;
	
	private String realname;
	
	private String salt;
	
	private String status;
	
	private String location;
	
	private String home_branch;
	
	private List<UserRole> roles;
	
	
	

	/**
	 * @return the plainPassword
	 */
	public String getPlainPassword() {
		return plainPassword;
	}

	/**
	 * @param plainPassword the plainPassword to set
	 */
	public void setPlainPassword(String plainPassword) {
		this.plainPassword = plainPassword;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the realname
	 */
	public String getRealname() {
		return realname;
	}

	/**
	 * @param realname the realname to set
	 */
	public void setRealname(String realname) {
		this.realname = realname;
	}

	/**
	 * @return the salt
	 */
	public String getSalt() {
		return salt;
	}

	/**
	 * @param salt the salt to set
	 */
	public void setSalt(String salt) {
		this.salt = salt;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * @param location the location to set
	 */
	public void setLocation(String location) {
		this.location = location;
	}

	public String getHome_branch() {
		return home_branch;
	}

	public void setHome_branch(String home_branch) {
		this.home_branch = home_branch;
	}

	public List<UserRole> getRoles() {
		return roles;
	}

	public void setRoles(List<UserRole> roles) {
		this.roles = roles;
	}
	
	
	
	
	

}
