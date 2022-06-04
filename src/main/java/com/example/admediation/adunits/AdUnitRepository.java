package com.example.admediation.adunits;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AdUnitRepository extends JpaRepository<AdUnit, Long> {

  @Query("SELECT au, an FROM AdUnit au JOIN au.adNetwork an " +
      "WHERE (:countryCode is null or au.countryCode = :countryCode) " +
      "AND (:osVersion is null OR an.minAndroidOsVersion <= :osVersion) " +
      "ORDER BY au.priority DESC")
  public List<AdUnit> filter(@Param("countryCode") String countryCode, @Param("osVersion") Integer osVersion);

}
