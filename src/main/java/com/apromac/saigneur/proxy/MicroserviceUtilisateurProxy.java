package com.apromac.saigneur.proxy;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "saigneur-utilisateur", url = "${apromac.msaigneur-utilisateur.url}")
public interface MicroserviceUtilisateurProxy {


}

