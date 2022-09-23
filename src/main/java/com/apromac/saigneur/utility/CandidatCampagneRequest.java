package com.apromac.saigneur.utility;

import com.apromac.saigneur.dto.InscriptionDTO;
import com.apromac.saigneur.entity.CampagneEntity;
import com.apromac.saigneur.entity.CandidatEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CandidatCampagneRequest {
    private CampagneEntity campagneEntity;
    private CandidatEntity candidatEntity;
    private InscriptionDTO inscriptionDTO;
}
