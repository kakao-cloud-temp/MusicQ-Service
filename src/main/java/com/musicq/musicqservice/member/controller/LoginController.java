package com.musicq.musicqservice.member.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.musicq.musicqservice.member.dto.LoginDto;
import com.musicq.musicqservice.member.dto.LoginResDto;
import com.musicq.musicqservice.member.service.LoginService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/members")
public class LoginController {
	private final LoginService loginService;

	@Value("${jwt.header}")
	private String jwtHeader;

	@Value("${Cookie-Max-Age}")
	private int maxAge;
	@Value("${Cookie-Header}")
	private String cookieHeader;

	@PostMapping("/login")
	public ResponseEntity<LoginResDto> login(
		@Valid @RequestBody LoginDto loginDto,
		HttpServletRequest requset
	){
		// 로그인 결과
		ResponseEntity<LoginResDto> loginResult = loginService.login(loginDto, requset);

		return loginResult;
	}
}