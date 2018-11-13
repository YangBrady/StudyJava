package me.yangjun.modules.baseweb.web;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import me.yangjun.common.web.BaseController;

@WebServlet("/servlet/study/DownloadController")
public class DownloadController extends BaseController {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("text/html;charset=utf-8");

		String dealType = req.getParameter("dealType");
		if ("show".equals(dealType)) {
			String fileName = "/Users/yangjun/Documents/temp/rBCU0TMwbcg.jpg";
			File file = new File(fileName);
			InputStream is = new FileInputStream(file);
			OutputStream os = resp.getOutputStream();
			byte[] tmp = new byte[1024 * 5];
			int endFlag = 0;
			while ((endFlag = is.read(tmp)) != -1) {
				os.write(tmp, 0, endFlag);
			}
			is.close();
			os.close();
		} else {
		}
	}
}
