package com.webservice.controller;

import com.webservice.dto.MemberDTO;
import com.webservice.svc.MemberService;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.List;

@Controller
public class MemberController {

    @Setter(onMethod_ = {@Autowired})
    MemberService memberService;

    // 리스트
    @RequestMapping(value = "/memberList")
    public String memberList(Model model) throws Exception {
        List<MemberDTO> list = memberService.memberList();
        model.addAttribute("result", list);
        return "memberList";
    }

    //상세 정보
    @RequestMapping(value = "/memberView")
    public String memberView(String member_id, Model model){
        model.addAttribute("dto", memberService.memberView(member_id));
        return "memberView";
    }

    //수정
    @RequestMapping(value = "/updateMember")
    public String updateMember(@ModelAttribute MemberDTO dto){
        memberService.updateMember(dto);
        return "redirect:/memberList";
    }
    //삭제
    @RequestMapping(value = "/deleteMember")
    public String deleteMember(@RequestParam String member_id){
        memberService.deleteMember(member_id);
        return "redirect:/memberList";
    }



}
