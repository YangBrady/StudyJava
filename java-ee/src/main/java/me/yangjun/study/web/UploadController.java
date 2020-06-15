package me.yangjun.study.web;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import me.yangjun.study.common.BaseController;
import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.apache.tomcat.util.http.fileupload.servlet.ServletRequestContext;

@WebServlet("/servlet/study/UploadController")
public class UploadController extends BaseController {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");

		String message = "文件上传失败";

		DiskFileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload servletFileUpload = new ServletFileUpload(factory);
		servletFileUpload.setFileSizeMax(10 * 1024 * 1024); // 10M
		ServletRequestContext servletRequestContext = new ServletRequestContext(req);
		try {
			List<FileItem> fileItems = servletFileUpload.parseRequest(servletRequestContext);
			for (FileItem fileItem : fileItems) {
				if (!fileItem.isFormField()) {
					String fileName = fileItem.getName();
					String uploadFilePath = this.getServletContext().getRealPath("/WEB-INF/upload");
					File file = new File(uploadFilePath + fileName);
					fileItem.write(file);
				}
			}
			message = "文件上传成功";
		} catch (Exception e) {
			e.printStackTrace();
		}
		req.setAttribute("message", message);
		req.getRequestDispatcher("/message.jsp").forward(req, resp);
	}
}
