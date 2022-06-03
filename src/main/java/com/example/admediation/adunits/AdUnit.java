package com.example.admediation.adunits;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.example.admediation.adnetworks.AdNetwork;

/**
 * AdUnit holds data about diferent instances of the ads that are displayed from
 * every network.
 * Diferent types like banner or interestial and for different countries.
 * AdUnit also holds data for the priority score of every unit.
 */
@Entity
public class AdUnit {
  private @Id @GeneratedValue Long id;
  private String countryCode;
  private int priority = 0;
  @ManyToOne
  @JoinColumn(name = "ADNETWORK_ID")
  private AdNetwork adNetwork;

  public AdUnit() {
  }

  public AdUnit(String countryCode, int priority, AdNetwork adNetwork) {
    this.countryCode = countryCode;
    this.priority = priority;
    this.adNetwork = adNetwork;
  }

  public Long getId() {
    return id;
  }

  public String getCountryCode() {
    return countryCode;
  }

  public void setCountryCode(String countryCode) {
    this.countryCode = countryCode;
  }

  public int getPriority() {
    return priority;
  }

  public void setPriority(int priority) {
    this.priority = priority;
  }

  public AdNetwork getAdNetwork() {
    return adNetwork;
  }

  public void setAdNetwork(AdNetwork adNetwork) {
    this.adNetwork = adNetwork;
  }

}
