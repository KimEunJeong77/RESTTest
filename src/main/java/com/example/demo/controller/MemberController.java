package com.example.demo.controller;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dto.MemberDTO;
import com.example.demo.service.MemberService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j    // Simple Logging Facade for Java
/*
 * GET /member/ 		상세정보요청
 * GET /member/list 	모든정보요청
 * POST /member			생성
 * DELETE /member/ 	삭제
 * */
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	
	@GetMapping("/member/list")
	public ModelAndView memberList() {
		log.info("========================== @GetMapping(\"/member/list\") ==================================");
		ModelAndView mv=new ModelAndView("/member/list");
		List<MemberDTO> list=memberService.findMemberList();
		mv.addObject("list", list);
		return mv;
	}
	
	@GetMapping("/member/{id}")
	public ModelAndView member(		
			@PathVariable(name="id") String id
	) {
		log.info("========================== @GetMapping(\"/member/{id}\") ==================================");
		ModelAndView mv=new ModelAndView("/member/detail");
		MemberDTO member=memberService.findMemberDetail(id);
		mv.addObject("member", member);
		return mv;
	}	
	
	@RequestMapping("/member/add-form")
	public ModelAndView addform() {
		log.info("========================== @RequestMapping(\"/member/add-form\") ==================================");
		ModelAndView mv=new ModelAndView("/member/addform");
		return mv;
	}
	@RequestMapping("/member/update-form/{id}")
	public ModelAndView updateform(
			@PathVariable(name="id") String id) {
		log.info("========================== @RequestMapping(\"/member/update-form/{id}\") ==================================");
		ModelAndView mv=new ModelAndView("/member/updateform");
		MemberDTO member=memberService.findMemberDetail(id);
		mv.addObject("member", member);
		return mv;
	}

	
	@PostMapping("/member")
	public ModelAndView register(		
			MemberDTO memberDTO
	) {
		log.info("========================== @PostMapping(\"/member\") ==================================");
		memberService.registerMember(memberDTO);
		ModelAndView mv=new ModelAndView("redirect:/member/list");
		return mv;
	}	
	
	@DeleteMapping("/member/{id}")
	public ModelAndView remove(		
			@PathVariable String id
	) {
		log.info("========================== @DeleteMapping(\"/member/{id}\") ==================================");
		memberService.removeMember(id);
		ModelAndView mv=new ModelAndView("redirect:/member/list");
		return mv;
	}
	
	@PutMapping("/member")
	public ModelAndView change(		
			MemberDTO memberDTO
	) {
		log.info("========================== @PutMapping(\"/member\") ==================================");
		memberService.changeMember(memberDTO);
		ModelAndView mv=new ModelAndView("redirect:/member/list");
		return mv;
	}
}