package com.apromac.saigneur.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class InscriptionDTO {
    private Long inscriptionID;
    private String districtInscription;
    private String abreviationDistrictInscription;
    private String zoneInscription;
    private Date dateInscription;
}
