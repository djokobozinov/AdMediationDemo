package com.example.admediation.adunits;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdUnitController {

  private AdUnitRepository adUnitRepository;

  public AdUnitController(AdUnitRepository adUnitRepository) {
    this.adUnitRepository = adUnitRepository;
  }

  @GetMapping("/adunit")
  public List<AdUnitDTO> filter(@RequestParam(required = false) String countryCode,
      @RequestParam(required = false) Integer osVersion) {
    List<AdUnit> adUnits = adUnitRepository.filter(countryCode, osVersion);
    return adUnits.stream()
        .map(AdUnitDTO::convertToDto)
        .collect(Collectors.toList());
  }

}
