package com.hcl.bankUtil.service;

import com.hcl.bankUtil.dto.EmailDto;

public interface EmailService {

	String sendEmail(EmailDto emailDto);

}
