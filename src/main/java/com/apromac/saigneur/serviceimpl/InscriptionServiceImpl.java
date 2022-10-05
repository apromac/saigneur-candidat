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

import java.util.ArrayList;
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

        // on set la campagne dans l'objet inscription
        saveInscriptionEntity.setCampagne(campagneEntity);

        // on enregistre le candidat puis on set la valeur de l'objet dans celui de inscription
        CandidatEntity saveCandidat = candidatRepository.save(candidatEntity);
        if (saveCandidat == null)
            throw new RuntimeException("Désolé, une erreur est survenue lors de la sauvegarde des informations relatives à ce candidat");

        saveInscriptionEntity.setCandidat(saveCandidat);

//        saveInscriptionEntity.setInscriptionID(inscriptionDTO.getInscriptionID());
        saveInscriptionEntity.setDateInscription(inscriptionDTO.getDateInscription());
        saveInscriptionEntity.setDistrictInscription(inscriptionDTO.getDistrictInscription());
        saveInscriptionEntity.setZoneInscription(inscriptionDTO.getZoneInscription());

        saveInscriptionEntity.setIsFormer(inscriptionDTO.getIsFormer());
        saveInscriptionEntity.setStructureFormation(inscriptionDTO.getStructureFormation());
        saveInscriptionEntity.setAnneeFormation(inscriptionDTO.getAnneeFormation());
        saveInscriptionEntity.setIsAppliquer(inscriptionDTO.getIsAppliquer());
        saveInscriptionEntity.setTypeFormation(inscriptionDTO.getTypeFormation());
        saveInscriptionEntity.setLieuFormation(inscriptionDTO.getLieuFormation());
        saveInscriptionEntity.setTypeSaigneFormation(inscriptionDTO.getTypeSaigneFormation());
        saveInscriptionEntity.setNomPlanteurFormation(inscriptionDTO.getNomPlanteurFormation());
        saveInscriptionEntity.setMatriculePlanteurFormation(inscriptionDTO.getMatriculePlanteurFormation());
        saveInscriptionEntity.setLieuFormation(inscriptionDTO.getLieuFormation());
        saveInscriptionEntity.setAnneePlanteurFormation(inscriptionDTO.getAnneePlanteurFormation());
        saveInscriptionEntity.setContactPlanteurFormation(inscriptionDTO.getContactPlanteurFormation());

        saveInscriptionEntity.setPropositionEmploi(inscriptionDTO.getPropositionEmploi());
        saveInscriptionEntity.setNomPlanteurEmploi(inscriptionDTO.getNomPlanteurEmploi());
        saveInscriptionEntity.setMatriculePlanteurEmploi(inscriptionDTO.getMatriculePlanteurEmploi());
        saveInscriptionEntity.setLieuPlanteurEmploi(inscriptionDTO.getLieuPlanteurEmploi());
        saveInscriptionEntity.setAnneePlanteurEmploi(inscriptionDTO.getAnneePlanteurEmploi());
        saveInscriptionEntity.setContactPlanteurEmploi(inscriptionDTO.getContactPlanteurEmploi());

        saveInscriptionEntity.setIsActivite(inscriptionDTO.getIsActivite());
        saveInscriptionEntity.setNomPlanteurActivite(inscriptionDTO.getNomPlanteurActivite());
        saveInscriptionEntity.setMatriculePlanteurActivite(inscriptionDTO.getMatriculePlanteurActivite());
        saveInscriptionEntity.setLieuPlanteurActivite(inscriptionDTO.getLieuPlanteurActivite());
        saveInscriptionEntity.setAnneePlanteurActivite(inscriptionDTO.getAnneePlanteurActivite());
        saveInscriptionEntity.setContactPlanteurActivite(inscriptionDTO.getContactPlanteurActivite());

        saveInscriptionEntity.setMotivation(inscriptionDTO.getMotivation());
        saveInscriptionEntity.setStatut(inscriptionDTO.getStatut());
        
