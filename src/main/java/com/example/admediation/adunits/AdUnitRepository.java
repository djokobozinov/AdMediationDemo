package com.example.admediation.adunits;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AdUnitRepository extends JpaRepository<AdUnit, Long> {

  @Query("SELECT adUnit FROM AdUnit adUnit WHERE :countryCode is null or adUnit.countryCode = :countryCode ORDER BY adUnit.priority DESC")
  public List<AdUnit> filter(@Param("countryCode") String countryCode);

}
