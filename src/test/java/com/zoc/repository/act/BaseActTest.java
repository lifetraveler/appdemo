package com.zoc.repository.act;

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.junit.Test;
import org.nutz.lang.Files;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springside.modules.test.spring.SpringTransactionalTestCase;

@DirtiesContext
@ContextConfiguration(locations = { "/applicationContext.xml" })
public class BaseActTest extends SpringTransactionalTestCase {

	private static Logger logger = LoggerFactory.getLogger(BaseActTest.class);

	@Test
	public void uploadParamTest() {

		try {
			/* get excel template */
			InputStream in = Files.findFileAsStream("templates/in/Input-List.xls");
			HSSFWorkbook workbook;
			workbook = new HSSFWorkbook(in);
			HSSFSheet sheet = workbook.getSheet("CNSZRRSZ");

			int rowLength = 57 - 7 + 1;
			
			Iterator<Row> rows = sheet.rowIterator();
			
			while(rows.hasNext()){
				Row row = rows.next();
				if(row.getRowNum() < 7){
					continue;
				}
				logger.debug(row.getCell(0).getStringCellValue());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
