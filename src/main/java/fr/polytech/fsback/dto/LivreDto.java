package fr.polytech.fsback.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
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

}
