package com.apromac.saigneur.controller;

import com.apromac.saigneur.entity.CampagneEntity;
import com.apromac.saigneur.entity.InscriptionEntity;
import com.apromac.saigneur.service.CampagneService;
import com.apromac.saigneur.service.CandidatService;
import com.apromac.saigneur.service.InscriptionService;
import com.apromac.saigneur.utility.CandidatCampagneRequest;
import com.apromac.saigneur.utility.InterviewRequest;
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





    @ApiOperation(value = "Méthode permettant de sauvegarder l'inscription d'un candidat en fonction d'une campagne")
    @PostMapping(value = "/inscription/saveInscription")
    public ResponseEntity<InscriptionEntity> sauvegarderInscription(@RequestBody CandidatCampagneRequest candidatCampagneRequest) {
        CampagneEntity campagneTrouver = campagneService.findByCampagneID(candidatCampagneRequest.getCampagneEntity().getCampagneID());

        InscriptionEntity saveInscription = inscriptionService.saveInscriptionCampagneCandidat(
                campagneTrouver,
                candidatCampagneRequest.getCandidatEntity(),
                candidatCampagneRequest.getInscriptionDTO());

        return new ResponseEntity<>(saveInscription, HttpStatus.CREATED);
    }



    @ApiOperation(value = "Méthode permettant de modifier l'inscription du candidat d'une campagne grace à l'ID de" +
            "l'inscription et un objet inscription")
    @PutMapping(value = "/inscription/{inscriptionID}")
    public ResponseEntity<InscriptionEntity> modifierUneInscription(@RequestBody InscriptionEntity inscriptionEntity,
                                                                    @PathVariable Long inscriptionID) {
        InscriptionEntity inscriptionTrouver = inscriptionService.findByInscriptionID(inscriptionID);


        InscriptionEntity updateInscription = inscriptionService.updateInscription(inscriptionTrouver, inscriptionEntity);

        return new ResponseEntity<>(updateInscription, HttpStatus.OK);
    }





    @ApiOperation(value = "Méthode permettant de valider ou retirer un candidat dans la liste des candidats inscrits")
    @GetMapping(value = "/inscription/{inscriptionID}/selection/{isSelect}")
    public ResponseEntity<InscriptionEntity> recupererValidationSelectionCandidat(@PathVariable Long inscriptionID,
                                                                                  @PathVariable Boolean isSelect) {
        InscriptionEntity inscription = inscriptionService.findBySelectionInscriptionID(inscriptionID, isSelect);

        return new ResponseEntity<>(inscription, HttpStatus.OK);
    }



    @ApiOperation(value = "Méthode permettant de valider les candidats retenus pour l'interview de la campagne en cours")
    @GetMapping(value = "/inscription/{inscriptionID}/interview/{isInterview}")
    public ResponseEntity<InscriptionEntity> recupererValidationInterviewCandidat(@PathVariable Long inscriptionID,
                                                                                  @PathVariable Boolean isInterview) {
        InscriptionEntity inscription = inscriptionService.findByInterviewInscriptionID(inscriptionID, isInterview);

        return new ResponseEntity<>(inscription, HttpStatus.OK);
    }



    @ApiOperation(value = "Méthode permettant de valider les candidats retenus à l'interview de la campagne en cours")
    @GetMapping(value = "/inscription/{inscriptionID}/retenus/{isRetenus}")
    public ResponseEntity<InscriptionEntity> recupererValidationRetenuesCandidat(@PathVariable Long inscriptionID,
                                                                                 @PathVariable Boolean isRetenus) {
        InscriptionEntity inscription = inscriptionService.findByRetenusInscriptionID(inscriptionID, isRetenus);

        return new ResponseEntity<>(inscription, HttpStatus.OK);
    }


    /******************************************************************************************************************/
    /**                                        IMPLEMENTATION DE LA PARTIE MOBILE                                    **/
    /******************************************************************************************************************/

    @ApiOperation(value = "Methode permettant de mettre à jour les informations de l'interview réalisé par le TDH avec le mobile")
    @PutMapping(value = "/inscription/candidat/interviewer")
    public ResponseEntity<List<InscriptionEntity>> recupererCandidatInterviewer(@RequestBody InterviewRequest interviewRequest) {
        List<InscriptionEntity> inscriptionEntities = inscriptionService.findByCandidatInterviewer(interviewRequest);

        return new ResponseEntity<>(inscriptionEntities, HttpStatus.OK);
    }


