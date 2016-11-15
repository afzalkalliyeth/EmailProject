package com.email.rest.controler;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.email.rest.model.EmailRequest;
import com.email.rest.service.EmailService;

@RestController
@RequestMapping("/email")
public class EmailController {
	
	@Autowired
	EmailService emailService;
	
	@RequestMapping(method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
	  public Response sendEmail(@RequestBody EmailRequest emailRequest) {
	    
		int status = emailService.sendEmail(emailRequest);
		System.out.println(status);
		ResponseBuilder rb = Response.status(status);

	    return rb.build();
	  }
}
