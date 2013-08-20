package com.zoc.web.act;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.nutz.lang.Files;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.zoc.common.SuperUtils;
import com.zoc.common.poi.ExportExcel;
import com.zoc.common.service.SuperService;
import com.zoc.entity.act.CNNSDDYQ;
import com.zoc.entity.act.CNNSDJFQ;
import com.zoc.entity.act.CNNSDJYQ;
import com.zoc.entity.act.CNNSDQQY;
import com.zoc.entity.act.CNNSDQYQ;
import com.zoc.entity.act.CNNSDQYZ;
import com.zoc.entity.act.CNNSDYCN;
import com.zoc.entity.act.CNNSDYCQ;
import com.zoc.entity.act.CNNSDYGQ;
import com.zoc.entity.act.CNNSDYHQ;
import com.zoc.entity.act.CNNSDYJQ;
import com.zoc.entity.act.CNNSDYLQ;
import com.zoc.entity.act.CNNSDYQK;
import com.zoc.entity.act.CNNSDYSF;
import com.zoc.entity.act.CNNSDYSQ;
import com.zoc.entity.act.CNNSDYTQ;
import com.zoc.entity.act.CNNSQZCB;
import com.zoc.entity.act.CNNSYJZD;
import com.zoc.entity.act.CNNSYJZQ;
import com.zoc.entity.act.CNNSYRZJ;
import com.zoc.entity.act.CNNSYZZJ;
import com.zoc.entity.act.CNSZRRSZ;
import com.zoc.entity.act.UploadParam;
import com.zoc.service.act.CNNSDDYQService;
import com.zoc.service.act.UploadParamService;

/**
 * @author Super
 */
@Controller
@RequestMapping(value = "batch")
public class BatchController {

	private static Logger logger = LoggerFactory.getLogger(BatchController.class);

	@Autowired
	UploadParamService uploadParamService;

	@Autowired
	CNNSDDYQController cnnsddyqController;

	@Autowired
	CNNSDJFQController cnnsdjfqController;

	@Autowired
	CNNSDJYQController cnnsdjyqController;

	@Autowired
	CNNSDQQYController cnnsdqqyController;

	@Autowired
	CNNSDQYQController cnnsdqyqController;

	@Autowired
	CNNSDQYZController cnnsdqyzController;

	@Autowired
	CNNSDYCNController cnnsdycnController;

	@Autowired
	CNNSDYCQController cnnsdycqController;

	@Autowired
	CNNSDYGQController cnnsdygqController;

	@Autowired
	CNNSDYHQController cnnsdyhqController;

	@Autowired
	CNNSDYJQController cnnsdyjqController;

	@Autowired
	CNNSDYLQController cnnsdylqController;

	@Autowired
	CNNSDYQKController cnnsdyqkController;

	@Autowired
	CNNSDYSFController cnnsdysfController;

	@Autowired
	CNNSDYSQController cnnsdysqController;

	@Autowired
	CNNSDYTQController cnnsdytqController;

	@Autowired
	CNNSQZCBController cnnsqzcbController;
	
	@Autowired
	CNNSYJZDController cnnsyjzdController;
	
	@Autowired
	CNNSYJZQController cnnsyjzqController;
	
	@Autowired
	CNNSYRZJController cnnsyrzjController;
	
	@Autowired
	CNNSYZZJController cnnsyzzjController;

	@RequestMapping(value = "/input", method = RequestMethod.GET)
	public String input(Model model) {
		return "act/BatchInput";
	}

	@RequestMapping(value = "/output", method = RequestMethod.GET)
	public String output(Model model) {
		return "act/BatchOutput";
	}

