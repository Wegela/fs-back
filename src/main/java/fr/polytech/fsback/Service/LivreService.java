package fr.polytech.fsback.Service;

import fr.polytech.fsback.Controllers.Livre;
import fr.polytech.fsback.Entity.LivreEntity;
import fr.polytech.fsback.dto.LivreDto;
import fr.polytech.fsback.exception.NotFoundException;
import fr.polytech.fsback.repository.LivreRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
@Service
@RequiredArgsConstructor
public class LivreService {

    private LivreRepository livreRepository;

    public List<LivreEntity> getLivres() {
        return this.livreRepository.findAll();
    }
    public LivreEntity getLivreById(String id) {
        return this.livreRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Livre with id " + id + " doesn't exist"));
    }

    public LivreEntity addLivres(String titre) {
        final LivreEntity newlivre = LivreEntity.builder().titre(titre).build();
        this.livreRepository.save(newlivre);
        return newlivre;
    }

}
