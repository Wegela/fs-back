package fr.polytech.fsback.Service;

import fr.polytech.fsback.Controllers.Livre;
import fr.polytech.fsback.dto.BibliothequeDto;
import fr.polytech.fsback.dto.LivreDto;
import fr.polytech.fsback.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class BibliothequeService {

    private final List<BibliothequeDto> listeDeBibliotheque = new ArrayList<>();
    private final LivreService livreService;
    public BibliothequeDto getBibliothequeById(final String id){
        return this.listeDeBibliotheque.stream().filter(bibliothequeDto -> bibliothequeDto.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new NotFoundException("bibliotheque with this is not exist"));
    }

    public LivreDto addLivreToBiblio(final String bibliothequeId, final String livreId){
        final BibliothequeDto bibliotheque = this.getBibliothequeById(bibliothequeId);
        final LivreDto livreToAdd = this.livreService.getLivreById(livreId);

        bibliotheque.getLivres().add(livreToAdd);

        return livreToAdd;
    }
}
