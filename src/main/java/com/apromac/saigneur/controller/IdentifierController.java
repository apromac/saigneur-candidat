package com.apromac.saigneur.controller;

import com.apromac.saigneur.entity.IdentifierEntity;
import com.apromac.saigneur.service.IdentifierService;
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
public class IdentifierController {

    @Autowired
    private IdentifierService identifierService;

    @ApiOperation(value = "Méthode permettant de récupérer une identification grace à son ID")
    @GetMapping(value = "/identifier/findByIdentifierID/{identifierID}")
    public ResponseEntity<IdentifierEntity> recupererUnIdentifier(@PathVariable String identifierID) {
        Optional<IdentifierEntity> identifierOptional = identifierService.findByIdentifierID(identifierID);

        return new ResponseEntity<>(identifierOptional.get(), HttpStatus.OK);
    }

    @ApiOperation(value = "Méthode permettant de récupérer la liste des identifications grace à l'ID de la campagne")
    @GetMapping(value = "/identifier/findByCampagne/{campagneID}")
    public ResponseEntity<List<IdentifierEntity>> identifierParCampagne(@PathVariable Long campagneID) {
        List<IdentifierEntity> byCampagne = identifierService.findByCampagne(campagneID);

        return new ResponseEntity<>(byCampagne, HttpStatus.OK);
    }
}
