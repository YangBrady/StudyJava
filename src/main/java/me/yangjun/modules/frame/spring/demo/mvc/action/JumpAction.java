package me.yangjun.modules.frame.spring.demo.mvc.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author mooejun
 * @since 2019/05/06
 */
@Controller
@RequestMapping(value = "/frame/spring/demo/mvc")
public class JumpAction {

    /**
     * 转发
     */
    @RequestMapping(value = "forward1")
    public void forward1(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("index").forward(request, response);
    }

    /**
     * 转发(提倡)
     */
    @RequestMapping(value = "forward2")
    public String forward2(HttpServletRequest request, HttpServletResponse response) {
        return "modules/frame/spring/demo/mvc/index";
    }

    /**
     * 重定向
     */
    @RequestMapping(value = "redirect1")
    public void redirect1(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect(request.getContextPath() + "/frame/spring/demo/mvc/index");
    }

    @RequestMapping(value = "redirect2")
    public String redirect2(HttpServletRequest request, HttpServletResponse response) {
        return "redirect:index";
    }

    /**
     * request中参数（parameter）和属性（Attribute）的区别：
     *
     * 不同点：
     * 来源不同：     参数（parameter）是从客户端（浏览器）中由用户提供的，若是GET方法是从URL中提供的，若是POST方法是从请求体（request body）中提供的；
     *              属性（attribute）是服务器端的组件（JSP或者Servlet）利用requst.setAttribute（）设置的
     * 操作不同：     参数（parameter）的值只能读取不能修改，读取可以使用request.getParameter()读取；
     *              属性（attribute）的值既可以读取亦可以修改，读取可以使用request.setAttribute(),设置可使用request.getAttribute()
     * 数据类型不同： 参数（parameter）不管前台传来的值语义是什么，在服务器获取时都以String类型看待，并且客户端的参数值只能是简单类型的值，不能是复杂类型，比如一个对象。
     *              属性（attribute）的值可以是任意一个Object类型。
     *
     * 共同点
     * 二者的值都被封装在request对象中。
     */
}
