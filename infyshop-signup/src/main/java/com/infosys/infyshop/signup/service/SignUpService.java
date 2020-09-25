package com.infosys.infyshop.signup.service;

import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.infosys.infyshop.signup.dto.LoginDTO;
import com.infosys.infyshop.signup.dto.SignUpDTO;
import com.infosys.infyshop.signup.entity.SignUp;
import com.infosys.infyshop.signup.repository.SignUpRepository;

@Service
public class SignUpService {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	SignUpRepository signUpRepository;
	
	//Sign Up
	public ResponseEntity<SignUp> signUp(SignUpDTO signUpDTO) {
		logger.info("Sign up request of user {}", signUpDTO);
		SignUp signUp = signUpDTO.createEntity();
		return ResponseEntity.ok().body(signUpRepository.save(signUp));
	}
	
	// Login
	public boolean login(LoginDTO loginDTO) {
		Boolean flag=false;
		logger.info("Login request for customer {} with password {}", loginDTO.getEmail(),loginDTO.getPassword());
		Optional<SignUp> signUp;
		signUp=signUpRepository.findById(loginDTO.getEmail());
		if(signUp.isPresent() && signUp.get() != null && signUp.get().getPassword().equals(loginDTO.getPassword())) {
			flag= true;
		}
		return flag;
	}
	
	//Update profile
	public ResponseEntity<SignUp> updateProfile(String userId, SignUpDTO signUpDTO) {
		SignUpDTO signUpDTO1= null;
		logger.info("Update Profile request for user {}", userId);
		Optional<SignUp> signUp = signUpRepository.findById(userId);
		SignUp updatedSignUp = null;
		if(signUp.isPresent()) {
			signUpDTO1 = SignUpDTO.valueOf(signUp.get());
			signUpDTO1.setName(signUpDTO.getName());
			signUpDTO1.setPassword(signUpDTO.getPassword());
			SignUp signUp1 = signUpDTO1.createEntity();
			updatedSignUp = signUpRepository.save(signUp1);
		}
		return ResponseEntity.ok(updatedSignUp);
	}
}
