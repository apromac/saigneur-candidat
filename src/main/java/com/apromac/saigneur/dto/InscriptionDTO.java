package com.apromac.saigneur.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class InscriptionDTO {

    // localite
    private Long inscriptionID;
    private String districtInscription;
    private String zoneInscription;
    private Date dateInscription;
    private Double distanceInscription;


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
    private String contactPlanteurFormation;


    private Boolean propositionEmploi;
    private String nomPlanteurEmploi;
    private String matriculePlanteurEmploi;
    private String lieuPlanteurEmploi;
    private Date anneePlanteurEmploi;
    private String contactPlanteurEmploi;


    private Boolean isActivite;
    private String nomPlanteurActivite;
    private String matriculePlanteurActivite;
    private String lieuPlanteurActivite;
    private Date anneePlanteurActivite;
    private String contactPlanteurActivite;


    private String motivation;
    private Integer statut;


    // motivation
    private String descriptionReveil;
    private Double noteReveil;
    private String descriptionCouche;
    private Double noteCouche;
    private String descriptionOccupation;
    private Double noteOccupation;
    private Boolean peurObscurite;
    private Double noteObscurite;


    // endurance
    private Boolean sportif;
    private String descriptionSportif;
    private Double noteSprotif;
    private String descriptionLongueDistance;
    private Double noteLongueDistance;
    private boolean isInterviewer;

    // adaptation
    private Boolean monteVelo;
    private Double noteVelo;
    private Boolean presencePlantation;
    private String motifPresencePlantation;
    private Double notePresencePlantation;
}
