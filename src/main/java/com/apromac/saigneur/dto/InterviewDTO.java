package com.apromac.saigneur.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InterviewDTO {
    // inscription
    private Long inscriptionID;

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

    // adaptation
    private Boolean monteVelo;
    private Double noteVelo;
    private Boolean presencePlantation;
    private String motifPresencePlantation;
    private Double notePresencePlantation;
    private Boolean isInterviewer;
}
