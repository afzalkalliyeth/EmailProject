package com.email.providers;

import com.email.rest.model.EmailRequest;

public interface MailProvider {
	
	int send(EmailRequest emailRequest);
}
