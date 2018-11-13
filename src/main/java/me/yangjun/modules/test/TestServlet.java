package me.yangjun.modules.test;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
		urlPatterns = { "/TestServlet" }, 
		initParams = { 
				@WebInitParam(name = "prodType", value = "wifi", description = "产品类型")
		})
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public TestServlet() {
		super();
	}

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		super.service(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String prodType = this.getServletConfig().getInitParameter("prodType");
		String prodType2 = this.getInitParameter("prodType");
		response.getWriter().write("Served at: " + request.getContextPath());
		response.getWriter().write("\n");
		response.getWriter().write("prodType = " + prodType);
		response.getWriter().write("\n");
		response.getWriter().write("prodType2 = " + prodType2);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
