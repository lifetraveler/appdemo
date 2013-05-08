/**   
 * @Title: ShiroDbRealm.java
 * @Package com.zoc.service.security
 * @Description: TODO
 * @author superzoc@gmail.com   
 * @date Apr 12, 2013 2:18:20 PM
 * @version   
 */
package com.zoc.service.security.impl;

import java.io.Serializable;

import javax.annotation.PostConstruct;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springside.modules.utils.Encodes;

import com.zoc.common.SuperUtils;
import com.zoc.entity.security.User;
import com.zoc.service.security.UserService;

/**
 * @author Administrator
 * 
 */
public class ShiroDbRealm extends AuthorizingRealm {

	private static Logger logger = LoggerFactory.getLogger(ShiroDbRealm.class);

	private UserService userService;

	public ShiroDbRealm() {
		super();
	}

	/**
	 * 授权查询回调函数, 进行鉴权但缓存中无用户的授权信息时调用.
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		return null;
	}

	/**
	 * 认证回调函数,登录时调用
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {
		UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
		User user = userService.fetchByUserName(token.getUsername());
		if (user != null) {
			if (user.getStatus().equals("C")) {
				throw new DisabledAccountException();
			}

			byte[] salt = Encodes.decodeHex(user.getSalt());
			return new SimpleAuthenticationInfo(user, user.getPassword(), ByteSource.Util.bytes(salt), getName());
		} else {
			return null;
		}

	}

	/**
	 * 设定Password校验的Hash算法与迭代次数.
	 */
	@PostConstruct
	public void initCredentialsMatcher() {
		HashedCredentialsMatcher matcher = new HashedCredentialsMatcher(SuperUtils.HASH_ALGORITHM);
		matcher.setHashIterations(SuperUtils.HASH_INTERATIONS);

		setCredentialsMatcher(matcher);
	}

	/**
	 * @param userService
	 *            the userService to set
	 */
	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	/**
	 * 自定义Authentication对象，使得Subject除了携带用户的登录名外还可以携带更多信息.
	 */
	public static class ShiroUser implements Serializable {

		private static final long serialVersionUID = -1748602382963711884L;
		private String username;
		private User user;

		public ShiroUser() {

		}

		/**
		 * 构造函数
		 * 
		 * @param id
		 * @param loginName
		 * @param email
		 * @param createTime
		 * @param status
		 */
		public ShiroUser(String username, User user) {
			this.username = username;
			this.user = user;
		}

		/**
		 * 返回 loginName 的值
		 * 
		 * @return loginName
		 */
		public String getUsername() {
			return username;
		}

		/**
		 * 返回 user 的值
		 * 
		 * @return user
		 */
		public User getUser() {
			return user;
		}

		/**
		 * 本函数输出将作为默认的<shiro:principal/>输出.
		 */
		@Override
		public String toString() {
			return username;
		}
	}

}
