package com.zoc.common.poi;

import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.nutz.lang.Files;

import com.zoc.entity.act.UploadParam;

public class CopyExcel {

	public void copyExcel(UploadParam up) {
		/* get excel template */
		InputStream in = Files.findFileAsStream(up.getTemplate_path() + up.getWork_book());
		HSSFWorkbook workbook;
		try {
			workbook = new HSSFWorkbook(in);
			HSSFSheet sheet = workbook.getSheet(up.getSheet_name());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
