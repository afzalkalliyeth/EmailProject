package com.email.rest.service;

import org.springframework.stereotype.Service;

import com.email.providers.MailGunMailProvider;
import com.email.providers.MailProvider;
import com.email.providers.SparkPostMailProvider;
import com.email.rest.model.EmailRequest;

@Service
public class EmailServiceImpl implements EmailService {

	@Override
	public int sendEmail(EmailRequest emailRequest) {
		 
 		MailProvider[] mailProviders = { new SparkPostMailProvider(), new MailGunMailProvider()};
		
 		int statusCode = 0;
		for (MailProvider mailProvider : mailProviders) {
			
			statusCode = mailProvider.send(emailRequest);
			
			if (statusCode == 200) {
				break;
			}
		}
		return statusCode;
	}

}
