package com.ibnj.acaosocial.exception;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllException(
			Exception ex, WebRequest request
			){
				List<String> detalhes = new ArrayList<>();
				detalhes.add(ex.getLocalizedMessage());
				HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
				ErrorResponse error = new ErrorResponse(httpStatus.value(),
						"Erro ao processar a requisição", detalhes);
				
				return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}	
	
	@ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<Object> handleNoSuchElementException(
    		final NoSuchElementException ex,
            final WebRequest request) {
		List<String> detalhes = new ArrayList<>();
		detalhes.add(ex.getLocalizedMessage());
		ErrorResponse error = new ErrorResponse(HttpStatus.NOT_FOUND.value(), 
				"O Registro buscado não foi encontrado", detalhes);

		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
	
	@ExceptionHandler(NoSuchElementFoundException.class)
	public final ResponseEntity<Object> handleNoSuchElementFoundException(
			NoSuchElementFoundException ex, WebRequest request
	){
		List<String> detalhes = new ArrayList<>();
		detalhes.add(ex.getLocalizedMessage());
		HttpStatus httpStatus = HttpStatus.NOT_FOUND;
		ErrorResponse error = new ErrorResponse(httpStatus.value(), 
				"O Registro buscado não foi encontrado", detalhes);
		
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
	/** /
	@ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<Object> handleNoSuchElementException(
    		final NoSuchElementException ex,
            final WebRequest request) {
		List<String> detalhes = new ArrayList<>();
		detalhes.add(ex.getLocalizedMessage());
		ErrorResponse error = new ErrorResponse(HttpStatus.NOT_FOUND.value(), 
				"O Registro buscado não foi encontrado", detalhes);
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }*/
	
}
