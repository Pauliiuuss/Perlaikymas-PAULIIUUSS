package lt2020.sventes.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lt2020.sventes.entities.SventeInfo;
import lt2020.sventes.services.SventeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@Api(value = "sventes")
@RequestMapping("/api/sventes")
public class SventeController {

    @Autowired
    public SventeService sventeService;

    @GetMapping
    @ApiOperation(value="gauti sventes",notes="grazina svenciu sarasa")
    public Collection<SventeInfo> gautiSventes(){
        return sventeService.gautiSventes();
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "gauti svente pagal id", notes = "grazina svente pagal duota id")
    public SventeInfo gautiSventePagalId(long id){
        return sventeService.gautiSventePagalId(id);
    }

    @DeleteMapping("{sventesId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation(value="istrinti svente",notes="istrina svente pagal id")
    public void istrintiSvente( @PathVariable("sventesId") long id){
        sventeService.istrintiSvente(id);
    }

    @PostMapping("/prideti")
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value="prideti svente",notes="prideda svente")
    public void pridetiSvente(@RequestBody SventeInfo sventeInfo){
        sventeService.pridetiSvente(sventeInfo);
    }

    @PutMapping("/atnaujinti")
    @ResponseStatus(HttpStatus.ACCEPTED)
    @ApiOperation(value="atnaujinti svente",notes="atnaujina svente")
    public void atnaujintiSvente(SventeInfo sventeInfo){
        sventeService.atnaujintiSvente(sventeInfo);
    }
}
