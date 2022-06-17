package com.example.admediation;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

import com.example.admediation.adunits.AdUnitDTO;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class AdUnitRequestTest {

  @LocalServerPort
  private int port;

  @Autowired
  private TestRestTemplate restTemplate;

  @Test
  public void getAdUnitsByCountryCode() {
    ResponseEntity<AdUnitDTO[]> response = restTemplate.getForEntity(
        "http://localhost:" + port + "/adunit?countryCode=SI",
        AdUnitDTO[].class);
    AdUnitDTO[] adUnits = response.getBody();
    assertEquals(true, adUnits.length > 0);
    assertEquals("SI", adUnits[0].getCountryCode());
  }
}
