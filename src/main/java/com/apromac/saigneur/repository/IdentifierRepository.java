package com.apromac.saigneur.repository;

import com.apromac.saigneur.entity.CampagneEntity;
import com.apromac.saigneur.entity.CandidatEntity;
import com.apromac.saigneur.entity.IdentifierEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IdentifierRepository extends JpaRepository<IdentifierEntity, String> {
    List<IdentifierEntity> findByCampagne(CampagneEntity campagne);
    List<IdentifierEntity> findByCandidat(CandidatEntity candidat);
    List<IdentifierEntity> findByCampagneAndCandidat(CampagneEntity campagne, CandidatEntity candidat);
}
