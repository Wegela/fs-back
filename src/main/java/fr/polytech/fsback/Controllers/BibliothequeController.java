package fr.polytech.fsback.Controllers;

import fr.polytech.fsback.Service.BibliothequeService;
import fr.polytech.fsback.dto.BibliothequeDto;
import fr.polytech.fsback.dto.LivreDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
@RequiredArgsConstructor
@RestController
public class BibliothequeController {

    private final BibliothequeService bibliothequeService;

    @GetMapping("/bibliotheque/{id}")
    public BibliothequeDto getBibliothequeById(@PathVariable final String id){
        return this.bibliothequeService.getBibliothequeById(id);
    }

    @GetMapping("/bibliotheque/{id}/livres")
    public @ResponseBody

    @PostMapping("/bibliotheque/{id}/livres")
    public @ResponseBody LivreDto livreDTO(@Valid @RequestBody final LivreDto body) {
        return livreService.addLivres(body.getTitre());
    }
}
