package com.apromac.saigneur.serviceimpl;

import com.apromac.saigneur.entity.CampagneEntity;
import com.apromac.saigneur.exception.NoContentException;
import com.apromac.saigneur.exception.NotFoundException;
import com.apromac.saigneur.repository.CampagneRepository;
import com.apromac.saigneur.service.CampagneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CampagneServiceImpl implements CampagneService {

    @Autowired
    private CampagneRepository campagneRepository;

    /**
     *
     * @param campagneID
     * @return campagneOptional
     */
    @Override
    public Optional<CampagneEntity> findByCampagneID(Long campagneID) {
        Optional<CampagneEntity> campagneOptional = campagneRepository.findById(campagneID);

        if (!campagneOptional.isPresent())
            throw new NotFoundException("Désolé, la campagne désignée n'existe pas");

        return campagneOptional;
    }

    /**
     *
     * @return campagnes, list of all campagne
     */
    @Override
    public List<CampagneEntity> findAllCampagne() {
        List<CampagneEntity> campagnes = campagneRepository.findAll();

        if (campagnes.isEmpty())
            throw new NoContentException("Désolé, aucune campagne disponible");

        return campagnes;
    }

}
