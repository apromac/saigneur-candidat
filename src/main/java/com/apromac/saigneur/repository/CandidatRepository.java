package com.apromac.saigneur.repository;

import com.apromac.saigneur.entity.CandidatEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CandidatRepository extends JpaRepository<CandidatEntity, Long> {
}
