package com.apromac.saigneur.controller;

import com.apromac.saigneur.bean.OccuperBean;
import com.apromac.saigneur.dto.LocaliteCandidatDTO;
import com.apromac.saigneur.proxy.MicroserviceUtilisateurProxy;
import com.apromac.saigneur.service.LocaliteCandidatService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


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
            throw new RuntimeException("");

        LocaliteCandidatDTO localiteCandidat = localiteCandidatService.findByPosteTDH(occuperBeans);

        return new ResponseEntity<>(localiteCandidat, HttpStatus.OK);
    }
}
