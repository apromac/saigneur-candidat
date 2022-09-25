package com.apromac.saigneur.serviceimpl;

import com.apromac.saigneur.dto.CandidatDTO;
import com.apromac.saigneur.entity.CandidatEntity;
import com.apromac.saigneur.entity.InscriptionEntity;
import com.apromac.saigneur.exception.NotFoundException;
import com.apromac.saigneur.repository.CandidatRepository;
import com.apromac.saigneur.service.CandidatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CandidatServiceImpl implements CandidatService {

    @Autowired
    private CandidatRepository candidatRepository;



    /**
     *
     * @param inscriptions
     * @return
     */
    public List<CandidatDTO> candidatsByCampagne(List<InscriptionEntity> inscriptions) {
        List<CandidatDTO> candidatsDTO = new ArrayList<>();
        for (InscriptionEntity inscription: inscriptions) {
            CandidatDTO candidatDTO = new CandidatDTO();

            CandidatEntity candidat = inscription.getCandidat();

            candidatDTO.setCandidatID(candidat.getCandidatID());
            candidatDTO.setNomCandidat(candidat.getNomCandidat());
            candidatDTO.setPrenomsCandidat(candidat.getPrenomsCandidat());
            candidatDTO.setGenreCandidat(candidat.getGenreCandidat());
            candidatDTO.setDateNaisCandidat(candidat.getDateNaisCandidat());
            candidatDTO.setLieuNaisCandidat(candidat.getLieuNaisCandidat());
            candidatDTO.setLieuResidCandidat(candidat.getLieuResidCandidat());
            candidatDTO.setNiveauEtudeCandidat(candidat.getNiveauEtudeCandidat());
            candidatDTO.setMetierActuelCandidat(candidat.getMetierActuelCandidat());
            candidatDTO.setPremierContactCandidat(candidat.getPremierContactCandidat());
            candidatDTO.setSecondContactCandidat(candidat.getSecondContactCandidat());
            candidatDTO.setTypePieceCandidat(candidat.getTypePieceCandidat());
            candidatDTO.setNumeroPieceCandidat(candidat.getNumeroPieceCandidat());
            candidatDTO.setCampagneEntity(inscription.getCampagne());
            candidatDTO.setInscriptionID(inscription.getInscriptionID());
            candidatDTO.setDistrictInscription(inscription.getDistrictInscription());
//            candidatDTO.setAbreviationDistrictInscription(inscription.getAbreviationDistrictInscription());
            candidatDTO.setZoneInscription(inscription.getZoneInscription());
            candidatDTO.setDateInscription(inscription.getDateInscription());

            candidatsDTO.add(candidatDTO);
        }

        return candidatsDTO;
    }




























    /**
     *
     * @param candidatID
     * @return
     */
    @Override
    public CandidatEntity findByCandidatID(Long candidatID) {
        Optional<CandidatEntity> candidatOptional = candidatRepository.findById(candidatID);
        if (!candidatOptional.isPresent())
            throw new NotFoundException("Désolé, la campagne désignée n'existe pas");

        return candidatOptional.get();
    }

    /**
     *
     * @param candidat
     * @return
     */
    @Override
    public CandidatEntity saveCandidat(CandidatEntity candidat) {
        CandidatEntity candidatSave = candidatRepository.save(candidat);
        if (candidatSave == null)
            throw new RuntimeException("Une erreur est survenu lors de la sauvegarde du candidat.");

        return candidatSave;
    }

    /**
     *
     * @return
     */
    @Override
    public List<CandidatEntity> findAllCandidat() {
        List<CandidatEntity> candidats = candidatRepository.findAll();
        if (candidats.isEmpty())
            throw new NotFoundException("Désolé, aucun candidat disponible");

        return candidats;
    }

}
