package com.apromac.saigneur.service;

import com.apromac.saigneur.entity.CampagneEntity;

import java.util.List;
import java.util.Optional;

public interface CampagneService {
//    public Optional<CampagneEntity> findByCampagneID(Long campagneID);
    public CampagneEntity findByCampagneID(Long campagneID);
    public CampagneEntity saveCampagne(CampagneEntity campagne);
    public List<CampagneEntity> findAllCampagne();
}
