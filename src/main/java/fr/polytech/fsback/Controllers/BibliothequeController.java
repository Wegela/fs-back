package fr.polytech.fsback.Controllers;

import fr.polytech.fsback.Service.BibliothequeService;
import fr.polytech.fsback.dto.BibliothequeDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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
}
