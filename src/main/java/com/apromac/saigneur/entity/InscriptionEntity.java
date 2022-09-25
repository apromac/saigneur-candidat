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

    @Column(name = "abr_dist_inscri", nullable = false)
    private String abreviationDistrictInscription;

    @Column(name = "zone_inscri", nullable = false)
    private String zoneInscription;

    @Column(name = "date_inscri", nullable = false)
    private Date dateInscription;



    @ManyToOne
    @JoinColumn(name = "code_candidat", nullable = false)
    private CandidatEntity candidat;

    @ManyToOne
    @JoinColumn(name = "code_campagne", nullable = false)
    private CampagneEntity campagne;
}
