package lt2020.sventes.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import lt2020.sventes.misc.SventesTipas;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class MetaiInfo {
    private long metai;
    private SventesTipas sventesTipas;
    private String rytuHoroskopas;
}
