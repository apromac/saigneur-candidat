package com.apromac.saigneur.serviceimpl;

import com.apromac.saigneur.service.LocaliteCandidatService;
import org.springframework.stereotype.Service;

@Service
public class LocaliteCandidatServiceImpl implements LocaliteCandidatService {

}


//    /**
//     *
//     * @param occuperBean
//     * @return
//     */
//    public LocaliteCandidatDTO findByPosteTDH(OccuperBean occuperBean) {
//        LocaliteCandidatDTO localiteCandidatDTO = new LocaliteCandidatDTO();
//
////        localiteCandidatDTO.setPosteTDH(occuperBean.getPosteBean().getLibellePoste());
////        localiteCandidatDTO.setNomTDH(occuperBean.getUtilisateurBean().getNomUtilisateur());
////        localiteCandidatDTO.setPrenomsTDH(occuperBean.getUtilisateurBean().getPrenomsUtilisateur());
//
////        localiteCandidatDTO.setPosteTDH(occuperBean.getPosteBean());
////        localiteCandidatDTO.setUtilisateurTDH(occuperBean.getUtilisateurBean());
//
//        localiteCandidatDTO.setDistrictTDH(occuperBean.getDistrictOccuper());
//        localiteCandidatDTO.setZoneTDH(occuperBean.getZoneOccuper());
//
//        return localiteCandidatDTO;
//    }
//
//
//    /**
//     *
//     * @param occuperBeans
//     * @return
//     */
//    public List<LocaliteCandidatDTO> findByProfilTDH(List<OccuperBean> occuperBeans) {
//        List<LocaliteCandidatDTO> localiteCandidatDTOS = new ArrayList<>();
//
//        for(OccuperBean occuperBean: occuperBeans) {
//            LocaliteCandidatDTO localiteCandidatDTO = new LocaliteCandidatDTO();
//
////            localiteCandidatDTO.setNomTDH(occuperBean.getUtilisateurBean() != null ? occuperBean.getUtilisateurBean().getNomUtilisateur() : "");
////            localiteCandidatDTO.setPrenomsTDH(occuperBean.getUtilisateurBean() != null ? occuperBean.getUtilisateurBean().getPrenomsUtilisateur() : "");
//
//            localiteCandidatDTO.setUtilisateurTDH(occuperBean.getUtilisateurBean() != null ? occuperBean.getUtilisateurBean() : null);
//            localiteCandidatDTO.setDistrictTDH(occuperBean.getDistrictOccuper());
//            localiteCandidatDTO.setZoneTDH(occuperBean.getZoneOccuper());
//
//            localiteCandidatDTOS.add(localiteCandidatDTO);
//        }
//
//        if (localiteCandidatDTOS.isEmpty())
//            throw new NoContentException("Désolé, la liste est vide.");
//
//        return localiteCandidatDTOS;
//    }