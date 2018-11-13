package me.yangjun.modules.baseweb.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ThreadSafetyController")
public class ThreadSafetyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	int i = 0;

	public ThreadSafetyController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		i++;
		try {
			Thread.sleep(4 * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		response.getWriter().write(i + "");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
