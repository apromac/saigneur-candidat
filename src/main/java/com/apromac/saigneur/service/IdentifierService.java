package com.apromac.saigneur.service;

import com.apromac.saigneur.entity.IdentifierEntity;

import java.util.List;
import java.util.Optional;

public interface IdentifierService {
    public String findIdentifierID(Long campagneID, String abreviationDistrict);
    public Optional<IdentifierEntity> findByIdentifierID(String identifierID);
    public List<IdentifierEntity> findByCampagne(Long campagneID);
}
