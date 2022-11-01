package com.apromac.saigneur.serviceimpl;

import com.apromac.saigneur.dto.InscriptionDTO;
import com.apromac.saigneur.dto.InterviewDTO;
import com.apromac.saigneur.entity.CampagneEntity;
import com.apromac.saigneur.entity.CandidatEntity;
import com.apromac.saigneur.entity.InscriptionEntity;
import com.apromac.saigneur.exception.NoContentException;
import com.apromac.saigneur.exception.NotFoundException;
import com.apromac.saigneur.repository.CampagneRepository;
import com.apromac.saigneur.repository.CandidatRepository;
import com.apromac.saigneur.repository.InscriptionRepository;
import com.apromac.saigneur.service.InscriptionService;
import com.apromac.saigneur.utility.InterviewRequest;
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
     * Methode permettant de récupérer la liste des candidats en fonction de la campagne en cours, du statut et du district.
     * @param campagneEntity objet representant la campagne en cours
     * @param statutCandidat numéro representant le statut du candidat. (0) pour inscrit, (1) pour retenu, (2) pour interview
     * @param districtCandidat chaine de caractère representant le district du candidat
     * @return
     */
    @Override
    public List<InscriptionEntity> findByCampagneAndStatutAndDistrictInscription(CampagneEntity campagneEntity, Integer statutCandidat,
                                                                                 String districtCandidat) {
        List<InscriptionEntity> inscriptions = inscriptionRepository.findByCampagneAndStatutAndDistrictInscription(campagneEntity,
                statutCandidat, districtCandidat);
        if (inscriptions.isEmpty())
            throw new NoContentException("Désolé, aucun candidat trouvé pour cette campagne.");

        return inscriptions;
    }



    /**
     * Methode permettant de récupérer la liste des candidats en fonction de la campagne et du statut du candidat. Reservé
     * à l'administrateur
     * @param campagneEntity
     * @param statutCandidat
     * @return
     */
    @Override
    public List<InscriptionEntity> findByCampagneAndStatut(CampagneEntity campagneEntity, Integer statutCandidat) {
        List<InscriptionEntity> inscriptions = inscriptionRepository.findByCampagneAndStatut(campagneEntity, statutCandidat);
        if (inscriptions.isEmpty())
            throw new NoContentException("Désolé, aucun candidat trouvé pour cette campagne.");

        return inscriptions;
    }


