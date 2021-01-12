package lt2020.sventes.entities;


import lombok.*;
import lt2020.sventes.misc.SventesTipas;

import javax.persistence.*;
import java.util.Set;

@RequiredArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "metai")
public class Metai {

    @Version
    private long version;

    @OneToMany(mappedBy = "Svente", cascade = {CascadeType.DETACH, CascadeType.MERGE})
    private Set<Svente> sventes;

    @NonNull
    @Id
    @Column(name = "metai", unique = true)
    private long metai;
    @NonNull
    @Enumerated(EnumType.STRING)
    @Column(name = "Sventes Tipas")
    private SventesTipas sventesTipas;
    @NonNull
    @Column(name = "Rytu horoskopas")
    private String rytuHoroskopas;


}
