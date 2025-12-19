package com.wallet.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wallet.entity.Wallet;

@Repository
public interface WalletRepository extends JpaRepository<Wallet, UUID> {

}
