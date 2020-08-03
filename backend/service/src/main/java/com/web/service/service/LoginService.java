package com.web.service.service;

import com.web.service.model.MemberDTO;
import com.web.service.repository.MemberRepository;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class LoginService {
    @Setter(onMethod_ = {@Autowired})
    private static MemberRepository memberRepository;

    public static String Login(String member_id, String member_password) throws Exception{
        MemberDTO memberDTO = new MemberDTO();
        String loginsuccess = "0";
        memberDTO.setMember_id(member_id);
        memberDTO.setMember_password(member_password);
        log.info("안드로이드에서 들어온 값 :" + member_id);
        log.info("안드로이드에서 들어온 값 :" + member_password);
        log.info("로그인 정보 : " + memberRepository.login(memberDTO));
        if(memberRepository.login(memberDTO) == null){
            loginsuccess = "0";
        }else if(memberRepository.login(memberDTO)     !=null){
            loginsuccess = "1";
        }

        return loginsuccess;
    }
    public void insertMember(String member_id, String member_nickname,
                             String member_password) throws Exception{
        MemberDTO login = new MemberDTO();
        login.setMember_id(member_id);
        login.setMember_nickname(member_nickname);
        login.setMember_password(member_password);
        memberRepository.insertMember(login);

    }
}
