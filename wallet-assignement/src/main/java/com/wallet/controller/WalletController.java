package com.wallet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wallet.entity.Wallet;
import com.wallet.service.WalletServie;

@Controller
@RequestMapping(value = "/api/wallet/")
public class WalletController {

	@Autowired
	WalletServie walletServie;
	
	@PostMapping(value = "/save")
	public ResponseEntity<Wallet> saveWallet(@RequestBody Wallet wallet) {
//		return walletServie.saveWallet(wallet);
		HttpHeaders headers = new HttpHeaders();
		headers.add("Custom-Header", "1234567890");
		
//		return ResponseEntity<>(walletServie.saveWallet(wallet), headers, HttpStatus.OK);
		return ResponseEntity.ok().header("Custom-Header", "Custom-Value").body(walletServie.saveWallet(wallet));
	}
}
