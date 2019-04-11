package com.xy.pois.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.xy.pois.domain.POI;

@Repository
public interface POIsRepository extends JpaRepository<POI, Long>{

}
