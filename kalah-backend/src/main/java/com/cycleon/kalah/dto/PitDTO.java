package com.cycleon.kalah.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PitDTO {
    private Integer id;
    private Integer pitIdentifier;
    private Integer quantityOfSeeds;
}
