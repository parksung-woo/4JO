package com.web.service.service;

import com.web.service.model.MemberDTO;
import com.web.service.repository.MemberRepository;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class MemberService {

    @Setter(onMethod_ = {@Autowired})
    private MemberService memberService;

    //리스트
    public List<Map<String, Object>> memberList(){
        return MemberRepository.memberList();
    }
    //상세 정보
    public MemberDTO memberListOne(String member_id){
        return MemberRepository.memberListOne(member_id);
    }
    //수정
    public static void updateMember(MemberDTO memberDTO){
        MemberRepository.updateMember(memberDTO);
    }

    //삭제
    public static void deleteMember(String member_id){
        MemberRepository.deleteMember(member_id);
    }

    //가입
    public static void insertMembver(MemberDTO memberDTO){
        MemberRepository.insertMember(memberDTO);
    }
}
