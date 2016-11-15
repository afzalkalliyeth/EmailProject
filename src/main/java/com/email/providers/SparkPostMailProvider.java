package com.email.providers;

import javax.ws.rs.core.MediaType;

import com.email.rest.model.EmailRequest;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.core.util.MultivaluedMapImpl;


public class SparkPostMailProvider implements MailProvider {

	@Override
	public int send(EmailRequest emailRequest) {
		
	    Client client = Client.create();

	    WebResource webResource =
	        client.resource("https://api.sparkpost.com/api/v1/transmissions");
	    
	    webResource.header("Authorization", "85067f5f1fe9e56a6af81f61c6985f8bbc502106");
	    webResource.header("Content-Type", "application/json");
	    MultivaluedMapImpl formData = new MultivaluedMapImpl();
	    formData.add("from", "sandbox@sparkpostbox.com");
	    formData.add("recipients", emailRequest.getToAddress());
	    formData.add("subject", emailRequest.getSubject());
	    formData.add("text", emailRequest.getMessage());	    ClientResponse clientResponse = webResource.type(MediaType.APPLICATION_FORM_URLENCODED).
	                                                post(ClientResponse.class, formData);
	    
	    System.out.println(clientResponse.toString());
	    return clientResponse.getStatus();
	    

		
	}

}
