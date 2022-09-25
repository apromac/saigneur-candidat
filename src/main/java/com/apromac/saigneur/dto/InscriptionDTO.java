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



    private String isFormer;
    private Boolean structureFormation;
    private Date anneeFormation;
    private Boolean isAppliquer;
    private String typeFormation;
    private String lieuFormation;
    private String typeSaigneFormation;
    private String nomPlanteurFormation;
    private String matriculePlanteurFormation;
    private String lieuPlanteurFormation;
    private Date anneePlanteurFormation;
    private String contactPlanteurFormation;


    private Boolean propositionEmploi;
    private String nomPlanteurEmploi;
    private String matriculePlanteurEmploi;
    private Date anneePlanteurEmploi;
    private String contactPlanteurEmploi;


    private Boolean isActivite;
    private String nomPlanteurActivite;
    private String matriculePlanteurActivite;
    private String lieuPlanteurActivite;
    private Boolean anneePlanteurActivite;
    private String contactPlanteurActivite;


    private String motivation;
}
