package com.wallet.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wallet.entity.WalletDTO;
import com.wallet.service.WalletServie;

@RestController
@RequestMapping(value = "/api/v1")
public class WalletController {

	@Autowired
	WalletServie walletServie;

	@PostMapping("/wallet")
	public ResponseEntity<Object> saveWallet(@RequestBody WalletDTO walletDTO) {
		System.out.println("Inside the controller ...........");
		HttpHeaders headers = new HttpHeaders();
		headers.add("Custom-Header", "Custom-Value");
		try {
			return ResponseEntity.ok().header("Custom-Header", "Custom-Value").body(walletServie.saveWallet(walletDTO));
		} catch (Exception e) {
			return ResponseEntity.ok().header("Custom-Header", "Custom-Value").body(e.getMessage());
		}
	}
	
	@GetMapping("/wallets/{WALLET_UUID}")
	public ResponseEntity<Object> getWalletBalance(@PathVariable UUID WALLET_UUID){
		System.out.println(WALLET_UUID);
		
		return ResponseEntity.ok().body(walletServie.getWalletBalance(WALLET_UUID));
	}
}
