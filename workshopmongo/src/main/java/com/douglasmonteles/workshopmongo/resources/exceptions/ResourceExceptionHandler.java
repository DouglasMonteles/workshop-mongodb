package com.douglasmonteles.workshopmongo.resources.exceptions;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.douglasmonteles.workshopmongo.services.exceptions.ObjectNotFoundException;

@ControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException exception, 
			HttpServletRequest request) {
		var status = HttpStatus.NOT_FOUND;
		var error = new StandardError(
			System.currentTimeMillis(), 
			status.value(), 
			"Não encontrado", 
			exception.getMessage(), 
			request.getRequestURI()
		);
		
		return ResponseEntity.status(status).body(error);
	}
	
}
