package com.kantar.airways.domain.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.kantar.airways.domain.entity.CourseEntity;

@Repository
public interface CourseRepository extends JpaRepository<CourseEntity, Long> {
	
	@Query("select c from CourseEntity c where c.originAirport.id = :originId and c.destinationAirport.id = :destinationId")
	Optional<CourseEntity> findByOriginIdAndDestinationId(Long originId, Long destinationId);
	
}