//    /**
//     *
//     * @param inscriptionEntity
//     * @return
//     */
//    public InscriptionEntity saveInscription(InscriptionEntity inscriptionEntity) {
//        if (inscriptionEntity.getCandidat() == null)
//            throw new RuntimeException("Désolé, nous avons rencontré une erreur lors de la récupérations des informations du candidat");
//
//        InscriptionEntity saveInscription = inscriptionRepository.saveAndFlush(inscriptionEntity);
//        if (saveInscription == null)
//            throw new RuntimeException("Désolé, nous avons rencontrés une erreur lors de la sauvegarde des informations relatives à l'inscription du candidat");
//
//        return saveInscription;
//    }



    /**
     * Methode permettant de sauvegarder l'inscription d'un candidat à une campagne
     * @param campagneEntity objet representant la campagne
     * @param candidatEntity objet representant le candidat à inscrire
     * @param inscriptionDTO objet representant les informations sur l'inscription du candidat
     * @return saveInscription
     */
    @Override
    public InscriptionEntity saveInscriptionCampagneCandidat(CampagneEntity campagneEntity, CandidatEntity candidatEntity,
                                                             InscriptionDTO inscriptionDTO) {

        if (candidatEntity == null)
            throw new RuntimeException("Désolé, nous avons rencontré une erreur lors de la récupérations des informations du candidat");

        if (inscriptionDTO == null)
            throw new RuntimeException("Désolé, une erreur c'est produite lors de la récupération des informations de l'inscription");


        InscriptionEntity saveInscriptionEntity = new InscriptionEntity();

        saveInscriptionEntity.setInscriptionID(inscriptionDTO.getInscriptionID());
        saveInscriptionEntity.setDateInscription(inscriptionDTO.getDateInscription());
        saveInscriptionEntity.setDistrictInscription(inscriptionDTO.getDistrictInscription());
        saveInscriptionEntity.setZoneInscription(inscriptionDTO.getZoneInscription());
        saveInscriptionEntity.setDistanceInscription(inscriptionDTO.getDistanceInscription());

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

        // campagne
        saveInscriptionEntity.setCampagne(campagneEntity);

        // candidat
        CandidatEntity saveCandidat = candidatRepository.saveAndFlush(candidatEntity);
        if (saveCandidat == null)
            throw new RuntimeException("Désolé, une erreur est survenue lors de la sauvegarde des informations relatives à ce candidat");

        saveInscriptionEntity.setCandidat(saveCandidat);

        // sauvegarde de l'inscription
        InscriptionEntity saveInscription = inscriptionRepository.save(saveInscriptionEntity);
        if (saveInscription == null)
            throw new RuntimeException("Désolé, nous avons rencontrés une erreur lors de la sauvegarde des informations relatives à l'inscription du candidat");

        return saveInscription;
    }



    /**
     * Methode permettant de recupérer une inscription grace à son ID
     * @param inscriptionID
     * @return
     */
    @Override
    public InscriptionEntity findByInscriptionID(Long inscriptionID) {
        Optional<InscriptionEntity> inscriptionOptional = inscriptionRepository.findById(inscriptionID);
        if (!inscriptionOptional.isPresent())
            throw new NotFoundException("Désolé, l'inscription recherché est introuvable.");

        return inscriptionOptional.get();
    }



    /**
     * Methode permettant de modifier l'inscription d'un candidat d'une campagne grace à l'ID de l'inscription et un
     * objet inscription
     * @param inscriptionTrouver
     * @param inscriptionEntity
     * @return
     */
    @Override
    public InscriptionEntity updateInscription(InscriptionEntity inscriptionTrouver, InscriptionEntity inscriptionEntity) {

        //inscriptionTrouver.setInscriptionID(inscriptionEntity.getInscriptionID());
        inscriptionTrouver.setDateInscription(inscriptionEntity.getDateInscription());
        inscriptionTrouver.setDistrictInscription(inscriptionEntity.getDistrictInscription());
        inscriptionTrouver.setZoneInscription(inscriptionEntity.getZoneInscription());
        inscriptionTrouver.setDistanceInscription(inscriptionEntity.getDistanceInscription());

        inscriptionTrouver.setIsFormer(inscriptionEntity.getIsFormer());
        inscriptionTrouver.setStructureFormation(inscriptionEntity.getStructureFormation());
        inscriptionTrouver.setAnneeFormation(inscriptionEntity.getAnneeFormation());
        inscriptionTrouver.setIsAppliquer(inscriptionEntity.getIsAppliquer());
        inscriptionTrouver.setTypeFormation(inscriptionEntity.getTypeFormation());
        inscriptionTrouver.setLieuFormation(inscriptionEntity.getLieuFormation());
        inscriptionTrouver.setTypeSaigneFormation(inscriptionEntity.getTypeSaigneFormation());
        inscriptionTrouver.setNomPlanteurFormation(inscriptionEntity.getNomPlanteurFormation());
        inscriptionTrouver.setMatriculePlanteurFormation(inscriptionEntity.getMatriculePlanteurFormation());
        inscriptionTrouver.setLieuFormation(inscriptionEntity.getLieuFormation());
        inscriptionTrouver.setAnneePlanteurFormation(inscriptionEntity.getAnneePlanteurFormation());
        inscriptionTrouver.setContactPlanteurFormation(inscriptionEntity.getContactPlanteurFormation());

        inscriptionTrouver.setPropositionEmploi(inscriptionEntity.getPropositionEmploi());
        inscriptionTrouver.setNomPlanteurEmploi(inscriptionEntity.getNomPlanteurEmploi());
        inscriptionTrouver.setMatriculePlanteurEmploi(inscriptionEntity.getMatriculePlanteurEmploi());
        inscriptionTrouver.setLieuPlanteurEmploi(inscriptionEntity.getLieuPlanteurEmploi());
        inscriptionTrouver.setAnneePlanteurEmploi(inscriptionEntity.getAnneePlanteurEmploi());
        inscriptionTrouver.setContactPlanteurEmploi(inscriptionEntity.getContactPlanteurEmploi());

        inscriptionTrouver.setIsActivite(inscriptionEntity.getIsActivite());
        inscriptionTrouver.setNomPlanteurActivite(inscriptionEntity.getNomPlanteurActivite());
        inscriptionTrouver.setMatriculePlanteurActivite(inscriptionEntity.getMatriculePlanteurActivite());
        inscriptionTrouver.setLieuPlanteurActivite(inscriptionEntity.getLieuPlanteurActivite());
        inscriptionTrouver.setAnneePlanteurActivite(inscriptionEntity.getAnneePlanteurActivite());
        inscriptionTrouver.setContactPlanteurActivite(inscriptionEntity.getContactPlanteurActivite());

        inscriptionTrouver.setMotivation(inscriptionEntity.getMotivation());
        inscriptionTrouver.setStatut(inscriptionEntity.getStatut());

        // campagne
        inscriptionTrouver.setCampagne(inscriptionEntity.getCampagne());

        // candidat
        CandidatEntity updateCandidat = candidatRepository.saveAndFlush(inscriptionEntity.getCandidat());
        if (updateCandidat == null)
            throw new RuntimeException("Désolé, une erreur est survenue lors de la sauvegarde des informations relatives à ce candidat");

        inscriptionTrouver.setCandidat(updateCandidat);

        // sauvegarde des modifications de l'inscription
        InscriptionEntity updateInscription = inscriptionRepository.saveAndFlush(inscriptionTrouver);
        if (updateInscription == null)
            throw new RuntimeException("Désolé, nous avons rencontrés une erreur lors de la sauvegarde des informations relatives à l'inscription du candidat");

        return updateInscription;
    }




    /**
     * Methode permettant de valider ou retirer un candidat dans la liste des candidats à selectionner
     * @param inscriptionID
     * @param isSelect
     * @return
     */
    @Override
    public InscriptionEntity findBySelectionInscriptionID(Long inscriptionID, Boolean isSelect) {
        Optional<InscriptionEntity> inscriptionOptional = inscriptionRepository.findById(inscriptionID);
        if (!inscriptionOptional.isPresent())
            throw new RuntimeException("Désolé, l'inscription recherchée est introuvable");

        InscriptionEntity inscriptionEntity = inscriptionOptional.get();

        if (isSelect) {
            inscriptionEntity.setStatut(1);
            inscriptionEntity.setIsInterviewer(false);
        } else {
            inscriptionEntity.setStatut(0);
        }

        InscriptionEntity inscriptionUpdate = inscriptionRepository.save(inscriptionEntity);
        if (inscriptionUpdate == null)
            throw new NoContentException("Désolé, nous avons rencontré un problème lors de la mise à jour des entités.");

        return inscriptionUpdate;
    }



