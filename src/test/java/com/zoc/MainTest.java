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
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.nutz.lang.Files;

import com.alibaba.fastjson.JSON;
import com.zoc.common.poi.ImportExcel;
import com.zoc.entity.act.CNSZJJSQ;
import com.zoc.entity.act.CNSZRRSZ;
import com.zoc.entity.security.Menu;
import com.zoc.repository.act.CNSZJJSQDao;

/**
 * @author Administrator
 * 
 */
public class MainTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Class<CNSZJJSQ> classzz = null;
		System.out.println(classzz.getSimpleName());
	}

}
