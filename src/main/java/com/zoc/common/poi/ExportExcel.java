/**   
 * @Title: ExportExcel.java
 * @Package com.zoc.common.poi
 * @Description: TODO
 * @author superzoc@gmail.com   
 * @date May 3, 2013 3:39:08 PM
 * @version   
 */
package com.zoc.common.poi;

import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.nutz.lang.Files;

import com.zoc.entity.act.UploadParam;

/**
 * @author Administrator
 * 
 */
public class ExportExcel<T> {
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); // 格式化日期
	
	public void batchExport(UploadParam up, Collection<T> dataset, OutputStream out,HSSFWorkbook workbook) throws Exception{
		// 首先检查数据看是否是正确的
					Iterator<T> its = dataset.iterator();
					// 取得实际泛型类
					T ts = its.next();
					Class tCls = ts.getClass();

					HSSFSheet sheet = workbook.getSheet(up.getSheet_name());
					
					// 得到所有字段
					Field filed[] = ts.getClass().getDeclaredFields();
					// 导出的字段的get方法
					List<ExcelMap> maps = new ArrayList<ExcelMap>();

					// 遍历整个filed
					for (int i = 0; i < filed.length; i++) {
						Field f = filed[i];
						ExcelAnnotation exa = f.getAnnotation(ExcelAnnotation.class);
						// 如果设置了annottion
						if (exa != null) {
							// 添加到需要导出的字段的方法
							String fieldname = f.getName();
							String methodName = "get" + fieldname.substring(0, 1).toUpperCase() + fieldname.substring(1);
							Method getMethod = tCls.getMethod(methodName, new Class[] {});
							ExcelMap map = new ExcelMap(exa.cellIndex(), getMethod, f.getType());
							maps.add(map);
						}
					}
					int index = up.getRow_start();
					HSSFRow row;
					for (T t : dataset) {
						row = sheet.createRow(index);
						for (ExcelMap map : maps) {
							HSSFCell cell = row.createCell(map.getIndex());
							Object value = map.getMethod().invoke(t, new Object[] {});
							String textValue = getValue(value);
							cell.setCellValue(textValue);
						}
						index++;
					}
	}

	public void exportExcel(UploadParam up, Collection<T> dataset, OutputStream out) throws Exception {
			// 首先检查数据看是否是正确的
			Iterator<T> its = dataset.iterator();
			// 取得实际泛型类
			T ts = its.next();
			Class tCls = ts.getClass();

			/* get excel template */
			InputStream in = Files.findFileAsStream(up.getTemplate_path() + up.getWork_book());
			HSSFWorkbook workbook = new HSSFWorkbook(in);
			HSSFSheet sheet = workbook.getSheet(up.getSheet_name());
			
			// 得到所有字段
			Field filed[] = ts.getClass().getDeclaredFields();
			// 导出的字段的get方法
			List<ExcelMap> maps = new ArrayList<ExcelMap>();

			// 遍历整个filed
			for (int i = 0; i < filed.length; i++) {
				Field f = filed[i];
				ExcelAnnotation exa = f.getAnnotation(ExcelAnnotation.class);
				// 如果设置了annottion
				if (exa != null) {
					// 添加到需要导出的字段的方法
					String fieldname = f.getName();
					String methodName = "get" + fieldname.substring(0, 1).toUpperCase() + fieldname.substring(1);
					Method getMethod = tCls.getMethod(methodName, new Class[] {});
					ExcelMap map = new ExcelMap(exa.cellIndex(), getMethod, f.getType());
					maps.add(map);
				}
			}
			int index = up.getRow_start();
			HSSFRow row;
			for (T t : dataset) {
				row = sheet.createRow(index);
				for (ExcelMap map : maps) {
					HSSFCell cell = row.createCell(map.getIndex());
					Object value = map.getMethod().invoke(t, new Object[] {});
					String textValue = getValue(value);
					cell.setCellValue(textValue);
				}
				index++;
			}
			workbook.write(out);

	}

	@SuppressWarnings({ "static-access" })
	private String getValue(Object value) throws ParseException {
		String textValue = "";
		if (null == value) {
			return textValue;
		}
		if (value instanceof Boolean) {
			boolean bValue = (Boolean) value;
			textValue = "是";
			if (!bValue) {
				textValue = "否";
			}
		} else if (value instanceof GregorianCalendar) {
			GregorianCalendar calendar = (GregorianCalendar) value;
			Date d = calendar.getTime();
			textValue = sdf.format(d);
		} else {
			textValue = value.toString();
		}
		return textValue;
	}
}
