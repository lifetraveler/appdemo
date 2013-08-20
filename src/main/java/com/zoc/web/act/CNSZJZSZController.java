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
import com.zoc.entity.act.CNNSDDYQ;
import com.zoc.entity.act.CNSZJZSZ;
import com.zoc.service.act.CNSZJZSZService;

/**
 * @author Super
 */
@Controller
@RequestMapping(value = "CNSZJZSZ")
public class CNSZJZSZController extends ActController<CNSZJZSZ> {

	private static Logger logger = LoggerFactory.getLogger(CNSZJZSZController.class);

	private static final String DEFAULT_PAGE = "act/ACT";

	private static final String CONTROLLER_ID = "CNSZJZSZ";

	@Autowired
	private CNSZJZSZService CNSZJZSZService;

	@RequestMapping(method = RequestMethod.GET)
	public String main(Model model) {
		model.addAttribute("LOCATION", SuperUtils.getSubjectUser().getLocation());
		model.addAttribute("MENUID", "CNSZJZSZ");
		model.addAttribute("UNIT", 0);
		model.addAttribute("TITLE", "年末参保职工平均累计缴费工资指数情况（中人）");
		return DEFAULT_PAGE;
	}

	@RequestMapping(value = "/list", method = { RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody
	List<CNSZJZSZ> list(Model model, CNSZJZSZ entity, @RequestParam(value = "key", required = false) String key) {
		return CNSZJZSZService.list(abstractList(entity, key, CNSZJZSZ.class));
	}

	@RequestMapping(value = "/save", method = { RequestMethod.POST })
	public @ResponseBody
	String save(@RequestParam("data") String data) {
		logger.debug(data);
		try{
		CNSZJZSZService.batchSave(SuperUtils.parseArray(data, CNSZJZSZ.class));
		return "更新成功";
		}catch(Exception e){
			e.printStackTrace();
			return "更新失败";
		}
	}

	@RequestMapping(value = "/upload", method = { RequestMethod.POST })
	public @ResponseBody
	String upload(MultipartHttpServletRequest request) {
		return abstractUpload(request, CONTROLLER_ID, CNSZJZSZ.class, CNSZJZSZService);

	}

	@RequestMapping(value = "/download", method = { RequestMethod.GET })
	public @ResponseBody
	void download(HttpServletResponse response, CNSZJZSZ entity) {
		abstractDownload(response, CNSZJZSZService.list(abstractList(entity, null, CNSZJZSZ.class)), CONTROLLER_ID);
	}

}
