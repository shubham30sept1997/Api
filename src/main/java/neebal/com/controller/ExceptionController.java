package neebal.com.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import neebal.com.response.Response;

@ControllerAdvice
public class ExceptionController {

	
	@ExceptionHandler(value= {Exception.class})
	public ResponseEntity<Object> handleAnyException(Exception ex,WebRequest request)
	{
		String errorMessage = ex.getLocalizedMessage();
		if(errorMessage==null) errorMessage = ex.toString();
		Response loginResponse = new Response(errorMessage);
		return new ResponseEntity<>
		(loginResponse,new HttpHeaders(),HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
