package servertest.demo.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import servertest.demo.Util.FileUtil;

import javax.servlet.http.HttpServletRequest;

@Controller
@ComponentScan("servertest.demo")
public class CrmController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    //处理文件上传
    @RequestMapping(value="/api/testuploadimg", method = RequestMethod.POST)
    @ResponseBody
    public String uploadImg(@RequestParam("fileToUpload") MultipartFile file, HttpServletRequest request) {
        String contentType = file.getContentType();
        String fileName = file.getOriginalFilename();
        logger.info("fileName-->" + fileName);
        logger.info("getContentType-->" + contentType);
        //String filePath = request.getSession().getServletContext().getRealPath("imgupload/");
        //logger.info(filePath);
        try {
            FileUtil.uploadFile(file.getBytes(), "/", fileName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "success";
    }
}
