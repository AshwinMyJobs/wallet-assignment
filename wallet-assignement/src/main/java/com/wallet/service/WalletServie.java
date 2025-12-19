package com.wallet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wallet.entity.Wallet;
import com.wallet.repository.WalletRepository;

@Service
public class WalletServie {

	@Autowired
	WalletRepository walletRepository;
	
	public Wallet saveWallet(Wallet wallet) {
		return walletRepository.save(wallet);
	}
}
