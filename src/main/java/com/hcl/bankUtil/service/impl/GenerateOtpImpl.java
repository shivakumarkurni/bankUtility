package com.hcl.bankUtil.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.hcl.bankUtil.service.GenerateOtp;

@Service
public class GenerateOtpImpl implements GenerateOtp {

	@Value("${min}")
	private int min;
	
	@Value("${max}")
	private int max;
	
	@Override
	public Integer generateOtp() {
		
		int generatedOtp= (int)(Math.random() *(max-min))+min;
		System.out.println("rendom "+generatedOtp);
		return generatedOtp;
	}
}