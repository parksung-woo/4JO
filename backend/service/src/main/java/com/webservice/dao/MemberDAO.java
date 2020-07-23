package com.webservice.dao;

import com.webservice.dto.MemberDTO;

import java.util.List;

public interface MemberDAO {
    //리스트
    public List<MemberDTO> memberList() throws Exception;

    // 상세 정보
    public MemberDTO memberView(String member_id);

    //수정
    public MemberDTO updateMember(MemberDTO dto);

    //삭제
    public MemberDTO deleteMember(String member_id);
}
