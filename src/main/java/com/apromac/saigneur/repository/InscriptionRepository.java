package com.apromac.saigneur.repository;

import com.apromac.saigneur.entity.CampagneEntity;
import com.apromac.saigneur.entity.CandidatEntity;
import com.apromac.saigneur.entity.InscriptionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InscriptionRepository extends JpaRepository<InscriptionEntity, String> {
    List<InscriptionEntity> findByCampagne(CampagneEntity campagne);
    List<InscriptionEntity> findByCandidat(CandidatEntity candidat);
    List<InscriptionEntity> findByCampagneAndCandidat(CampagneEntity campagne, CandidatEntity candidat);
}
