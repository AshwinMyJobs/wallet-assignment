package com.wallet.aop;

import java.util.Date;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Component
@AllArgsConstructor
@NoArgsConstructor
public class ApiError {

	int statusCode;
	String errorMessage;
	Date date;
	
}
