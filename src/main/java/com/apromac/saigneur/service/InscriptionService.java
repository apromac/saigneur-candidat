package com.apromac.saigneur.service;

import com.apromac.saigneur.dto.InscriptionDTO;
import com.apromac.saigneur.entity.CampagneEntity;
import com.apromac.saigneur.entity.CandidatEntity;
import com.apromac.saigneur.entity.InscriptionEntity;

import java.util.List;

public interface InscriptionService {
    public InscriptionEntity saveInscriptionCampagneCandidat(CampagneEntity campagneEntity,
                                                             CandidatEntity candidatEntity,
                                                             InscriptionDTO inscriptionDTO);
    public List<InscriptionEntity> findByCampagne(Long campagneID);
    public List<InscriptionEntity> findSelectionCandidats(CampagneEntity campagneEntity, Boolean isValid);
    public InscriptionEntity findByInscriptionID(Long inscriptionID, Boolean isSelect);
    public List<InscriptionEntity> findByInterviewCandidats(CampagneEntity campagne);
    public InscriptionEntity findByValidationInterviewCandidats(CandidatEntity candidatEntity,
                                                                CampagneEntity campagneEntity,
                                                                Boolean isInterview);

















//    public InscriptionEntity findValidationCandidat(Long candidatID, Boolean isValid);
//    public InscriptionEntity findByIdentifierID(String identifierID);
    public List<InscriptionEntity> findByCandidat(Long candidatID);
    public List<InscriptionEntity> findByCampagneAndCandidat(Long campagneID, Long candidatID);

}
