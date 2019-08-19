package com.hcl.bankUtil.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.bankUtil.dto.EmailDto;
import com.hcl.bankUtil.service.EmailService;
import com.hcl.bankUtil.service.GenerateOtp;

@RestController
@RequestMapping("/bankUtility")
@CrossOrigin(allowedHeaders = { "*", "*/" }, origins = { "*", "*/" })
public class UtilityController {

	@Autowired
	private GenerateOtp generateOtp;
	
	@Autowired
	private EmailService emailService;
	
	@GetMapping("/otp")
	public ResponseEntity<Integer> generateOtp() {
		return new ResponseEntity<>(generateOtp.generateOtp(), HttpStatus.OK);
	}
	
	@PostMapping("/email")
	public ResponseEntity<String> sendEmail(@RequestBody EmailDto emailDto){
		return new ResponseEntity<>(emailService.sendEmail(emailDto), HttpStatus.CREATED);
	}
}
