package com.apromac.saigneur.service;

import com.apromac.saigneur.dto.InscriptionDTO;
import com.apromac.saigneur.entity.CampagneEntity;
import com.apromac.saigneur.entity.CandidatEntity;
import com.apromac.saigneur.entity.InscriptionEntity;

import java.util.List;

public interface InscriptionService {
    public InscriptionEntity saveInscriptionCampagneCandidat(CampagneEntity campagneEntity, CandidatEntity candidatEntity, InscriptionDTO inscriptionDTO);
    public InscriptionEntity findByValidationInterviewCandidats(CandidatEntity candidatEntity, CampagneEntity campagneEntity, Boolean isInterview);
    public List<InscriptionEntity> findByCampagne(Long campagneID);
    public List<InscriptionEntity> findByCampagneAndStatut(Long campagneID, Integer statutCandidat);
    public InscriptionEntity findByInscriptionID(Long inscriptionID, Boolean isSelect);


















    public List<InscriptionEntity> findByCandidat(Long candidatID);
    public List<InscriptionEntity> findByCampagneAndCandidat(Long campagneID, Long candidatID);

}
