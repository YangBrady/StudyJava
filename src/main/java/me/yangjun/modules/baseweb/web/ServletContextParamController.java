package me.yangjun.modules.baseweb.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ServletContextParamController")
public class ServletContextParamController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletContextParamController() {
		super();
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println(this.getServletConfig().getServletContext().getInitParameter("app_name"));
		System.out.println(this.getServletContext().getInitParameter("app_name"));
		super.service(request, response);
	}

}
