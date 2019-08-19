package com.hcl.bankUtil.test;

public class RendomVal {

	public static void main(String[] args) {
		
		for(int i=0; i<10; i++) {
			int generatedOtp;
			int max=9999, min=1000;
			generatedOtp = (int)(Math.random() *(max-min))+min;
			System.out.println("rendom "+generatedOtp);
			
		}
	}
}