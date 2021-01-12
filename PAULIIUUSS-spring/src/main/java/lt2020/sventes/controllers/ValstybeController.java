package lt2020.sventes.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lt2020.sventes.entities.ValstybeInfo;
import lt2020.sventes.services.ValstybeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@Api(value = "valstybes")
@RequestMapping("/api/valstybes")
public class ValstybeController {

    @Autowired
    public ValstybeService valstybeService;

    @GetMapping
    @ApiOperation(value="gauti valstybes",notes="grazina valstybiu sarasa")
    public Collection<ValstybeInfo> gautiValstybes() {
        return valstybeService.gautiValstybe();
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "gauti valstybe pagal pavadinima", notes = "grazina valstybe pagal duota pavadinima")
    public ValstybeInfo gautiValstybePagalPavadinima(String pavadinimas){
        return valstybeService.gautiValstybePagalPavadinima(pavadinimas);
    }

    @GetMapping("/grouped")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "gauti grupuota valstybe", notes = "grazina sugrupuota valstybe")
    public ValstybeInfo gautiGrupuotasValstybes(){
        return valstybeService.gautiGupuotasValstybes();
    }

    @DeleteMapping("{valstybesPav}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation(value="istrinti valstybe",notes="istrina valstybe")
    public void istrintiValstybe(@PathVariable("valstybesPav") String pavadinimas){
        valstybeService.istrintiValstybe(pavadinimas);
    }

    @PostMapping("/prideti")
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value="prideti valstybe",notes="prideda valstybe")
    public void pridetiValstybe(@RequestBody ValstybeInfo valstybeInfo){
        valstybeService.pridetiValstybe(valstybeInfo);
    }

    @PutMapping("/atnaujinti")
    @ResponseStatus(HttpStatus.ACCEPTED)
    @ApiOperation(value="atnaujinti valstybe",notes="atnaujina valstybe")
    public void atnaujintiValstybe(ValstybeInfo valstybeInfo){
            valstybeService.atnaujintiValstybe(valstybeInfo);
    }
}
