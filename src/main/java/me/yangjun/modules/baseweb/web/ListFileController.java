package me.yangjun.modules.baseweb.web;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import me.yangjun.common.web.BaseController;

@WebServlet("/servlet/study/ListFileController")
public class ListFileController extends BaseController {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 获取上传目录
		String uploadFilePath = this.getServletContext().getRealPath("/WEB-INF/upload");
		// 存储文件名
		Map<String, String> fileNameMap = new HashMap<String, String>();
		listFile(new File(uploadFilePath), fileNameMap);
	}

	private void listFile(File file, Map<String, String> fileNameMap) {

	}
}
