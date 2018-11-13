package me.yangjun.modules.baseweb.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import me.yangjun.modules.baseweb.entity.PersonEntity;

/**
 * ServletContext传递数据
 * @author yangjun
 * @version 1.0
 * @since 2018-11-12 19:35:36
 */
@WebServlet(name = "ServletContextController", urlPatterns = { "/ServletContextController" })
public class ServletContextController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletContextController() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PersonEntity p1 = new PersonEntity("光辉", 18, "女");
		PersonEntity p2 = new PersonEntity("德玛", 20, "男");
		this.getServletConfig().getServletContext().setAttribute("p1", p1);
		this.getServletContext().setAttribute("p2", p2);
		super.service(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PersonEntity p1 = (PersonEntity) this.getServletConfig().getServletContext().getAttribute("p1");
		System.out.println(p1);
		PersonEntity p2 = (PersonEntity) this.getServletContext().getAttribute("p2");
		System.out.println(p2);
	}

}
