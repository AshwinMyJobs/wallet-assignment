package com.wallet.controller;

import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wallet.aop.ApiError;
import com.wallet.entity.WalletDTO;
import com.wallet.exception.InvalidOperrationTypeException;
import com.wallet.service.WalletServie;

@RestController
@RequestMapping(value = "/api/v1")
public class WalletController {

	@Autowired
	WalletServie walletServie;

//	@PostMapping("/wallet")
//	public ResponseEntity<Object> saveWallet(@RequestBody WalletDTO walletDTO) {
//		System.out.println("Inside the controller ...........");
//		HttpHeaders headers = new HttpHeaders();
//		headers.add("Custom-Header", "Custom-Value");
//		try {
//			return ResponseEntity.ok().header("Custom-Header", "Custom-Value").body(walletServie.saveWallet(walletDTO));
//		} catch (Exception e) {
//			return ResponseEntity.ok().header("Custom-Header", "Custom-Value").body(e.getMessage());
//		}
//	}
	
	@PostMapping("/wallet")
	public ResponseEntity<Object> saveWallet(@RequestBody WalletDTO walletDTO) throws Exception {
		System.out.println("Inside the controller ...........");
		HttpHeaders headers = new HttpHeaders();
		headers.add("Custom-Header", "Custom-Value");

		return ResponseEntity.ok().header("Custom-Header", "Custom-Value").body(walletServie.saveWallet(walletDTO));

	}
	
	@GetMapping("/wallets/{WALLET_UUID}")
	public ResponseEntity<Object> getWalletBalance(@PathVariable UUID WALLET_UUID){
		System.out.println(WALLET_UUID);
		
		return ResponseEntity.ok().body(walletServie.getWalletBalance(WALLET_UUID));
	}
	
	@ExceptionHandler(value = InvalidOperrationTypeException.class)
	public ResponseEntity<ApiError> handleNoValidOperrationFoundExcepton(){
		System.out.println("Inside exception handler method..............");
		ApiError apiError = new ApiError(400, "No Valid OperationType Found", new Date());
		return new ResponseEntity<ApiError>(apiError, HttpStatus.BAD_REQUEST);
	}
}
