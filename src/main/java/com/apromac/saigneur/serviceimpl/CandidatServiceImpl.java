package com.apromac.saigneur.serviceimpl;

import com.apromac.saigneur.dto.CandidatDTO;
import com.apromac.saigneur.entity.CampagneEntity;
import com.apromac.saigneur.entity.CandidatEntity;
import com.apromac.saigneur.entity.InscriptionEntity;
import com.apromac.saigneur.exception.NoContentException;
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
            // candidat
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


            CampagneEntity campagne = inscription.getCampagne();
            //campagne
            candidatDTO.setCampagneID(campagne.getCampagneID());
            candidatDTO.setLibelleCampagne(campagne.getLibelleCampagne());
            candidatDTO.setActiveCampagne(campagne.getActiveCampagne());


            //inscription
            candidatDTO.setDistrictInscription(inscription.getDistrictInscription());
            candidatDTO.setZoneInscription(inscription.getZoneInscription());
            candidatDTO.setDateInscription(inscription.getDateInscription());
            candidatDTO.setIsFormer(inscription.getIsFormer());
            candidatDTO.setStructureFormation(inscription.getStructureFormation());
            candidatDTO.setAnneeFormation(inscription.getAnneeFormation());
            candidatDTO.setIsAppliquer(inscription.getIsAppliquer());
            candidatDTO.setTypeFormation(inscription.getTypeFormation());
            candidatDTO.setLieuFormation(inscription.getLieuFormation());
            candidatDTO.setTypeSaigneFormation(inscription.getTypeSaigneFormation());
            candidatDTO.setNomPlanteurFormation(inscription.getNomPlanteurFormation());
            candidatDTO.setMatriculePlanteurFormation(inscription.getMatriculePlanteurFormation());
            candidatDTO.setLieuPlanteurFormation(inscription.getLieuPlanteurFormation());
            candidatDTO.setAnneePlanteurFormation(inscription.getAnneePlanteurFormation());
            candidatDTO.setContactPlanteurFormation(inscription.getContactPlanteurFormation());
            candidatDTO.setPropositionEmploi(inscription.getPropositionEmploi());
            candidatDTO.setNomPlanteurEmploi(inscription.getNomPlanteurEmploi());
            candidatDTO.setMatriculePlanteurEmploi(inscription.getMatriculePlanteurEmploi());
            candidatDTO.setLieuPlanteurEmploi(inscription.getLieuPlanteurEmploi());
            candidatDTO.setAnneePlanteurEmploi(inscription.getAnneePlanteurEmploi());
            candidatDTO.setContactPlanteurEmploi(inscription.getContactPlanteurEmploi());
            candidatDTO.setIsActivite(inscription.getIsActivite());
            candidatDTO.setNomPlanteurActivite(inscription.getNomPlanteurActivite());
            candidatDTO.setMatriculePlanteurActivite(inscription.getMatriculePlanteurActivite());
            candidatDTO.setLieuPlanteurActivite(inscription.getLieuPlanteurActivite());
            candidatDTO.setAnneePlanteurActivite(inscription.getAnneePlanteurActivite());
            candidatDTO.setContactPlanteurActivite(inscription.getContactPlanteurActivite());
            candidatDTO.setMotivation(inscription.getMotivation());
            candidatDTO.setStatut(inscription.getStatut());

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
            throw new NotFoundException("Désolé, le candidat désignée n'existe pas");

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
            throw new NoContentException("Désolé, aucun candidat disponible");

        return candidats;
    }

}
