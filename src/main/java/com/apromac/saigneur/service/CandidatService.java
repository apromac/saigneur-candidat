package com.apromac.saigneur.service;

import com.apromac.saigneur.entity.CandidatEntity;

import java.util.List;

public interface CandidatService {
//    public Optional<CandidatEntity> findByCandidatID(Long candidatID);
    public CandidatEntity findByCandidatID(Long candidatID);
    public CandidatEntity saveCandidat(CandidatEntity candidat);
    public List<CandidatEntity> findAllCandidat();
}
