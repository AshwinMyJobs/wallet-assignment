package com.wallet.aop;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import com.wallet.exception.InvalidOperrationTypeException;

//@RestController
@ControllerAdvice
public class WalletExceptionHandler {

//	@ExceptionHandler(value = InvalidOperrationTypeException.class)
	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<ApiError> handleNoValidOperrationFoundExcepton(){
		System.out.println("Inside exception handler..............");
		ApiError apiError = new ApiError(500, "No Valid OperationType Found", new Date());
		return new ResponseEntity<ApiError>(apiError, HttpStatus.LOCKED);
	}
}
