package com.cycleon.kalah.service.impl;

import com.cycleon.kalah.dto.GameDTO;
import com.cycleon.kalah.dto.PitDTO;
import com.cycleon.kalah.model.Game;
import com.cycleon.kalah.model.Pit;
import com.cycleon.kalah.model.PlayerTurn;
import com.cycleon.kalah.repository.KalahGameRepository;
import com.cycleon.kalah.repository.PitRepository;
import com.cycleon.kalah.service.KalahGameService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;

@Slf4j
@Service
public class KalahGameServiceImpl implements KalahGameService {
    @Value("${game.rules.pitStartIndex}")
    private int pitStartIndex;

    @Value("${game.rules.pitEndIndex}")
    private int pitEndIndex;

    @Value("${game.rules.playerOneHouseIndex}")
    private int playerOneHouseIndex;

    @Value("${game.rules.playerTwoHouseIndex}")
    private int playerTwoHouseIndex;

    @Value("${game.rules.emptySeeds}")
    private int emptySeeds;


    @Autowired
    private KalahGameRepository kalahGameRepository;

    @Autowired
    private PitRepository pitRepository;

    @Override
    public Game createNewGame(Integer numberOfSeeds) {
        Game game = new Game();

        // Setting up the pits for the game
        ArrayList<Pit> pits = new ArrayList<Pit>();
        for(int index = pitStartIndex; index <= pitEndIndex; index++) {
            Pit pit = new Pit();
            pit.setPitIdentifier(index);
            if(index == playerOneHouseIndex || index == playerTwoHouseIndex)
                pit.setQuantityOfSeeds(emptySeeds);
            else
                pit.setQuantityOfSeeds(numberOfSeeds);
            pit.setGame(game);
            pits.add(pit);
        }
        game.setPits(pits);
        kalahGameRepository.saveAndFlush(game);
        log.info("Game: {} registered successfully!", game.getId());
        return game;
    }

    @Override
    public Game getGameInstance(Integer id) {
        if(kalahGameRepository.findById(id).isPresent())
            return kalahGameRepository.findById(id).get();

        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Game not found.");
    }

    @Override
    public Game updateGameInstance(Game game) {
        Game updatedGameInstance = kalahGameRepository.saveAndFlush(game);
        return updatedGameInstance;
    }

    @Override
    public Game sow(Integer id, Integer pitIndex) {
        Game game = this.getGameInstance(id);

        if(pitIndex.equals(playerOneHouseIndex) || pitIndex.equals(playerTwoHouseIndex))
            return game;

        if(game.getPlayerTurn() == null){
            if(pitIndex < playerOneHouseIndex)
                game.setPlayerTurn(PlayerTurn.PLAYER_SOUTH);
            else
                game.setPlayerTurn(PlayerTurn.PLAYER_NORTH);
        }

        if(game.getPlayerTurn().equals(PlayerTurn.PLAYER_SOUTH) && pitIndex > playerOneHouseIndex ||
           game.getPlayerTurn().equals(PlayerTurn.PLAYER_NORTH) && pitIndex < playerTwoHouseIndex)
            return game;


        Pit selectedPit = game.getPits().stream().filter(p -> p.getPitIdentifier().equals(pitIndex)).findFirst().get();
        Integer seedsInPit = selectedPit.getQuantityOfSeeds();

        if(seedsInPit.equals(emptySeeds))
            return game;

        selectedPit.setQuantityOfSeeds(emptySeeds);

        game.setCurrentPitIndex(pitIndex);

        for(Integer i = 0; i < seedsInPit; i++){
            sowRight(game, false);
        }

        sowRight(game, true);

        Integer currentPitIndex = game.getCurrentPitIndex();

        if(!currentPitIndex.equals(playerOneHouseIndex) && !currentPitIndex.equals(playerTwoHouseIndex))
            game.setPlayerTurn(nextTurn(game.getPlayerTurn()));
        return game;
    }

    @Override
    public GameDTO gameToDTO(Game game) {
        ModelMapper modelMapper = new ModelMapper();
        GameDTO gameDTO = modelMapper.map(game, GameDTO.class);
        gameDTO.setPits(gameDTO.getPits().stream().sorted(Comparator.comparing(PitDTO::getPitIdentifier)).collect(Collectors.toList()));
        return gameDTO;
    }

    private void sowRight(Game game, Boolean isLastStone) {
        Integer currentPitIndex = game.getCurrentPitIndex() % pitEndIndex + 1;
        PlayerTurn playerTurn = game.getPlayerTurn();
        if(currentPitIndex.equals(playerOneHouseIndex) && playerTurn.equals(PlayerTurn.PLAYER_NORTH) ||
           currentPitIndex.equals(playerTwoHouseIndex) && playerTurn.equals(PlayerTurn.PLAYER_SOUTH)){
            currentPitIndex = currentPitIndex % pitEndIndex + 1;
        }
        game.setCurrentPitIndex(currentPitIndex);

        Integer finalCurrentPitIndex = currentPitIndex;
        Pit targetPit = game.getPits().stream().filter(p -> p.getPitIdentifier().equals(finalCurrentPitIndex)).findFirst().get();
        if(!isLastStone || currentPitIndex.equals(playerOneHouseIndex) || currentPitIndex.equals(playerTwoHouseIndex)){
            targetPit.setQuantityOfSeeds(targetPit.getQuantityOfSeeds() + 1);
            return;
        }

        Pit oppositePit = game.getPits().stream().filter(p -> p.getPitIdentifier().equals(pitEndIndex - finalCurrentPitIndex)).findFirst().get();
        if(targetPit.getQuantityOfSeeds().equals(emptySeeds) && oppositePit.getQuantityOfSeeds().equals(emptySeeds)){
            Integer oppositeSeeds = oppositePit.getQuantityOfSeeds();
            oppositePit.setQuantityOfSeeds(emptySeeds);
            Integer pitHouseIndex = currentPitIndex < playerOneHouseIndex ? playerOneHouseIndex : playerTwoHouseIndex;
            Pit pitHouse = game.getPits().stream().filter(p -> p.getPitIdentifier().equals(pitHouseIndex)).findFirst().get();
            pitHouse.setQuantityOfSeeds(pitHouse.getQuantityOfSeeds() + oppositeSeeds + 1);
            return;
        }
        targetPit.setQuantityOfSeeds(targetPit.getQuantityOfSeeds() + 1);
    }

    private PlayerTurn nextTurn(PlayerTurn currentTurn) {
        if(currentTurn.equals(PlayerTurn.PLAYER_NORTH))
            return PlayerTurn.PLAYER_SOUTH;
        return PlayerTurn.PLAYER_NORTH;
    }
}
