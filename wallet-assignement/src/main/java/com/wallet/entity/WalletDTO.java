package com.wallet.entity;

import java.util.UUID;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@AllArgsConstructor
@NoArgsConstructor
@Data
public class WalletDTO {

    private UUID walletId; 
	
	String operationType;
	
	Integer amount;

	Integer balance;
}
