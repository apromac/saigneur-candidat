package com.apromac.saigneur.serviceimpl;

import com.apromac.saigneur.bean.OccuperBean;
import com.apromac.saigneur.bean.UtilisateurBean;
import com.apromac.saigneur.dto.LocaliteCandidatDTO;
import com.apromac.saigneur.exception.NoContentException;
import com.apromac.saigneur.exception.NotFoundException;
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
    public List<LocaliteCandidatDTO> findByProfilTDH(List<OccuperBean> occuperBeans) {
        List<LocaliteCandidatDTO> localiteCandidatDTOS = new ArrayList<>();

        for(OccuperBean occuperBean: occuperBeans) {
            LocaliteCandidatDTO localiteCandidatDTO = new LocaliteCandidatDTO();

            UtilisateurBean utilisateurBean = occuperBean.getUtilisateurBean();
            if(utilisateurBean == null)
                throw new NotFoundException("Désolé, nous n'avons pas pu recupérer l'utilisateur");

//            localiteCandidatDTO.setPrenomsTDH(occuperBean.getUtilisateurBean().getPrenomsUtilisateur());
            localiteCandidatDTO.setDistrictTDH(occuperBean.getDistrictOccuper());
            localiteCandidatDTO.setZoneTDH(occuperBean.getZoneOccuper());

            localiteCandidatDTOS.add(localiteCandidatDTO);
        }

        if (localiteCandidatDTOS.isEmpty())
            throw new NoContentException("Désolé, la liste est vide.");

        return localiteCandidatDTOS;
    }
}
