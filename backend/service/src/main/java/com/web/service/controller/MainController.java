package com.web.service.controller;

import com.web.service.model.MainDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author Jeon Jin Ho
 * @date 20-08-13
 */

@Controller
@Slf4j
public class MainController {

    /**
     *  관리자 페이지 중 첫번째 화면 부분
     * @return "main" : main.jsp 출력
     */
    @GetMapping(value = "/main")
    public String login() {
        log.info("main 첫번째 화면 실행");
        return "main";
    }

    /**
     * 웹 관리자 로그인 부분 관
     * 관리자 ID와 비밀 번호를 임의로 설정
     * 로그인 성공/실패 유무 확인
     * @param login : 임의로 설정한 관리자 ID와 Password 값 받음
     * @return "redirect:/memberList" : 로그인 성공시 memberList.jsp 페이지로 이동
     *         "main"                 : 로그인 실패시 main.jsp 페이지로 그대로
     */
    @PostMapping(value = "/login")
    public String loginSubmit(@ModelAttribute MainDTO login) {
        String id = login.getId();
        String password = login.getPassword();
        //userid : admin password : 1234
        if(id.equals("admin")&&password.equals("1234")) {
            log.info("main 로그인 후 실행");
            return "redirect:/memberList";
        }
        //로그인 실패시 전달 값
        log.info("main 로그인 실패");
        return "main";
    }

}
