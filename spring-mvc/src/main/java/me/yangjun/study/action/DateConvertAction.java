package me.yangjun.study.action;

import me.yangjun.study.dto.Food;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author mooejun
 * @since 2019/05/06
 */
@Controller
@RequestMapping(value = "/frame/spring/demo/mvc")
public class DateConvertAction {
	/**
	 * 使用InitBinder来处理Date类型的参数
	 */
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		CustomDateEditor dateEditor = new CustomDateEditor(df, true);
		binder.registerCustomEditor(Date.class, dateEditor);
	}
//    @InitBinder
//    public void initBinder(ServletRequestDataBinder binder) {
//        binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"),
//                true));
//    }

	@RequestMapping("str2date")
	public String str2date(Model model, Food food) {
		System.out.println("food=" + food);
		model.addAttribute("message", food.getProductDate());
		return "modules/frame/spring/demo/mvc/index";
	}

}
