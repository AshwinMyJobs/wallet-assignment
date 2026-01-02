package com.wallet.repository;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.wallet.entity.Wallet;

@DataJpaTest
public class WalletRepositoryTest {

	@Autowired
	private WalletRepository walletRepository;
	
//	@Test
//    public void givenWalletObject_whenSave_thenReturnSavedStudent() {
//        Wallet wallet = new Wallet();
//        
//        wallet.setWalletId(UUID.randomUUID());
//        wallet.setOperationType("DEPOSIT");
//        wallet.setBalance(100);
//        
//        
//
//        Wallet savedWallet = walletRepository.save(wallet);
//
//        assertNotNull(savedWallet);
//        assertNotNull(savedWallet.getWalletId());
//    }
	
}
