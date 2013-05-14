/**   
 * @Title: ImportExcel.java
 * @Package com.zoc.common.poi
 * @Description: TODO
 * @author superzoc@gmail.com   
 * @date May 1, 2013 12:16:35 AM
 * @version   
 */
package com.zoc.common.poi;

import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import com.zoc.entity.act.UploadParam;

/**
 * @author Administrator
 * 
 */
public class ImportExcel<T> {

	private Class<T> classzz;

	public ImportExcel(Class<T> classzz) {
		this.classzz = classzz;
	}

	/**
	 * 导入EXCEL
	 */
	public Collection<T> importExcel(InputStream in, UploadParam param) {
		Collection<T> dist = new ArrayList<T>();

		try {
			/**
			 * 反射得到所有的方法
			 */
			// 得到目标类的所有字段列表
			Field[] field = classzz.getDeclaredFields();
			// 将所有标有annotation的字段，也就是允许导入数据的字段，放入到一个中
			List<ExcelMap> fieldList = new ArrayList<ExcelMap>();
			// 循环读取所有字段
			for (int i = 0; i < field.length; i++) {
				Field f = field[i];
				// 得到单个字段上的Annotation
				ExcelAnnotation exa = f.getAnnotation(ExcelAnnotation.class);
				// 如果标识了Annotation的话
				if (null != exa) {
					// 构造设置了Annotation的字段的setter方法
					String fieldName = f.getName();
					String setMethodName = "set" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
					// 构造调用的method
					Method method;
					method = classzz.getMethod(setMethodName, new Class[] { f.getType() });
					ExcelMap em = new ExcelMap(exa.cellIndex(), method, f.getGenericType());
					fieldList.add(em);
				}
			}

			/*
			 * excel的解析开始
			 */
			// 得到工作表
			HSSFWorkbook book = new HSSFWorkbook(in);
			// 得到第一页
			HSSFSheet sheet = book.getSheet(param.getSheet_name());
			// 得到第一面的所有行
			Iterator<Row> rows = sheet.rowIterator();

			while (rows.hasNext()) {
				Row row = rows.next();
				if (row.getRowNum() < param.getRow_start())
					continue;
				else {
					T obj = classzz.newInstance();
					for (ExcelMap em : fieldList) {
						Cell cell = row.getCell(em.getIndex());
						if (cell == null) {
							continue;
						}
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_NUMERIC:
							String type = em.getColType().toString();
							if (type.equals("class java.lang.Double")) {
								em.getMethod().invoke(obj,
										(double) Math.round(cell.getNumericCellValue() * 100 / 100.0));
							} else if (type.equals("class java.lang.Integer")) {
								em.getMethod().invoke(obj, (int) cell.getNumericCellValue());
							} else {
								em.getMethod().invoke(obj, Double.toString(cell.getNumericCellValue()));
							}

							break;
						case Cell.CELL_TYPE_STRING:
							em.getMethod().invoke(obj, cell.getStringCellValue());
							break;
						}
					}
					dist.add(obj);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

		return dist;

	}

	public Integer getDataYear(InputStream in, int x, int y) {
		return 2011;
	}

}
