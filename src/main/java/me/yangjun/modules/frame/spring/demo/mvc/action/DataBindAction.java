package me.yangjun.modules.frame.spring.demo.mvc.action;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import me.yangjun.modules.frame.spring.demo.mvc.dto.Department;
import me.yangjun.modules.frame.spring.demo.mvc.dto.Food;
import me.yangjun.modules.frame.spring.demo.mvc.dto.User;

/**
 * @author mooejun
 * @since 2019-02-20
 */

@Controller
@RequestMapping(value = "/frame/spring/demo/mvc")
public class DataBindAction {

    /**
     * 测试页
     */
    @RequestMapping(value = "testPage")
    public String testPage() {
        return "modules/frame/spring/demo/mvc/testPage";
    }

    /**
     * 只允许GET请求
     */
    @RequestMapping(value = "justGet", method = RequestMethod.GET)
    public String justGet() {
        return "modules/frame/spring/demo/mvc/ok";
    }

    /**
     * 只允许POST请求
     */
    @RequestMapping(value = "justPost", method = RequestMethod.POST)
    public String justPost() {
        return "modules/frame/spring/demo/mvc/ok";
    }

    /**
     * 消息页
     */
    @RequestMapping(value = "index")
    public ModelAndView index(ModelAndView modelAndView) {
        modelAndView.setViewName("modules/frame/spring/demo/mvc/index");
        // modelAndView.addObject("message", "hello");
        return modelAndView;
    }

    /**
     * 接收JavaBean
     */
    @RequestMapping(value = "receiveByJavaBean")
    public String receiveByJavaBean(Model model, User user) {
        model.addAttribute("message", user);
        return "modules/frame/spring/demo/mvc/index";
    }

    /**
     * PathVariable注解
     * 绑定URL占位符到入参
     */
    @RequestMapping(value = "receiveUrlParam/{id}")
    public String receiveUrlParam(Model model, @PathVariable("id") String id) {
        model.addAttribute("message", id);
        return "modules/frame/spring/demo/mvc/index";
    }

    /**
     * 接收数组
     */
    @RequestMapping(value = "receiveArray")
    public String receiveArray(Model model, int[] hobby) {
        for (int i : hobby) {
            System.out.println(i);
        }
        model.addAttribute("message", "数组列出成功");
        return "modules/frame/spring/demo/mvc/index";
    }

    /**
     * 接收List<JavaBean>
     */
    @RequestMapping(value = "receiveList")
    public String receiveList(Model model, Department department) {
        for (User user : department.getUsers()) {
            System.out.println(user);
        }
        model.addAttribute("message", "List列出成功");
        return "modules/frame/spring/demo/mvc/index";
    }

    /**
     * RequestParam注解
     * 参数绑定
     */
    @RequestMapping(value = "requestParam")
    public String requestParam(Model model, @RequestParam(value = "name") String name,
                               @RequestParam(value = "sex", required = false) String sex) {
        model.addAttribute("message", name);
        return "modules/frame/spring/demo/mvc/index";
    }

    /**
     * ModelAttribute注解
     * 用法一：绑定请求参数到命令对象
     * 用于将多个请求参数绑定到一个命令对象，从而简化绑定流程，而且自动暴露为模型数据用于视图页面展示时使用；
     */
    @RequestMapping(value = "modelAttributeAtParam")
    public String modelAttributeAtParam(Model model, @ModelAttribute(value = "user") User user) {
        model.addAttribute("message", user);
        return "modules/frame/spring/demo/mvc/index";
    }

    /**
     * ModelAttribute注解
     * 用法二：暴露表单引用对象为模型数据
     * 为表单准备要展示的表单引用对象，如注册时需要选择的所在城市等，而且在每个@RequestMapping注解的方法之前，自动添加到模型对象中
     */
    @ModelAttribute(value = "user110")
    public User modelAttributeUser() {
        User user = new User("110", "哈哈110");
        System.out.println(user);
        return user;
    }

    @RequestMapping(value = "modelAttributeAtFunction")
    public String modelAttributeAtFunction(Model model) {
        model.addAttribute("message", model.asMap().get("user110"));
        return "modules/frame/spring/demo/mvc/index";
    }

    /**
     * RequestBody注解
     * 该注解用于读取Request请求的body部分数据，使用系统默认配置的HttpMessageConverter进行解析，
     * 然后把相应的数据绑定到要返回的对象上 ,再把HttpMessageConverter返回的对象数据绑定到 controller中方法的参数上
     * 可以用String接收，也可以用对象直接接
     * 测试方式：用postman传入Content-Type为application/xml或者application/json的数据
     */
    @RequestMapping("requestBody")
    public String requestBody(Model model, @RequestBody String jsonStr) {
        model.addAttribute("message", jsonStr);
        return "modules/frame/spring/demo/mvc/index";
    }

    /**
     * ResponseBody注解
     * 该注解用于将Controller的方法返回的对象，通过适当的HttpMessageConverter转换为指定格式后，写入到Response对象的body数据区
     */
    @RequestMapping("responseBody")
    @ResponseBody
    public User responseBody() {
        User user = new User("1", "哈哈");
        System.out.println(user);
        return user;
    }

}
