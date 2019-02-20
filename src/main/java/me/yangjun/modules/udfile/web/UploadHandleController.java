package me.yangjun.modules.udfile.web;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.FileUploadBase;
import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.apache.tomcat.util.http.fileupload.ProgressListener;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.apache.tomcat.util.http.fileupload.servlet.ServletRequestContext;

import me.yangjun.common.web.BaseController;

/**
 * @ClassName: UploadHandleController
 * @Description: 文件上传，Servlet 3.0以下需要添加commons-fileupload.jar和commons-io.jar
 * @author: yangjun
 * @date: 2018-06-12
 */
@WebServlet("/servlet/UploadHandleController")
public class UploadHandleController extends BaseController {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String savePath = this.getServletContext().getRealPath("/WEB-INF/upload");
		File savePathFile = new File(savePath);
		if (!savePathFile.exists() && !savePathFile.isDirectory()) {
			savePathFile.mkdir();
		}

		String message = "";
		try {
			// 创建一个DiskFileItemFactory工厂
			DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
			// 创建一个文件上传解析器
			ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);
			// 监听文件上传进度
			servletFileUpload.setProgressListener(new ProgressListener() {

				@Override
				public void update(long pBytesRead, long pContentLength, int arg2) {
					System.out.println("文件大小为：" + pContentLength + ",当前已处理：" + pBytesRead);
				}
			});
			servletFileUpload.setHeaderEncoding("utf-8");
			// 设置上传单个文件的大小的最大值10MB
			servletFileUpload.setFileSizeMax(10 * 1024 * 1024);
			// 设置上传文件总量最大为15MB
			servletFileUpload.setSizeMax(15 * 1024 * 1024);
			// 判断提交上来的数据是否是上传表单的数据
			ServletRequestContext servletRequestContext = new ServletRequestContext(request);
			if (!ServletFileUpload.isMultipartContent(servletRequestContext)) {
				// TODO 按照传统方式获取数据
				return;
			}
			// 使用ServletFileUpload解析器解析上传数据，解析结果返回的是一个List<FileItem>集合，每一个FileItem对应一个Form表单的输入项
			List<FileItem> list = servletFileUpload.parseRequest(servletRequestContext);
			for (FileItem item : list) {
				// 如果fileitem中封装的是普通输入项的数据
				if (item.isFormField()) {
					String name = item.getFieldName();
					String value = item.getString("UTF-8");
					System.out.println(name + "=" + value);
				} else {
					// 如果fileitem中封装的是上传文件
					String filename = item.getName();
					System.out.println(filename);
					if (filename == null || filename.trim().equals("")) {
						continue;
					}
					// 有些浏览器提交上来的文件名是带有路径的，如： c:\a\b\1.txt，而有些只是单纯的文件名，如：1.txt
					filename = filename.substring(filename.lastIndexOf(File.separator) + 1);
					// 得到上传文件的扩展名来限制上传格式
					String fileExtName = filename.substring(filename.lastIndexOf(".") + 1);
					System.out.println("上传的文件的扩展名是：" + fileExtName);
					InputStream in = item.getInputStream();
					// 得到文件保存的名称
					String saveFilename = genFileName(filename);
					// 得到文件的保存目录
					String realSavePath = genPath(saveFilename, savePath);
					System.out.println("文件保存路径=" + realSavePath);
					FileOutputStream out = new FileOutputStream(realSavePath + File.separator + filename);
					byte buffer[] = new byte[1024];
					int len = 0;
					// 循环将输入流读入到缓冲区当中，(len=in.read(buffer))>0就表示in里面还有数据
					while ((len = in.read(buffer)) > 0) {
						out.write(buffer, 0, len);
					}
					in.close();
					out.close();
					// 删除临时文件
					item.delete();
					message = "文件上传成功！";
				}
			}
		} catch (FileUploadBase.FileSizeLimitExceededException e) {
			e.printStackTrace();
			request.setAttribute("message", "单个文件超出最大值！！！");
			request.getRequestDispatcher("/message.jsp").forward(request, response);
			return;
		} catch (FileUploadBase.SizeLimitExceededException e) {
			e.printStackTrace();
			request.setAttribute("message", "上传文件的总的大小超出限制的最大值！！！");
			request.getRequestDispatcher("/message.jsp").forward(request, response);
			return;
		} catch (FileUploadException e) {
			e.printStackTrace();
		}
		request.setAttribute("message", message);
		request.getRequestDispatcher("/message.jsp").forward(request, response);
	}

	/**
	 * @Method: makeFileName
	 * @Description: 生成上传文件的文件名，文件名以：uuid+"_"+文件的原始名称
	 * @param filename
	 *            文件的原始名称
	 * @return uuid+"_"+文件的原始名称
	 */
	private String genFileName(String filename) {
		// 为防止文件覆盖的现象发生，要为上传文件产生一个唯一的文件名
		return UUID.randomUUID().toString() + "_" + filename;
	}

	/**
	 * @Method: makePath
	 * @Description: 为防止一个目录下面出现太多文件，要使用hash算法打散存储
	 * @param filename
	 *            文件名，要根据文件名生成存储目录
	 * @param savePath
	 *            文件存储路径
	 * @return 新的存储目录
	 */
	private String genPath(String filename, String savePath) {
		// 得到文件名的hashCode的值，得到的就是filename这个字符串对象在内存中的地址
		int hashcode = filename.hashCode();
		int dir1 = hashcode & 0xf; // 0--15
		int dir2 = (hashcode & 0xf0) >> 4; // 0-15
		String dir = savePath + File.separator + dir1 + File.separator + dir2;
		File file = new File(dir);
		if (!file.exists()) {
			file.mkdirs();
		}
		return dir;
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
