package com.example.admediation;

import com.example.admediation.adnetworks.AdNetwork;
import com.example.admediation.adnetworks.AdNetworkRepository;
import com.example.admediation.adunits.AdUnit;
import com.example.admediation.adunits.AdUnitRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LoadDatabase {

  private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

  @Bean
  CommandLineRunner initDatabase(AdNetworkRepository adNetworkRepository, AdUnitRepository adUnitRepository) {

    return args -> {
      // Admob
      AdNetwork adMob = new AdNetwork(1L, "AdMob", 9);
      log.info("Preloading " + adNetworkRepository.save(adMob));
      log.info("Preloading " + adUnitRepository.save(new AdUnit("US", 1, adMob)));
      // Facebook
      AdNetwork facebook = new AdNetwork(2L, "Facebook", null);
      log.info("Preloading " + adNetworkRepository.save(facebook));
      log.info("Preloading " + adUnitRepository.save(new AdUnit("SI", 2, facebook)));
    };
  }
}