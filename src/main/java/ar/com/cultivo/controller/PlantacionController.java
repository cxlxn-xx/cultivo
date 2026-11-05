package ar.com.cultivo.controller;
import ar.com.cultivo.entities.Plantacion;
import ar.com.cultivo.services.IPlantacionServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api")
public class PlantacionController {

    @Autowired
    private IPlantacionServices entityService;

    @GetMapping(path = "/plantaciones")
    public List<Plantacion> getAll() {
        return entityService.getAll();
    }

    @GetMapping(path = "/plantaciones/{id}")
    public Plantacion get(@PathVariable Integer id) {
        return entityService.get(id);
    }

    @GetMapping(path = "/plantaciones/periodo/{periodo}")
    public List<Plantacion> porPeriodo(@PathVariable String periodo) {
        return entityService.findByPeriodo(periodo);
    }

    @GetMapping(path = "/plantaciones/periodo/{periodo}/cultivos/{codigoCultivos}")
    public List<Plantacion> porPeriodoYCultivos(@PathVariable String periodo, @PathVariable Integer codigoCultivos) {
        return entityService.findByPeriodoAndCultivos(periodo, codigoCultivos);
    }

    @GetMapping(path = "/plantaciones/entre-fechas")
    public List<Plantacion> entreFechas(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate desde,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate hasta) {
        return entityService.findByFechaBetween(desde, hasta);
    }
}


