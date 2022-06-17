package com.example.admediation;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

import com.example.admediation.adnetworks.AdNetworkDTO;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class AdNetworkRequestTest {

  @LocalServerPort
  private int port;

  @Autowired
  private TestRestTemplate restTemplate;

  @Test
  public void getAdNetworks() {
    ResponseEntity<AdNetworkDTO[]> response = restTemplate.getForEntity("http://localhost:" + port + "/adnetwork",
        AdNetworkDTO[].class);
    AdNetworkDTO[] adNetworks = response.getBody();
    assertEquals(true, adNetworks.length > 0);
  }
}
