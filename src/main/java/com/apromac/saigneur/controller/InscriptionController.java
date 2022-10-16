package com.apromac.saigneur.controller;

import com.apromac.saigneur.entity.CampagneEntity;
import com.apromac.saigneur.entity.CandidatEntity;
import com.apromac.saigneur.entity.InscriptionEntity;
import com.apromac.saigneur.exception.NoContentException;
import com.apromac.saigneur.exception.NotFoundException;
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



    @ApiOperation(value = "Méthode permettant de sauvegarder l'inscription d'un candidat pour une campagne précise")
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



    @ApiOperation(value = "Méthode permettant de valider ou retirer un candidat dans la liste des candidats à selectionner")
    @GetMapping(value = "/inscription/{inscriptionID}/selection/{isSelect}")
    public ResponseEntity<InscriptionEntity> recupererValidationCandidat(@PathVariable Long inscriptionID,
                                                                         @PathVariable Boolean isSelect) {
        InscriptionEntity inscription = inscriptionService.findByInscriptionID(inscriptionID, isSelect);

        return new ResponseEntity<>(inscription, HttpStatus.OK);
    }



    @ApiOperation(value = "Méthode permettant de valider les candidats de l'interview de la campagne en cours")
    @GetMapping(value = "/inscription/candidat/{candidatID}/interview/{isInterview}")
    public ResponseEntity<InscriptionEntity> recupererValidationInterviewCandidat(@PathVariable Long candidatID,
                                                                                  @PathVariable Boolean isInterview) {
        CampagneEntity campagne = campagneService.findCurrentCampagne();

        CandidatEntity candidat = candidatService.findByCandidatID(candidatID);
        if (candidat == null)
            throw new NotFoundException("Désolé, le candidat sélectionné n'existe pas dans la base.");

        InscriptionEntity inscriptions = inscriptionService.findByValidationInterviewCandidats(candidat, campagne, isInterview);

        return new ResponseEntity<>(inscriptions, HttpStatus.OK);
    }



    @ApiOperation(value = "Méthode permettant de recevoir les données de l'interview transmis par le TDH")
    @PutMapping(value = "/inscription/updateInterview")
    public ResponseEntity<List<InscriptionEntity>> majInterview(@RequestBody CandidatCampagneRequest candidatCampagneRequest) {
//        CampagneEntity campagneTrouver = campagneService.findByCampagneID(candidatCampagneRequest.getCampagneEntity().getCampagneID());
//        if (campagneTrouver == null)
//            throw new RuntimeException("Désolé, aucune campagne trouvé avec cet ID");
//
//        InscriptionEntity saveInscription = inscriptionService.saveInscriptionCampagneCandidat(
//                campagneTrouver,
//                candidatCampagneRequest.getCandidatEntity(),
//                candidatCampagneRequest.getInscriptionDTO());
//        if (saveInscription == null)
//            throw new RuntimeException("Désolé, une erreur est survenue lors de la sauvegarde des informations relatives à l'insnscription du candidat");
//
//        return new ResponseEntity<>(saveInscription, HttpStatus.CREATED);

        throw new NoContentException("La methode est en cours d'élaboration.");
    }













    @ApiOperation(value = "Méthode permettant de récupérer la liste des identifications grace à l'ID de la campagne")
    @GetMapping(value = "/inscription/findByCampagne/{campagneID}")
    public ResponseEntity<List<InscriptionEntity>> identifierParCampagne(@PathVariable Long campagneID) {
        List<InscriptionEntity> byCampagne = inscriptionService.findByCampagne(campagneID);

        return new ResponseEntity<>(byCampagne, HttpStatus.OK);
    }

}
