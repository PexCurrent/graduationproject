package cn.qingwei.graduationproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ErrorPageController {

    @RequestMapping(value = "/error/")
    public String error() {
        return "error";
    }
}
