package com.hcl.bankUtil.service.impl;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.hcl.bankUtil.dto.EmailDto;
import com.hcl.bankUtil.service.EmailService;

@Service
public class EmailServiceImpl implements EmailService {

	@Autowired
	private JavaMailSender mailSender;
	
	@Override
	public String sendEmail(EmailDto emailDto) {
		
		String returnString = "Mail sent Successfully.";
		
		MimeMessage message = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message);
		
		try {
			helper.setTo(emailDto.getEmailId());
			helper.setSubject(emailDto.getSubject());
			helper.setText(emailDto.getTextBody());
		} catch (MessagingException e) {
			e.printStackTrace();
			returnString = "Mail failed.";
		}
		mailSender.send(message);
		
		return returnString;
	}

}
