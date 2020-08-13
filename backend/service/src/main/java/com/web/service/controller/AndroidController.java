package com.web.service.controller;


import com.web.service.model.MemberDTO;
import com.web.service.service.LoginService;
import com.web.service.service.MemberService;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Jeon Jin Ho
 * @date 20-08-13
 */

@RestController
@Slf4j
public class AndroidController {

    @Setter(onMethod_ = {@Autowired})
    LoginService loginService;

    /**
     * 로그인 결과값( 1 : 성공, 0 : 실패 )을 안드로 전송
     * @param member_id        : 회원 아이디
     * @param member_password  : 회원 비밀번호
     * @return "로그인 결과 : " + LoginService.Login(member_id,member_password) :
     *          로그인 결과 : 1 - 안드로이드 로그인 성공
     *          로그인 결과 : 0 - 안드로이드 로그인 실패
     */
    @GetMapping("/androidLogin")
    public String androidLogin(String member_id,
                               String member_password) {
        log.info("androidLogin 실행");
        return "로그인 결과 : " + LoginService.Login(member_id,member_password);
    }

    /**
     * 안드 회원 가입에서 아이디 중복 체크
     * @param member_id                        : 회원 아이디
     * @return loginService.idCheck(member_id) : 중복 확인
     */
    @GetMapping(value = "/idCheck")
    public  String idCheck(String member_id) {
        log.info("중복 체크 실행");

        return loginService.idCheck(member_id);
    }

    /**
     * 스트링으로 들어오는 배열값을
     * str의 값과 비교하여
     * 하나라도 틀리면 false 리턴
     * @param params : 안드로이드에서 들어온 값을 배열에 담기는 역할
     * @param str    : 걸러야할 값
     * @return       : boolean값을 리턴
     */
    public boolean checkEmptyValues(String[] params, String str){
        for(String param : params){
            log.debug(param);
            if(param.equals(str)){
                return false;
            }
        }
        return true;
    }

    /**
     * 안드로이드에서 보낸 회원 정보를 DB에 저장
     * @param member_id       : 회원 아이디
     * @param member_nickname : 회원 닉네임
     * @param member_password : 회원 비밀번호
     * @return "androidClose" : "androidClose"라는 값을 리턴
     */
    @GetMapping("/androidInsert")
    public String insertMember(@RequestParam String member_id,
                               @RequestParam String member_nickname,
                               @RequestParam String member_password) {
        log.info("androidInsert 실행");
        String[] values = {member_id, member_password, member_nickname};
        if(checkEmptyValues(values, "")) {
            log.info("Fail : null or \"\" ");
            log.info("아이디 : "+member_id);
            log.info("비밀번호 : "+member_password);
            log.info("닉네임 : "+member_nickname);
        } else {
            MemberDTO memberDTO = new MemberDTO();
            memberDTO.setMember_id(member_id);
            memberDTO.setMember_nickname(member_nickname);
            memberDTO.setMember_password(member_password);
            MemberService.insertMember(memberDTO);
            log.info("success");
            log.info("아이디 : "+member_id);
            log.info("비밀번호 : "+member_password);
            log.info("닉네임 : "+member_nickname);
        }

        return "androidClose";
    }

}
