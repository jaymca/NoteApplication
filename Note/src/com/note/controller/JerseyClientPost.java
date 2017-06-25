package com.note.controller;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class JerseyClientPost {
	public static void main(String[] args) {

		try {
			Client client = Client.create();
			WebResource webResource = client.resource("http://localhost:8080/Note/createNote");

			String input = "{\"noteId\":3,\"title\":\"UI Testing\",\"noteDesc\":\"UI Testing going on\",\"createTime\":\"Jun 18, 2017 9:51:53 PM\",\"lastUpdateTime\":\"Jun 18, 2017 9:51:53 PM\",\"user\":{\"userId\":1}}";

			ClientResponse response = webResource.type("application/json").post(ClientResponse.class, input);

			if (response.getStatus() != 201) {
				throw new RuntimeException("Failed : HTTP error code : "
				     + response.getStatus());
			}

			System.out.println("Output from Server .... \n");
			String output = response.getEntity(String.class);
			System.out.println(output);

		  } catch (Exception e) {

			e.printStackTrace();

		  }

		}
}
