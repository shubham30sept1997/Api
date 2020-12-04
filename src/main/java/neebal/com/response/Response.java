package neebal.com.response;

import neebal.com.entity.User;

public class Response {
	
	String invalidResponse;

	public String getInvalidResponse() {
		return invalidResponse;
	}

	public void setInvalidResponse(String invalidResponse) {
		this.invalidResponse = invalidResponse;
	}

	public Response() {
		super();
	}

	public Response(String invalidResponse) {

		this.invalidResponse = invalidResponse;
	}

	

}
