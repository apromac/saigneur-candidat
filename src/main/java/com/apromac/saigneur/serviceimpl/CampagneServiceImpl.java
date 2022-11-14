package com.apromac.saigneur.serviceimpl;

import com.apromac.saigneur.entity.CampagneEntity;
import com.apromac.saigneur.entity.InscriptionEntity;
import com.apromac.saigneur.exception.NoContentException;
import com.apromac.saigneur.exception.NotAcceptableException;
import com.apromac.saigneur.exception.NotFoundException;
import com.apromac.saigneur.repository.CampagneRepository;
import com.apromac.saigneur.service.CampagneService;
import com.apromac.saigneur.service.InscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CampagneServiceImpl implements CampagneService {

    @Autowired
    private CampagneRepository campagneRepository;

    @Autowired
    private InscriptionService inscriptionService;



    /**
     * Methode permettant de récupérer la liste des campagnes
     * @return campagnes
     */
    @Override
    public List<CampagneEntity> findAllCampagne() {
        List<CampagneEntity> campagnes = campagneRepository.findAll();
        if (campagnes.isEmpty())
            throw new NoContentException("Désolé, aucune campagne disponible.");

        return campagnes;
    }



    /**
     * Methode permettant de récupérer la campagne en cours
     * @return campagneEntity
     */
    @Override
    public CampagneEntity findCurrentCampagne() {
        CampagneEntity campagneEntity = campagneRepository.findByActiveCampagneTrue();
        if (campagneEntity == null)
            throw new NotFoundException("Désolé, nous n'avons pas réussi à récupérer la campagne en cours.");

        return campagneEntity;
    }



    /**
     * Methode permettant de récuperer une campagne gras à son ID
     * @param campagneID
     * @return
     */
    @Override
    public CampagneEntity findByCampagneID(Long campagneID) {
        Optional<CampagneEntity> campagneOptional = campagneRepository.findById(campagneID);
        if (!campagneOptional.isPresent())
            throw new NotFoundException("Désolé, la campagne désignée n'existe pas.");

        return campagneOptional.get();
    }



    /**
     * Methode permettant de sauvegarder une campagne
     * @param campagneEntity represent l'objet Campagne
     * @return campagne Save
     */
    @Override
    public CampagneEntity saveCampagne(CampagneEntity campagneEntity) {
        List<CampagneEntity> campagnesActives = cheickAllCampagneActivated();
        if (campagnesActives.isEmpty()) {
            campagneEntity.setActiveCampagne(true);
        } else {
            disableAllCampagneActivated(campagnesActives);
            campagneEntity.setActiveCampagne(true);
        }

        campagneEntity.setLibelleCampagne(campagneEntity.getLibelleCampagne().toUpperCase());
        CampagneEntity campagneSave = campagneRepository.save(campagneEntity);
        if (campagneSave == null)
            throw new RuntimeException("Une erreur est survenu lors de la sauvegarde de la campagne.");

        return campagneSave;
    }


    /**
     * Methode permettant de modifier une campagne en fonction d'un objet CampagneTrouver, provenant de la base de données
     * et un objet CampagneEntity provenant de la partie cliente
     * @param campagneTrouver represente un objet campagne provenant de la base de données
     * @param campagneEntity represente un objet campagne provenant de la partie cliente
     * @return
     */
    @Override
    public CampagneEntity updateCampagne(CampagneEntity campagneTrouver, CampagneEntity campagneEntity) {
        CampagneEntity campagneActivated = campagneRepository.findByActiveCampagneTrue();

        if (campagneActivated != null) {
            if (campagneEntity.getActiveCampagne()) {
                campagneActivated.setActiveCampagne(false);
                campagneRepository.save(campagneActivated);

                campagneTrouver.setActiveCampagne(campagneEntity.getActiveCampagne());
                campagneTrouver.setLibelleCampagne(campagneEntity.getLibelleCampagne().toUpperCase());
            } else {
                campagneTrouver.setActiveCampagne(campagneEntity.getActiveCampagne());
                campagneTrouver.setLibelleCampagne(campagneEntity.getLibelleCampagne().toUpperCase());
            }
        }

        CampagneEntity campagneSave = campagneRepository.saveAndFlush(campagneTrouver);

        return campagneSave;
    }


    /**
     * Methode permettant de désactiver toutes les campagnes actives
     */
    private void disableAllCampagneActivated(List<CampagneEntity> campagnesActives) {
        for (CampagneEntity campagne: campagnesActives) {
            campagne.setActiveCampagne(false);
            campagneRepository.save(campagne);
        }
    }



    /**
     * Methode permettant de récupérer la liste des campagnes activées
     * @return
     */
    private List<CampagneEntity> cheickAllCampagneActivated() {
        List<CampagneEntity> campagneActives = new ArrayList<>();

        List<CampagneEntity> campagnes = campagneRepository.findAll();
        if (campagnes.isEmpty()) {
            return campagneActives;
        } else {
            for (CampagneEntity campagne: campagnes) {
                if (campagne.getActiveCampagne())
                    campagneActives.add(campagne);
            }
        }

        return campagneActives;
    }


    /**
     * Methode permettant de supprimer une campagne grace à un objet CampagneEntity
     * @param campagneEntity
     */
    public void deleteCampagne(CampagneEntity campagneEntity) {
        List<InscriptionEntity> inscriptionsTrouver = inscriptionService.findByCampagne(campagneEntity);
        if (inscriptionsTrouver.isEmpty()) {
            campagneRepository.delete(campagneEntity);
        } else {
            throw new NotAcceptableException("Désolé, cette campagne ne peut être supprimée car elle est rattachée à une autre entité.");
        }
    }

}

