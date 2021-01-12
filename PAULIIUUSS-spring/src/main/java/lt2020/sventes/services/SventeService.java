package lt2020.sventes.services;

import lt2020.sventes.DAO.SventeDAO;
import lt2020.sventes.entities.Svente;
import lt2020.sventes.entities.SventeInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.stream.Collectors;
@Service
public class SventeService {

    @Autowired
    private SventeDAO sventeDAO;

    @Transactional(readOnly = true)
    public Collection<SventeInfo> gautiSventes(){
        return sventeDAO.findAll()
                .stream()
                .map( isdb -> new SventeInfo(
                        isdb.getValstybe(),
                        isdb.getMetai(),
                        isdb.getId(),
                        isdb.getPavadinimas(),
                        isdb.getAprasymas(),
                        isdb.getPaveiksliukoUrl(),
                        isdb.getVeliava()))
                .collect(Collectors.toList());
    }
    
    @Transactional(readOnly = true)
    public SventeInfo gautiSventePagalId(long id){
        Svente info = sventeDAO.findAll()
                .stream()
                .filter(isdb -> isdb.getId() == id)
                .findFirst()
                .orElse(null);
        return new SventeInfo(
                info.getValstybe(),
                info.getMetai(),
                info.getId(),
                info.getPavadinimas(),
                info.getAprasymas(),
                info.getPaveiksliukoUrl(),
                info.getVeliava());
    }

    @Transactional
    public void istrintiSvente(long id){
        sventeDAO.deleteById(id);
    }


    @Transactional
    public void pridetiSvente(SventeInfo sventeInfo){
            Svente idb = new Svente(
                    sventeInfo.getValstybe(),
                    sventeInfo.getMetai(),
                    sventeInfo.getPavadinimas(),
                    sventeInfo.getAprasymas(),
                    sventeInfo.getPaveiksliukoUrl(),
                    sventeInfo.getVeliava());
            sventeDAO.save(idb);
    }

    @Transactional
    public void atnaujintiSvente(SventeInfo sventeInfo){
        Svente idb = sventeDAO.findAll()
                .stream()
                .filter(isdb -> isdb.getId() == sventeInfo.getId())
                .findFirst()
                .orElse(null);
        if(idb != null) {
            idb.setValstybe(sventeInfo.getValstybe());
            idb.setMetai(sventeInfo.getMetai());
            idb.setPavadinimas(sventeInfo.getPavadinimas());
            idb.setAprasymas(sventeInfo.getAprasymas());
            idb.setPaveiksliukoUrl(sventeInfo.getPaveiksliukoUrl());
            idb.setVeliava(sventeInfo.getVeliava());
            sventeDAO.save(idb);
        } else {
            throw new IllegalArgumentException("Svente nerasta");
        }
    }


}
