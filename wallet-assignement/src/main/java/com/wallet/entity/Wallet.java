package com.wallet.entity;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Wallet {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID walletId; 
	
	@Column
	String operationType;
		
	@Column
	Integer balance;
}
