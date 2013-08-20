package com.zoc.web.act;

import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.nutz.lang.Files;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.zoc.common.SuperUtils;
import com.zoc.common.poi.ExportExcel;
import com.zoc.common.poi.ImportExcel;
import com.zoc.common.service.SuperService;
import com.zoc.entity.act.BaseActEntity;
import com.zoc.entity.act.CNSZRRSZ;
import com.zoc.entity.act.UploadParam;
import com.zoc.service.act.UploadParamService;

public abstract class ActController<T extends BaseActEntity> {

	@Autowired
	private UploadParamService uploadParamService;
	
	public  T abstractList(T entity,String data,Class<T> classzz){
		if (!SuperUtils.isNullOrEmpty(data)) {
			entity = SuperUtils.parseObject(data, classzz);
		}
		if (SuperUtils.isNullOrEmpty(entity.getLocationSection())
				&& !SuperUtils.GBL_LOCATION.equals(SuperUtils.getSubjectUser().getLocation())) {
			entity.setLocation(SuperUtils.getSubjectUser().getLocation());
		}
		return entity;
		
	}

	public String abstractUpload(MultipartHttpServletRequest request, String controller_id, Class<T> classzz,
			SuperService<T, Long> superService) {

		try {
			ImportExcel<T> in = new ImportExcel<T>(classzz);

			Iterator<String> it = request.getFileNames();

			UploadParam uploadParam = uploadParamService.fetchByMenuId(controller_id);

			List<T> lists = new ArrayList<T>();

			// 标准模版
			List<T> templates = (List<T>) in.importExcel(
					Files.findFileAsStream(uploadParam.getTemplate_path() + uploadParam.getWork_book()), uploadParam);

			while (it.hasNext()) {
				List<MultipartFile> files = request.getFiles(it.next());
				for (MultipartFile file : files) {

					// 传入数据
					lists.addAll(in.importExcel(file.getInputStream(), uploadParam));

					if (uploadParam.getRow_check().equals("C")) {
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
								T entity = lists.get(i);
								entity.setLocation(SuperUtils.getSubjectUser().getLocation());
								entity.setYear(in.getDataYear(file.getInputStream(), 4, 6));
								entity.setC0(i + 1);
							}
						}
					}
				}
			}
			for (T t : lists) {
				t.setYear(Integer.valueOf(request.getParameter("year")));
				if(SuperUtils.isNullOrEmpty(t.getLocation())){
					t.setLocation(SuperUtils.getSubjectUser().getLocation());
				}
			}
			superService.upload(lists);
			return "数据导入成功";
		} catch (Exception e) {
			e.printStackTrace();
			return "数据导入失败";
		}
	}

	public void abstractDownload(HttpServletResponse response, List<T> datas, String controller_id) {
		OutputStream os;
		UploadParam uploadParam = uploadParamService.fetchByMenuId(controller_id);
		try {
			os = response.getOutputStream();
			response.reset();
			response.setHeader("Content-disposition", "attachment; filename=Output.xls");
			response.setContentType("application/msexcel");

			ExportExcel<T> ee = new ExportExcel<T>();
			ee.exportExcel(uploadParam, datas, os);
			os.flush();
			os.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
