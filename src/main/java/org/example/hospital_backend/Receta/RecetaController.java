package org.example.hospital_backend.Receta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/receta")
public class RecetaController {

    @Autowired
    private final RecetaService recetaService;

    public RecetaController(RecetaService recetaService) {
        this.recetaService = recetaService;
    }

    @GetMapping
    public List<Receta> getRecetas() {
        return recetaService.getRecetas();
    }

    @GetMapping(path = "{receta_id}")
    public Receta getRecetaById(long receta_id) {
        return recetaService.getRecetaById(receta_id);
    }

    @PostMapping
    public Receta crearReceta(Receta receta) {
        return recetaService.addReceta(receta);
    }

    @DeleteMapping(path = "{receta_id}")
    public void deleteReceta(@PathVariable("receta_id") long receta_id) {
        recetaService.deleteReceta(receta_id);
    }
}
