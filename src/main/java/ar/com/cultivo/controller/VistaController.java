package ar.com.cultivo.controller;

import ar.com.cultivo.entities.*;
import ar.com.cultivo.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/vista")
public class VistaController {

    @Autowired private ICultivosServices cultivoService;
    @Autowired private ILotesServices loteService;
    @Autowired private ICompradorServices compradorService;
    @Autowired private IPlantacionServices plantacionService;
    @Autowired private IGastosServices gastoService;
    @Autowired private ICosechasServices cosechaService;
    @Autowired private IVentasServices ventaService;

    @GetMapping("")
    public String index() {
        return "index";
    }


    //  CULTIVOS

    @GetMapping("/cultivos")
    public String verCultivos(Model model) {
        model.addAttribute("cultivos", cultivoService.getAll());
        return "cultivos";
    }

    @GetMapping("/cultivos/form")
    public String formCultivo(@RequestParam(required = false) Integer codigo, Model model) {
        Cultivos cultivos = (codigo != null) ? cultivoService.get(codigo) : new Cultivos();
        model.addAttribute("cultivo", cultivos);
        return "cultivo-form";
    }
    @PostMapping("/cultivos/guardar")
    public String guardarCultivo(@ModelAttribute Cultivos cultivo, RedirectAttributes ra) {
        cultivoService.save(cultivo);
        ra.addFlashAttribute("mensaje", "Cultivo guardado correctamente.");
        return "redirect:/vista/cultivos";
    }

    @GetMapping("/cultivos/eliminar/{id}")
    public String eliminarCultivo(@PathVariable Integer id, RedirectAttributes ra) {
        try {
            cultivoService.delete(cultivoService.get(id));
            ra.addFlashAttribute("mensaje", "Cultivo eliminado.");
        } catch (Exception e) {
            ra.addFlashAttribute("error", "No se puede eliminar (tiene plantaciones asociadas).");
        }
        return "redirect:/vista/cultivos";
    }


    // COMPRADORES

    @GetMapping("/comprador")
    public String verComprador(Model model) {
        model.addAttribute("comprador", compradorService.getAll());
        return "comprador";
    }

    @GetMapping("/comprador/form")
    public String formComprador(@RequestParam(required = false) Integer codigo, Model model) {
        Comprador comprador = (codigo != null) ? compradorService.get(codigo) : new Comprador();
        model.addAttribute("comprador", comprador);
        return "comprador-form";
    }

    @PostMapping("/comprador/guardar")
    public String guardarComprador(@ModelAttribute Comprador comprador, RedirectAttributes ra) {
        compradorService.save(comprador);
        ra.addFlashAttribute("mensaje", "Comprador guardado correctamente.");
        return "redirect:/vista/comprador";
    }

    @GetMapping("/comprador/eliminar/{id}")
    public String eliminarComprador(@PathVariable Integer id, RedirectAttributes ra) {
        try {
            compradorService.delete(compradorService.get(id));
            ra.addFlashAttribute("mensaje", "Comprador eliminado.");
        } catch (Exception e) {
            ra.addFlashAttribute("error", "No se puede eliminar (tiene ventas asociadas).");
        }
        return "redirect:/vista/comprador";
    }


    //  VENTAS

    @GetMapping("/venta")
    public String verVenta(Model model) {
        model.addAttribute("venta", ventaService.getAll());
        return "venta";
    }

    @GetMapping("/venta/form")
    public String formVenta(@RequestParam(required = false) Integer id, Model model) {
        Venta venta = (id != null) ? ventaService.get(id) : new Venta();
        model.addAttribute("venta", venta);

        model.addAttribute("plantaciones", plantacionService.getAll());
        model.addAttribute("compradores", compradorService.getAll());
        return "venta-form";
    }

    @PostMapping("/venta/guardar")
    public String guardarVenta(@ModelAttribute Venta venta, RedirectAttributes ra) {
        ventaService.save(venta);
        ra.addFlashAttribute("mensaje", "Venta guardada correctamente.");
        return "redirect:/vista/venta";
    }

