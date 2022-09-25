package com.apromac.saigneur.service;

import com.apromac.saigneur.entity.CampagneEntity;

import java.util.List;

public interface CampagneService {
    public CampagneEntity findByCampagneID(Long campagneID);
    public CampagneEntity saveCampagne(CampagneEntity campagne);
    public List<CampagneEntity> findAllCampagne();
    public CampagneEntity findCurrentCampagne();
}
