package fr.polytech.fsback.Service;

import fr.polytech.fsback.Controllers.Livre;
import fr.polytech.fsback.dto.LivreDto;
import fr.polytech.fsback.exception.NotFoundException;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
@Service
public class LivreService {
    private Collection<LivreDto> livres = new ArrayList<LivreDto>(Arrays.asList(LivreDto.builder().ID("1").titre("abc").build(), LivreDto.builder().ID("2").titre("def").build()));

    public LivreService() {
        LivreDto createdLivre = LivreDto.builder().ID(String.valueOf(Math.random())).titre("Harry Potter").build();
        livres.add(createdLivre);
    }


    public LivreDto getLivreById(String id) {
        return this.livres.stream().filter(livreDto -> livreDto.getID()==id).findFirst()
                .orElseThrow(() -> new NotFoundException("Livre with id " + id + " doesn't exist"));
    }

    public  Collection<LivreDto> getLivres(){
        return livres;
    }

    public LivreDto addLivres(String name){
        LivreDto createdLivre = LivreDto.builder().ID(String.valueOf(Math.random())).titre(name).build();
        livres.add(createdLivre);
        return (createdLivre);
    }

    public void deleteLivres(String id){
        livres.remove(getLivreById(id));

    }
}
