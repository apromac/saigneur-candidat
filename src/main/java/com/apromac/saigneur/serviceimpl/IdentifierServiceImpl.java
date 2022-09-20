package com.apromac.saigneur.serviceimpl;

import com.apromac.saigneur.entity.CampagneEntity;
import com.apromac.saigneur.entity.CandidatEntity;
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
    public IdentifierEntity findByIdentifierID(String identifierID) {
        Optional<IdentifierEntity> identifierOptional = identifierRepository.findById(identifierID);
        if (!identifierOptional.isPresent())
            throw new NotFoundException("Désolé, l'identification désignée n'existe pas");

        return identifierOptional.get();
    }

    /**
     *
     * @param campagneID
     * @return
     */
    @Override
    public List<IdentifierEntity> findByCampagne(Long campagneID) {
        Optional<CampagneEntity> campagneOptional = campagneRepository.findById(campagneID);
        if (!campagneOptional.isPresent())
            throw new NotFoundException("Désolé, cette campagne n'existe pas");

        List<IdentifierEntity> identifierCampagne = identifierRepository.findByCampagne(campagneOptional.get());
        if (identifierCampagne.isEmpty())
            throw new NoContentException("Désolé, aucun conténu trouvé");

        return identifierCampagne;
    }

    /**
     *
     * @param candidatID
     * @return
     */
    @Override
    public List<IdentifierEntity> findByCandidat(Long candidatID) {
        Optional<CandidatEntity> candidatOptional = candidatRepository.findById(candidatID);
        if (!candidatOptional.isPresent())
            throw new NotFoundException("Désolé, ce candidat n'existe pas");

        List<IdentifierEntity> identifierCandidat = identifierRepository.findByCandidat(candidatOptional.get());
        if (identifierCandidat.isEmpty())
            throw new NoContentException("Désolé, aucun conténu trouvé");

        return identifierCandidat;
    }

    /**
     *
     * @param campagneID
     * @param candidatID
     * @return
     */
    @Override
    public List<IdentifierEntity> findByCampagneAndCandidat(Long campagneID, Long candidatID) {
        Optional<CampagneEntity> campagneOptional = campagneRepository.findById(campagneID);
        if (!campagneOptional.isPresent())
            throw new NotFoundException("Désolé, cette campagne n'existe pas");

        Optional<CandidatEntity> candidatOptional = candidatRepository.findById(candidatID);
        if (!candidatOptional.isPresent())
            throw new NotFoundException("Désolé, ce candidat n'existe pas");

        List<IdentifierEntity> identifierCampagneAndCandidat = identifierRepository.findByCampagneAndCandidat(campagneOptional.get(), candidatOptional.get());
        if (identifierCampagneAndCandidat.isEmpty())
            throw new NoContentException("Désolé, aucun conténu trouvé");

        return identifierCampagneAndCandidat;
    }



//    /**
//     *
//     * @param identifierID
//     * @return
//     */
//    @Override
//    public Optional<IdentifierEntity> findByIdentifierID(String identifierID) {
//        Optional<IdentifierEntity> identifierOptional = identifierRepository.findById(identifierID);
//        if (!identifierOptional.isPresent())
//            throw new NotFoundException("Désolé, l'identification désignée n'existe pas");
//
//        return identifierOptional;
//    }


//    /**
//     *
//     * @param campagneID
//     * @param abreviationDistrict
//     * @return
//     */
//    @Override
//    public String findIdentifierID(Long campagneID, String abreviationDistrict) {
//        String identifierID = null;
//        List<IdentifierEntity> byCampagne = identifierRepository.findByCampagne(campagneID);
//
//        int compteur = byCampagne.size() + 1;
//
//        identifierID = abreviationDistrict + "compteur" + "S";
//
//        return identifierID;
//    }

}
