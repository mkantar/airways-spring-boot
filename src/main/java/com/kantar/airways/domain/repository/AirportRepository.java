package com.kantar.airways.domain.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kantar.airways.domain.entity.AirportEntity;

@Repository
public interface AirportRepository extends JpaRepository<AirportEntity, Long> {

    Optional<AirportEntity> findByName(String name);

    List<AirportEntity> findByCity(String city);

}
