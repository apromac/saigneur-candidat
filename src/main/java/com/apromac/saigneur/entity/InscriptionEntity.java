package com.apromac.saigneur.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(schema = "saigneurcandidat", name = "inscription")
public class InscriptionEntity {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_inscription", updatable = false, nullable = false)
    private Long inscriptionID;

    @Column(name = "dist_inscri", nullable = false)
    private String districtInscription;

    @Column(name = "zone_inscri", nullable = false)
    private String zoneInscription;

    @Column(name = "date_inscri", nullable = true)
    @Temporal(TemporalType.DATE)
    private Date dateInscription;



    @Column(name = "estformer_form", nullable = false)
    private Boolean isFormer;

    @Column(name = "structure_form", nullable = true)
    private String structureFormation;

    @Column(name = "annee_form", nullable = true)
    @Temporal(TemporalType.DATE)
    private Date anneeFormation;

    @Column(name = "appliquer_form", nullable = false)
    private Boolean isAppliquer;

    @Column(name = "tformation_form", nullable = true)
    private String typeFormation;

    @Column(name = "lformation_form", nullable = true)
    private String lieuFormation;

    @Column(name = "tsaigne_form", nullable = true)
    private String typeSaigneFormation;

    @Column(name = "nplanteur_form", nullable = true)
    private String nomPlanteurFormation;

    @Column(name = "mplanteur_form", nullable = true)
    private String matriculePlanteurFormation;

    @Column(name = "lplanteur_form", nullable = true)
    private String lieuPlanteurFormation;

    @Column(name = "aplanteur_form", nullable = true)
    @Temporal(TemporalType.DATE)
    private Date anneePlanteurFormation;

    @Column(name = "cplanteur_form", nullable = true)
    private Integer contactPlanteurFormation;



    @Column(name = "proposition_emp", nullable = false)
    private Boolean propositionEmploi;

    @Column(name = "nplanteur_emp", nullable = true)
    private String nomPlanteurEmploi;

    @Column(name = "mplanteur_emp", nullable = true)
    private String matriculePlanteurEmploi;

    @Column(name = "lplanteur_emp", nullable = true)
    private String lieuPlanteurEmploi;

    @Column(name = "aplanteur_emp", nullable = true)
    @Temporal(TemporalType.DATE)
    private Date anneePlanteurEmploi;

    @Column(name = "cplanteur_emp", nullable = true)
    private Integer contactPlanteurEmploi;



    @Column(name = "enactivite_act", nullable = false)
    private Boolean isActivite;

    @Column(name = "nplanteur_act", nullable = true)
    private String nomPlanteurActivite;

    @Column(name = "mplanteur_act", nullable = true)
    private String matriculePlanteurActivite;

    @Column(name = "lplanteur_act", nullable = true)
    private String lieuPlanteurActivite;

    @Column(name = "aplanteur_act", nullable = true)
    @Temporal(TemporalType.DATE)
    private Date anneePlanteurActivite;

    @Column(name = "cplanteur_act", nullable = true)
    private Integer contactPlanteurActivite;



    @Column(name = "desire_motiv", nullable = true)
    private String motivation;

//    @Column(name = "enselection", nullable = true)
//    private Boolean isSelectionner;
//
//    @Column(name = "eninterview", nullable = true)
//    private Boolean isInterview;
//
//    @Column(name = "enretenu", nullable = true)
//    private Boolean isRetenu;

    @Column(name = "statut_inscri", nullable = false)
    private Integer statut;



    @ManyToOne
    @JoinColumn(name = "code_candidat", nullable = false)
    private CandidatEntity candidat;

    @ManyToOne
    @JoinColumn(name = "code_campagne", nullable = false)
    private CampagneEntity campagne;
}
