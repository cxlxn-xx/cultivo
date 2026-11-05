package ar.com.cultivo.controller;
import ar.com.cultivo.entities.Lote;
import ar.com.cultivo.services.ILotesServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api")
public class LoteController {

    @Autowired
    private ILotesServices entityService;

    @GetMapping(path = "/lote")
    public List<Lote> getAll() {
        return entityService.getAll();
    }

    @GetMapping(path = "/lote/{id}")
    public Lote get(@PathVariable Integer id) {
        return entityService.get(id);
    }

    @GetMapping(path = "/lote/search/{expression}")
    public List<Lote> getList(@PathVariable String expression) {
        return entityService.findByDescrip(expression);
    }
    @PostMapping(value = "/lote", consumes = "application/json", produces = "application/json")
    public Lote save(@RequestBody Lote entity) {
        entityService.save(entity);
        return entity;
    }

    @GetMapping(path = "/lote/delete/{id}")
    public String delete(@PathVariable Integer id) {
        Lote entity = null;
        try {
            entity = entityService.get(id);
            entityService.delete(entity);
            return null;
        } catch (Exception e) {
            return e.getMessage().toString();
        }
    }
}
