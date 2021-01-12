package lt2020.sventes.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class SventeInfo {
    private Valstybe valstybe;
    private Metai metai;
    private long id;
    private String pavadinimas;
    private String aprasymas;
    private String paveiksliukoUrl;
    private boolean veliava;

    public boolean getVeliava(){
        return veliava;
    }
}
