package com.web.service.controller;


import com.web.service.model.MemberDTO;
import com.web.service.model.SensorDTO;
import com.web.service.service.LoginService;
import com.web.service.service.MemberService;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class AndroidController {

    @Setter(onMethod_ = {@Autowired})
    private MemberService memberService;

    @Setter(onMethod_ = {@Autowired})
    LoginService loginService;


    @GetMapping("/androidLogin")
    public String androidLogin(String member_id, String member_password) throws Exception{
        log.info("androidLogin 실행");
        // 0이면 실패 1이면 성공
        String log = "로그인 결과 : " + loginService.Login(member_id,member_password);

        return log;
    }
    //안드로이드 회원가입
    @GetMapping("/androidInsert")
    public String androidInsert(@RequestParam String member_id, @RequestParam String member_nickname,
                                @RequestParam String member_password) throws Exception{
        log.info("androidInsert 실행");
        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setMember_id(member_id);
        memberDTO.setMember_nickname(member_nickname);
        memberDTO.setMember_password(member_password);
        memberService.insertMember(memberDTO);
        return "androidClose";
    }

}
