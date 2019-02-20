package me.yangjun.modules.baseweb.web;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ServletContextReadController")
public class ServletContextReadController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletContextReadController() {
		super();
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		InputStream is = this.getServletContext().getResourceAsStream("/WEB-INF/classes/test/test.properties");
		//InputStream is = this.getServletContext().getResourceAsStream("/test.properties");
		Properties properties = new Properties();
		properties.load(is);
		String productName = properties.getProperty("productName");
		String copyrightYear = properties.getProperty("copyrightYear");
		String version = properties.getProperty("version");
		System.out.println("productName=" + productName + " ,copyrightYear=" + copyrightYear + ", version=" + version);
		super.service(request, response);
	}

}
