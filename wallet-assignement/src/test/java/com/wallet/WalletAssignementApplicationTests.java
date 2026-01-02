package com.wallet;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.web.client.RestTemplate;

import com.wallet.entity.Wallet;
import com.wallet.entity.WalletDTO;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class WalletAssignementApplicationTests {

	@Test
	void contextLoads() {
	}
	
	@LocalServerPort
	private int port;
	
	private String baseUrl = "http://localhost";
	
	private static RestTemplate restTemplate;
	
	@Autowired
	private H2Repository h2Repository;
	
	@BeforeAll
	public static void init() {
		restTemplate = new RestTemplate();
	}
	
	@BeforeEach
	public void setUp() {
		baseUrl = baseUrl.concat(":").concat(port+"").concat("/wallets");
	}

	public void testWallet() {
		WalletDTO walletDto = new WalletDTO();
		walletDto.setOperationType("DEPOSIT");
		walletDto.setAmount(1000);
		
		WalletDTO response = restTemplate.postForObject(baseUrl, walletDto, WalletDTO.class);
		
		assertEquals("10000", response.getBalance());
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
