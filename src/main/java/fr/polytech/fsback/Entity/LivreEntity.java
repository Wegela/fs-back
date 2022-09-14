package fr.polytech.fsback.Entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "livre")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class LivreEntity {

    @Id
    @GeneratedValue
    private String id;

    @Column(name = "titre")
    private String titre;
}
