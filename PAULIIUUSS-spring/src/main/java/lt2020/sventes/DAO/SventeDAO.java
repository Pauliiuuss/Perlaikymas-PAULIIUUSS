package lt2020.sventes.DAO;

import lt2020.sventes.entities.Svente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SventeDAO extends JpaRepository<Svente, Long> {
}
