package me.yangjun.modules.frame.spring.demo.mvc.action;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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
    public String demo001(Model model) {
        return "modules/frame/spring/demo/mvc/hello";
    }
}
