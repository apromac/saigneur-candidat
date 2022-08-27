package com.apromac.saigneur.serviceimpl;

import com.apromac.saigneur.entity.IdentifierEntity;
import com.apromac.saigneur.exception.NoContentException;
import com.apromac.saigneur.exception.NotFoundException;
import com.apromac.saigneur.repository.CampagneRepository;
import com.apromac.saigneur.repository.CandidatRepository;
import com.apromac.saigneur.repository.IdentifierRepository;
import com.apromac.saigneur.service.IdentifierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IdentifierServiceImpl implements IdentifierService {

    @Autowired
    private IdentifierRepository identifierRepository;

    @Autowired
    private CandidatRepository candidatRepository;

    @Autowired
    private CampagneRepository campagneRepository;


    /**
     *
     * @param identifierID
     * @return
     */
    @Override
    public Optional<IdentifierEntity> findByIdentifierID(String identifierID) {
        Optional<IdentifierEntity> identifierOptional = identifierRepository.findById(identifierID);

        if (!identifierOptional.isPresent())
            throw new NotFoundException("Désolé, l'identification désignée n'existe pas");

        return identifierOptional;
    }

    /**
     *
     * @param campagneID
     * @return
     */
    public List<IdentifierEntity> findByCampagne(Long campagneID) {
        List<IdentifierEntity> identifierCampagne = identifierRepository.findByCampagne(campagneID);

        if (identifierCampagne.isEmpty())
            throw new NoContentException("Désolé, aucun conténu trouvé");

        return identifierCampagne;
    }

    /**
     *
     * @param campagneID
     * @param abreviationDistrict
     * @return
     */
    @Override
    public String findIdentifierID(Long campagneID, String abreviationDistrict) {
        String identifierID = null;
        List<IdentifierEntity> byCampagne = identifierRepository.findByCampagne(campagneID);

        int compteur = byCampagne.size() + 1;

        identifierID = abreviationDistrict + "compteur" + "S";

        return identifierID;
    }

}