	@RequestMapping(value = "/download", method = RequestMethod.GET)
	public @ResponseBody
	void download(HttpServletResponse response, Model model) {
		OutputStream os;
		List<UploadParam> ups = uploadParamService.list(null);
		try {
			/* get excel template */
			InputStream in = Files.findFileAsStream("templates/in/Input-List.xls");
			HSSFWorkbook workbook = new HSSFWorkbook(in);
			os = response.getOutputStream();
			response.reset();
			response.setHeader("Content-disposition", "attachment; filename=Output.xls");
			response.setContentType("application/msexcel");
			for (UploadParam up : ups) {
				if ("CNNSDDYQ".equals(up.getMenu_id())) {
					ExportExcel<CNNSDDYQ> ee = new ExportExcel<CNNSDDYQ>();
					CNNSDDYQ entity = new CNNSDDYQ();
					ee.batchExport(up, cnnsddyqController.list(model, entity, null), os, workbook);
				}
				if ("CNNSDJFQ".equals(up.getMenu_id())) {
					ExportExcel<CNNSDJFQ> ee = new ExportExcel<CNNSDJFQ>();
					CNNSDJFQ entity = new CNNSDJFQ();
					ee.batchExport(up, cnnsdjfqController.list(model, entity, null), os, workbook);
				}
				if ("CNNSDJYQ".equals(up.getMenu_id())) {
					ExportExcel<CNNSDJYQ> ee = new ExportExcel<CNNSDJYQ>();
					CNNSDJYQ entity = new CNNSDJYQ();
					ee.batchExport(up, cnnsdjyqController.list(model, entity, null), os, workbook);
				}
				if ("CNNSDQQY".equals(up.getMenu_id())) {
					ExportExcel<CNNSDQQY> ee = new ExportExcel<CNNSDQQY>();
					CNNSDQQY entity = new CNNSDQQY();
					ee.batchExport(up, cnnsdqqyController.list(model, entity, null), os, workbook);
				}
				if ("CNNSDQYQ".equals(up.getMenu_id())) {
					ExportExcel<CNNSDQYQ> ee = new ExportExcel<CNNSDQYQ>();
					CNNSDQYQ entity = new CNNSDQYQ();
					ee.batchExport(up, cnnsdqyqController.list(model, entity, null), os, workbook);
				}
				if ("CNNSDQYZ".equals(up.getMenu_id())) {
					ExportExcel<CNNSDQYZ> ee = new ExportExcel<CNNSDQYZ>();
					CNNSDQYZ entity = new CNNSDQYZ();
					ee.batchExport(up, cnnsdqyzController.list(model, entity, null), os, workbook);
				}
				if ("CNNSDYCN".equals(up.getMenu_id())) {
					ExportExcel<CNNSDYCN> ee = new ExportExcel<CNNSDYCN>();
					CNNSDYCN entity = new CNNSDYCN();
					ee.batchExport(up, cnnsdycnController.list(model, entity, null), os, workbook);
				}
				if ("CNNSDYCQ".equals(up.getMenu_id())) {
					ExportExcel<CNNSDYCQ> ee = new ExportExcel<CNNSDYCQ>();
					CNNSDYCQ entity = new CNNSDYCQ();
					ee.batchExport(up, cnnsdycqController.list(model, entity, null), os, workbook);
				}
				if ("CNNSDYGQ".equals(up.getMenu_id())) {
					ExportExcel<CNNSDYGQ> ee = new ExportExcel<CNNSDYGQ>();
					CNNSDYGQ entity = new CNNSDYGQ();
					ee.batchExport(up, cnnsdygqController.list(model, entity, null), os, workbook);
				}
				if ("CNNSDYHQ".equals(up.getMenu_id())) {
					ExportExcel<CNNSDYHQ> ee = new ExportExcel<CNNSDYHQ>();
					CNNSDYHQ entity = new CNNSDYHQ();
					ee.batchExport(up, cnnsdyhqController.list(model, entity, null), os, workbook);
				}
				if ("CNNSDYJQ".equals(up.getMenu_id())) {
					ExportExcel<CNNSDYJQ> ee = new ExportExcel<CNNSDYJQ>();
					CNNSDYJQ entity = new CNNSDYJQ();
					ee.batchExport(up, cnnsdyjqController.list(model, entity, null), os, workbook);
				}
				if ("CNNSDYLQ".equals(up.getMenu_id())) {
					ExportExcel<CNNSDYLQ> ee = new ExportExcel<CNNSDYLQ>();
					CNNSDYLQ entity = new CNNSDYLQ();
					ee.batchExport(up, cnnsdylqController.list(model, entity, null), os, workbook);
				}
				if ("CNNSDYQK".equals(up.getMenu_id())) {
					ExportExcel<CNNSDYQK> ee = new ExportExcel<CNNSDYQK>();
					CNNSDYQK entity = new CNNSDYQK();
					ee.batchExport(up, cnnsdyqkController.list(model, entity, null), os, workbook);
				}
				if ("CNNSDYSF".equals(up.getMenu_id())) {
					ExportExcel<CNNSDYSF> ee = new ExportExcel<CNNSDYSF>();
					CNNSDYSF entity = new CNNSDYSF();
					ee.batchExport(up, cnnsdysfController.list(model, entity, null), os, workbook);
				}
				if ("CNNSDYSQ".equals(up.getMenu_id())) {
					ExportExcel<CNNSDYSQ> ee = new ExportExcel<CNNSDYSQ>();
					CNNSDYSQ entity = new CNNSDYSQ();
					ee.batchExport(up, cnnsdysqController.list(model, entity, null), os, workbook);
				}
				if ("CNNSDYTQ".equals(up.getMenu_id())) {
					ExportExcel<CNNSDYTQ> ee = new ExportExcel<CNNSDYTQ>();
					CNNSDYTQ entity = new CNNSDYTQ();
					ee.batchExport(up, cnnsdytqController.list(model, entity, null), os, workbook);
				}
				if ("CNNSQZCB".equals(up.getMenu_id())) {
					ExportExcel<CNNSQZCB> ee = new ExportExcel<CNNSQZCB>();
					CNNSQZCB entity = new CNNSQZCB();
					ee.batchExport(up, cnnsqzcbController.list(model, entity, null), os, workbook);
				}
				if ("CNNSQZCB".equals(up.getMenu_id())) {
					ExportExcel<CNNSQZCB> ee = new ExportExcel<CNNSQZCB>();
					CNNSQZCB entity = new CNNSQZCB();
					ee.batchExport(up, cnnsqzcbController.list(model, entity, null), os, workbook);
				}
				if ("CNNSYJZD".equals(up.getMenu_id())) {
					ExportExcel<CNNSYJZD> ee = new ExportExcel<CNNSYJZD>();
					CNNSYJZD entity = new CNNSYJZD();
					ee.batchExport(up, cnnsyjzdController.list(model, entity, null), os, workbook);
				}
				if ("CNNSYJZQ".equals(up.getMenu_id())) {
					ExportExcel<CNNSYJZQ> ee = new ExportExcel<CNNSYJZQ>();
					CNNSYJZQ entity = new CNNSYJZQ();
					ee.batchExport(up, cnnsyjzqController.list(model, entity, null), os, workbook);
				}
				if ("CNNSYRZJ".equals(up.getMenu_id())) {
					ExportExcel<CNNSYRZJ> ee = new ExportExcel<CNNSYRZJ>();
					CNNSYRZJ entity = new CNNSYRZJ();
					ee.batchExport(up, cnnsyrzjController.list(model, entity, null), os, workbook);
				}
				if ("CNNSYZZJ".equals(up.getMenu_id())) {
					ExportExcel<CNNSYZZJ> ee = new ExportExcel<CNNSYZZJ>();
					CNNSYZZJ entity = new CNNSYZZJ();
					ee.batchExport(up, cnnsyzzjController.list(model, entity, null), os, workbook);
				}
			}
			workbook.write(os);
			os.flush();
			os.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
