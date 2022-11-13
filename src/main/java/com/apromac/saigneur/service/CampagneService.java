package com.apromac.saigneur.service;

import com.apromac.saigneur.entity.CampagneEntity;

import java.util.List;

public interface CampagneService {

    /**
     * Methode permettant de récupérer la liste des campagnes
     * @return
     */
    public List<CampagneEntity> findAllCampagne();

    /**
     * Methode permettant de récupérer la campagne en cours
     * @return
     */
    public CampagneEntity findCurrentCampagne();

    /**
     * Methode permettant de récupérer une camgagne grace à son  ID
     * @param campagneID
     * @return
     */
    public CampagneEntity findByCampagneID(Long campagneID);

    /**
     * Methode permettant de sauvegarder une campagne
     * @param campagne
     * @return
     */
    public CampagneEntity saveCampagne(CampagneEntity campagne);

    /**
     * Methode permettant de modifier une campagne en fonction d'un objet CampagneTrouver et CampagneEntity
     * @param campagneTrouver
     * @param campagneEntity
     * @return
     */
    public CampagneEntity updateCampagne(CampagneEntity campagneTrouver, CampagneEntity campagneEntity);

    /**
     * Methode permetant de supprimer une campagne grace à son ID
     * @param campagneEntity
     */
    public void deleteCampagne(CampagneEntity campagneEntity);

}

