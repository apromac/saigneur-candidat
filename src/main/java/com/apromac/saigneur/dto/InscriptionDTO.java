package com.apromac.saigneur.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class InscriptionDTO {
//    private Long inscriptionID;
    private String districtInscription;
    private String zoneInscription;
    private Date dateInscription;


    private Boolean isFormer;
    private String structureFormation;
    private Date anneeFormation;
    private Boolean isAppliquer;
    private String typeFormation;
    private String lieuFormation;
    private String typeSaigneFormation;
    private String nomPlanteurFormation;
    private String matriculePlanteurFormation;
    private String lieuPlanteurFormation;
    private Date anneePlanteurFormation;
    private Integer contactPlanteurFormation;


    private Boolean propositionEmploi;
    private String nomPlanteurEmploi;
    private String matriculePlanteurEmploi;
    private String lieuPlanteurEmploi;
    private Date anneePlanteurEmploi;
    private Integer contactPlanteurEmploi;


    private Boolean isActivite;
    private String nomPlanteurActivite;
    private String matriculePlanteurActivite;
    private String lieuPlanteurActivite;
    private Date anneePlanteurActivite;
    private Integer contactPlanteurActivite;


    private String motivation;
    private Boolean isSelectionner;
    private Boolean isInterview;
    private Boolean isRetenu;
    private Integer statut;
}
