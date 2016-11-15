package com.email.rest.service;

import com.email.rest.model.EmailRequest;

public interface EmailService {
	
	int sendEmail(EmailRequest emailRequest);
}	
