package ar.com.cultivo.controller;
import ar.com.cultivo.entities.Cosechas;
import ar.com.cultivo.services.ICosechasServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

        import java.util.List;

@RestController
@RequestMapping("/api")
public class CosechaController {

    @Autowired
    private ICosechasServices entityService;

    @GetMapping(path = "/cosechas")
    public List<Cosechas> getAll() {
        return entityService.getAll();
    }

    @GetMapping(path = "/cosechas/{id}")
    public Cosechas get(@PathVariable Integer id) {
        return entityService.get(id);
    }

    @PostMapping(value = "/cosechas", consumes = "application/json", produces = "application/json")
    public Cosechas save(@RequestBody Cosechas entity) {
        entityService.save(entity);
        return entity;
    }

    @GetMapping(path = "/cosechas/delete/{id}")
    public String delete(@PathVariable Integer id) {
        Cosechas entity = null;
        try {
            entity = entityService.get(id);
            entityService.delete(entity);
            return null;
        } catch (Exception e) {
            return e.getMessage().toString();
        }
    }
}