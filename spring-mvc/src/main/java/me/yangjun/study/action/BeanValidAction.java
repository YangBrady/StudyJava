package me.yangjun.study.action;

import me.yangjun.study.dto.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

/**
 * @author mooejun
 * @since 2019/05/07
 */
@Controller
@RequestMapping(value = "/frame/spring/demo/mvc")
public class BeanValidAction {
    /**
     * Valid注解表示按照在实体上标记的注解验证参数
     */
    @RequestMapping(value = "beanValid")
    public String beanValid(Model model, @Valid User user) {
        model.addAttribute("message", user);
        return "modules/frame/spring/demo/mvc/index";
    }
}
