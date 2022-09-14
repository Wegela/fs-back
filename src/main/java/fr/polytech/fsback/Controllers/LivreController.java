package fr.polytech.fsback.Controllers;
import fr.polytech.fsback.Service.LivreService;
import fr.polytech.fsback.dto.LivreDto;
import fr.polytech.fsback.dto.LivreDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.bytebuddy.utility.RandomString;
import org.springframework.web.bind.annotation.*;
import java.lang.Math;
import javax.persistence.Id;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Random;

@RestController()
//@RequiredArgsConstructor
@Slf4j
public class LivreController {

    public final LivreService livreService;

    public LivreController(LivreService lservice) {
        this.livreService = lservice;
    }

    // Retourne un livre spécifique à un ID
    @GetMapping("/livres/{ID}")
    public @ResponseBody LivreDto getLivreByID(@PathVariable String ID){
        return this.livreService.getLivreById(ID);

    }

    // Retourne la liste complète des livres
    @GetMapping("/livres")
    public @ResponseBody Collection<LivreDto> getLivres(){
        return this.livreService.getLivres();
    }

    @PostMapping("/livres")
    public @ResponseBody LivreDto livreDTO(@Valid @RequestBody final LivreDto body) {
        return livreService.addLivres(body.getTitre());
    }

    @DeleteMapping("/livres/{id}")
    public @ResponseBody void deleteLivrebyId(@PathVariable String id){
        log.info("Delete livre " + id);
        livreService.deleteLivres(id);
    }
}

