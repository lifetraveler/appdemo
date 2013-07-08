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
import com.zoc.entity.act.CNSZRRSZ;
import com.zoc.service.act.CNSZRRSZService;

/**
 * @author Super
 */
@Controller
@RequestMapping(value = "CNSZRRSZ")
public class CNSZRRSZController extends ActController<CNSZRRSZ> {

	private static Logger logger = LoggerFactory.getLogger(CNSZRRSZController.class);

	private static final String DEFAULT_PAGE = "act/CN";

	private static final String CONTROLLER_ID = "CNSZRRSZ";

	@Autowired
	private CNSZRRSZService CNSZRRSZService;

	@RequestMapping(method = RequestMethod.GET)
	public String main(Model model) {
		model.addAttribute("LOCATION", SuperUtils.getSubjectUser().getLocation());
		model.addAttribute("MENUID", "CNSZRRSZ");
		model.addAttribute("UNIT", 0);
		model.addAttribute("TITLE", "年末参保职工人数情况（中人）");
		return DEFAULT_PAGE;
	}

	@RequestMapping(value = "/list", method = { RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody
	List<CNSZRRSZ> list(Model model, CNSZRRSZ entity, @RequestParam(value = "key", required = false) String key) {
		if (!SuperUtils.isNullOrEmpty(key)) {
			entity = SuperUtils.parseObject(key, CNSZRRSZ.class);
		}
		if (SuperUtils.isNullOrEmpty(entity.getLocationSection())
				&& !SuperUtils.GBL_LOCATION.equals(SuperUtils.getSubjectUser().getLocation())) {
			entity.setLocation(SuperUtils.getSubjectUser().getLocation());
		}
		return CNSZRRSZService.list(entity);
	}

	@RequestMapping(value = "/save", method = { RequestMethod.POST })
	public @ResponseBody
	String save(@RequestParam("data") String data) {
		logger.debug(data);
		try {
			CNSZRRSZService.batchSave(SuperUtils.parseArray(data, CNSZRRSZ.class));
			return "更新成功";
		} catch (Exception e) {
			e.printStackTrace();
			return "更新失败";
		}
	}

	@RequestMapping(value = "/upload", method = { RequestMethod.POST })
	public @ResponseBody
	String upload(MultipartHttpServletRequest request) {
		return abstractUpload(request, CONTROLLER_ID, CNSZRRSZ.class, CNSZRRSZService);

	}

	@RequestMapping(value = "/download", method = { RequestMethod.GET })
	public @ResponseBody
	void download(HttpServletResponse response, CNSZRRSZ entity) {
		entity.setLocation(SuperUtils.getSubjectUser().getLocation());
		abstractDownload(response, CNSZRRSZService.list(entity), CONTROLLER_ID);
	}

}
