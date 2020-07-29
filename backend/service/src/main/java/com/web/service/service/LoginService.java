package com.web.service.service;

import com.web.service.model.MemberDTO;
import com.web.service.repository.MemberRepository;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    @Setter(onMethod_ = {@Autowired})
    private static MemberRepository memberRepository;

    public static String Login(String member_id, String member_password) throws Exception{
        MemberDTO login = new MemberDTO();
        String loginsuccess = "0";
        login.setMember_id(member_id);
        login.setMember_password(member_password);
        if(memberRepository.login(login)!=null){
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
