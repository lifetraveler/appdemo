package com.zoc.web.act;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.zoc.entity.act.CNSTRNMQ;
import com.zoc.entity.act.CNSTRNXQ;
import com.zoc.entity.act.CNSTYXYP;
import com.zoc.entity.act.CNSTYYGP;
import com.zoc.entity.act.CNSTYYPJ;
import com.zoc.entity.act.CNSTZKZQ;
import com.zoc.entity.act.CNSTZSZQ;
import com.zoc.entity.act.CNSZJJSQ;
import com.zoc.entity.act.CNSZJNXX;
import com.zoc.entity.act.CNSZJNXZ;
import com.zoc.entity.act.CNSZJZSX;
import com.zoc.entity.act.CNSZJZSZ;
import com.zoc.entity.act.CNSZRRSX;
import com.zoc.entity.act.CNSZRRSZ;
import com.zoc.entity.act.CNSZRXCB;
import com.zoc.entity.act.CNSZZKZX;
import com.zoc.entity.act.CNSZZKZZ;
import com.zoc.entity.act.CNSZZSZX;
import com.zoc.entity.act.CNSZZSZZ;
import com.zoc.entity.act.CWSJHGJJ;
import com.zoc.entity.act.CWSJLDJY;
import com.zoc.entity.act.CWSJRKSJ;
import com.zoc.entity.act.CWSJSRGZ;
import com.zoc.entity.act.UploadParam;
import com.zoc.entity.act.UploadResult;
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

	@Autowired
	CNSTRNMQController cnstrnmqController;

	@Autowired
	CNSTRNXQController cnstrnxqController;

	@Autowired
	CNSTYXYPController cnstyxypController;

	@Autowired
	CNSTYYGPController cnstyygpController;

	@Autowired
	CNSTYYPJController cnstyypjController;

	@Autowired
	CNSTZKZQController cnstzkzqController;

	@Autowired
	CNSTZSZQController cnstzszqController;

	@Autowired
	CNSZJJSQController cnszjjsqController;

	@Autowired
	CNSZJNXXController cnszjnxxController;

	@Autowired
	CNSZJNXZController cnszjnxzController;

	@Autowired
	CNSZJZSXController cnszjzsxController;

	@Autowired
	CNSZJZSZController cnszjzszController;

	@Autowired
	CNSZRRSXController cnszrrsxController;

	@Autowired
	CNSZRRSZController cnszrrszController;

	@Autowired
	CNSZRXCBController cnszrxcbController;

	@Autowired
	CNSZZKZXController cnszzkzxController;

	@Autowired
	CNSZZKZZController cnszzkzzController;

	@Autowired
	CNSZZSZXController cnszzszxController;

	@Autowired
	CNSZZSZZController cnszzszzController;

	@Autowired
	CWSJHGJJController cwsjhgjjController;

	@Autowired
	CWSJLDJYController cwsjldjyController;

	@Autowired
	CWSJRKSJController cwsjrksjController;

	@Autowired
	CWSJSRGZController cwsjsrgzController;

	@RequestMapping(value = "/input", method = RequestMethod.GET)
	public String input(Model model) {
		return "act/BatchInput";
	}

	@RequestMapping(value = "/output", method = RequestMethod.GET)
	public String output(Model model) {
		return "act/BatchOutput";
	}

	@RequestMapping(value = "/upload", method = { RequestMethod.POST })
	public @ResponseBody
	List<UploadResult> upload(MultipartHttpServletRequest request) {
		List<UploadResult> results = new ArrayList<UploadResult>();
		results.add(new UploadResult("分地区基本养老保险情况综合表(大口径)", cnnsddyqController.upload(request)));
		results.add(new UploadResult("分地区企业离退休人员养老金发放和社会化管理情况表", cnnsdjfqController.upload(request)));
		results.add(new UploadResult("分地区基本养老保险情况综合表（机关事业）", cnnsdjyqController.upload(request)));
		results.add(new UploadResult("分地区基本养老保险情况综合表（企业+其他）", cnnsdqqyController.upload(request)));
		results.add(new UploadResult("分地区基本养老保险情况综合表（企业）", cnnsdqyqController.upload(request)));
		results.add(new UploadResult("分地区基本养老保险情况综合表（其他）", cnnsdqyzController.upload(request)));
		results.add(new UploadResult("分地区基本养老保险参保农民工同比情况表", cnnsdycnController.upload(request)));
		results.add(new UploadResult("分地区基本养老保险参保职工同比情况表", cnnsdycqController.upload(request)));
		results.add(new UploadResult("分地区基本养老保险参保职工同比情况表", cnnsdycqController.upload(request)));
		results.add(new UploadResult("分地区基本养老保险个人账户累计记账额同比情况表", cnnsdygqController.upload(request)));
		results.add(new UploadResult("分地区基本养老保险稽核清欠情况表", cnnsdyhqController.upload(request)));
		results.add(new UploadResult("分地区基本养老保险缴费人员同比情况表", cnnsdyjqController.upload(request)));
		results.add(new UploadResult("分地区基本养老保险离休人员同比情况表", cnnsdylqController.upload(request)));
		results.add(new UploadResult("分地区基本养老保险人均缴费工资、退休人员养老金、替代率情况表", cnnsdyqkController.upload(request)));
		results.add(new UploadResult("分地区基本养老保险基金收缴率、负担系数情况表", cnnsdysfController.upload(request)));
		results.add(new UploadResult("分地区基本养老保险当期非正常退休及死亡人员情况表", cnnsdysqController.upload(request)));
		results.add(new UploadResult("分地区基本养老保险离退休人员同比情况表", cnnsdytqController.upload(request)));
		results.add(new UploadResult("企业基本养老保险中央财政专项补助情况表", cnnsqzcbController.upload(request)));
		results.add(new UploadResult("基本养老保险基金收支情况决算表(大口径)", cnnsyjzdController.upload(request)));
		results.add(new UploadResult("基本养老保险基金收支情况决算表(企业)", cnnsyjzqController.upload(request)));
		results.add(new UploadResult("基本养老保险基金收入同比增减情况表", cnnsyrzjController.upload(request)));
		results.add(new UploadResult("基本养老保险基金总支出及财政到帐同比增减情况表", cnnsyzzjController.upload(request)));
		results.add(new UploadResult("年末退休人员人数情况", cnstrnmqController.upload(request)));
		results.add(new UploadResult("新退休人员人数情况", cnstrnxqController.upload(request)));
		results.add(new UploadResult("年新退休人员应发月平均养老金水平", cnstyxypController.upload(request)));
		results.add(new UploadResult("年退休人员应发实账个人账户月平均养老金水平", cnstyygpController.upload(request)));
		results.add(new UploadResult("年退休人员应发月平均养老金水平", cnstyypjController.upload(request)));
		results.add(new UploadResult("年末退休人员平均个人帐户空账储存额情况", cnstzkzqController.upload(request)));
		results.add(new UploadResult("年末退休人员平均个人帐户实账储存额情况", cnstzszqController.upload(request)));
		results.add(new UploadResult("年末参保职工人均缴费基数情况", cnszjnxxController.upload(request)));
		results.add(new UploadResult("年末参保职工人均缴费年限（含视同）情况（新人）", cnszjnxzController.upload(request)));
		results.add(new UploadResult("年末参保职工平均累计缴费工资指数情况（新人）", cnszjzsxController.upload(request)));
		results.add(new UploadResult("年末参保职工平均累计缴费工资指数情况（中人）", cnszjzszController.upload(request)));
		results.add(new UploadResult("年末参保职工人数情况（新人）", cnszrrsxController.upload(request)));
		results.add(new UploadResult("年末参保职工人数情况（中人）", cnszrrszController.upload(request)));
		results.add(new UploadResult("年末新参保职工人数情况", cnszrxcbController.upload(request)));
		results.add(new UploadResult("年末参保职工平均个人帐户空账储存额情况（新人）", cnszzkzxController.upload(request)));
		results.add(new UploadResult("年末参保职工平均个人帐户空账储存额情况（中人）", cnszzkzzController.upload(request)));
		results.add(new UploadResult("年末参保职工平均个人帐户实账储存额情况（新人）", cnszzszxController.upload(request)));
		results.add(new UploadResult("年末参保职工平均个人帐户实账储存额情况（中人）", cnszzszzController.upload(request)));
		results.add(new UploadResult("宏观决策", cwsjhgjjController.upload(request)));
		results.add(new UploadResult("劳动就业", cwsjldjyController.upload(request)));
		results.add(new UploadResult("人口数据", cwsjrksjController.upload(request)));
		results.add(new UploadResult("收入和工资", cwsjsrgzController.upload(request)));
		return results;
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
				if ("CNSTRNMQ".equals(up.getMenu_id())) {
					ExportExcel<CNSTRNMQ> ee = new ExportExcel<CNSTRNMQ>();
					CNSTRNMQ entity = new CNSTRNMQ();
					ee.batchExport(up, cnstrnmqController.list(model, entity, null), os, workbook);
				}
				if ("CNSTRNXQ".equals(up.getMenu_id())) {
					ExportExcel<CNSTRNXQ> ee = new ExportExcel<CNSTRNXQ>();
					CNSTRNXQ entity = new CNSTRNXQ();
					ee.batchExport(up, cnstrnxqController.list(model, entity, null), os, workbook);
				}
				if ("CNSTYXYP".equals(up.getMenu_id())) {
					ExportExcel<CNSTYXYP> ee = new ExportExcel<CNSTYXYP>();
					CNSTYXYP entity = new CNSTYXYP();
					ee.batchExport(up, cnstyxypController.list(model, entity, null), os, workbook);
				}
				if ("CNSTYYGP".equals(up.getMenu_id())) {
					ExportExcel<CNSTYYGP> ee = new ExportExcel<CNSTYYGP>();
					CNSTYYGP entity = new CNSTYYGP();
					ee.batchExport(up, cnstyygpController.list(model, entity, null), os, workbook);
				}
				if ("CNSTYYPJ".equals(up.getMenu_id())) {
					ExportExcel<CNSTYYPJ> ee = new ExportExcel<CNSTYYPJ>();
					CNSTYYPJ entity = new CNSTYYPJ();
					ee.batchExport(up, cnstyypjController.list(model, entity, null), os, workbook);
				}
				if ("CNSTZKZQ".equals(up.getMenu_id())) {
					ExportExcel<CNSTZKZQ> ee = new ExportExcel<CNSTZKZQ>();
					CNSTZKZQ entity = new CNSTZKZQ();
					ee.batchExport(up, cnstzkzqController.list(model, entity, null), os, workbook);
				}
				if ("CNSTZSZQ".equals(up.getMenu_id())) {
					ExportExcel<CNSTZSZQ> ee = new ExportExcel<CNSTZSZQ>();
					CNSTZSZQ entity = new CNSTZSZQ();
					ee.batchExport(up, cnstzszqController.list(model, entity, null), os, workbook);
				}
				if ("CNSZJJSQ".equals(up.getMenu_id())) {
					ExportExcel<CNSZJJSQ> ee = new ExportExcel<CNSZJJSQ>();
					CNSZJJSQ entity = new CNSZJJSQ();
					ee.batchExport(up, cnszjjsqController.list(model, entity, null), os, workbook);
				}
				if ("CNSZJNXX".equals(up.getMenu_id())) {
					ExportExcel<CNSZJNXX> ee = new ExportExcel<CNSZJNXX>();
					CNSZJNXX entity = new CNSZJNXX();
					ee.batchExport(up, cnszjnxxController.list(model, entity, null), os, workbook);
				}
				if ("CNSZJNXZ".equals(up.getMenu_id())) {
					ExportExcel<CNSZJNXZ> ee = new ExportExcel<CNSZJNXZ>();
					CNSZJNXZ entity = new CNSZJNXZ();
					ee.batchExport(up, cnszjnxzController.list(model, entity, null), os, workbook);
				}
				if ("CNSZJZSX".equals(up.getMenu_id())) {
					ExportExcel<CNSZJZSX> ee = new ExportExcel<CNSZJZSX>();
					CNSZJZSX entity = new CNSZJZSX();
					ee.batchExport(up, cnszjzsxController.list(model, entity, null), os, workbook);
				}
				if ("CNSZJZSZ".equals(up.getMenu_id())) {
					ExportExcel<CNSZJZSZ> ee = new ExportExcel<CNSZJZSZ>();
					CNSZJZSZ entity = new CNSZJZSZ();
					ee.batchExport(up, cnszjzszController.list(model, entity, null), os, workbook);
				}
				if ("CNSZRRSX".equals(up.getMenu_id())) {
					ExportExcel<CNSZRRSX> ee = new ExportExcel<CNSZRRSX>();
					CNSZRRSX entity = new CNSZRRSX();
					ee.batchExport(up, cnszrrsxController.list(model, entity, null), os, workbook);
				}
				if ("CNSZRRSZ".equals(up.getMenu_id())) {
					ExportExcel<CNSZRRSZ> ee = new ExportExcel<CNSZRRSZ>();
					CNSZRRSZ entity = new CNSZRRSZ();
					ee.batchExport(up, cnszrrszController.list(model, entity, null), os, workbook);
				}
				if ("CNSZRXCB".equals(up.getMenu_id())) {
					ExportExcel<CNSZRXCB> ee = new ExportExcel<CNSZRXCB>();
					CNSZRXCB entity = new CNSZRXCB();
					ee.batchExport(up, cnszrxcbController.list(model, entity, null), os, workbook);
				}
				if ("CNSZZKZX".equals(up.getMenu_id())) {
					ExportExcel<CNSZZKZX> ee = new ExportExcel<CNSZZKZX>();
					CNSZZKZX entity = new CNSZZKZX();
					ee.batchExport(up, cnszzkzxController.list(model, entity, null), os, workbook);
				}
				if ("CNSZZKZZ".equals(up.getMenu_id())) {
					ExportExcel<CNSZZKZZ> ee = new ExportExcel<CNSZZKZZ>();
					CNSZZKZZ entity = new CNSZZKZZ();
					ee.batchExport(up, cnszzkzzController.list(model, entity, null), os, workbook);
				}
				if ("CNSZZSZX".equals(up.getMenu_id())) {
					ExportExcel<CNSZZSZX> ee = new ExportExcel<CNSZZSZX>();
					CNSZZSZX entity = new CNSZZSZX();
					ee.batchExport(up, cnszzszxController.list(model, entity, null), os, workbook);
				}
				if ("CNSZZSZZ".equals(up.getMenu_id())) {
					ExportExcel<CNSZZSZZ> ee = new ExportExcel<CNSZZSZZ>();
					CNSZZSZZ entity = new CNSZZSZZ();
					ee.batchExport(up, cnszzszzController.list(model, entity, null), os, workbook);
				}
				if ("CWSJHGJJ".equals(up.getMenu_id())) {
					ExportExcel<CWSJHGJJ> ee = new ExportExcel<CWSJHGJJ>();
					CWSJHGJJ entity = new CWSJHGJJ();
					ee.batchExport(up, cwsjhgjjController.list(model, entity, null), os, workbook);
				}
				if ("CWSJLDJY".equals(up.getMenu_id())) {
					ExportExcel<CWSJLDJY> ee = new ExportExcel<CWSJLDJY>();
					CWSJLDJY entity = new CWSJLDJY();
					ee.batchExport(up, cwsjldjyController.list(model, entity, null), os, workbook);
				}
				if ("CWSJRKSJ".equals(up.getMenu_id())) {
					ExportExcel<CWSJRKSJ> ee = new ExportExcel<CWSJRKSJ>();
					CWSJRKSJ entity = new CWSJRKSJ();
					ee.batchExport(up, cwsjrksjController.list(model, entity, null), os, workbook);
				}
				if ("CWSJSRGZ".equals(up.getMenu_id())) {
					ExportExcel<CWSJSRGZ> ee = new ExportExcel<CWSJSRGZ>();
					CWSJSRGZ entity = new CWSJSRGZ();
					ee.batchExport(up, cwsjsrgzController.list(model, entity, null), os, workbook);
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
