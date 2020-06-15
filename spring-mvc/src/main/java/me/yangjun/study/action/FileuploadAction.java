package me.yangjun.study.action;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author mooejun
 * @since 2019/05/06
 */
@Controller
@RequestMapping(value = "/frame/spring/demo/mvc")
public class FileuploadAction {
    /**
     * 文件上传
     * 需要common-io和common-fileupload支持
     * 需要在SpringMVC配置文件配置上传文件拦截器
     */
    @RequestMapping(value = "upload", method = RequestMethod.POST)
    public String uploadDemo001_resp(Model model, HttpServletRequest req) throws Exception {
        MultipartHttpServletRequest mreq = (MultipartHttpServletRequest) req;
        MultipartFile mfile = mreq.getFile("file");
        String fileName = mfile.getOriginalFilename();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String fileFold = req.getSession().getServletContext().getRealPath("/") + "upload/";
        File file = new File(fileFold + sdf.format(new Date()) + fileName);
        new File(fileFold).mkdirs();
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(mfile.getBytes());
        fos.flush();
        fos.close();
        model.addAttribute("message", "文件路径" + file);
        return "modules/frame/spring/demo/mvc/index";
    }
}
