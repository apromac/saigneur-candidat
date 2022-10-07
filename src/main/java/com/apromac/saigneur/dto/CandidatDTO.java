package com.apromac.saigneur.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class CandidatDTO {

    // candidat
    private Long candidatID;
    private String nomCandidat;
    private String prenomsCandidat;
    private String genreCandidat;
    private Date dateNaisCandidat;
    private String lieuNaisCandidat;
    private String lieuResidCandidat;
    private String niveauEtudeCandidat;
    private String metierActuelCandidat;
    private Integer premierContactCandidat;
    private Integer secondContactCandidat;
    private String typePieceCandidat;
    private String numeroPieceCandidat;

    // campage
    private Long campagneID;
    private String libelleCampagne;
    private Boolean activeCampagne;


    // inscriptionDTO
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
    private Integer statut;
}
