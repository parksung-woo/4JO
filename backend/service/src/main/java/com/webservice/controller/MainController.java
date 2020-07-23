package com.webservice.controller;

import com.webservice.dto.MainDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MainController {

    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public String login() {

        return "main";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String loginSubmit(@ModelAttribute MainDTO login, HttpServletRequest request, Model model) {
        String password = login.getPassword();
        //userid : admin password : 1234
        if(password.equals("1234")) {
            System.out.println("1234 tttt");
            return "redirect:/memberList";
        }
        //로그인 실패시 전달 값
        model.addAttribute("loginError", true);
        return "main";
    }
}
