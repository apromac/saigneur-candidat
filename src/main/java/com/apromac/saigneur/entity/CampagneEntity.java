package com.apromac.saigneur.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(schema = "saigneurcandidat", name = "campagne")
public class CampagneEntity {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_campagne", updatable = false, nullable = false)
    private Long campagneID;

    @Column(name = "lib_campagne", nullable = false)
    private String libelleCampagne;

    @Column(name = "active_campagne", nullable = false)
    private Boolean activeCampagne;

}
