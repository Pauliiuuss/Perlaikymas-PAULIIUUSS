package lt2020.sventes.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lt2020.sventes.entities.MetaiInfo;
import lt2020.sventes.services.MetaiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@Api(value = "metai")
@RequestMapping("/api/metai")
public class MetaiController {

    @Autowired
    private MetaiService metaiService;

    @GetMapping
    @ApiOperation(value="gauti metus",notes="grazina metu sarasa")
    public Collection<MetaiInfo> gautiVisusMetus(){
        return metaiService.gautiVisusMetus();
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "gauti metus pagal data", notes = "grazina metus pagal duota data")
    public Collection<MetaiInfo> gautiMetus(long metai){
        return metaiService.gautiMetus(metai);
    }

    @DeleteMapping("/{Metai}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation(value="istrinti metus",notes="istrina metus")
    public void istrintiMetus( @PathVariable("Metai") long metai){
        metaiService.istrintiMetus(metai);
    }

    @PostMapping("/prideti")
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value="prideti metus",notes="prideda metus")
    public void pridetiMetus(@RequestBody MetaiInfo metaiInfo){
        metaiService.pridetiMetus(metaiInfo);
    }

    @PutMapping("/atnaujinti")
    @ResponseStatus(HttpStatus.ACCEPTED)
    @ApiOperation(value="atnaujinti metus",notes="atnaujina metus")
    public void atnaujintiMetus(MetaiInfo metaiInfo){
        metaiService.atnaujintiMetus(metaiInfo);
    }

}
