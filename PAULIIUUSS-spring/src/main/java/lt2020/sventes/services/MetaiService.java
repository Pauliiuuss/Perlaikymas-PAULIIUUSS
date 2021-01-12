package lt2020.sventes.services;

import lt2020.sventes.DAO.MetaiDAO;
import lt2020.sventes.entities.Metai;
import lt2020.sventes.entities.MetaiInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class MetaiService {

    @Autowired
    private MetaiDAO metaiDAO;

    @Transactional(readOnly = true)
    public Collection<MetaiInfo> gautiVisusMetus(){
        return metaiDAO.findAll()
                .stream()
                .map(isdb -> new MetaiInfo(
                        isdb.getMetai(),
                        isdb.getSventesTipas(),
                        isdb.getRytuHoroskopas()
                ))
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public Collection<MetaiInfo> gautiMetus(long metai){
        return metaiDAO.findAll()
                .stream()
                .filter( isdb -> isdb.getMetai() == metai)
                .map( isdb -> new MetaiInfo(
                        isdb.getMetai(),
                        isdb.getSventesTipas(),
                        isdb.getRytuHoroskopas()))
                .collect(Collectors.toList());
    }

    @Transactional
    public void istrintiMetus(long metai){
        metaiDAO.deleteById(metai);}

    @Transactional
    public void pridetiMetus(MetaiInfo metaiInfo){
        Metai idb = new Metai(
                metaiInfo.getMetai(),
                metaiInfo.getSventesTipas(),
                metaiInfo.getRytuHoroskopas());
        metaiDAO.save(idb);
    }

    @Transactional
    public void atnaujintiMetus(MetaiInfo metaiInfo){
        Metai idb = metaiDAO.findAll()
                .stream()
                .filter( isdb -> isdb.getMetai() == metaiInfo.getMetai())
                .findFirst()
                .orElse(null);
        if(idb != null){
            idb.setSventesTipas(metaiInfo.getSventesTipas());
            idb.setRytuHoroskopas(metaiInfo.getRytuHoroskopas());
            idb.setRytuHoroskopas(metaiInfo.getRytuHoroskopas());
        }
    }
}
