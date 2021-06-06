package com.cycleon.kalah.service;

import com.cycleon.kalah.dto.GameDTO;
import com.cycleon.kalah.model.Game;

public interface KalahGameService {
    public Game createNewGame(Integer numberOfSeeds);
    public Game getGameInstance(Integer id);
    public Game updateGameInstance(Game game);
    public Game sow(Integer id, Integer pitIndex);
    public GameDTO gameToDTO(Game game);
}
