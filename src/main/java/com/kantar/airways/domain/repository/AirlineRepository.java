package com.kantar.airways.domain.repository;

import com.kantar.airways.domain.entity.AirlineEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirlineRepository extends JpaRepository<AirlineEntity, Long> {

    AirlineEntity findByCompany(String company);

}
