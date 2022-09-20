package com.apromac.saigneur.controller;

import com.apromac.saigneur.entity.CandidatEntity;
import com.apromac.saigneur.entity.IdentifierEntity;
import com.apromac.saigneur.exception.NoContentException;
import com.apromac.saigneur.service.CandidatService;
import com.apromac.saigneur.service.IdentifierService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/v1")
public class CandidatController {

    @Autowired
    private CandidatService candidatService;

    @Autowired
    private IdentifierService identifierService;

    @ApiOperation(value = "Méthode permettant de récupérer un candidat grace à son ID")
    @GetMapping(value = "/candidat/findByCandidatID/{candidatID}")
    public ResponseEntity<CandidatEntity> recupererUnCandidat(@PathVariable long candidatID) {
        CandidatEntity candidat = candidatService.findByCandidatID(candidatID);

        return new ResponseEntity<>(candidat, HttpStatus.OK);
    }

    @ApiOperation(value = "Méthode permettant de récupérer la liste des candidats d'une campagne grace à son ID")
    @GetMapping(value = "/candidat/findByCampagneID/{campagneID}")
    public ResponseEntity<List<CandidatEntity>> recupererCandidatParCampagne(@PathVariable long campagneID) {
        List<IdentifierEntity> byCampagne = identifierService.findByCampagne(campagneID);

        List<CandidatEntity> candidats = new ArrayList<>();

        for (IdentifierEntity identify: byCampagne) {
            CandidatEntity candidat = identify.getCandidat();
            candidats.add(candidat);
        }

        if (candidats.isEmpty())
            throw new NoContentException("Désolé, aucun candidat trouvé.");

        return new ResponseEntity<>(candidats, HttpStatus.OK);
    }

    @ApiOperation(value = "Méthode permettant de sauvegarder un candidat")
    @PostMapping(value = "/candidat/saveCandidat")
    public ResponseEntity<CandidatEntity> sauvegarderUnCandidat(@RequestBody CandidatEntity candidat) {
        CandidatEntity candidatSave = candidatService.saveCandidat(candidat);

        return new ResponseEntity<>(candidatSave, HttpStatus.OK);
    }

    @ApiOperation(value = "Méthode permettant de récupérer tous candidats, quelques soit la campagne")
    @GetMapping(value = "/candidat/findAllCandidat")
    public ResponseEntity<List<CandidatEntity>> recupererCandidats() {
        List<CandidatEntity> candidats = candidatService.findAllCandidat();

        return new ResponseEntity<>(candidats, HttpStatus.OK);
    }

}

