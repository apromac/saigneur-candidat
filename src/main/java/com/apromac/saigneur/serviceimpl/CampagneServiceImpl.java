package com.apromac.saigneur.serviceimpl;

import com.apromac.saigneur.entity.CampagneEntity;
import com.apromac.saigneur.exception.NoContentException;
import com.apromac.saigneur.exception.NotFoundException;
import com.apromac.saigneur.repository.CampagneRepository;
import com.apromac.saigneur.service.CampagneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CampagneServiceImpl implements CampagneService {

    @Autowired
    private CampagneRepository campagneRepository;



    /**
     * Methode permettant de récupérer la liste des campagnes
     * @return campagnes
     */
    @Override
    public List<CampagneEntity> findAllCampagne() {
        List<CampagneEntity> campagnes = campagneRepository.findAll();
        if (campagnes.isEmpty())
            throw new NoContentException("Désolé, aucune campagne disponible");

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
            throw new NotFoundException("Désolé, nous n'avons pas réussi à récupérer la campagne en cours");

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
            throw new NotFoundException("Désolé, la campagne désignée n'existe pas");

        return campagneOptional.get();
    }



    /**
     * Methode permettant de sauvegarder une campagne
     * @param campagne represent l'objet Campagne
     * @return campagne Save
     */
    @Override
    public CampagneEntity saveCampagne(CampagneEntity campagne) {
        CampagneEntity campagneSave = campagneRepository.save(campagne);
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
        campagneTrouver.setActiveCampagne(campagneEntity.getActiveCampagne());
        campagneTrouver.setLibelleCampagne(campagneEntity.getLibelleCampagne());

        CampagneEntity campagneSave = campagneRepository.saveAndFlush(campagneTrouver);

        return campagneSave;
    }

}

