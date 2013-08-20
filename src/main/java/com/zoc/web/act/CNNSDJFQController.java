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
import com.zoc.entity.act.CNNSDJFQ;
import com.zoc.entity.act.CNNSDJFQ;
import com.zoc.service.act.CNNSDJFQService;

/**
 * @author Super
 */
@Controller
@RequestMapping(value = "CNNSDJFQ")
public class CNNSDJFQController extends ActController<CNNSDJFQ> {

	private static Logger logger = LoggerFactory.getLogger(CNNSDJFQController.class);

	private static final String DEFAULT_PAGE = "act/ACT";

	private static final String CONTROLLER_ID = "CNNSDJFQ";

	@Autowired
	private CNNSDJFQService CNNSDJFQService;

	@RequestMapping(method = RequestMethod.GET)
	public String main(Model model) {
		model.addAttribute("location", SuperUtils.getSubjectUser().getLocation());
		model.addAttribute("year", 2011);
		model.addAttribute("MENUID", "CNNSDJFQ");
		model.addAttribute("UNIT", 0);
		model.addAttribute("TITLE", "分地区企业离退休人员养老金发放和社会化管理情况表");
		return DEFAULT_PAGE;
	}

	@RequestMapping(value = "/list", method = { RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody
	List<CNNSDJFQ> list(Model model, CNNSDJFQ entity, @RequestParam(value = "key", required = false) String key) {
		return CNNSDJFQService.list(abstractList(entity, key, CNNSDJFQ.class));
	}

	@RequestMapping(value = "/save", method = { RequestMethod.POST })
	public @ResponseBody
	String save(@RequestParam("data") String data) {
		logger.debug(data);
		CNNSDJFQService.batchSave(SuperUtils.parseArray(data, CNNSDJFQ.class));
		return "save success!";
	}

	@RequestMapping(value = "/upload", method = { RequestMethod.POST })
	public @ResponseBody
	String upload(MultipartHttpServletRequest request) {
		return abstractUpload(request, CONTROLLER_ID, CNNSDJFQ.class, CNNSDJFQService);

	}

	@RequestMapping(value = "/download", method = { RequestMethod.GET })
	public @ResponseBody
	void download(HttpServletResponse response, CNNSDJFQ entity) {
		abstractDownload(response, CNNSDJFQService.list(abstractList(entity, null, CNNSDJFQ.class)), CONTROLLER_ID);
	}

}
