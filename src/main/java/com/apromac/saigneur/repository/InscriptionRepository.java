package com.apromac.saigneur.repository;

import com.apromac.saigneur.entity.CampagneEntity;
import com.apromac.saigneur.entity.InscriptionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InscriptionRepository extends JpaRepository<InscriptionEntity, Long> {
    List<InscriptionEntity> findByCampagneAndStatutAndDistrictInscription(CampagneEntity campagneEntity, Integer statutCandidat, String districtCandidat);
    List<InscriptionEntity> findByCampagneAndStatut(CampagneEntity campagneEntity, Integer statutCandidat);
    List<InscriptionEntity> findByStatutAndZoneInscriptionAndIsInterviewerFalse(Integer statutCandidat, String zoneCandidat);
    List<InscriptionEntity> findByCampagne(CampagneEntity campagneEntity);
}

//
//
//    InscriptionEntity findByCandidatAndCampagne(CandidatEntity candidatEntity, CampagneEntity campagneEntity);
//    List<InscriptionEntity> findByCampagneAndStatut(CampagneEntity campagneEntity, Integer statutCandidat);
//
//    List<InscriptionEntity> findByCandidat(CandidatEntity candidat);
//    List<InscriptionEntity> findByCampagneAndCandidat(CampagneEntity campagne, CandidatEntity candidat);