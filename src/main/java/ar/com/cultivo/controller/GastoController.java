package ar.com.cultivo.controller;
import ar.com.cultivo.entities.Gasto;
import ar.com.cultivo.services.IGastosServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class GastoController {

    @Autowired
    private IGastosServices entityService;

    @GetMapping(path = "/gasto")
    public List<Gasto> getAll() {
        return entityService.getAll();
    }

    @GetMapping(path = "/gasto/{id}")
    public Gasto get(@PathVariable Integer id) {
        return entityService.get(id);
    }


    @PostMapping(value = "/gasto", consumes = "application/json", produces = "application/json")
    public Gasto save(@RequestBody Gasto entity) {
        entityService.save(entity);
        return entity;
    }

    @GetMapping(path = "/gasto/delete/{id}")
    public String delete(@PathVariable Integer id) {
        Gasto entity = null;
        try {
            entity = entityService.get(id);
            entityService.delete(entity);
            return null;
        } catch (Exception e) {
            return e.getMessage().toString();
        }
    }
}