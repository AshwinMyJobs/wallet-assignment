package com.wallet.aop;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import com.wallet.exception.WalletException;

@Component
@RestController
@ControllerAdvice
public class WalletExceptionHandler {

	@ExceptionHandler(value = WalletException.class)
	public ResponseEntity<Object> handleNoValidOperrationFoundExcepton(WalletException e) {
		System.out.println("Inside exception handler..............");
		System.out.println(e.getCode());

		String errorCode = e.getCode();
		String errorMessage = e.getExceptionMessage();

		ApiError apiError = new ApiError();

		switch (errorCode) {
		case "400":
			apiError = new ApiError(400, "No Valid OperationType Found", new Date());
			//return new ResponseEntity<Object>(apiError, HttpStatus.EXPECTATION_FAILED);
			break;
		case "401":
			apiError = new ApiError(401, "Non existing wallet id", new Date());
			//return new ResponseEntity<Object>(apiError, HttpStatus.EXPECTATION_FAILED);
			break;
		case "403":
			apiError = new ApiError(403, "In sufficient funds", new Date());
			//return new ResponseEntity<Object>(apiError, HttpStatus.EXPECTATION_FAILED);
			break;
		case "404":
			apiError = new ApiError(404, "In valid json", new Date());
			//return new ResponseEntity<Object>(apiError, HttpStatus.EXPECTATION_FAILED);
			break;

		default:
			throw new IllegalArgumentException("Unexpected value: " + errorCode);

		}
		return new ResponseEntity<Object>(apiError, HttpStatus.BAD_GATEWAY);
	}
}
