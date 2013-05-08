package com.zoc.web.act;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.nutz.json.Json;
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
import com.zoc.common.poi.ImportExcel;
import com.zoc.entity.act.In_2_2_1;
import com.zoc.entity.act.In_1_1;
import com.zoc.entity.security.User;
import com.zoc.service.act.InputService;

/**
 * @author Super
 */
@Controller
@RequestMapping(value = "input")
public class InputController {

	private static Logger logger = LoggerFactory.getLogger(InputController.class);

	private static final String IN_1_1 = "act/in_1_1";

	private static final String IN_2_2_1 = "act/in_2_2_1";

	private InputService inputService;

	/**
	 * @param inputService
	 *            the inputService to set
	 */
	@Autowired
	public void setInputService(InputService inputService) {
		this.inputService = inputService;
	}

	/**
	 * Outer_1_1
	 */
	@RequestMapping(value = "1_1", method = RequestMethod.GET)
	public String inOuter1_1() {
		return IN_1_1;
	}

	@RequestMapping(value = "/1_1/list", method = { RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody
	List<In_1_1> listIn_1_1(@RequestParam(value = "c1", required = false) Integer c1) {
		return inputService.queryIn_1_1(c1);
	}

	@RequestMapping(value = "/1_1/save", method = { RequestMethod.POST })
	public @ResponseBody
	String saveIn_1_1(@RequestParam("data") String data) {
		logger.debug(data);
		inputService.batchSaveIn_1_1(SuperUtils.parseArray(data, In_1_1.class));
		return "save success!";
	}

	@RequestMapping(value = "/1_1/upload", method = { RequestMethod.POST })
	public @ResponseBody
	void uploadIn_1_1(MultipartHttpServletRequest request) throws IOException {
		Iterator<String> it = request.getFileNames();
		while (it.hasNext()) {
			List<MultipartFile> files = request.getFiles(it.next());
			for (MultipartFile file : files) {
				logger.info("file name is {}", file.getOriginalFilename());
				ImportExcel<In_1_1> in = new ImportExcel<In_1_1>(In_1_1.class);
				List<In_1_1> lists = (List<In_1_1>) in.importExcel(file.getInputStream(), 5);
				for (In_1_1 entity : lists) {
					inputService.addIn_1_1(entity);
				}
			}
		}
	}

	/*
	 * Inner_2_1
	 */
	@RequestMapping(value = "2_2_1", method = RequestMethod.GET)
	public String in_2_1() {
		return IN_2_2_1;
	}

	@RequestMapping(value = "/2_2_1/list", method = { RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody
	List<In_2_2_1> listIn_2_1() {
		Subject currentUser = SecurityUtils.getSubject();
		User user = (User)currentUser.getPrincipal();
		In_2_2_1 data = new In_2_2_1();
		data.setLoc_id(user.getLocation());
		return inputService.queryIn_2_2_1(data);
	}
	
	@RequestMapping(value = "/2_2_1/save", method = { RequestMethod.POST })
	public @ResponseBody
	String saveIn_2_2_1(@RequestParam("data") String data) {
		logger.debug(data);
		inputService.batchSaveIn_2_2_1(JSON.parseArray(data.replace("_state", "state").replace("_uid", "uid")
				.replace("_index", "index"), In_2_2_1.class));
		return "save success!";
	}
	
	@RequestMapping(value = "/2_2_1/upload", method = { RequestMethod.POST })
	public @ResponseBody
	void uploadIn_2_1(MultipartHttpServletRequest request) throws IOException {
		Iterator<String> it = request.getFileNames();
		while (it.hasNext()) {
			List<MultipartFile> files = request.getFiles(it.next());
			for (MultipartFile file : files) {
				logger.info("file name is {}", file.getOriginalFilename());
				ImportExcel<In_2_2_1> in = new ImportExcel<In_2_2_1>(In_2_2_1.class);
				List<In_2_2_1> lists = (List<In_2_2_1>) in.importExcel(file.getInputStream(), 7);
				for (In_2_2_1 entity : lists) {
					inputService.addIn_2_2_1(entity);
				}
			}
		}
	}
}
