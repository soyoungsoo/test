package com.koitt.board.controller;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.koitt.board.model.UserInfo;
import com.koitt.board.service.UserInfoService;

@Controller
@RequestMapping("/rest")
public class UserRestController {

	@Autowired
	private UserInfoService userInfoService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@RequestMapping(value = "/user/login", method = RequestMethod.POST)
	public ResponseEntity<String> login(UserInfo userinfo){
		// 아이디 존재 유무와 비밀번호 일치 여부 확인
		boolean isMatched = userInfoService.isPasswordMatched(userinfo.getEmail(), userinfo.getPassword());
		
		if (isMatched) {
			
			// Base 64 인코딩 전 평문
			String plainCredentials = userinfo.getEmail() + ":" + userinfo.getPassword();
			// 평문을 Base64로 인코딩
			String base64Credentials = new String(Base64.encodeBase64(plainCredentials.getBytes()));
		
			return new ResponseEntity<String>(base64Credentials, HttpStatus.OK);
		}
			return new ResponseEntity<String>("", HttpStatus.NOT_FOUND);
	}
}
