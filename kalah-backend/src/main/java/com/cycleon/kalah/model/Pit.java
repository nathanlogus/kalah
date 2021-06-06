package com.cycleon.kalah.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "PIT")
public class Pit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer pitIdentifier;

    private Integer quantityOfSeeds;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "game_id", insertable = true, updatable = false)
    @JsonManagedReference
    private Game game;

}
