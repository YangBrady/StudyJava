package me.yangjun.modules.frame.spring.demo.mvc.action;

import me.yangjun.modules.frame.spring.demo.mvc.dto.Department;
import me.yangjun.modules.frame.spring.demo.mvc.dto.Food;
import me.yangjun.modules.frame.spring.demo.mvc.dto.User;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.beans.PropertyEditorSupport;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author mooejun
 * @since 2019-02-20
 */

@Controller
@RequestMapping(value = "/frame/spring/demo/mvc")
public class HelloAction {

    @RequestMapping(value = "demo001")
    public ModelAndView demo001(ModelAndView modelAndView) {
        modelAndView.setViewName("modules/frame/spring/demo/mvc/hello");
        return modelAndView;
    }

    @RequestMapping(value = "demo002")
    public String demo002() {
        return "modules/frame/spring/demo/mvc/ok";
    }

    /**
     * 只允许GET请求
     */
    @RequestMapping(value = "demo003", method = RequestMethod.GET)
    public String demo003() {
        return "modules/frame/spring/demo/mvc/hello";
    }

    /**
     * 只允许POST请求
     */
    @RequestMapping(value = "demo004", method = RequestMethod.POST)
    public String demo004() {
        return "modules/frame/spring/demo/mvc/hello";
    }

    /**
     * 传统web参数
     */
    @RequestMapping(value = "demo005")
    public String demo005(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String xm = request.getParameter("xm");
        String nl = request.getParameter("nl");
        System.out.println("xm=" + xm);
        System.out.println("nl=" + nl);
        //绑定到session域对象中
        request.getSession().setAttribute("username", xm);
        request.getSession().setAttribute("salary", nl);

        // 重定向/jsp/success.jsp页面
        // response.sendRedirect(request.getContextPath() + "/demo001");

        // 重定向
        // return "redirect:modules/frame/spring/demo/mvc/hello";

        // 转发页面
        // request.getRequestDispatcher("demo002").forward(request, response);

        // 转发(提倡)
        return "modules/frame/spring/demo/mvc/hello";
    }

    /**
     * 接收JavaBean
     */
    @RequestMapping(value = "demo006")
    public String demo006() {
        return "modules/frame/spring/demo/mvc/demo006";
    }

    @RequestMapping(value = "demo006_resp")
    public String demo006_resp(Model model, User user) {
        System.out.println(user);
        model.addAttribute("message", user.getUsername());
        return "modules/frame/spring/demo/mvc/index";
    }


    @RequestMapping(value = "demo006_01")
    public String demo006_01() {
        return "modules/frame/spring/demo/mvc/demo006_01";
    }

    @RequestMapping(value = "demo006_01_resp/{id}")
    public String demo006_01_resp(Model model, User user, @PathVariable("id") String id) {
        System.out.println("id=" + id);
        System.out.println(user);
        model.addAttribute("message", user.getUsername());
        return "modules/frame/spring/demo/mvc/index";
    }

    /**
     * 接收数组
     */
    @RequestMapping(value = "demo007")
    public String demo007_req() {
        return "modules/frame/spring/demo/mvc/demo007";
    }

    @RequestMapping(value = "demo007_resp")
    public String demo007_resp(Model model, int[] hobby) {
        for (int i : hobby) {
            System.out.println(i);
        }
        model.addAttribute("message", "demo007列出成功");
        return "modules/frame/spring/demo/mvc/index";
    }

    /**
     * 接收List<JavaBean>
     */
    @RequestMapping(value = "demo008")
    public String demo008_req() {
        return "modules/frame/spring/demo/mvc/demo008";
    }

    @RequestMapping(value = "demo008_resp")
    public String demo008_resp(Model model, Department department) {
        for (User user : department.getUsers()) {
            System.out.println(user);
        }
        model.addAttribute("message", "demo008列出成功");
        return "modules/frame/spring/demo/mvc/index";
    }

    /**
     * 收集多个模型
     */
    @RequestMapping(value = "demo010")
    public String demo010(Model model) {
        User user = new User();
        user.setId("1");
        user.setUsername("哈哈");
        Food food = new Food();
        food.setUsername("鱼");
        food.setSeason("无");
        model.addAttribute("user", user);
        model.addAttribute("food", food);
        return "modules/frame/spring/demo/mvc/demo008_resp";
    }

