/**   
 * @Title: MainTest.java
 * @Package com.zoc
 * @Description: TODO
 * @author superzoc@gmail.com   
 * @date Apr 30, 2013 4:19:02 PM
 * @version   
 */
package com.zoc;

import java.io.File;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

import com.zoc.entity.security.Menu;



/**
 * @author Administrator
 * 
 */
public class MainTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Menu menu = new Menu();
		System.out.println(menu.getClass().getName());
	}
	

}
