package com.cycleon.kalah.dto;

import com.cycleon.kalah.model.Pit;
import com.cycleon.kalah.model.PlayerTurn;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GameDTO {
    private Integer id;
    private List<PitDTO> pits;
    @Enumerated(EnumType.STRING)
    private PlayerTurn playerTurn;
}
