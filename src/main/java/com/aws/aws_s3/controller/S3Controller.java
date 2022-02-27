package com.aws.aws_s3.controller;
import com.aws.aws_s3.entity.S3Info;
import com.aws.aws_s3.service.S3InfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;

@Controller
@RequestMapping("/api")
public class S3Controller {

    @Autowired
    private S3InfoService s3InfoService;

    @GetMapping("/")
    public String showMainPage()
    {
        return "main";// new ModelAndView("main");
    }

    @GetMapping("/s3info")
    public String showS3InfoFromDB(Model model){
        List<S3Info> s3InfoList = s3InfoService.getS3InfoFromDB();
        if(s3InfoList.isEmpty()){
            s3InfoService.updateS3Info();
            s3InfoList = s3InfoService.getS3InfoFromDB();
        }
        model.addAttribute("s3InfoList", s3InfoList);
        return "s3info";
    }


}
