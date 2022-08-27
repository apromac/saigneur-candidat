package com.apromac.saigneur.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(schema = "saigneurcandidat", name = "identifier")
public class IdentifierEntity {

//    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_identifier", updatable = false, nullable = false)
    private String identifierID;

    @Column(name = "dist_identifier", nullable = false)
    private String districtIden;

    @Column(name = "abr_dist_identifier", nullable = false)
    private String abrDistrictIden;

    @Column(name = "dep_identifier", nullable = false)
    private String departementIden;

    @Column(name = "date_identifier", nullable = false)
    private Date dateIden;



    @ManyToOne
    @JoinColumn(name = "code_candidat", nullable = false)
    private CandidatEntity candidat;

    @ManyToOne
    @JoinColumn(name = "code_campagne", nullable = false)
    private CampagneEntity campagne;
}
