package com.apromac.saigneur.repository;

import com.apromac.saigneur.entity.IdentifierEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IdentifierRepository extends JpaRepository<IdentifierEntity, String> {
    List<IdentifierEntity> findByCampagne(Long campagneID);
}
