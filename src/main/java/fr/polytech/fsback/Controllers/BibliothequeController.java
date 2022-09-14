package fr.polytech.fsback.Controllers;

import fr.polytech.fsback.Service.BibliothequeService;
import fr.polytech.fsback.Service.LivreService;
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
    private final LivreService livreService;
    @GetMapping("/bibliotheques/{id}")
    public @ResponseBody BibliothequeDto getBibliothequesById(@PathVariable final String id) {
        return this.bibliothequeService.getBibliothequeById(id);
    }

    @PostMapping("/bibliotheques/{bibliothequeId}/livres")
    public @ResponseBody LivreDto addLivreToBibliotheque(@PathVariable final String bibliothequeId, @RequestBody @Valid final LivreDto livre) {
        return this.bibliothequeService.addLivreToBiblio(bibliothequeId, livre.getID());
    }
}
