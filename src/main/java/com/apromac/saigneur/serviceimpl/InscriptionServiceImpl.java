package com.apromac.saigneur.serviceimpl;

import com.apromac.saigneur.dto.InscriptionDTO;
import com.apromac.saigneur.entity.CampagneEntity;
import com.apromac.saigneur.entity.CandidatEntity;
import com.apromac.saigneur.entity.InscriptionEntity;
import com.apromac.saigneur.exception.NoContentException;
import com.apromac.saigneur.exception.NotFoundException;
import com.apromac.saigneur.repository.CampagneRepository;
import com.apromac.saigneur.repository.CandidatRepository;
import com.apromac.saigneur.repository.InscriptionRepository;
import com.apromac.saigneur.service.InscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InscriptionServiceImpl implements InscriptionService {

    @Autowired
    private InscriptionRepository inscriptionRepository;

    @Autowired
    private CandidatRepository candidatRepository;

    @Autowired
    private CampagneRepository campagneRepository;



    /**
     *
     * @param campagneEntity
     * @param candidatEntity
     * @param inscriptionDTO
     * @return
     */
    public InscriptionEntity saveInscriptionCampagneCandidat(CampagneEntity campagneEntity,
                                                             CandidatEntity candidatEntity,
                                                             InscriptionDTO inscriptionDTO) {
        InscriptionEntity saveInscriptionEntity = new InscriptionEntity();
        saveInscriptionEntity.setCampagne(campagneEntity);
        saveInscriptionEntity.setCandidat(candidatEntity);
        saveInscriptionEntity.setDateInscription(inscriptionDTO.getDateInscription());
        saveInscriptionEntity.setDistrictInscription(inscriptionDTO.getDistrictInscription());
        saveInscriptionEntity.setAbreviationDistrictInscription(inscriptionDTO.getAbreviationDistrictInscription());
        saveInscriptionEntity.setZoneInscription(inscriptionDTO.getZoneInscription());
        saveInscriptionEntity.setInscriptionID("");

        InscriptionEntity saveInscription = inscriptionRepository.save(saveInscriptionEntity);
        if (saveInscription == null)
            throw new RuntimeException("Désolé, nous avons rencontrés une erreur lors de la sauvegarde des informations relatives à l'inscription du candidat");

        return saveInscription;
    }

    /**
     *
     * @param campagneID
     * @return
     */
    @Override
    public List<InscriptionEntity> findByCampagne(Long campagneID) {
        Optional<CampagneEntity> campagneOptional = campagneRepository.findById(campagneID);
        if (!campagneOptional.isPresent())
            throw new NotFoundException("Désolé, cette campagne n'existe pas");

        List<InscriptionEntity> inscriptions = inscriptionRepository.findByCampagne(campagneOptional.get());
        if (inscriptions.isEmpty())
            throw new NoContentException("Désolé, aucun contenu trouvé");

        return inscriptions;
    }






















    /**
     *
     * @param identifierID
     * @return
     */
    @Override
    public InscriptionEntity findByIdentifierID(String identifierID) {
        Optional<InscriptionEntity> identifierOptional = inscriptionRepository.findById(identifierID);
        if (!identifierOptional.isPresent())
            throw new NotFoundException("Désolé, l'identification désignée n'existe pas");

        return identifierOptional.get();
    }



    /**
     *
     * @param candidatID
     * @return
     */
    @Override
    public List<InscriptionEntity> findByCandidat(Long candidatID) {
        Optional<CandidatEntity> candidatOptional = candidatRepository.findById(candidatID);
        if (!candidatOptional.isPresent())
            throw new NotFoundException("Désolé, ce candidat n'existe pas");

        List<InscriptionEntity> identifierCandidat = inscriptionRepository.findByCandidat(candidatOptional.get());
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
    public List<InscriptionEntity> findByCampagneAndCandidat(Long campagneID, Long candidatID) {
        Optional<CampagneEntity> campagneOptional = campagneRepository.findById(campagneID);
        if (!campagneOptional.isPresent())
            throw new NotFoundException("Désolé, cette campagne n'existe pas");

        Optional<CandidatEntity> candidatOptional = candidatRepository.findById(candidatID);
        if (!candidatOptional.isPresent())
            throw new NotFoundException("Désolé, ce candidat n'existe pas");

        List<InscriptionEntity> identifierCampagneAndCandidat = inscriptionRepository.findByCampagneAndCandidat(campagneOptional.get(), candidatOptional.get());
        if (identifierCampagneAndCandidat.isEmpty())
            throw new NoContentException("Désolé, aucun conténu trouvé");

        return identifierCampagneAndCandidat;
    }

}
