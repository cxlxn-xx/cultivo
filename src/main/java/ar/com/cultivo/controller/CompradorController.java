package ar.com.cultivo.controller;
import ar.com.cultivo.entities.Comprador;
import ar.com.cultivo.services.ICompradorServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CompradorController {

    @Autowired
    private ICompradorServices entityService;

    @GetMapping(path = "/comprador")
    public List<Comprador> getAll() {
        return entityService.getAll();
    }

    @GetMapping(path = "/comprador/{id}")
    public Comprador get(@PathVariable Integer id) {
        return entityService.get(id);
    }

    @GetMapping(path = "/comprador/search/{expression}")
    public List<Comprador> getList(@PathVariable String expression) {
        return entityService.findByNombre(expression);
    }

    @PostMapping(value = "/comprador", consumes = "application/json", produces = "application/json")
    public Comprador save(@RequestBody Comprador entity) {
        entityService.save(entity);
        return entity;
    }

    @GetMapping(path = "/comprador/delete/{id}")
    public String delete(@PathVariable Integer id) {
        Comprador entity = null;
        try {
            entity = entityService.get(id);
            entityService.delete(entity);
            return null;
        } catch (Exception e) {
            return e.getMessage().toString();
        }
    }

}