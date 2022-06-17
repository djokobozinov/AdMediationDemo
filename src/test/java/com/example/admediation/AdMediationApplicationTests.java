package com.example.admediation;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.admediation.adnetworks.AdNetworkController;

@SpringBootTest
class AdMediationApplicationTests {

	@Autowired
	AdNetworkController adNetworkController;

	@Test
	void contextLoads() {
		assertNotNull(adNetworkController);
	}

}
