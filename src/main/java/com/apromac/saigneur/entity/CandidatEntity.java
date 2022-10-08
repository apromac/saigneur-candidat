package com.apromac.saigneur.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(schema = "saigneurcandidat", name = "candidat")
public class CandidatEntity {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_candidat", updatable = false, nullable = false)
    private Long candidatID;

    @Column(name = "nom_candidat", nullable = true)
    private String nomCandidat;

    @Column(name = "prenoms_candidat", nullable = true)
    private String prenomsCandidat;

    @Column(name = "genre_candidat", nullable = true)
    private String genreCandidat;

    @Column(name = "dnaissance_candidat", nullable = true)
    @Temporal(TemporalType.DATE)
    private Date dateNaisCandidat;

    @Column(name = "lnaissance_candidat", nullable = true)
    private String lieuNaisCandidat;

    @Column(name = "lresidence_candidat", nullable = true)
    private String lieuResidCandidat;

    @Column(name = "netude_candidat", nullable = true)
    private String niveauEtudeCandidat;

    @Column(name = "mactuel_candidat", nullable = true)
    private String metierActuelCandidat;

    @Column(name = "pcontact_candidat", nullable = true)
    private String premierContactCandidat;

    @Column(name = "scontact_candidat", nullable = true)
    private String secondContactCandidat;

    @Column(name = "tpiece_candidat", nullable = true)
    private String typePieceCandidat;

    @Column(name = "npiece_candidat", nullable = true)
    private String numeroPieceCandidat;

}
