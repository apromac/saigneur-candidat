package com.apromac.saigneur.service;

import com.apromac.saigneur.bean.OccuperBean;
import com.apromac.saigneur.dto.LocaliteCandidatDTO;

public interface LocaliteCandidatService {
    public LocaliteCandidatDTO findByPosteTDH(OccuperBean occuperBean);
}
