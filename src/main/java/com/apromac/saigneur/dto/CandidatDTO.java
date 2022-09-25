package com.apromac.saigneur.dto;

import com.apromac.saigneur.entity.CampagneEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class CandidatDTO {
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
    private CampagneEntity campagneEntity;
    private Long inscriptionID;
    private String districtInscription;
    private String zoneInscription;
    private Date dateInscription;
}
