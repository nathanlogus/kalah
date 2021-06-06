package com.cycleon.kalah.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "GAME")
public class Game implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "game", cascade=CascadeType.ALL)
    @JsonBackReference
    private List<Pit> pits;

    private PlayerTurn playerTurn;

    @JsonIgnore
    private int currentPitIndex;

}
