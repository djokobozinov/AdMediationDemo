package com.example.admediation.adunits;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdUnitController {

  @Autowired
  private AdUnitRepository adUnitRepository;

  @GetMapping("/adunit")
  public List<AdUnitDTO> filter(@RequestParam(required = false) String countryCode,
      @RequestParam(required = false) Integer osVersion) {
    List<AdUnit> adUnits = adUnitRepository.filter(countryCode, osVersion);
    adUnits = AdUnitHelper.filterPriorityNetworks(adUnits);
    // In case list is empty, get all ad units.
    // Non optimal order is better than empty list is specified in the task.
    if (adUnits == null || adUnits.isEmpty()) {
      adUnits = adUnitRepository.findAll();
    }
    return adUnits.stream()
        .map(AdUnitDTO::convertToDto)
        .collect(Collectors.toList());
  }

  @PutMapping("/adunit")
  public ResponseEntity<String> update(@RequestBody List<AdUnitDTO> adUnitsParam) {
    // generate list of ids from dtos, to load the entites from database
    Set<Long> ids = adUnitsParam.stream().map(au -> au.getId()).collect(Collectors.toSet());
    // load existing entites from database
    List<AdUnit> adUnits = adUnitRepository.findAllById(ids);
    // create list that need to be updated, only exsiting AdUnits will be updated
    List<AdUnit> updateList = new ArrayList<>();
    for (Long id : ids) {
      AdUnitDTO adUnitDto = adUnitsParam.stream().filter(au -> au.getId() == id).findFirst().get();
      Optional<AdUnit> adUnitOptional = adUnits.stream().filter(au -> au.getId() == id).findFirst();
      if (!adUnitOptional.isPresent()) {
        return new ResponseEntity<>(
            "AdUnit with id " + id + " not exist and cannot be updated!",
            HttpStatus.BAD_REQUEST);
      }
      AdUnit adUnitToUpdate = adUnitOptional.get();
      adUnitToUpdate.setPriority(adUnitDto.getPriority());
      updateList.add(adUnitToUpdate);
    }
    adUnitRepository.saveAllAndFlush(updateList);
    return new ResponseEntity<>(
        "Successfully updated all ad units",
        HttpStatus.OK);
  }
}
