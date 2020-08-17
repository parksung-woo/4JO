package com.web.service.service;

import com.web.service.model.MemberDTO;
import com.web.service.repository.MemberRepository;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author Jeon Jin Ho
 * @date 20-08-13
 */

@Service
public class MemberService {
    /**
     * 웹 목록 페이지 데이터 가공
     * @return MemberRepository.memberList()
     * : -memberMapper에 id가 memberList인 SQL문 데이터 가공
     */
    public List<Map<String, Object>> memberList(){
        return MemberRepository.memberList();
    }

    /**
     * 웹 상세보기 데이터 가공
     * @param member_id : 회원 아이디
     * @return MemberRepository.memberListOne(member_id)
     * : -memberMapper에 id가 memberListOne인 SQL문 데이터 가공
     */
    public MemberDTO memberListOne(String member_id){
        return MemberRepository.memberListOne(member_id);
    }

    /**
     * 웹 상세보기에 있는 수정부분 데이터 가공
     * @param memberDTO : 수정할 데이터 값을 담음
     */
    public static void updateMember(MemberDTO memberDTO){
        MemberRepository.updateMember(memberDTO);
    }

    /**
     * 웹 목록페이지의 삭제 부분 데이터 가공
     * @param member_id : 삭제할 회원 아이디
     */
    public static void deleteMember(String member_id){ MemberRepository.deleteMember(member_id); }

    /**
     * 안드로이드 회원가입 데이터 가공
     * @param memberDTO : 안드로이드에서 보낸 회원 데이터를 담음
     */
    public static void insertMember(MemberDTO memberDTO){
        MemberRepository.insertMember(memberDTO);
    }

}
