package com.kantar.airways.domain.repository;

import com.kantar.airways.domain.entity.AirlineEntity;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirlineRepository extends JpaRepository<AirlineEntity, Long> {

	Optional<AirlineEntity> findByCompany(String company);

}
