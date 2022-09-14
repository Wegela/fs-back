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
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@RestController()
//@RequiredArgsConstructor
@Slf4j
public class LivreController {

    private final LivreService livreService;

    public LivreController(LivreService lservice) {
        this.livreService = lservice;
    }

    // Retourne un livre spécifique à un ID
    @GetMapping("/livres/{ID}")
    public @ResponseBody LivreDto getLivreByID(@PathVariable String id){
        return LivreDto.fromEntity(this.livreService.getLivreById(id));

    }

    // Retourne la liste complète des livres
    @GetMapping("/livres")
    public @ResponseBody List<LivreDto> getLivres(){
        return this.livreService.getLivres().stream().map(entity -> LivreDto.fromEntity(entity)).collect(Collectors.toList());
    }

    @PostMapping("/livres")
    public @ResponseBody LivreDto livreDTO(@Valid @RequestBody final LivreDto body) {
        return LivreDto.fromEntity(livreService.addLivres(body.getTitre()));
    }

    @PostMapping("/Livres")
    public LivreDto postLivre(@Valid @RequestBody LivreDto l){
        return LivreDto.fromEntity(this.livreService.addLivres(l.getTitre()));
    }

    @DeleteMapping("/livres/{id}")
    public @ResponseBody void deleteLivrebyId(@PathVariable String id){
        log.info("Delete livre " + id);
        livreService.deleteLivres(id);
    }
}

