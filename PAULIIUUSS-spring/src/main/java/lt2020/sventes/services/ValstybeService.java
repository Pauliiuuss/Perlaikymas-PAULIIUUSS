package lt2020.sventes.services;

import lt2020.sventes.DAO.ValstybeDAO;
import lt2020.sventes.entities.Valstybe;
import lt2020.sventes.entities.ValstybeInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class ValstybeService {

    @Autowired
    public ValstybeDAO valstybeDAO;

    @Transactional(readOnly = true)
    public Collection<ValstybeInfo> gautiValstybe() {
        return valstybeDAO.findAll().stream()
                .map(isdb -> new ValstybeInfo(
                        isdb.getPavadinimas(),
                        isdb.getVeliavosNuotraukosUrl(),
                        isdb.getPrezidentas()))
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public ValstybeInfo gautiValstybePagalPavadinima(String pavadinimas){
        Valstybe info = valstybeDAO.findAll()
                .stream()
                .filter( isdb -> isdb.getPavadinimas().equals(pavadinimas))
                .findFirst()
                .orElse(null);
        return new ValstybeInfo(
                info.getPavadinimas(),
                info.getVeliavosNuotraukosUrl(),
                info.getPrezidentas()
        );
    }

    @Transactional(readOnly = true)
    public ValstybeInfo gautiGupuotasValstybes(){
        Valstybe idb = valstybeDAO.findAllSventesGrouped();
        return new ValstybeInfo(idb.getPavadinimas(), idb.getVeliavosNuotraukosUrl(), idb.getPrezidentas());
    }

    @Transactional
    public void istrintiValstybe(String pavadinimas){
        valstybeDAO.deleteById(pavadinimas);
    }

    @Transactional
    public void pridetiValstybe(ValstybeInfo valstybeInfo){
        Valstybe idb = new Valstybe(
                valstybeInfo.getPavadinimas(),
                valstybeInfo.getVeliavosNuotraukosUrl(),
                valstybeInfo.getPrezidentas());
        valstybeDAO.save(idb);
    }

    @Transactional
    public void atnaujintiValstybe(ValstybeInfo valstybeInfo){
        Valstybe idb = valstybeDAO.findAll().stream()
                .filter(isdb -> isdb.getPavadinimas().equals(valstybeInfo.getPavadinimas()))
                .findFirst()
                .orElse(null);
        if(idb != null) {
            idb.setVeliavosNuotraukosUrl(valstybeInfo.getVeliavosNuotraukosUrl());
            idb.setPrezidentas(valstybeInfo.getPrezidentas());
            valstybeDAO.save(idb);
        }
    }
}
