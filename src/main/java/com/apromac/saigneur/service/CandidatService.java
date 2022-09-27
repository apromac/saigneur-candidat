package com.apromac.saigneur.service;

import com.apromac.saigneur.dto.CandidatDTO;
import com.apromac.saigneur.entity.CandidatEntity;
import com.apromac.saigneur.entity.InscriptionEntity;

import java.util.List;

public interface CandidatService {
    public CandidatEntity saveCandidat(CandidatEntity candidat);
    public List<CandidatDTO> candidatsByCampagne(List<InscriptionEntity> inscriptions);










    public CandidatEntity findByCandidatID(Long candidatID);
    public List<CandidatEntity> findAllCandidat();
}
