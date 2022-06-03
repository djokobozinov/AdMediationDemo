package com.example.admediation.adnetworks;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
public class AdNetworkController {

  private AdNetworkRepository adNetworkRepository;

  AdNetworkController(AdNetworkRepository adNetworkRepository) {
    this.adNetworkRepository = adNetworkRepository;
  }

  @GetMapping("/adnetwork")
  public List<AdNetwork> all() {
    return adNetworkRepository.findAll();
  }

  @PostMapping("/adnetwork")
  public AdNetwork createAdNetwork(@RequestBody AdNetwork adNetwork) {
    return adNetwork;
  }
}
