package lt2020.sventes.entities;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@NamedQuery(name = "Valstybe.findAllSventesGrouped",
query = "select Svente.pavadinimas, Svente.id, Valstybe.pavadinimas, count(Svente)" +
        " from Svente join Valstybe on Svente.valstybe = Valstybe.pavadinimas " +
        "group by (Valstybe.sventes)")
@Data
@RequiredArgsConstructor
@NoArgsConstructor
@Table(name="valstybe")
public class Valstybe {

    @OneToMany(mappedBy = "Svente", cascade = {CascadeType.MERGE, CascadeType.DETACH})
    private Set<Svente> sventes;

    @Version
    private long version;

    @NonNull
    @Id
    @Column(name = "pavadinimas", unique = true)
    private String pavadinimas;

    @NonNull
    @Column(name = "veliava")
    private String veliavosNuotraukosUrl;

    @NonNull
    @Column(name = "prezidentas")
    private String prezidentas;


}
