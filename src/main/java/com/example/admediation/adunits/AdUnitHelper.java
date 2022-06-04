package com.example.admediation.adunits;

import java.util.ArrayList;
import java.util.List;

public class AdUnitHelper {
  /**
   * This part of the code I will probably handle differently in production.
   * Helper method that will exclude AdUnits that not need to coesxist with
   * another AdUnit from another AdNetwork.
   */
  public static List<AdUnit> filterPriorityNetworks(List<AdUnit> adUnits) {
    List<AdUnit> listToRemove = new ArrayList<>();
    for (AdUnit adUnit : adUnits) {
      Long priorityNetwork = adUnit.getAdNetwork().getPriorityNetworkId();
      if (priorityNetwork == null) {
        continue;
      }
      if (isPriorityNetworkAdInList(adUnits, priorityNetwork)) {
        listToRemove.add(adUnit);
      }
    }
    adUnits.removeAll(listToRemove);
    return adUnits;
  }

  private static boolean isPriorityNetworkAdInList(List<AdUnit> adUnits, Long priorityNetwork) {
    for (AdUnit adUnit : adUnits) {
      if (adUnit.getAdNetwork().getId() == priorityNetwork) {
        return true;
      }
    }
    return false;
  }
}
