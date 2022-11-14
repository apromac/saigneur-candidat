package com.apromac.saigneur.service;

import com.apromac.saigneur.dto.InscriptionDTO;
import com.apromac.saigneur.entity.CampagneEntity;
import com.apromac.saigneur.entity.CandidatEntity;
import com.apromac.saigneur.entity.InscriptionEntity;
import com.apromac.saigneur.utility.InterviewRequest;

import java.util.List;

public interface InscriptionService {

    /**
     * Methode permettant de récupérer la liste des candidats en fonction de la campagne en cours, du statut et du district.
     * @param campagneEntity
     * @param statutCandidat
     * @param districtCandidat
     * @return
     */
    public List<InscriptionEntity> findByCampagneAndStatutAndDistrictInscription(CampagneEntity campagneEntity, Integer statutCandidat,
                                                                                 String districtCandidat);

    /**
     * Methode permettant de récupérer la liste des candidats en fonction de la campagne et du statut du candidat.
     * Réservé à l'administrateur
     * @param campagneEntity
     * @param statutCandidat
     * @return
     */
    public List<InscriptionEntity> findByCampagneAndStatut(CampagneEntity campagneEntity, Integer statutCandidat);

    /**
     * Methode permettant de sauvegarder l'inscription d'un candidat à une campagne
     * @param campagneEntity
     * @param candidatEntity
     * @param inscriptionDTO
     * @return
     */
    public InscriptionEntity saveInscriptionCampagneCandidat(CampagneEntity campagneEntity, CandidatEntity candidatEntity,
                                                             InscriptionDTO inscriptionDTO);

//    /**
//     * Methode permettant de sauvegarder une inscription d'un candidat
//     * @param inscriptionEntity
//     * @return
//     */
//    public InscriptionEntity saveInscription(InscriptionEntity inscriptionEntity);

    /**
     * Methode permettant de récupérer un objet Inscription grace à l'ID de l'inscription.
     * @param inscriptionID
     * @return
     */
    public InscriptionEntity findByInscriptionID(Long inscriptionID);

    /**
     * Methode permettant de modifier l'inscription du candidat d'une campagne grace à l'ID de l'inscription et un objet inscription
     * @param inscriptionTrouver
     * @param inscriptionEntity
     * @return
     */
    public InscriptionEntity updateInscription(InscriptionEntity inscriptionTrouver, InscriptionEntity inscriptionEntity);


    /**
     * Methode permettant de valider ou retirer un candidat dans la liste des candidats inscrits
     * @param inscriptionID
     * @param isSelect
     * @return
     */
    public InscriptionEntity findBySelectionInscriptionID(Long inscriptionID, Boolean isSelect);

//    /**
//     * Methode permettant de valider un candidat dans la liste des candidats selectionné
//     * @param inscriptionID
//     * @param isInterview
//     * @return
//     */
//    public InscriptionEntity findByInterviewInscriptionID(Long inscriptionID, Boolean isInterview);

    /**
     * Methode permettant de valider un candidat dans la liste des candidats interviewer
     * @param inscriptionID
     * @param isRetenus
     * @return
     */
    public InscriptionEntity findByRetenusInscriptionID(Long inscriptionID, Boolean isRetenus);


    /**
     * Méthode permettant de supprimer une inscription de candidat
     * @param inscriptionEntity
     * @return
     */
    public void deleteInscription(InscriptionEntity inscriptionEntity);


    /**
     * Methode permettant de récupérer la liste des inscriptions d'une campagne
     * @param campagneEntity
     * @return
     */
    public List<InscriptionEntity> findByCampagne(CampagneEntity campagneEntity);


    /******************************************************************************************************************/
    /**                                         IMPLEMENTATION PARTIE MOBILE                                         **/
    /******************************************************************************************************************/

    /**
     * Methode permettant de mettre à jour les informations de l'interview réalisé par le TDH
     * @param interviewRequest
     * @return
     */
    public List<InscriptionEntity> findByCandidatInterviewer(InterviewRequest interviewRequest);

    /**
     * Methode permettant de synchroniser les données des candidats à interviewer sur le mobile."
     * @param statutID
     * @param zoneCandidat
     * @return
     */
    public List<InscriptionEntity> findByStatutAndZoneAndInterview(Integer statutID, String zoneCandidat);

}



//    public InscriptionEntity findByValidationInterviewCandidats(CandidatEntity candidatEntity, CampagneEntity campagneEntity, Boolean isInterview);
//    public List<InscriptionEntity> findByCampagne(Long campagneID);
//    public InscriptionEntity findByInscriptionID(Long inscriptionID, Boolean isSelect);
//    public List<InscriptionEntity> findByCandidat(Long candidatID);
//    public List<InscriptionEntity> findByCampagneAndCandidat(Long campagneID, Long candidatID);
