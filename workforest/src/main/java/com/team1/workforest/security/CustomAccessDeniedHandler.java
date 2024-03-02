package com.team1.workforest.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CustomAccessDeniedHandler implements AccessDeniedHandler {@Override
	//인터페이스 임플리먼트 하고 메서드 추가
	
	public void handle(HttpServletRequest request, HttpServletResponse response,
			AccessDeniedException accessDeniedException) throws IOException, ServletException {
		log.info("handle");
		
		//DB 작업
		//로그 작업
		//메시지 발송
		
		response.sendRedirect("/accessError");
		
	}
	
	/*
	 공지사항 등록 화면(/notice/register)은 
	일반회원(member/java)이 접근할 수 없는 페이지이고,
	관리자(admin/java)만 접근 가능하므로..
	지정된 접근 거부 처리자(CustomAccessDeniedHandler)에서 
	접근 거부 처리 페이지(/security/accessError)로 리다이렉트 시킴
    */
	
	

}
