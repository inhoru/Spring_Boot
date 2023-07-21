package com.bs.hello.boot.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bs.hello.boot.dto.MemberDto;
import com.bs.hello.boot.service.MemberService;

@Controller
@RequestMapping("/member")
public class MemberController {
	
	private MemberService serivce;
	
	public MemberController(MemberService serivce) {
	this.serivce=serivce;
	}
	
	
	
	@GetMapping("/memberAll")
	public String selectMemberAll(Model m) {
		m.addAttribute("members",serivce.selectMemberAll());
		return "member/memberList";
	}

}
