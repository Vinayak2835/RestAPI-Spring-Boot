package com.crud.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.crud.responses.APIResponse;

@RestControllerAdvice
public class GlobalException {

	@ExceptionHandler(value = ResourceNotFoundException.class)
	public ResponseEntity<APIResponse> handleResourceNotFoundException(ResourceNotFoundException exception) {

		APIResponse apiResponse = new APIResponse(exception.getMessage(), false);

		return new ResponseEntity<APIResponse>(apiResponse, HttpStatus.NOT_FOUND);

	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(value = MethodArgumentNotValidException.class)
	public Map<String, String> methodArgumentNotValidException(MethodArgumentNotValidException exception) {

		Map<String, String> errorMap = new HashMap<String, String>();

		exception.getBindingResult().getFieldErrors().forEach(error -> {
			errorMap.put(error.getField(), error.getDefaultMessage());
		});
		return errorMap;
	}
	
	@ExceptionHandler(value = WrongpasswordFormatexception.class)
	public ResponseEntity<APIResponse> wrongpasswordFormatexception(WrongpasswordFormatexception exception) {

		APIResponse apiResponse = new APIResponse(exception.getMessage(), false);

		return new ResponseEntity<APIResponse>(apiResponse, HttpStatus.BAD_REQUEST);

	}

}
