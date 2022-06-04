package com.example.admediation.adnetworks;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.example.admediation.adunits.AdUnit;
import com.example.admediation.adunits.AdUnitDTO;

public class AdNetworkDTO {
  private Long id;
  private String name;
  private int minAndroidOsVersion;
  private String blockedCountries;
  private Long priorityNetworkId;
  private List<AdUnitDTO> adUnits;

  public AdNetworkDTO() {
  }

  public AdNetworkDTO(Long id, String name, int minAndroidOsVersion, String blockedCountries,
      Long priorityNetworkId, List<AdUnit> adUnits) {
    this.id = id;
    this.name = name;
    this.minAndroidOsVersion = minAndroidOsVersion;
    this.blockedCountries = blockedCountries;
    this.priorityNetworkId = priorityNetworkId;
    this.adUnits = convertAdUnitsToDTOs(adUnits);
  }

  private List<AdUnitDTO> convertAdUnitsToDTOs(List<AdUnit> adUnits) {
    return adUnits.stream()
        .map(AdUnitDTO::convertToDashboardDto)
        .sorted(Comparator.comparingInt(AdUnitDTO::getPriority).reversed())
        .collect(Collectors.toList());
  }

  public static AdNetworkDTO convertToDto(AdNetwork adNetwork) {
    return new AdNetworkDTO(adNetwork.getId(), adNetwork.getName(), adNetwork.getMinAndroidOsVersion(),
        adNetwork.getBlockedCountries(), adNetwork.getPriorityNetworkId(), adNetwork.getAdUnits());
  }

  public Long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public int getMinAndroidOsVersion() {
    return minAndroidOsVersion;
  }

  public String getBlockedCountries() {
    return blockedCountries;
  }

  public Long getPriorityNetworkId() {
    return priorityNetworkId;
  }

  public List<AdUnitDTO> getAdUnits() {
    return adUnits;
  }
}
