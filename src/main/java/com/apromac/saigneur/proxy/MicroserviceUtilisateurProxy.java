package com.apromac.saigneur.proxy;


import com.apromac.saigneur.bean.OccuperBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "saigneur-utilisateur", url = "${apromac.msaigneur-utilisateur.url}")
public interface MicroserviceUtilisateurProxy {

    @GetMapping(value = "/occuper/findByPosteID/{posteID}")
    List<OccuperBean> recupererDetailsPoste(@PathVariable long posteID);
}
