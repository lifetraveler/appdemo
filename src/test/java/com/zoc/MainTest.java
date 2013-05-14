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
import com.zoc.entity.act.CNSZRRSZ;
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
		InputStream in = Files.findFileAsStream("d:/Input-List.xls");
		ImportExcel<CNSZRRSZ> ie = new ImportExcel<CNSZRRSZ>(CNSZRRSZ.class);
		List<CNSZRRSZ> datas = new ArrayList<CNSZRRSZ>();
		List<String> tempdatas = new ArrayList<String>();
		try {
			/* get excel template */
			InputStream template = Files.findFileAsStream("templates/in/Input-List.xls");
			HSSFWorkbook workbook;
			workbook = new HSSFWorkbook(template);
			HSSFSheet sheet = workbook.getSheet("CNSZRRSZ");

			int rowLength = 57 - 7 + 1;

			Iterator<Row> rows = sheet.rowIterator();

			while (rows.hasNext()) {
				Row row = rows.next();
				if (row.getRowNum() < 7) {
					continue;
				}
				tempdatas.add(row.getCell(0).getStringCellValue());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (datas.size() != tempdatas.size()) {
			System.out.println("行不对");
		}
		try {
			for (int i = 0; i < datas.size(); i++) {
				if (!StringUtils.equals(datas.get(i).getC1(), tempdatas.get(i))) {
					System.out.println("名字不对");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("都对");
	}

}
