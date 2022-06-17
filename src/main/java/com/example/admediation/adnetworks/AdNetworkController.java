package com.example.admediation.adnetworks;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdNetworkController {

  @Autowired
  private AdNetworkRepository adNetworkRepository;

  @GetMapping("/adnetwork")
  public List<AdNetworkDTO> all() {
    List<AdNetwork> adNetworks = adNetworkRepository.findAll();
    return adNetworks.stream()
        .map(AdNetworkDTO::convertToDto)
        .collect(Collectors.toList());
  }
}
