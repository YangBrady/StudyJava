package me.yangjun.modules.frame.spring.demo.mvc.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author mooejun
 * @since 2019/05/06
 */
@Controller
@RequestMapping(value = "/frame/spring/demo/mvc")
public class ExceptionAction {
    /**
     * ExceptionHandler注解
     * 异常处理，出现异常时会执行该方法
     */
    @ExceptionHandler
    public ModelAndView exceptionHandler(Exception e) {
        ModelAndView modelAndView = new ModelAndView("modules/frame/spring/demo/mvc/error");
        modelAndView.addObject("exception", e);
        return modelAndView;
    }

    @RequestMapping("exceptionHandlerTest")
    public String exceptionHandlerTest() {
        System.out.println(1 / 0);
        return "modules/frame/spring/demo/mvc/index";
    }
}
