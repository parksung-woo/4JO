package com.web.service.controller;

import com.web.service.model.MemberDTO;
import com.web.service.service.MemberService;
import com.web.service.service.OndoService;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


/**
 * @author Jeon Jin Ho
 * @date 20-08-13
 */

@Controller
@Slf4j
public class MemberController {

    @Setter(onMethod_ = {@Autowired})
    private MemberService memberService;
    private OndoService ondoService;

    /**
     * ondoService
     * @param ondoService : OndoService 이용
     */
    public MemberController(OndoService ondoService) {
        this.ondoService = ondoService;
    }

    /**
     * 웹 리스트 페이지
     * @return mv : 회원 목록과 온습도 목록을 출력
     */
    @RequestMapping("/memberList")
    public ModelAndView memberList(){
        log.info("memberList 실행");
        ModelAndView mv = new ModelAndView();
        mv.addObject("result"    , memberService.memberList());
        mv.addObject("resultOndo", ondoService.selectOndoList());
        mv.setViewName("memberList");
        return mv;
    }

    /**
     * 웹 상세보기(수정 화면) 부분
     * @param member_id     : 회원 아이디
     * @param model         : 백그라운드에서 동작하는 로직을 처리
     * @return "memberView" : memberView로 출력
     */
    @GetMapping(value = "/memberView")
    public String updateMember(@RequestParam("member_id") String member_id,
                                                          Model  model){
        log.info("memberView 실행");
        model.addAttribute("list",memberService.memberListOne(member_id));
        return "memberView";
    }

    /**
     * 상세보기에서 수정 부분
     * @param memberDTO               : 수정할 값이 들어감
     * @return "redirect:/memberList" : 수정후 목록 페이지로 이동
     */
    @PostMapping(value = "/updateMember")
    public String updateMemberSubmit(@ModelAttribute MemberDTO memberDTO){
        log.info("updateMemberSubmit 실행");
        MemberService.updateMember(memberDTO);
        return "redirect:/memberList";
    }

    /**
     * 목록에서 회원 정보 삭제
     * @param member_id               : 회원 아이디
     * @return "redirect:/memberList" : 삭제후 목록 출력
     */
    @RequestMapping("/deleteMember")
    public String deleteMember(@RequestParam("member_id") String member_id){
        log.info("deleteMember 실행");
        MemberService.deleteMember(member_id);

        return "redirect:/memberList";
    }



}
