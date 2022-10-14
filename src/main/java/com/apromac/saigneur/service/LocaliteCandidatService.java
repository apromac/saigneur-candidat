package com.apromac.saigneur.service;

import com.apromac.saigneur.bean.OccuperBean;
import com.apromac.saigneur.dto.LocaliteCandidatDTO;

import java.util.List;

public interface LocaliteCandidatService {
    public LocaliteCandidatDTO findByPosteTDH(OccuperBean occuperBean);
    public List<LocaliteCandidatDTO> findByPosteTDH(List<OccuperBean> occuperBeans);
}