//        saveInscriptionEntity.setIsSelectionner(inscriptionDTO.getIsSelectionner());
//        saveInscriptionEntity.setIsInterview(inscriptionDTO.getIsInterview());
//        saveInscriptionEntity.setIsRetenu(inscriptionDTO.getIsRetenu());

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
            throw new NoContentException("Désolé, aucune inscription trouvée pour cette campagne.");

        return inscriptions;
    }




    /**
     *
     * @param inscriptionID
     * @param isSelect
     * @return
     */
    public InscriptionEntity findByInscriptionID(Long inscriptionID, Boolean isSelect) {
        Optional<InscriptionEntity> inscriptionOptional = inscriptionRepository.findById(inscriptionID);
        if (!inscriptionOptional.isPresent())
            throw new RuntimeException("Désolé, l'inscription recherché est introuvable");

        InscriptionEntity inscriptionEntity = inscriptionOptional.get();
//        inscriptionEntity.setIsSelectionner(isSelect);
//        inscriptionEntity.setIsInterview(isSelect);

        InscriptionEntity inscriptionUpdate = inscriptionRepository.save(inscriptionEntity);
        if (inscriptionUpdate == null)
            throw new NoContentException("Désolé, nous avons rencontré un problème lors de la mise à jour des entités.");

        return inscriptionUpdate;
    }


    /**
     *
     * @param candidatEntity
     * @param campagneEntity
     * @param isInterview
     * @return
     */
    public InscriptionEntity findByValidationInterviewCandidats(CandidatEntity candidatEntity, CampagneEntity campagneEntity, Boolean isInterview) {
        InscriptionEntity inscription = inscriptionRepository.findByCandidatAndCampagne(candidatEntity, campagneEntity);
        if (inscription == null)
            throw new NotFoundException("Désolé, nous avons rencontré un problème lors de la sauvegarde des informations.");

//        inscription.setIsRetenu(isInterview);
//        inscription.setIsInterview(false);

        InscriptionEntity inscriptionUpdate = inscriptionRepository.save(inscription);

        return inscriptionUpdate;
    }


    /**
     *
     * @param candidatEntity
     * @param campagneEntity
     * @param inscriptionID
     * @param statutCandidat
     * @return
     */
    public InscriptionEntity findByStatutNext(CandidatEntity candidatEntity, CampagneEntity campagneEntity, Long inscriptionID, Integer statutCandidat) {
        InscriptionEntity updateInscription = null;

        if (statutCandidat == 0) {
            InscriptionEntity inscriptionSelection = inscriptionRepository.findByCandidatAndCampagne(candidatEntity, campagneEntity);
            if (inscriptionSelection == null)
                throw new NotFoundException("Désolé, nous avons rencontré un problème lors de la sauvegarde des informations.");

            inscriptionSelection.setStatut(statutCandidat);
            updateInscription = inscriptionRepository.save(inscriptionSelection);
        } else if (statutCandidat == 1) {
            InscriptionEntity inscriptionSelection = inscriptionRepository.findByCandidatAndCampagne(candidatEntity, campagneEntity);
            if (inscriptionSelection == null)
                throw new NotFoundException("Désolé, nous avons rencontré un problème lors de la sauvegarde des informations.");

            inscriptionSelection.setStatut(statutCandidat);
            updateInscription = inscriptionRepository.save(inscriptionSelection);
        } else if (statutCandidat == 2) {
            InscriptionEntity inscriptionSelection = inscriptionRepository.findByCandidatAndCampagne(candidatEntity, campagneEntity);
            if (inscriptionSelection == null)
                throw new NotFoundException("Désolé, nous avons rencontré un problème lors de la sauvegarde des informations.");

            inscriptionSelection.setStatut(statutCandidat);
            updateInscription = inscriptionRepository.save(inscriptionSelection);
        } else if (statutCandidat == 3) {
            InscriptionEntity inscriptionSelection = inscriptionRepository.findByCandidatAndCampagne(candidatEntity, campagneEntity);
            if (inscriptionSelection == null)
                throw new NotFoundException("Désolé, nous avons rencontré un problème lors de la sauvegarde des informations.");

            inscriptionSelection.setStatut(statutCandidat);
            updateInscription = inscriptionRepository.save(inscriptionSelection);
        }

        return updateInscription;
    }


    /**
     *
     * @param campagneEntity
     * @param statutCandidat
     * @return
     */
    public List<InscriptionEntity> findByStatutInscription(CampagneEntity campagneEntity, Integer statutCandidat) {
        List<InscriptionEntity> statutInscriptions = new ArrayList<>();

        if (statutCandidat == 0) { // liste des candidats de la campagne en cours
            List<InscriptionEntity> inscriptionCandidats = inscriptionRepository.findByCampagneAndStatut(campagneEntity, statutCandidat);
            if (inscriptionCandidats.isEmpty())
                throw new NoContentException("Désolé, nous n'avons pas pu récupérer la liste des candidats pour la campagne en cours.");

            statutInscriptions = inscriptionCandidats;
        } else if (statutCandidat == 1) { // liste des candidats pour la selection
            List<InscriptionEntity> inscriptionCandidatsSelection = inscriptionRepository.findByCampagneAndStatut(campagneEntity, statutCandidat);
            if (inscriptionCandidatsSelection.isEmpty())
                throw new NoContentException("Désolé, nous n'avons pas pu récupérer la liste des candidats sélectionnés.");

            statutInscriptions = inscriptionCandidatsSelection;
        } else if (statutCandidat == 2) { // listes des candidats pour l'interview
            List<InscriptionEntity> inscriptionCandidatsInterview = inscriptionRepository.findByCampagneAndStatut(campagneEntity, statutCandidat);
            if (inscriptionCandidatsInterview.isEmpty())
                throw new NoContentException("Désolé, nous n'avons pas pu récupérer la liste des candidats destinés à l'interview.");

            statutInscriptions = inscriptionCandidatsInterview;
        } else if (statutCandidat == 3) { // listes des candidats retenus
            List<InscriptionEntity> inscriptionCandidatsRetenus = inscriptionRepository.findByCampagneAndStatut(campagneEntity, statutCandidat);
            if (inscriptionCandidatsRetenus.isEmpty())
                throw new NoContentException("Désolé, nous n'avons pas pu récupérer la liste des candidats retenus.");

            statutInscriptions = inscriptionCandidatsRetenus;
        }

        return statutInscriptions;
    }

