package com.cycleon.kalah.repository;

import com.cycleon.kalah.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KalahGameRepository extends JpaRepository<Game, Integer> {
}
