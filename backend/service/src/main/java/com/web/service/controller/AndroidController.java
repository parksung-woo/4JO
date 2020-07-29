package com.web.service.controller;


import com.web.service.model.MemberDTO;
import com.web.service.service.LoginService;
import com.web.service.service.MemberService;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AndroidController {

    Logger logger = LoggerFactory.getLogger(MemberController.class);

    @Setter(onMethod_ = {@Autowired})
    private MemberService memberService;



    @GetMapping("/androidLogin")
    public String androidLogin(String member_id, String member_password) throws Exception{
        logger.info("androidLogin 실행");
        String log = "1성공@"
                + LoginService.Login(member_id,member_password)
                +"@";
        if(LoginService.Login(member_id,member_password).equals("0")){
            log = "0실패";
        }
        else if(LoginService.Login(member_id,member_password).equals("2")){
            log = "2성공";
        }
        System.out.println("login end");
        return log;
    }
    //안드로이드 회원가입
    @GetMapping("/androidInsert")
    public String androidInsert(@RequestParam String member_id, @RequestParam String member_nickname,
                                @RequestParam String member_password) throws Exception{
        logger.info("androidInsert 실행");
        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setMember_id(member_id);
        memberDTO.setMember_nickname(member_nickname);
        memberDTO.setMember_password(member_password);
        memberService.insertMember(memberDTO);
        return "androidClose";
    }

}
