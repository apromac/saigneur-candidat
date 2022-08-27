package com.apromac.saigneur.serviceimpl;

import com.apromac.saigneur.entity.CandidatEntity;
import com.apromac.saigneur.exception.NotFoundException;
import com.apromac.saigneur.repository.CandidatRepository;
import com.apromac.saigneur.service.CandidatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CandidatServiceImpl implements CandidatService {

    @Autowired
    private CandidatRepository candidatRepository;

    /**
     *
     * @param candidatID
     * @return
     */
    @Override
    public Optional<CandidatEntity> findByCandidatID(Long candidatID) {
        Optional<CandidatEntity> candidatOptional = candidatRepository.findById(candidatID);

        if (!candidatOptional.isPresent())
            throw new NotFoundException("Désolé, la campagne désignée n'existe pas");

        return candidatOptional;
    }

    /**
     *
     * @return
     */
    @Override
    public List<CandidatEntity> findAllCandidat() {
        List<CandidatEntity> candidats = candidatRepository.findAll();

        if (candidats.isEmpty())
            throw new NotFoundException("Désolé, aucun candidat disponible");

        return candidats;
    }

}
