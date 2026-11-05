package ar.com.cultivo.controller;

import ar.com.cultivo.entities.Venta;
import ar.com.cultivo.services.IVentasServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;



import java.util.List;

@RestController
@RequestMapping("/api")
public class VentaController {

    @Autowired
    private IVentasServices entityService;

    @GetMapping(path = "/venta")
    public List<Venta> getAll() {
        return entityService.getAll();
    }

    @GetMapping(path = "/venta/{id}")
    public Venta get(@PathVariable Integer id) {
        return entityService.get(id);
    }

    @PostMapping(value = "/venta", consumes = "application/json", produces = "application/json")
    public Venta save(@RequestBody Venta entity) {
        entityService.save(entity);
        return entity;
    }

    @GetMapping(path = "/venta/delete/{id}")
    public String delete(@PathVariable Integer id) {
        Venta entity = null;
        try {
            entity = entityService.get(id);
            entityService.delete(entity);
            return null;
        } catch (Exception e) {
            return e.getMessage().toString();
        }
    }
    @GetMapping(path = "/ventas/comprador/{codigoComprador}/entre-fechas")
    public List<Venta> ventasPorCompradorEntreFechas(
            @PathVariable Integer codigoComprador,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate desde,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate hasta) {
        return entityService.findByCompradorAndFechaBetween(codigoComprador, desde, hasta);
    }
}