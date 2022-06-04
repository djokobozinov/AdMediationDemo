package com.example.admediation.adunits;

import java.util.List;

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
  public List<AdUnit> filter(@RequestParam(required = false) String countryCode,
      @RequestParam(required = false) Integer osVersion) {
    return adUnitRepository.filter(countryCode, osVersion);
  }

}
