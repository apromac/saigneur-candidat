package com.apromac.saigneur.service;

import com.apromac.saigneur.dto.CandidatDTO;
import com.apromac.saigneur.entity.InscriptionEntity;

import java.util.List;

public interface CandidatService {

    /**
     * Methode permettant de constituer la liste des candidats provenant des inscriptions.
     * @param inscriptions objet representant la liste des inscriptions contenant les candidats de la campagne en cours
     *                     en fonction du statut et du district du candidat. Dans le cas d'une requete de l'administrateur,
     *                     la liste "inscriptions" est obtenue en fonction de la campagne et du statut
     * @return
     */
    public List<CandidatDTO> findByInscriptions(List<InscriptionEntity> inscriptions);


    /******************************************************************************************************************/
    /**                                         IMPLEMENTATION PARTIE MOBILE                                         **/
    /******************************************************************************************************************/

    /**
     * Methode permettant de synchroniser les données des candidats à interviewer sur le mobile."
     * @param inscriptions
     * @return
     */
    public List<CandidatDTO> findBySynchroInscriptions(List<InscriptionEntity> inscriptions);

}


//
//    public CandidatEntity saveCandidat(CandidatEntity candidat);
//    public List<CandidatDTO> candidatsByCampagne(List<InscriptionEntity> inscriptions);
//    public CandidatEntity findByCandidatID(Long candidatID);
//    public List<CandidatEntity> findAllCandidat();