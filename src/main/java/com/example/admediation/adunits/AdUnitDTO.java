package com.example.admediation.adunits;

public class AdUnitDTO {
  private Long id;
  private String countryCode;
  private int priority;
  private AdType type;
  private String adNetwork;

  public AdUnitDTO() {
  }

  public AdUnitDTO(Long id, String countryCode, int priority, AdType type, String adNetwork) {
    this.id = id;
    this.countryCode = countryCode;
    this.priority = priority;
    this.type = type;
    this.adNetwork = adNetwork;
  }

  public static AdUnitDTO convertToDto(AdUnit adUnit) {
    return new AdUnitDTO(adUnit.getId(), adUnit.getCountryCode(), adUnit.getPriority(), adUnit.getAdType(),
        adUnit.getAdNetwork().getName());
  }

  public Long getId() {
    return id;
  }

  public String getCountryCode() {
    return countryCode;
  }

  public int getPriority() {
    return priority;
  }

  public AdType getType() {
    return type;
  }

  public String getAdNetwork() {
    return adNetwork;
  }
}
