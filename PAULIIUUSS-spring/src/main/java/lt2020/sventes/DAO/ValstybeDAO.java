package lt2020.sventes.DAO;

import lt2020.sventes.entities.Valstybe;
import lt2020.sventes.entities.ValstybeInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ValstybeDAO extends JpaRepository<Valstybe, String> {
    Valstybe findAllSventesGrouped();
}
