package com.bs.hello.boot.controller;

import java.security.Principal;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class SecurityController {

	@GetMapping("/loginpage")
	public String loginpage() {
		return "login";
	}
	
	@RequestMapping("/successLogin")
	public String successLogin(Principal principal) {
		Object o=SecurityContextHolder.getContext().getAuthentication();
		
		log.debug("{}",o);
		log.debug("로그인 성공");
		return "redirect:/";
	}
	@RequestMapping("/errorLogin")
	public String errorLogin() throws IllegalAccessException {
		throw new IllegalAccessException("잘못된접근입니다.");
	}
}
