package com.zoc.web.act;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.nutz.json.Json;
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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.alibaba.fastjson.JSON;
import com.zoc.common.SuperUtils;
import com.zoc.common.poi.ExportExcel;
import com.zoc.common.poi.ImportExcel;
import com.zoc.entity.act.In_2_2_1;
import com.zoc.entity.act.In_1_1;
import com.zoc.entity.act.Out_1_1;
import com.zoc.entity.security.User;
import com.zoc.service.act.InputService;
import com.zoc.service.act.OutputService;

/**
 * @author Super
 */
@Controller
@RequestMapping(value = "output")
public class OutputController {

	private static Logger logger = LoggerFactory.getLogger(OutputController.class);

	private static final String OUT_1_1 = "act/out_1_1";

	@Autowired
	private OutputService outputService;


	/**
	 * Outer_1_1
	 */
	@RequestMapping(value = "out_1_1", method = RequestMethod.GET)
	public String inOut1_1() {
		return OUT_1_1;
	}

	@RequestMapping(value = "/out_1_1/list", method = { RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody
	List<Out_1_1> listOuter_1_1(@RequestParam(value = "c1", required = false) Integer c1) {
		return outputService.queryOut_1_1(c1);
	}

	@RequestMapping(value = "/out_1_1/save", method = { RequestMethod.POST })
	public @ResponseBody
	String saveOut_1_1(@RequestParam("data") String data) {
		logger.debug(data);
		outputService.batchSaveOut_1_1(SuperUtils.parseArray(data, Out_1_1.class));
		return "save success!";
	}
	
	@RequestMapping(value = "/out_1_1/download", method = { RequestMethod.GET })
	public @ResponseBody
	void uploadOuter_1_1(HttpServletResponse response) throws IOException {
		OutputStream  os = response.getOutputStream();
		response.reset();
		response.setHeader("Content-disposition", "attachment; filename=out_1_1.xls");
		response.setContentType("application/msexcel");
		
		
		List<Out_1_1> datas = outputService.queryOut_1_1(null);
		
		ExportExcel<Out_1_1> ee = new ExportExcel<Out_1_1>();
		ee.exportExcel("templates/out_1_1.xls", datas, os);
		os.flush();
		os.close();
	}

}
