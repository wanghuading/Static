package com.microservice.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author whd
 * @Date 2018/5/31 21:21
 * @Description
 **/
@RequestMapping("/thymeleaf")
@Controller
public class ThymeleafController {
    @GetMapping("/index")
    public String getIndex() {
        return "index";
    }
}
