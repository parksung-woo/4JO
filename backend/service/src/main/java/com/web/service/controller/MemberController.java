package com.web.service.controller;

import com.web.service.model.MemberDTO;
import com.web.service.service.MemberService;
import com.web.service.service.OndoService;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@Slf4j
public class MemberController {

    @Setter(onMethod_ = {@Autowired})
    private MemberService memberService;
    @Setter(onMethod_ = {@Autowired})
    private OndoService ondoService;

    //리스트
    @RequestMapping("/memberList")
    public ModelAndView memberList(){
        log.info("memberList 실행");
        ModelAndView mv = new ModelAndView();
        mv.addObject("result", memberService.memberList());
        mv.addObject("resultOndo", ondoService.selectOndoList());
        mv.setViewName("memberList");
        return mv;
    }

    //상세보기, 수정 화면
    @RequestMapping(value = "/memberView", method = RequestMethod.GET)
    public String updateMember(@RequestParam("member_id") String member_id, Model model){
        log.info("memberView 실행");
        model.addAttribute("list",memberService.memberListOne(member_id));
        return "memberView";
    }

    //수정
    @RequestMapping(value = "/updateMember", method = RequestMethod.POST)
    public String updateMemberSubmit(@ModelAttribute MemberDTO memberDTO){
        log.info("updateMemberSubmit 실행");
        MemberService.updateMember(memberDTO);
        return "redirect:/memberList";
    }

    //삭제
    @RequestMapping("/deleteMember")
    public String deleteMember(@RequestParam("member_id") String member_id){
        log.info("deleteMember 실행");
        MemberService.deleteMember(member_id);

        return "redirect:/memberList";
    }



}
