package com.email.providers;

import javax.ws.rs.core.MediaType;

import com.email.rest.model.EmailRequest;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.filter.HTTPBasicAuthFilter;
import com.sun.jersey.core.util.MultivaluedMapImpl;


public class MailGunMailProvider implements MailProvider {

	@Override
	public int send(EmailRequest emailRequest) {
		
	    Client client = Client.create();
	    client.addFilter(new HTTPBasicAuthFilter("api",
	                "key-7c4d53a2125eccfffdb1c517b4b5d4fc"));
	    WebResource webResource =
	        client.resource("https://api.mailgun.net/v3/sandbox6b6530d229ba4da2b8f0b2b7b8557ac1.mailgun.org/messages");
	    MultivaluedMapImpl formData = new MultivaluedMapImpl();
	    formData.add("from", "Mailgun Sandbox <postmaster@sandbox6b6530d229ba4da2b8f0b2b7b8557ac1.mailgun.org>");
	    formData.add("to", emailRequest.getToAddress());
	    formData.add("subject", emailRequest.getSubject());
	    formData.add("text", emailRequest.getMessage());
	    ClientResponse clientResponse = webResource.type(MediaType.APPLICATION_FORM_URLENCODED).
	                                                post(ClientResponse.class, formData);
	    
	    System.out.println(clientResponse.toString());
	    return clientResponse.getStatus();

		
	}

}
