package com.example.admediation.adnetworks;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.example.admediation.adunits.AdUnit;

/**
 * AdNetwork hold data about the ad network SDK e.q. AdMob
 * and the details related to specific SDK.
 */
@Entity
public class AdNetwork {
  private @Id Long id;
  private String name;
  private int minAndroidOsVersion = 1;
  private String blockedCountries;
  private Long priorityNetworkId;
  @OneToMany(mappedBy = "adNetwork")
  private List<AdUnit> adUnits = new ArrayList<>();

  public AdNetwork() {
  }

  public AdNetwork(Long id, String name, int minAndroidOsVersion) {
    this.id = id;
    this.name = name;
    this.minAndroidOsVersion = minAndroidOsVersion;
  }

  public Long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getMinAndroidOsVersion() {
    return minAndroidOsVersion;
  }

  public void setMinAndroidOsVersion(Integer minAndroidOsVersion) {
    this.minAndroidOsVersion = minAndroidOsVersion;
  }

  public String getBlockedCountries() {
    return blockedCountries;
  }

  /**
   * If AdNetwork get blocked in some countrie it should be writen e.q. "US, CN"
   */
  public void setBlockedCountries(String blockedCountries) {
    this.blockedCountries = blockedCountries;
  }

  public Long getPriorityNetworkId() {
    return priorityNetworkId;
  }

  /**
   * Should be set only if AdNetwork does not need to coexist with other AdNetwork
   * that has higher priority.
   * (e.q. Admob and AdMob-OptOut don't go together)
   */
  public void setPriorityNetworkId(Long priorityNetworkId) {
    this.priorityNetworkId = priorityNetworkId;
  }

  public List<AdUnit> getAdUnits() {
    return adUnits;
  }

  public void setAdUnits(List<AdUnit> adUnits) {
    this.adUnits = adUnits;
  }
}
