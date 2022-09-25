package com.apromac.saigneur.controller;

import com.apromac.saigneur.dto.CandidatDTO;
import com.apromac.saigneur.entity.CampagneEntity;
import com.apromac.saigneur.entity.CandidatEntity;
import com.apromac.saigneur.entity.InscriptionEntity;
import com.apromac.saigneur.exception.NoContentException;
import com.apromac.saigneur.service.CampagneService;
import com.apromac.saigneur.service.CandidatService;
import com.apromac.saigneur.service.InscriptionService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/v1")
public class CandidatController {

    @Autowired
    private CandidatService candidatService;

    @Autowired
    private CampagneService campagneService;

    @Autowired
    private InscriptionService inscriptionService;



    @ApiOperation(value = "Méthode permettant de récupérer la liste des candidats d'une campagne grace à son ID")
    @GetMapping(value = "/candidat/campagne/findByCampagneID/{campagneID}")
    public ResponseEntity<List<CandidatDTO>> recupererCandidatParCampagne(@PathVariable long campagneID) {
        List<InscriptionEntity> inscriptions = inscriptionService.findByCampagne(campagneID);
        if (inscriptions.isEmpty())
            throw new NoContentException("Désolé, la liste ne contient aucune inscription pour cette campagne.");

        List<CandidatDTO> candidatsByCampagne = candidatService.candidatsByCampagne(inscriptions);
        if (candidatsByCampagne.isEmpty())
            throw new NoContentException("Désolé, la liste ne contient aucun candidat pour cette campagne.");

        return new ResponseEntity<>(candidatsByCampagne, HttpStatus.OK);
    }


    @ApiOperation(value = "Méthode permettant de récupérer la liste des candidats de la campagne en cours")
    @GetMapping(value = "/candidat/campagne/findByCurrentCampagne")
    public ResponseEntity<List<CandidatDTO>> recupererCandidatCampagneActuel() {
        CampagneEntity campagne = campagneService.findCurrentCampagne();

        List<InscriptionEntity> inscriptions = inscriptionService.findByCampagne(campagne.getCampagneID());
        if (inscriptions.isEmpty())
            throw new NoContentException("Désolé, la liste ne contient aucune inscription pour cette campagne.");

        List<CandidatDTO> candidatsByCampagne = candidatService.candidatsByCampagne(inscriptions);
        if (candidatsByCampagne.isEmpty())
            throw new NoContentException("Désolé, la liste ne contient aucun candidat pour cette campagne.");

        return new ResponseEntity<>(candidatsByCampagne, HttpStatus.OK);
    }
























    @ApiOperation(value = "Méthode permettant de récupérer un candidat grace à son ID")
    @GetMapping(value = "/candidat/findByCandidatID/{candidatID}")
    public ResponseEntity<CandidatEntity> recupererUnCandidat(@PathVariable long candidatID) {
        CandidatEntity candidat = candidatService.findByCandidatID(candidatID);

        return new ResponseEntity<>(candidat, HttpStatus.OK);
    }



    @ApiOperation(value = "Méthode permettant de sauvegarder un candidat")
    @PostMapping(value = "/candidat/saveCandidat")
    public ResponseEntity<CandidatEntity> sauvegarderUnCandidat(@RequestBody CandidatEntity candidat) {
        CandidatEntity candidatSave = candidatService.saveCandidat(candidat);

        return new ResponseEntity<>(candidatSave, HttpStatus.CREATED);
    }

    @ApiOperation(value = "Méthode permettant de récupérer tous candidats, quelques soit la campagne")
    @GetMapping(value = "/candidat/findAllCandidat")
    public ResponseEntity<List<CandidatEntity>> recupererCandidats() {
        List<CandidatEntity> candidats = candidatService.findAllCandidat();

        return new ResponseEntity<>(candidats, HttpStatus.OK);
    }

}
