package com.team1.workforest.security;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class CommonController {
	
	@GetMapping("/accessError")
	public String accessError(Authentication auth, Model model) {
		//auth: 로그인 정보가 들어있음
		log.info("accessError");
		
		
		model.addAttribute("msg", "권한 챙겨와요");
		
		return "accessError";
	}

}
