package com.apromac.saigneur.repository;

import com.apromac.saigneur.entity.CampagneEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CampagneRepository extends JpaRepository<CampagneEntity, Long> {
}