//    /**
//     * Methode permettant de valider un candidat dans la liste des candidats selectionné
//     * @param inscriptionID
//     * @param isInterview
//     * @return
//     */
//    @Override
//    public InscriptionEntity findByInterviewInscriptionID(Long inscriptionID, Boolean isInterview) {
//        Optional<InscriptionEntity> inscriptionOptional = inscriptionRepository.findById(inscriptionID);
//        if (!inscriptionOptional.isPresent())
//            throw new RuntimeException("Désolé, l'inscription recherchée est introuvable");
//
//        InscriptionEntity inscriptionEntity = inscriptionOptional.get();
//
//        if (isInterview) {
//            inscriptionEntity.setStatut(2);
//        } else {
//            inscriptionEntity.setStatut(1);
//        }
//
//        InscriptionEntity inscriptionUpdate = inscriptionRepository.save(inscriptionEntity);
//        if (inscriptionUpdate == null)
//            throw new NoContentException("Désolé, nous avons rencontré un problème lors de la mise à jour des entités.");
//
//        return inscriptionUpdate;
//    }



    /**
     * Methode permettant de valider un candidat dans la liste des candidats interviewer
     * @param inscriptionID
     * @param isRetenus
     * @return
     */
    @Override
    public InscriptionEntity findByRetenusInscriptionID(Long inscriptionID, Boolean isRetenus) {
        Optional<InscriptionEntity> inscriptionOptional = inscriptionRepository.findById(inscriptionID);
        if (!inscriptionOptional.isPresent())
            throw new RuntimeException("Désolé, l'inscription recherchée est introuvable");

        InscriptionEntity inscriptionEntity = inscriptionOptional.get();

        if (isRetenus) {
            inscriptionEntity.setStatut(2);
        } else {
            inscriptionEntity.setStatut(1);
        }

        InscriptionEntity inscriptionUpdate = inscriptionRepository.save(inscriptionEntity);
        if (inscriptionUpdate == null)
            throw new NoContentException("Désolé, nous avons rencontré un problème lors de la mise à jour des entités.");

        return inscriptionUpdate;
    }



    /******************************************************************************************************************/
    /**                                     IMPLEMENTATION DE LA PARTIE MOBILE                                       **/
    /******************************************************************************************************************/

    /**
     * Methode permettant de mettre à jour les informations de l'interview réalisé par le TDH. Ces informations provient de l'enquete
     * effectuée par le TDH sur le terrain à l'aide du mobile
     * @param interviewRequest
     * @return
     */
    @Override
    public List<InscriptionEntity> findByCandidatInterviewer(InterviewRequest interviewRequest) {
        List<InscriptionEntity> inscriptionsUpdate = new ArrayList<>();

        List<InterviewDTO> interviewDTOS = interviewRequest.getInterviewDTOS();
        for (InterviewDTO interviewDTO : interviewDTOS) {
            Optional<InscriptionEntity> inscriptionOptional = inscriptionRepository.findById(interviewDTO.getInscriptionID());
            if (!inscriptionOptional.isPresent())
                throw new NotFoundException("Désolé, une erreur c'est produite lors de la syncrhonisation des données.");

            InscriptionEntity inscriptionTrouver = inscriptionOptional.get();

            // motivation
            inscriptionTrouver.setDescriptionReveil(interviewDTO.getDescriptionReveil());
            inscriptionTrouver.setNoteReveil(interviewDTO.getNoteReveil());
            inscriptionTrouver.setDescriptionCouche(interviewDTO.getDescriptionCouche());
            inscriptionTrouver.setNoteCouche(interviewDTO.getNoteCouche());
            inscriptionTrouver.setDescriptionOccupation(interviewDTO.getDescriptionOccupation());
            inscriptionTrouver.setNoteOccupation(interviewDTO.getNoteOccupation());
            inscriptionTrouver.setPeurObscurite(interviewDTO.getPeurObscurite());
            inscriptionTrouver.setNoteObscurite(interviewDTO.getNoteObscurite());

            // endurance
            inscriptionTrouver.setSportif(interviewDTO.getSportif());
            inscriptionTrouver.setDescriptionSportif(interviewDTO.getDescriptionSportif());
            inscriptionTrouver.setNoteSprotif(interviewDTO.getNoteSprotif());
            inscriptionTrouver.setDescriptionLongueDistance(interviewDTO.getDescriptionLongueDistance());
            inscriptionTrouver.setNoteLongueDistance(interviewDTO.getNoteLongueDistance());

            // adaptation
            inscriptionTrouver.setMonteVelo(interviewDTO.getMonteVelo());
            inscriptionTrouver.setNoteVelo(interviewDTO.getNoteVelo());
            inscriptionTrouver.setPresencePlantation(interviewDTO.getPresencePlantation());
            inscriptionTrouver.setMotifPresencePlantation(interviewDTO.getMotifPresencePlantation());
            inscriptionTrouver.setNotePresencePlantation(interviewDTO.getNotePresencePlantation());
            inscriptionTrouver.setIsInterviewer(interviewDTO.getIsInterviewer());

            InscriptionEntity inscriptionUpdate = inscriptionRepository.save(inscriptionTrouver);
            inscriptionsUpdate.add(inscriptionUpdate);
        }

        return inscriptionsUpdate;
    }



    /**
     * Methode permettant de synchroniser les données des candidats à interviewer sur le mobile." ici, les candidats ne
     * sont pas encore interviewer. isInterviewer est par defaut à 'false'
     * @param statutID
     * @param zoneCandidat
     * @return
     */
    @Override
    public List<InscriptionEntity> findByStatutAndZoneAndInterview(Integer statutID, String zoneCandidat) {
        List<InscriptionEntity> sychroInscriptions = inscriptionRepository.findByStatutAndZoneInscriptionAndIsInterviewerFalse(statutID, zoneCandidat);
        if (sychroInscriptions.isEmpty())
            throw new NoContentException("Désolé, aucun candidat disponible pour l'interview");

        return sychroInscriptions;
    }

}




