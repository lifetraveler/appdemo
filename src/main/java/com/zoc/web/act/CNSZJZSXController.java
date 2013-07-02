package com.zoc.web.act;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.zoc.common.SuperUtils;
import com.zoc.entity.act.CNSZJZSX;
import com.zoc.service.act.CNSZJZSXService;

/**
 * @author Super
 */
@Controller
@RequestMapping(value = "CNSZJZSX")
public class CNSZJZSXController extends ActController<CNSZJZSX> {

	private static Logger logger = LoggerFactory.getLogger(CNSZJZSXController.class);

	private static final String DEFAULT_PAGE = "act/CN";

	private static final String CONTROLLER_ID = "CNSZJZSX";

	@Autowired
	private CNSZJZSXService CNSZJZSXService;

	@RequestMapping(method = RequestMethod.GET)
	public String main(Model model) {
		model.addAttribute("LOCATION", SuperUtils.getSubjectUser().getLocation());
		model.addAttribute("MENUID", "CNSZJZSX");
		model.addAttribute("UNIT", 0);
		model.addAttribute("TITLE", "年末参保职工平均累计缴费工资指数情况（新人）");
		return DEFAULT_PAGE;
	}

	@RequestMapping(value = "/list", method = { RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody
	List<CNSZJZSX> list(Model model, CNSZJZSX entity) {
		entity.setLocation(SuperUtils.getSubjectUser().getLocation());
		return CNSZJZSXService.list(entity);
	}

	@RequestMapping(value = "/save", method = { RequestMethod.POST })
	public @ResponseBody
	String save(@RequestParam("data") String data) {
		logger.debug(data);
		try{
		CNSZJZSXService.batchSave(SuperUtils.parseArray(data, CNSZJZSX.class));
		return "更新成功";
		}catch(Exception e){
			e.printStackTrace();
			return "更新失败";
		}
	}

	@RequestMapping(value = "/upload", method = { RequestMethod.POST })
	public @ResponseBody
	String upload(MultipartHttpServletRequest request) {
		return abstractUpload(request, CONTROLLER_ID, CNSZJZSX.class, CNSZJZSXService);

	}

	@RequestMapping(value = "/download", method = { RequestMethod.GET })
	public @ResponseBody
	void download(HttpServletResponse response, CNSZJZSX entity) {
		entity.setLocation(SuperUtils.getSubjectUser().getLocation());
		abstractDownload(response, CNSZJZSXService.list(entity), CONTROLLER_ID);
	}

}
