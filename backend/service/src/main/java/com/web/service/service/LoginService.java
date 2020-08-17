package com.web.service.service;

import com.web.service.model.MemberDTO;
import com.web.service.repository.MemberRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author Jeon Jin Ho
 * @date 20-08-13
 */

@Service
@Slf4j
public class LoginService {

    /**
     * 안드로이드에서 전송된 회원 아이디와 비밀번호를 
     * DB에 저장된 값과 비교해 다르면 0 같으면 1을 전송
     * @param member_id : 회원 아이디
     * @param member_password : 회원 비밀번호
     * @return loginsuccess : 일치 여부를 리턴
     */
    /*안드로이드 로그인*/
    public static String Login(String member_id, String member_password) {
        MemberDTO memberDTO = new MemberDTO();
        String loginsuccess = "0";
        memberDTO.setMember_id(member_id);
        memberDTO.setMember_password(member_password);

        log.info("안드로이드에서 들어온 값 :" + member_id);
        log.info("안드로이드에서 들어온 값 :" + member_password);
        log.info("로그인 정보 : " + MemberRepository.login(memberDTO));

        if(MemberRepository.login(memberDTO) == null){
            loginsuccess = "0";
        } else if(MemberRepository.login(memberDTO)     !=null) {
            loginsuccess = "1";
        }
        return loginsuccess;
    }

    /**
     * 안드로이드 중복 체크 (DB에서 카운트로 체크)
     * @param member_id : 회원 아이디
     * @return result   : 중복 여부를 리턴
     */
    public String idCheck(String member_id) {
        log.info("idCheck 실행");
        String result = "";
        int count = MemberRepository.idCheck(member_id);
        if(count == 0){
            result = "사용가능한 ID";
        } else {
            result = "중복된 ID";
        }
        return result;
    }
}
