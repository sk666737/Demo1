package com.infosys.infyshop.signup.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.infosys.infyshop.signup.dto.LoginDTO;
import com.infosys.infyshop.signup.dto.SignUpDTO;
import com.infosys.infyshop.signup.entity.SignUp;
import com.infosys.infyshop.signup.service.SignUpService;

@RestController
@CrossOrigin
public class SignUpController {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	SignUpService signUpService;
	// Save the friend details of a specific customer
	@PostMapping(value = "/signup", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<SignUp> signUp(@RequestBody SignUpDTO signUpDTO) {
		logger.info("Sign up request of user {} ", signUpDTO);
		return signUpService.signUp(signUpDTO);
	}
	
	// Login
	@PostMapping(value = "/login",consumes = MediaType.APPLICATION_JSON_VALUE)
	public boolean login(@RequestBody LoginDTO loginDTO) {
		logger.info("Login request for customer {} with password {}", loginDTO.getEmail(), loginDTO.getPassword());
		return signUpService.login(loginDTO);
	}
	
	@PostMapping(value = "/{userId}/update", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<SignUp> updateProfile(@PathVariable String userId, @RequestBody SignUpDTO signUpDTO) {
		logger.info("Update request of user {} ", signUpDTO);
		return signUpService.updateProfile(userId,signUpDTO);
	}
}
