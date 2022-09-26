package com.apromac.saigneur.controller;

import com.apromac.saigneur.entity.CampagneEntity;
import com.apromac.saigneur.entity.CandidatEntity;
import com.apromac.saigneur.entity.InscriptionEntity;
import com.apromac.saigneur.service.CampagneService;
import com.apromac.saigneur.service.CandidatService;
import com.apromac.saigneur.service.InscriptionService;
import com.apromac.saigneur.utility.CandidatCampagneRequest;
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
public class InscriptionController {

    @Autowired
    private InscriptionService inscriptionService;

    @Autowired
    private CampagneService campagneService;

    @Autowired
    private CandidatService candidatService;



    @ApiOperation(value = "Méthode permettant de sauvegarder l'inscription d'un candidat pour une campagne prévise")
    @PostMapping(value = "/inscription/saveInscription")
    public ResponseEntity<InscriptionEntity> sauvegarderInscription(@RequestBody CandidatCampagneRequest candidatCampagneRequest) {
        CampagneEntity campagneTrouver = campagneService.findByCampagneID(candidatCampagneRequest.getCampagneEntity().getCampagneID());
        if (campagneTrouver == null)
            throw new RuntimeException("Désolé, aucune campagne trouvé avec cet ID");

        InscriptionEntity saveInscription = inscriptionService.saveInscriptionCampagneCandidat(
                campagneTrouver,
                candidatCampagneRequest.getCandidatEntity(),
                candidatCampagneRequest.getInscriptionDTO());
        if (saveInscription == null)
            throw new RuntimeException("Désolé, une erreur est survenue lors de la sauvegarde des informations relatives à l'insnscription du candidat");

        return new ResponseEntity<>(saveInscription, HttpStatus.CREATED);
    }

    @ApiOperation(value = "Méthode permettant de recupérer les candidats de la campagne en cours avec plus de details")
    @GetMapping(value = "/inscription/candidat/selection/{isSelect}")
    public ResponseEntity<List<InscriptionEntity>> recupererSelectionCandidat(@PathVariable Boolean isSelect) {
        List<InscriptionEntity> inscriptions = inscriptionService.findSelectionCandidats(isSelect);

        return new ResponseEntity<>(inscriptions, HttpStatus.OK);
    }



//    @ApiOperation(value = "Méthode permettant de valider un candidat")
//    @GetMapping(value = "/inscription/candidat/selection/{isValid}")
//    public ResponseEntity<List<InscriptionEntity>> recupererValidationCandidat(@PathVariable Boolean isSelect/*, @RequestParam Long candidatID*/) {
////        CandidatEntity candidatOptional = candidatService.findByCandidatID(candidatID);
//
//        List<InscriptionEntity> inscriptions = inscriptionService.findValidationCandidats(isValid);
//
//        return new ResponseEntity<>(inscriptions, HttpStatus.OK);
//    }






















//    @ApiOperation(value = "Méthode permettant de récupérer une identification grace à son ID")
//    @GetMapping(value = "/inscription/findByIdentifierID/{identifierID}")
//    public ResponseEntity<InscriptionEntity> recupererUnIdentifier(@PathVariable String identifierID) {
//        InscriptionEntity byIdentifierID = inscriptionService.findByIdentifierID(identifierID);
//
//        return new ResponseEntity<>(byIdentifierID, HttpStatus.OK);
//    }

    @ApiOperation(value = "Méthode permettant de récupérer la liste des identifications grace à l'ID de la campagne")
    @GetMapping(value = "/inscription/findByCampagne/{campagneID}")
    public ResponseEntity<List<InscriptionEntity>> identifierParCampagne(@PathVariable Long campagneID) {
        List<InscriptionEntity> byCampagne = inscriptionService.findByCampagne(campagneID);

        return new ResponseEntity<>(byCampagne, HttpStatus.OK);
    }

}
