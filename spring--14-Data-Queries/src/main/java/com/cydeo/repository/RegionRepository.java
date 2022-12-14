package com.cydeo.repository;

import com.cydeo.entity.Region;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RegionRepository extends JpaRepository<Region,Integer> {

    //Display all regions in Canada
    List<Region> findByCountry(String Country);


    //Display all regions with country name includes 'United'
    List<Region> findByCountryContains(String CountryName);


    //Display all regions with country name includes 'United' in order(region)
    List<Region> findByCountryContainsOrderByRegion(String country);


    //Display top 2 regions in United States
    List<Region>findTopByCountry(String Country);
    List<Region>findTop2ByCountry(String Country);


    //Display all regions with country name includes 'United' in order(region)
    List<Region>findTop3ByCountry(String Country);


    List<Region> findTopByCountryContainsOrderByRegion(String country);



}