    /**
     * 参数绑定
     */
    @RequestMapping(value = "demo011")
    public String demo011(Model model, @RequestParam(value = "id", required = false) String id,
                          @RequestParam(value = "name") String name,
                          @RequestParam(value = "sex", required = false) String sex) {
        System.out.println("id=" + id + ",name=" + name + ",sex=" + sex);
        model.addAttribute("message", name + "，你好！");
        return "modules/frame/spring/demo/mvc/index";
    }

    /**
     * ModelAttribute注解
     * 绑定请求参数到命令对象
     * 用于将多个请求参数绑定到一个命令对象，从而简化绑定流程，而且自动暴露为模型数据用于视图页面展示时使用；
     */
    @RequestMapping(value = "modelAttribute/demo001")
    public String modelAttributeDemo001(Model model, @ModelAttribute(value = "user") User user) {
        System.out.println(user);
        model.addAttribute("message", "执行成功");
        return "modules/frame/spring/demo/mvc/index";
    }

    /**
     * ModelAttribute注解
     * 暴露表单引用对象为模型数据
     * 为表单准备要展示的表单引用对象，如注册时需要选择的所在城市等，而且在执行功能处理方法（@RequestMapping注解的方法）之前，自动添加到模型对象中
     */
    @ModelAttribute(value = "user")
    public User modelAttributeDemo002_resp() {
        User user = new User("1", "哈哈");
        System.out.println(user);
        return user;
    }

    @RequestMapping(value = "modelAttribute/demo002")
    public String modelAttributeDemo002() {
        return "modules/frame/spring/demo/mvc/modelAttributeDemo002";
    }

    /**
     * RequestBody 注解
     * 用postman传入Content-Type为application/xml或者application/json的数据
     */
    @RequestMapping("requestBody/demo001")
    @ResponseBody
    public String requestBodyDemo001(@RequestBody String jsonStr) {
        return jsonStr;
    }

    @RequestMapping("requestBody/demo002")
    @ResponseBody
    public String requestBodyDemo002(@RequestBody User user) {
        return user.toString();
    }

    /**
     * ResponseBody 注解
     * 用postman传入Content-Type为application/xml或者application/json的数据
     */
    @RequestMapping("responseBody/demo001")
    @ResponseBody
    public User responseBodyDemo001() {
        User user = new User("1", "哈哈");
        System.out.println(user);
        return user;
    }

    @RequestMapping("responseBody/demo002")
    @ResponseBody
    public User responseBodyDemo002(@RequestBody User user) {
        System.out.println(user);
        return user;
    }

    /**
     * 字符串转日期
     */
    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        // Date 类型转换
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        CustomDateEditor dateEditor = new CustomDateEditor(df, true);
        binder.registerCustomEditor(Date.class, dateEditor);
    }

    @RequestMapping("str2date/demo001")
    public String str2dateDemo001() {
        return "modules/frame/spring/demo/mvc/str2date";
    }

    @RequestMapping("str2date/demo001_resp")
    public String str2dateDemo001_resp(Food food) {
        System.out.println(food);
        return "modules/frame/spring/demo/mvc/index";
    }

    /**
     * 文件上传
     * 需要common-io和common-fileupload支持
     * 需要在SpringMVC配置文件配置上传文件拦截器
     */
    @RequestMapping("upload/demo001")
    public String uploadDemo001() {
        return "modules/frame/spring/demo/mvc/upload_demo001";
    }
    @RequestMapping(value = "upload/demo001_resp", method = RequestMethod.POST)
    public String uploadDemo001_resp(Model model, HttpServletRequest req) throws Exception {
        MultipartHttpServletRequest mreq = (MultipartHttpServletRequest) req;
        MultipartFile mfile = mreq.getFile("file");
        String fileName = mfile.getOriginalFilename();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        File file = new File(req.getSession().getServletContext().getRealPath("/") +
                "upload/" + sdf.format(new Date()) + fileName);
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(mfile.getBytes());
        fos.flush();
        fos.close();

        model.addAttribute("message", "文件路径" + file);
        return "modules/frame/spring/demo/mvc/index";
    }

    /**
     * 异常处理
     */
    @ExceptionHandler
    public ModelAndView exceptionHandler(Exception e) {
        ModelAndView modelAndView = new ModelAndView("modules/frame/spring/demo/mvc/error");
        modelAndView.addObject("exception", e);
        System.out.println("in testExceptionHandler");
        return modelAndView;
    }
    @RequestMapping("errorTest/demo001")
    public String errorTestDemo001() {
        System.out.println(1/0);
        return "modules/frame/spring/demo/mvc/index";
    }

}
