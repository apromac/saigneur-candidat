package com.apromac.saigneur.service;

import com.apromac.saigneur.entity.CandidatEntity;

import java.util.List;
import java.util.Optional;

public interface CandidatService {
    public Optional<CandidatEntity> findByCandidatID(Long candidatID);
    public List<CandidatEntity> findAllCandidat();
}