//
//    /**
//     *
//     * @param campagneID
//     * @return
//     */
//    @Override
//    public List<InscriptionEntity> findByCampagne(Long campagneID) {
//        Optional<CampagneEntity> campagneOptional = campagneRepository.findById(campagneID);
//        if (!campagneOptional.isPresent())
//            throw new NotFoundException("Désolé, cette campagne n'existe pas");
//
//        List<InscriptionEntity> inscriptions = inscriptionRepository.findByCampagne(campagneOptional.get());
//        if (inscriptions.isEmpty())
//            throw new NoContentException("Désolé, la liste ne contient aucune inscription pour cette campagne.");
//
//        return inscriptions;
//    }
//
//
//    /**
//     *
//     * @param inscriptionID
//     * @param isSelect
//     * @return
//     */
//
//
//
//
//
//    /**
//     *
//     * @param candidatEntity
//     * @param campagneEntity
//     * @param isInterview
//     * @return
//     */
//    public InscriptionEntity findByValidationInterviewCandidats(CandidatEntity candidatEntity,
//                                                                CampagneEntity campagneEntity,
//                                                                Boolean isInterview) {
//        InscriptionEntity inscription = inscriptionRepository.findByCandidatAndCampagne(candidatEntity, campagneEntity);
//        if (inscription == null)
//            throw new NotFoundException("Désolé, nous avons rencontré un problème lors de la sauvegarde des informations.");
//
//        if (isInterview) {
//            inscription.setStatut(2);
//        } else {
//            inscription.setStatut(1);
//        }
//
//        InscriptionEntity inscriptionUpdate = inscriptionRepository.save(inscription);
//
//        return inscriptionUpdate;
//    }
//
//
//
//
//    /**
//     *
//     * @param candidatEntity
//     * @param campagneEntity
//     * @param inscriptionID
//     * @param statutCandidat
//     * @return
//     */
//    public InscriptionEntity findByStatutNext(CandidatEntity candidatEntity,
//                                              CampagneEntity campagneEntity,
//                                              Long inscriptionID,
//                                              Integer statutCandidat) {
//
//        InscriptionEntity updateInscription = null;
//
//        if (statutCandidat == 0) {
//            InscriptionEntity inscriptionSelection = inscriptionRepository.findByCandidatAndCampagne(candidatEntity, campagneEntity);
//            if (inscriptionSelection == null)
//                throw new NotFoundException("Désolé, nous avons rencontré un problème lors de la sauvegarde des informations.");
//
//            inscriptionSelection.setStatut(statutCandidat);
//            updateInscription = inscriptionRepository.save(inscriptionSelection);
//        } else if (statutCandidat == 1) {
//            InscriptionEntity inscriptionSelection = inscriptionRepository.findByCandidatAndCampagne(candidatEntity, campagneEntity);
//            if (inscriptionSelection == null)
//                throw new NotFoundException("Désolé, nous avons rencontré un problème lors de la sauvegarde des informations.");
//
//            inscriptionSelection.setStatut(statutCandidat);
//            updateInscription = inscriptionRepository.save(inscriptionSelection);
//        } else if (statutCandidat == 2) {
//            InscriptionEntity inscriptionSelection = inscriptionRepository.findByCandidatAndCampagne(candidatEntity, campagneEntity);
//            if (inscriptionSelection == null)
//                throw new NotFoundException("Désolé, nous avons rencontré un problème lors de la sauvegarde des informations.");
//
//            inscriptionSelection.setStatut(statutCandidat);
//            updateInscription = inscriptionRepository.save(inscriptionSelection);
//        } else if (statutCandidat == 3) {
//            InscriptionEntity inscriptionSelection = inscriptionRepository.findByCandidatAndCampagne(candidatEntity, campagneEntity);
//            if (inscriptionSelection == null)
//                throw new NotFoundException("Désolé, nous avons rencontré un problème lors de la sauvegarde des informations.");
//
//            inscriptionSelection.setStatut(statutCandidat);
//            updateInscription = inscriptionRepository.save(inscriptionSelection);
//        }
//
//        return updateInscription;
//    }
//
//
//
//
//    /**
//     *
//     * @param campagneEntity
//     * @param statutCandidat
//     * @return
//     */
//    public List<InscriptionEntity> findByStatutInscription(CampagneEntity campagneEntity, Integer statutCandidat) {
//        List<InscriptionEntity> statutInscriptions = new ArrayList<>();
//
//        if (statutCandidat == 0) { // liste des candidats de la campagne en cours
//            List<InscriptionEntity> inscriptionCandidats = inscriptionRepository.findByCampagneAndStatut(campagneEntity, statutCandidat);
//            if (inscriptionCandidats.isEmpty())
//                throw new NoContentException("Désolé, nous n'avons pas pu récupérer la liste des candidats pour la campagne en cours.");
//
//            statutInscriptions = inscriptionCandidats;
//        } else if (statutCandidat == 1) { // liste des candidats pour la selection
//            List<InscriptionEntity> inscriptionCandidatsSelection = inscriptionRepository.findByCampagneAndStatut(campagneEntity, statutCandidat);
//            if (inscriptionCandidatsSelection.isEmpty())
//                throw new NoContentException("Désolé, nous n'avons pas pu récupérer la liste des candidats sélectionnés.");
//
//            statutInscriptions = inscriptionCandidatsSelection;
//        } else if (statutCandidat == 2) { // listes des candidats pour l'interview
//            List<InscriptionEntity> inscriptionCandidatsInterview = inscriptionRepository.findByCampagneAndStatut(campagneEntity, statutCandidat);
//            if (inscriptionCandidatsInterview.isEmpty())
//                throw new NoContentException("Désolé, nous n'avons pas pu récupérer la liste des candidats destinés à l'interview.");
//
//            statutInscriptions = inscriptionCandidatsInterview;
//        } else if (statutCandidat == 3) { // listes des candidats retenus
//            List<InscriptionEntity> inscriptionCandidatsRetenus = inscriptionRepository.findByCampagneAndStatut(campagneEntity, statutCandidat);
//            if (inscriptionCandidatsRetenus.isEmpty())
//                throw new NoContentException("Désolé, nous n'avons pas pu récupérer la liste des candidats retenus.");
//
//            statutInscriptions = inscriptionCandidatsRetenus;
//        }
//
//        return statutInscriptions;
//    }
//
//
//    /**
//     *
//     * @param candidatID
//     * @return
//     */
//    @Override
//    public List<InscriptionEntity> findByCandidat(Long candidatID) {
//        Optional<CandidatEntity> candidatOptional = candidatRepository.findById(candidatID);
//        if (!candidatOptional.isPresent())
//            throw new NotFoundException("Désolé, ce candidat n'existe pas");
//
//        List<InscriptionEntity> identifierCandidat = inscriptionRepository.findByCandidat(candidatOptional.get());
//        if (identifierCandidat.isEmpty())
//            throw new NoContentException("Désolé, aucun conténu trouvé");
//
//        return identifierCandidat;
//    }
//
//
//
//    /**
//     *
//     * @param campagneID
//     * @param candidatID
//     * @return
//     */
//    @Override
//    public List<InscriptionEntity> findByCampagneAndCandidat(Long campagneID, Long candidatID) {
//        Optional<CampagneEntity> campagneOptional = campagneRepository.findById(campagneID);
//        if (!campagneOptional.isPresent())
//            throw new NotFoundException("Désolé, cette campagne n'existe pas");
//
//        Optional<CandidatEntity> candidatOptional = candidatRepository.findById(candidatID);
//        if (!candidatOptional.isPresent())
//            throw new NotFoundException("Désolé, ce candidat n'existe pas");
//
//        List<InscriptionEntity> identifierCampagneAndCandidat = inscriptionRepository.findByCampagneAndCandidat(campagneOptional.get(), candidatOptional.get());
//        if (identifierCampagneAndCandidat.isEmpty())
//            throw new NoContentException("Désolé, aucun conténu trouvé");
//
//        return identifierCampagneAndCandidat;
//    }
