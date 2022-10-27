package com.apromac.saigneur.proxy;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "saigneur-utilisateur", url = "${apromac.msaigneur-utilisateur.url}")
public interface MicroserviceUtilisateurProxy {


}


//    @GetMapping("/api/v1/occuper/findByPosteTDHID/{posteTDHID}")
//    OccuperBean recupererPosteActuelTDHOccuper(@PathVariable long posteTDHID);
//
//    @GetMapping(value = "/api/v1/occuper/district/{district}/profil/{profilID}")
//    List<OccuperBean> recupererProfilTDHParDistrict(@PathVariable String district, @PathVariable Long profilID);