package com.bl.addressbook.validation;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.bl.addressbook.dto.AddressResponseDTO;

@ControllerAdvice
public class AddressBookControllerValidation extends ResponseEntityExceptionHandler{

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		List<String> errors = ex.getBindingResult().getAllErrors().stream().map(objErr-> objErr.getDefaultMessage()).collect(Collectors.toList());
		AddressResponseDTO response = new AddressResponseDTO("Error while performing REST Operation", errors);
		return new ResponseEntity<Object>(response, HttpStatus.BAD_REQUEST);
	}
}
