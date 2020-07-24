package com.kantar.airways.domain.repository;

import com.kantar.airways.domain.entity.AirportEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AirportRepository extends JpaRepository<AirportEntity, Long> {

    AirportEntity findByName(String name);

    List<AirportEntity> findByCity(String city);

}
