package com.apromac.saigneur.bean;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Data
@Getter
@Setter
public class OccuperBean {
    private Long occuperID;
    private String motifOccuper;
    private Date dateOccuper;
    private Boolean isOccuper;
    private String zoneOccuper;
    private String districtOccuper;
    private PosteBean posteBean;
    private UtilisateurBean utilisateurBean;
}
