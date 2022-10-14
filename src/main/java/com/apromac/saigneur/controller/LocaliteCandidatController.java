package com.apromac.saigneur.controller;

import com.apromac.saigneur.bean.OccuperBean;
import com.apromac.saigneur.dto.LocaliteCandidatDTO;
import com.apromac.saigneur.exception.NoContentException;
import com.apromac.saigneur.exception.NotFoundException;
import com.apromac.saigneur.proxy.MicroserviceUtilisateurProxy;
import com.apromac.saigneur.service.LocaliteCandidatService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/v1")
public class LocaliteCandidatController {

    @Autowired
    private MicroserviceUtilisateurProxy microserviceUtilisateurProxy;

    @Autowired
    private LocaliteCandidatService localiteCandidatService;



    @ApiOperation(value = "Méthode permettant de récupérer la localite du candidat grace à l'ID du poste du TDH")
    @GetMapping(value = "/localite/findByPosteTDH/{posteID}")
    public ResponseEntity<LocaliteCandidatDTO> recupererLocaliteCandidatParPosteTDH(@PathVariable Long posteID) {
        OccuperBean occuperBeans = microserviceUtilisateurProxy.recupererPosteActuelTDHOccuper(posteID);
        if (occuperBeans == null)
            throw new NotFoundException("Désolé, nous n'avons pas pu récupérer les informations relatives à la zone du TDH");

        LocaliteCandidatDTO localiteCandidat = localiteCandidatService.findByPosteTDH(occuperBeans);

        return new ResponseEntity<>(localiteCandidat, HttpStatus.OK);
    }


    @ApiOperation(value = "Méthode permettant de récupérer la localite du candidat grace à l'ID du poste du TDH")
    @GetMapping(value = "/localite/occuper/findByPosteTDH/{posteID}")
    public ResponseEntity<OccuperBean> recupererOccuperUtilisateur(@PathVariable Long posteID) {
        OccuperBean occuperBeans = microserviceUtilisateurProxy.recupererPosteActuelTDHOccuper(posteID);
        if (occuperBeans == null)
            throw new NotFoundException("Désolé, nous n'avons pas pu récupérer les informations relatives à la zone du TDH");

        return new ResponseEntity<>(occuperBeans, HttpStatus.OK);
    }


    @ApiOperation(value = "Méthode permettant de récupérer la liste des TDH avec leur localités en fonction de l'utilisateur connecté")
    @GetMapping(value = "/localite/posteTDH/{posteID}/district/{district}")
    public ResponseEntity<List<LocaliteCandidatDTO>> recupererLocaliteTDHParDistrict(@PathVariable Long posteID, @PathVariable String district) {
        List<OccuperBean> occuperBeans = microserviceUtilisateurProxy.recupererPosteActuelTDHParDisctrict(posteID, district);
        if (occuperBeans.isEmpty())
            throw new NoContentException("Désolé, nous n'avons pas pu récupérer les informations relatives à la zone du TDH");

        List<LocaliteCandidatDTO> posteTDHParDistrict = localiteCandidatService.findByPosteTDH(occuperBeans);

        return new ResponseEntity<>(posteTDHParDistrict, HttpStatus.OK);
    }

}
