package com.wallet.service;

import java.util.UUID;

import javax.management.openmbean.InvalidOpenTypeException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.wallet.entity.Wallet;
import com.wallet.entity.WalletDTO;
import com.wallet.repository.WalletRepository;

import jakarta.transaction.Transactional;

@Service
public class WalletServie {

	@Autowired
	WalletRepository walletRepository;

	@Transactional
	@Async
	public Wallet saveWallet(WalletDTO walletDTO) throws Exception {

		Wallet wallet = new Wallet();
 
		UUID walletId = walletDTO.getWalletId();
		Integer amount = walletDTO.getAmount();
		Integer balance = 0;

		if (walletId==null) {
			wallet.setBalance(amount);
			wallet.setOperationType(walletDTO.getOperationType());
			return walletRepository.save(wallet);
		} else {

			switch (walletDTO.getOperationType()) {
			case "DEPOSIT":
				wallet = walletRepository.getReferenceById(walletDTO.getWalletId());
				balance = wallet.getBalance();
				wallet.setBalance(balance + amount);
				wallet.setOperationType("DEPOSIT");
				wallet = walletRepository.save(wallet);
				break;
			case "WITHDRAW":
				wallet = walletRepository.getReferenceById(walletDTO.getWalletId());
				balance = wallet.getBalance();
				wallet.setBalance(balance - amount);
				wallet.setOperationType("WITHDRAW");
				wallet = walletRepository.save(wallet);
				break;
			default:
				throw new Exception("No valid operation type");
			}
		}

		return wallet;
	}

	@GetMapping()
	@Async
	public Integer getWalletBalance(UUID walletId) {
		return walletRepository.getReferenceById(walletId).getBalance();
	}

}