// Cette methode a été deplacé dans CandaidatController mais le findByStatutAndZoneAndInterview est utilisé
//    @ApiOperation(value = "Methode permettant de synchroniser les données des candidats à interviewer sur le mobile." +
//            "ici, les candidats ne sont pas encore interviewer. isInterviewer doit etre à 'false'")
//    @GetMapping(value = "/inscription/statut/{statutID}/zone/{zoneCandidat}/interview")
//    public ResponseEntity<List<InscriptionEntity>> synchroniserCandidatParStatutEtZoneEtInterview(@PathVariable Integer statutID,
//                                                                                                  @PathVariable String zoneCandidat) {
//        List<InscriptionEntity> inscriptionEntities = inscriptionService.findByStatutAndZoneAndInterview(statutID, zoneCandidat);
//
//        return new ResponseEntity<>(inscriptionEntities, HttpStatus.OK);
//    }

}







//    @ApiOperation(value = "Méthode permettant de valider les candidats retenus pour l'interview de la campagne en cours")
//    @GetMapping(value = "/inscription/candidat/{candidatID}/interview/{isInterview}")
//    public ResponseEntity<InscriptionEntity> recupererValidationInterviewCandidat(@PathVariable Long candidatID,
//                                                                                  @PathVariable Boolean isInterview) {
//
//
//        CampagneEntity campagne = campagneService.findCurrentCampagne();
//
//        CandidatEntity candidat = candidatService.findByCandidatID(candidatID);
//
//        InscriptionEntity inscriptions = inscriptionService.findByValidationInterviewCandidats(candidat, campagne, isInterview);
//
//        return new ResponseEntity<>(inscriptions, HttpStatus.OK);
//    }
//
//
//
//
//    @ApiOperation(value = "Méthode permettant de recevoir les données de l'interview transmis par le TDH")
//    @PutMapping(value = "/inscription/updateInterview")
//    public ResponseEntity<List<InscriptionEntity>> majInterview(@RequestBody CandidatCampagneRequest candidatCampagneRequest) {
////        CampagneEntity campagneTrouver = campagneService.findByCampagneID(candidatCampagneRequest.getCampagneEntity().getCampagneID());
////        if (campagneTrouver == null)
////            throw new RuntimeException("Désolé, aucune campagne trouvé avec cet ID");
////
////        InscriptionEntity saveInscription = inscriptionService.saveInscriptionCampagneCandidat(
////                campagneTrouver,
////                candidatCampagneRequest.getCandidatEntity(),
////                candidatCampagneRequest.getInscriptionDTO());
////        if (saveInscription == null)
////            throw new RuntimeException("Désolé, une erreur est survenue lors de la sauvegarde des informations relatives à l'insnscription du candidat");
////
////        return new ResponseEntity<>(saveInscription, HttpStatus.CREATED);
//
//        throw new NoContentException("La methode est en cours d'élaboration.");
//    }
//

//
//    @ApiOperation(value = "Méthode permettant de récupérer la liste des identifications grace à l'ID de la campagne")
//    @GetMapping(value = "/inscription/findByCampagne/{campagneID}")
//    public ResponseEntity<List<InscriptionEntity>> identifierParCampagne(@PathVariable Long campagneID) {
//        List<InscriptionEntity> byCampagne = inscriptionService.findByCampagne(campagneID);
//
//        return new ResponseEntity<>(byCampagne, HttpStatus.OK);
//    }

//    @ApiOperation(value = "Méthode permettant de sauvegarder l'inscription d'un candidat")
//    @PostMapping(value = "/inscription/saveInscription")
//    public ResponseEntity<InscriptionEntity> sauvegarderInscription(@RequestBody InscriptionEntity inscriptionEntity) {
//
//        InscriptionEntity saveInscription = inscriptionService.saveInscription(inscriptionEntity);
//
//        return new ResponseEntity<>(saveInscription, HttpStatus.CREATED);
//    }