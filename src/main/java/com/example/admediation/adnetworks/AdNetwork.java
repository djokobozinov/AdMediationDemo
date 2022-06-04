package com.example.admediation.adnetworks;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * AdNetwork hold data about the ad network SDK e.q. AdMob 
 * and the details related to specific SDK.
 */
@Entity
public class AdNetwork {
  private @Id Long id;
  private String name;
  private int minAndroidOsVersion = 1;

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
}
