package com.zoc.web.act;

import java.io.OutputStream;
import java.util.Iterator;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
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

import com.zoc.common.SuperUtils;
import com.zoc.common.poi.ExportExcel;
import com.zoc.common.poi.ImportExcel;
import com.zoc.entity.act.CNSZRRSX;
import com.zoc.entity.act.UploadParam;
import com.zoc.entity.security.User;
import com.zoc.service.act.CNSZRRSXService;
import com.zoc.service.act.UploadParamService;

/**
 * @author Super
 */
@Controller
@RequestMapping(value = "CNSZRRSX")
public class CNSZRRSXController {

	private static Logger logger = LoggerFactory.getLogger(CNSZRRSXController.class);

	private static final String DEFAULT_PAGE = "act/CNSZRRSX";

	private static final String CONTROLLER_ID = "CNSZRRSX";

	@Autowired
	private CNSZRRSXService CNSZRRSXService;

	@Autowired
	private UploadParamService uploadParamService;

	User user;

	@RequestMapping(method = RequestMethod.GET)
	public String main(Model model) {
		user = SuperUtils.getSubjectUser();
		model.addAttribute("location", user.getLocation());
		model.addAttribute("year", "2011");
		return DEFAULT_PAGE;
	}

	@RequestMapping(value = "/list", method = { RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody
	List<CNSZRRSX> list(Model model) {
		CNSZRRSX entity = new CNSZRRSX();
		user = SuperUtils.getSubjectUser();
		entity.setLocation(user.getLocation());
		return CNSZRRSXService.list(entity);
	}

	@RequestMapping(value = "/save", method = { RequestMethod.POST })
	public @ResponseBody
	String save(@RequestParam("data") String data) {
		logger.debug(data);
		CNSZRRSXService.batchSave(SuperUtils.parseArray(data, CNSZRRSX.class));
		return "save success!";
	}

	@RequestMapping(value = "/upload", method = { RequestMethod.POST })
	public @ResponseBody
	String upload(MultipartHttpServletRequest request) {

		try {
			Iterator<String> it = request.getFileNames();

			UploadParam uploadParam = uploadParamService.fetchByMenuId(CONTROLLER_ID);

			while (it.hasNext()) {
				List<MultipartFile> files = request.getFiles(it.next());
				for (MultipartFile file : files) {
					ImportExcel<CNSZRRSX> in = new ImportExcel<CNSZRRSX>(CNSZRRSX.class);
					// 传入数据
					List<CNSZRRSX> lists = (List<CNSZRRSX>) in.importExcel(file.getInputStream(), uploadParam);
					// 标准模版
					List<CNSZRRSX> templates = (List<CNSZRRSX>) in.importExcel(
							Files.findFileAsStream(uploadParam.getTemplate_path() + uploadParam.getWork_book()),
							uploadParam);
					int paramColSize = uploadParam.getRow_end() - uploadParam.getRow_start() + 1;
					// 总行数校验
					if (lists.size() != paramColSize || lists.size() != templates.size()) {
						return "数据格式文件有误，请重新核对";
					}
					// 逐行校验
					for (int i = 0; i < lists.size(); i++) {
						if (!StringUtils.equals(lists.get(i).getC1(), templates.get(i).getC1())) {
							return "模版" + templates.get(i).getC1() + " 有误差，请核对";
						} else {
							CNSZRRSX entity = lists.get(i);
							entity.setLocation(SuperUtils.getSubjectUser().getLocation());
							entity.setYear(in.getDataYear(file.getInputStream(), 4, 6));
							entity.setC0(i + 1);
						}
					}
					//service统一控制事务
					CNSZRRSXService.upload(lists);

				}
			}

			return "数据导入成功";
		} catch (Exception e) {
			e.printStackTrace();
			return "数据导入失败";
		}
	}

	@RequestMapping(value = "/download", method = { RequestMethod.GET })
	public @ResponseBody
	void download(HttpServletResponse response) {
		OutputStream os;
		try {
			os = response.getOutputStream();
			response.reset();
			response.setHeader("Content-disposition", "attachment; filename=Output.xls");
			response.setContentType("application/msexcel");

			CNSZRRSX entity = new CNSZRRSX();
			user = SuperUtils.getSubjectUser();
			entity.setLocation(user.getLocation());

			List<CNSZRRSX> datas = CNSZRRSXService.list(entity);

			UploadParam uploadParam = uploadParamService.fetchByMenuId(CONTROLLER_ID);

			ExportExcel<CNSZRRSX> ee = new ExportExcel<CNSZRRSX>();
			ee.exportExcel(uploadParam, datas, os);
			os.flush();
			os.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		}

	}

}
