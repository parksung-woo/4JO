package com.webservice.svc;

import com.webservice.dao.MemberDAO;
import com.webservice.dto.MemberDTO;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
public class MemberService {

        @Setter(onMethod_ = {@Autowired})
        MemberDAO memberDAO;

        //리스트
        public List<MemberDTO> memberList() throws Exception {
                return memberDAO.memberList();
        }

        //상세 정보
        public MemberDTO memberView(String member_id) {
                return memberDAO.memberView(member_id);
        }

        //수정
        public MemberDTO updateMember(MemberDTO dto){

                return memberDAO.updateMember(dto);
        }


        //삭제
        public MemberDTO deleteMember(String member_id){
               return memberDAO.deleteMember(member_id);
        }
}
