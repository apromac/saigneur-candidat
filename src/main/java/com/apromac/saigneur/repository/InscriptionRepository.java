package com.apromac.saigneur.repository;

import com.apromac.saigneur.entity.CampagneEntity;
import com.apromac.saigneur.entity.CandidatEntity;
import com.apromac.saigneur.entity.InscriptionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InscriptionRepository extends JpaRepository<InscriptionEntity, Long> {
    List<InscriptionEntity> findByCampagne(CampagneEntity campagneEntity);
    InscriptionEntity findByCandidatAndCampagne(CandidatEntity candidatEntity, CampagneEntity campagneEntity);
    List<InscriptionEntity> findByCampagneAndStatut(CampagneEntity campagneEntity, Integer statutCandidat);




//    List<InscriptionEntity> findByCampagneAndIsSelectionnerTrue(CampagneEntity campagneEntity);
//    List<InscriptionEntity> findByCampagneAndIsSelectionnerFalse(CampagneEntity campagneEntity);
//    List<InscriptionEntity> findByCampagneAndIsInterviewTrue(CampagneEntity campagneEntity);
//    List<InscriptionEntity> findByCampagneAndIsRetenuTrue(CampagneEntity campagneEntity);

















    List<InscriptionEntity> findByCandidat(CandidatEntity candidat);
    List<InscriptionEntity> findByCampagneAndCandidat(CampagneEntity campagne, CandidatEntity candidat);

}
