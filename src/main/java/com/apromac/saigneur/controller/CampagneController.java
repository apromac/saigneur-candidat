package com.apromac.saigneur.controller;

import com.apromac.saigneur.entity.CampagneEntity;
import com.apromac.saigneur.service.CampagneService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/v1")
public class CampagneController {

    @Autowired
    private CampagneService campagneService;


    @ApiOperation(value = "Méthode permettant de sauvegarder une campagne")
    @PostMapping(value = "/campagne/saveCampagne")
    public ResponseEntity<CampagneEntity> sauvegarderUneCampagne(@RequestBody CampagneEntity campagne) {
        CampagneEntity campagneSave = campagneService.saveCampagne(campagne);

        return new ResponseEntity<>(campagneSave, HttpStatus.CREATED);
    }

    @ApiOperation(value = "Méthode permettant de récupérer la liste des campagnes")
    @GetMapping(value = "/campagne/findAllCampagne")
    public ResponseEntity<List<CampagneEntity>> recupererCampagnes() {
        List<CampagneEntity> campagnes = campagneService.findAllCampagne();

        return new ResponseEntity<>(campagnes, HttpStatus.OK);
    }

    @ApiOperation(value = "Méthode permettant de récupérer la compagne en cours")
    @GetMapping(value = "/campagne/findCurrentCampagne")
    public ResponseEntity<CampagneEntity> recupererCampagneEnCours() {
        CampagneEntity campagne = campagneService.findCurrentCampagne();

        return new ResponseEntity<>(campagne, HttpStatus.OK);
    }






















    @ApiOperation(value = "Méthode permettant de récupérer une campagne grace à son ID")
    @GetMapping(value = "/campagne/findByCampagneID/{campagneID}")
    public ResponseEntity<CampagneEntity> recupererUneCampagne(@PathVariable long campagneID) {
        CampagneEntity campagne = campagneService.findByCampagneID(campagneID);

        return new ResponseEntity<>(campagne, HttpStatus.OK);
    }

}
