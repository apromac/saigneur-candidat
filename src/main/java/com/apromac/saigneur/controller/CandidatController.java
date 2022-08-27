package com.apromac.saigneur.controller;

import com.apromac.saigneur.entity.CandidatEntity;
import com.apromac.saigneur.service.CandidatService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/v1")
public class CandidatController {

    @Autowired
    private CandidatService candidatService;

    @ApiOperation(value = "Méthode permettant de récupérer un candidat grace à son ID")
    @GetMapping(value = "/candidat/findByCandidatID/{candidatID}")
    public ResponseEntity<CandidatEntity> recupererUnCandidat(@PathVariable long candidatID) {
        Optional<CandidatEntity> candidatOptional = candidatService.findByCandidatID(candidatID);

        return new ResponseEntity<>(candidatOptional.get(), HttpStatus.OK);
    }

    @ApiOperation(value = "Méthode permettant de récupérer tous candidats, quelques soit la campagne")
    @GetMapping(value = "/candidat/findAllCandidat")
    public ResponseEntity<List<CandidatEntity>> recupererCandidats() {
        List<CandidatEntity> candidats = candidatService.findAllCandidat();

        return new ResponseEntity<>(candidats, HttpStatus.OK);
    }

}
