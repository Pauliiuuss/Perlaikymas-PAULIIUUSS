package lt2020.sventes.entities;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@RequiredArgsConstructor
@NoArgsConstructor
@Table(name = "svente")
public class Svente {

    @NonNull
    @Column(name = "Valstybe")
    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE})
    @JoinColumn(name = "Valstybe Sventes")
    private Valstybe valstybe;
    @NonNull
    @Column(name = "Data")
    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE})
    @JoinColumn(name = "Metai metai")
    private Metai metai;

    @Version
    private long version;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;
    @NonNull
    @Column(name = "pavadinimas", unique = true)
    private String pavadinimas;
    @NonNull
    @Column(name = "aprasymas")
    private String aprasymas;
    @NonNull
    @Column(name = "paveiksliukas")
    private String paveiksliukoUrl;
    @NonNull
    @Column(name = "iskelta veliava")
    private boolean veliava;

    public boolean getVeliava(){
        return veliava;
    }

}
