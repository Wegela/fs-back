package fr.polytech.fsback.dto;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BibliothequeDto {

    @JsonProperty("id")
    private String id;
    @JsonProperty("nom")
    private String nom;
    @JsonProperty("livres")
    private List<LivreDto> livres;

}
