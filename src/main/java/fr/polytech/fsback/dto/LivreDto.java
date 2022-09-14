package fr.polytech.fsback.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import fr.polytech.fsback.Entity.LivreEntity;
import fr.polytech.fsback.Service.LivreService;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LivreDto {
    @JsonProperty("ID")
    private String ID;


    @JsonProperty("titre")
    @Size(max = 10)
    private String titre;

    public static LivreDto fromEntity(LivreEntity entity) {
        return LivreDto.builder().ID(entity.getId()).titre(entity.getTitre()).build();
    }

}
