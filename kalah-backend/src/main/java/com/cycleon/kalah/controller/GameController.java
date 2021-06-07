package com.cycleon.kalah.controller;


import com.cycleon.kalah.dto.GameDTO;
import com.cycleon.kalah.model.Game;
import com.cycleon.kalah.service.KalahGameService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;


@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/game")
public class GameController {
    @Value("${game.rules.defaultSeeds}")
    private int defaultSeeds;

    @Value("${game.rules.playerOneHouseIndex}")
    private int playerOneHouseIndex;

    @Value("${game.rules.playerTwoHouseIndex}")
    private int playerTwoHouseIndex;

    @Autowired
    private KalahGameService kalahGameService;

    @GetMapping("/{id}")
    public ResponseEntity<GameDTO> getGameData(@PathVariable Integer id) {
        Game game = kalahGameService.getGameInstance(id);
        GameDTO gameDTO = kalahGameService.gameToDTO(game);
        return ResponseEntity.ok(gameDTO);
    }

    @PostMapping
    public ResponseEntity<Game> createKalahGame(@RequestParam(name="numberOfSeeds", required = false) Integer numberOfSeeds){
        if(numberOfSeeds != null){
            return ResponseEntity.ok(kalahGameService.createNewGame(numberOfSeeds));
        } else {
            return ResponseEntity.ok(kalahGameService.createNewGame(defaultSeeds));
        }
    }

    @PostMapping("/{gameId}/pits/{pitId}")
    public ResponseEntity<GameDTO> sow(@PathVariable(value = "gameId") Integer gameId, @PathVariable(value = "pitId") Integer pitId){
        if(pitId.equals(null) || pitId < 1 || pitId.equals(playerOneHouseIndex) || pitId.equals(playerTwoHouseIndex) || pitId > playerTwoHouseIndex)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Pit Index is Invalid.");

        Game game = kalahGameService.sow(gameId, pitId);
        kalahGameService.updateGameInstance(game);
        GameDTO gameDTO = kalahGameService.gameToDTO(game);
        return ResponseEntity.ok(gameDTO);
    }

}