//    /**
//     *
//     * @param isValid
//     * @return
//     */
//    public List<InscriptionEntity> findSelectionCandidats(CampagneEntity campagneEntity, Boolean isValid) {
//        List<InscriptionEntity> inscriptions = new ArrayList<>();
//
//        if (isValid) {
//            inscriptions = inscriptionRepository.findByCampagneAndIsSelectionnerTrue(campagneEntity);
//            if (inscriptions.isEmpty())
//                throw new NoContentException("Désolé, aucune inscription trouvée pour la campagne en cours.");
//        } else {
//            inscriptions = inscriptionRepository.findByCampagneAndIsSelectionnerFalse(campagneEntity);
//            if (inscriptions.isEmpty())
//                throw new NoContentException("Désolé, aucune inscription trouvée pour la campagne en cours.");
//        }
//
//        return inscriptions;
//    }


//    /**
//     *
//     * @return
//     */
//    public List<InscriptionEntity> findByInterviewCandidats(CampagneEntity campagneEntity) {
//        List<InscriptionEntity> inscriptions = inscriptionRepository.findByCampagneAndIsInterviewTrue(campagneEntity);
//        if (inscriptions.isEmpty())
//            throw new NoContentException("Désolé, nous n'avons pas pu récupérer la liste des candidats destinés à l'interview.");
//
//        return inscriptions;
//    }


//    /**
//     *
//     * @param campagneEntity
//     * @return
//     */
//    public List<InscriptionEntity> findByRetenuCandidats(CampagneEntity campagneEntity) {
//        List<InscriptionEntity> inscriptions = inscriptionRepository.findByCampagneAndIsRetenuTrue(campagneEntity);
//        if (inscriptions.isEmpty())
//            throw new NoContentException("Désolé, nous n'avons pas pu récupérer la liste des candidats retenus.");
//
//        return inscriptions;
//    }


























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