    @GetMapping("/venta/eliminar/{id}")
    public String eliminarVenta(@PathVariable Integer id, RedirectAttributes ra) {
        try {
            ventaService.delete(ventaService.get(id));
            ra.addFlashAttribute("mensaje", "Venta eliminada.");
        } catch (Exception e) {
            ra.addFlashAttribute("error", "Error al eliminar la venta.");
        }
        return "redirect:/vista/venta";
    }


    //  LOTES

    @GetMapping("/lote")
    public String verLote(Model model) {
        model.addAttribute("lote", loteService.getAll());
        return "lote";
    }

    @GetMapping("/lote/form")
    public String formLote(@RequestParam(required = false) Integer id, Model model) {
        Lote lote = (id != null) ? loteService.get(id) : new Lote();
        model.addAttribute("lote", lote);
        return "lote-form";
    }

    @PostMapping("/lote/guardar")
    public String guardarLote(@ModelAttribute Lote lote, RedirectAttributes ra) {
        loteService.save(lote);
        ra.addFlashAttribute("mensaje", "Lote guardado.");
        return "redirect:/vista/lote";
    }

    @GetMapping("/lote/eliminar/{id}")
    public String eliminarLote(@PathVariable Integer id, RedirectAttributes ra) {
        try {
            loteService.delete(loteService.get(id));
            ra.addFlashAttribute("mensaje", "Lote eliminado.");
        } catch (Exception e) {
            ra.addFlashAttribute("error", "No se puede eliminar.");
        }
        return "redirect:/vista/lote";
    }


    // PLANTACIONES Y OTROS

    @GetMapping("/plantacion")
    public String verPlantacion(Model model) {
        model.addAttribute("plantacion", plantacionService.getAll());
        return "plantacion";
    }
    @GetMapping("/plantacion/form")
    public String formPlantacion(@RequestParam(required = false) Integer id, Model model) {
        Plantacion plantacion = (id != null) ? plantacionService.get(id) : new Plantacion();
        model.addAttribute("plantacion", plantacion);
        model.addAttribute("cultivos", cultivoService.getAll());
        model.addAttribute("lotes", loteService.getAll());
        return "plantacion-form";
    }
    @PostMapping("/plantacion/guardar")
    public String guardarPlantacion(@ModelAttribute Plantacion plantacion, RedirectAttributes ra) {
        plantacionService.save(plantacion);
        ra.addFlashAttribute("mensaje", "Plantación guardada correctamente.");
        return "redirect:/vista/plantacion";
    }

    @GetMapping("/plantacion/eliminar/{id}")
    public String eliminarPlantacion(@PathVariable Integer id, RedirectAttributes ra) {
        try {
            plantacionService.delete(plantacionService.get(id));
            ra.addFlashAttribute("mensaje", "Plantación eliminada.");
        } catch (Exception e) {
            ra.addFlashAttribute("error", "No se puede eliminar.");
        }
        return "redirect:/vista/plantacion";
    }

    @GetMapping("/gasto")
    public String verGasto(Model model) {
        model.addAttribute("gasto", gastoService.getAll());
        return "gasto";
    }

    @GetMapping("/cosechas")
    public String verCosechas(Model model) {
        model.addAttribute("cosechas", cosechaService.getAll());
        return "cosechas";
    }
    @GetMapping("/cosechas/form")
    public String formCosecha(@RequestParam(required = false) Integer id, Model model) {
        Cosechas cosecha = (id != null) ? cosechaService.get(id) : new Cosechas();
        model.addAttribute("cosecha", cosecha);
        model.addAttribute("plantaciones", plantacionService.getAll());
        return "cosecha-form";
    }

    @PostMapping("/cosechas/guardar")
    public String guardarCosecha(@ModelAttribute Cosechas cosecha, RedirectAttributes ra) {
        cosechaService.save(cosecha);
        ra.addFlashAttribute("mensaje", "Cosecha guardada correctamente.");
        return "redirect:/vista/cosechas";
    }

    @GetMapping("/cosechas/eliminar/{id}")
    public String eliminarCosecha(@PathVariable Integer id, RedirectAttributes ra) {
        try {
            cosechaService.delete(cosechaService.get(id));
            ra.addFlashAttribute("mensaje", "Cosecha eliminada.");
        } catch (Exception e) {
            ra.addFlashAttribute("error", "Error al eliminar la cosecha.");
        }
        return "redirect:/vista/cosechas";
    }
}