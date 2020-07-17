package com.serviceweb.serviceweb;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @RequestMapping("/test.jsp")
    public String test(){
        return "test.jsp";
    }
}
