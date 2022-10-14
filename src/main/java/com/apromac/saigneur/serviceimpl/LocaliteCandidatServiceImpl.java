package com.apromac.saigneur.serviceimpl;

import com.apromac.saigneur.bean.OccuperBean;
import com.apromac.saigneur.dto.LocaliteCandidatDTO;
import com.apromac.saigneur.service.LocaliteCandidatService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LocaliteCandidatServiceImpl implements LocaliteCandidatService {


    /**
     *
     * @param occuperBean
     * @return
     */
    public LocaliteCandidatDTO findByPosteTDH(OccuperBean occuperBean) {
        LocaliteCandidatDTO localiteCandidatDTO = new LocaliteCandidatDTO();

//        localiteCandidatDTO.setPosteTDH(occuperBean.getPosteBean().getLibellePoste());
//        localiteCandidatDTO.setNomTDH(occuperBean.getUtilisateurBean().getNomUtilisateur());
//        localiteCandidatDTO.setPrenomsTDH(occuperBean.getUtilisateurBean().getPrenomsUtilisateur());

//        localiteCandidatDTO.setPosteTDH(occuperBean.getPosteBean());
//        localiteCandidatDTO.setUtilisateurTDH(occuperBean.getUtilisateurBean());

        localiteCandidatDTO.setDistrictTDH(occuperBean.getDistrictOccuper());
        localiteCandidatDTO.setZoneTDH(occuperBean.getZoneOccuper());

        return localiteCandidatDTO;
    }


    /**
     *
     * @param occuperBeans
     * @return
     */
    public List<LocaliteCandidatDTO> findByPosteTDH(List<OccuperBean> occuperBeans) {
        List<LocaliteCandidatDTO> localiteCandidatDTOS = new ArrayList<>();

        for(OccuperBean occuperBean: occuperBeans) {
            LocaliteCandidatDTO localiteCandidatDTO = new LocaliteCandidatDTO();

            localiteCandidatDTO.setDistrictTDH(occuperBean.getDistrictOccuper());
            localiteCandidatDTO.setZoneTDH(occuperBean.getZoneOccuper());
        }
        
        return localiteCandidatDTOS;
    }
}
