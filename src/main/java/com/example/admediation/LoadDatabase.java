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
      log.info("Preloading test data started!");

      // Admob
      AdNetwork adMob = new AdNetwork(1L, "AdMob", 9);
      adNetworkRepository.save(adMob);
      adUnitRepository.save(new AdUnit("US", 78, adMob));
      adUnitRepository.save(new AdUnit("DE", 56, adMob));
      // Facebook
      AdNetwork facebook = new AdNetwork(2L, "Facebook", 8);
      adNetworkRepository.save(facebook);
      adUnitRepository.save(new AdUnit("SI", 25, facebook));
      // Unity
      AdNetwork unity = new AdNetwork(3L, "Unity", 1);
      adNetworkRepository.save(unity);
      adUnitRepository.save(new AdUnit("US", 12, unity));
      adUnitRepository.save(new AdUnit("DE", 34, unity));

      log.info("Preloading test data finished!");
    };
  }
}