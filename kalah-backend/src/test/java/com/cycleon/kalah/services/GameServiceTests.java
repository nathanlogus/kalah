package com.cycleon.kalah.services;


import com.cycleon.kalah.model.Game;
import com.cycleon.kalah.model.PlayerTurn;
import com.cycleon.kalah.service.KalahGameService;
import org.assertj.core.api.BDDAssertions;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application-test.properties")
public class GameServiceTests {
    @Autowired
    private KalahGameService kalahGameService;

    @Value("${game.rules.defaultSeeds}")
    private int defaultSeeds;

    @Test
    public void createNewGame() {
        Game createGameInstance = kalahGameService.createNewGame(defaultSeeds);
        BDDAssertions.then(createGameInstance.getPlayerTurn()).isNull();
        BDDAssertions.then(createGameInstance.getPits().size()).isEqualTo(14);
        BDDAssertions.then(createGameInstance.getPits().get(0).getQuantityOfSeeds()).isEqualTo(4);
        BDDAssertions.then(createGameInstance.getPits().get(1).getQuantityOfSeeds()).isEqualTo(4);
        BDDAssertions.then(createGameInstance.getPits().get(2).getQuantityOfSeeds()).isEqualTo(4);
        BDDAssertions.then(createGameInstance.getPits().get(3).getQuantityOfSeeds()).isEqualTo(4);
        BDDAssertions.then(createGameInstance.getPits().get(4).getQuantityOfSeeds()).isEqualTo(4);
        BDDAssertions.then(createGameInstance.getPits().get(5).getQuantityOfSeeds()).isEqualTo(4);
        BDDAssertions.then(createGameInstance.getPits().get(6).getQuantityOfSeeds()).isEqualTo(0);
        BDDAssertions.then(createGameInstance.getPits().get(7).getQuantityOfSeeds()).isEqualTo(4);
        BDDAssertions.then(createGameInstance.getPits().get(8).getQuantityOfSeeds()).isEqualTo(4);
        BDDAssertions.then(createGameInstance.getPits().get(9).getQuantityOfSeeds()).isEqualTo(4);
        BDDAssertions.then(createGameInstance.getPits().get(10).getQuantityOfSeeds()).isEqualTo(4);
        BDDAssertions.then(createGameInstance.getPits().get(11).getQuantityOfSeeds()).isEqualTo(4);
        BDDAssertions.then(createGameInstance.getPits().get(12).getQuantityOfSeeds()).isEqualTo(4);
        BDDAssertions.then(createGameInstance.getPits().get(13).getQuantityOfSeeds()).isEqualTo(0);
    }

    @Test
    public void getGameInstance(){
        Game createGameInstance = kalahGameService.createNewGame(defaultSeeds);
        Game collectGameCreated = kalahGameService.getGameInstance(createGameInstance.getId());
        BDDAssertions.then(createGameInstance.getId()).isEqualTo(collectGameCreated.getId());
    }

    @Test
    public void sowFirstPitOfPlayerSouth(){
        Game createGameInstance = kalahGameService.createNewGame(defaultSeeds);
        Game gameAfterSow = kalahGameService.sow(createGameInstance.getId(), 1);
        BDDAssertions.then(gameAfterSow.getPlayerTurn()).isEqualTo(PlayerTurn.PLAYER_NORTH);
        BDDAssertions.then(gameAfterSow.getPits().get(0).getQuantityOfSeeds()).isEqualTo(0);
        BDDAssertions.then(gameAfterSow.getPits().get(1).getQuantityOfSeeds()).isEqualTo(5);
        BDDAssertions.then(gameAfterSow.getPits().get(2).getQuantityOfSeeds()).isEqualTo(5);
        BDDAssertions.then(gameAfterSow.getPits().get(3).getQuantityOfSeeds()).isEqualTo(5);
        BDDAssertions.then(gameAfterSow.getPits().get(4).getQuantityOfSeeds()).isEqualTo(5);
        BDDAssertions.then(gameAfterSow.getPits().get(5).getQuantityOfSeeds()).isEqualTo(4);
        BDDAssertions.then(gameAfterSow.getPits().get(6).getQuantityOfSeeds()).isEqualTo(0);
        BDDAssertions.then(gameAfterSow.getPits().get(7).getQuantityOfSeeds()).isEqualTo(4);
        BDDAssertions.then(gameAfterSow.getPits().get(8).getQuantityOfSeeds()).isEqualTo(4);
        BDDAssertions.then(gameAfterSow.getPits().get(9).getQuantityOfSeeds()).isEqualTo(4);
        BDDAssertions.then(gameAfterSow.getPits().get(10).getQuantityOfSeeds()).isEqualTo(4);
        BDDAssertions.then(gameAfterSow.getPits().get(11).getQuantityOfSeeds()).isEqualTo(4);
        BDDAssertions.then(gameAfterSow.getPits().get(12).getQuantityOfSeeds()).isEqualTo(4);
        BDDAssertions.then(gameAfterSow.getPits().get(13).getQuantityOfSeeds()).isEqualTo(0);
    }

    @Test
    public void sowFirstPitOfPlayerNorth(){
        Game createGameInstance = kalahGameService.createNewGame(defaultSeeds);
        Game gameAfterSow = kalahGameService.sow(createGameInstance.getId(), 8);
        BDDAssertions.then(gameAfterSow.getPlayerTurn()).isEqualTo(PlayerTurn.PLAYER_SOUTH);
        BDDAssertions.then(gameAfterSow.getPits().get(0).getQuantityOfSeeds()).isEqualTo(4);
        BDDAssertions.then(gameAfterSow.getPits().get(1).getQuantityOfSeeds()).isEqualTo(4);
        BDDAssertions.then(gameAfterSow.getPits().get(2).getQuantityOfSeeds()).isEqualTo(4);
        BDDAssertions.then(gameAfterSow.getPits().get(3).getQuantityOfSeeds()).isEqualTo(4);
        BDDAssertions.then(gameAfterSow.getPits().get(4).getQuantityOfSeeds()).isEqualTo(4);
        BDDAssertions.then(gameAfterSow.getPits().get(5).getQuantityOfSeeds()).isEqualTo(4);
        BDDAssertions.then(gameAfterSow.getPits().get(6).getQuantityOfSeeds()).isEqualTo(0);
        BDDAssertions.then(gameAfterSow.getPits().get(7).getQuantityOfSeeds()).isEqualTo(0);
        BDDAssertions.then(gameAfterSow.getPits().get(8).getQuantityOfSeeds()).isEqualTo(5);
        BDDAssertions.then(gameAfterSow.getPits().get(9).getQuantityOfSeeds()).isEqualTo(5);
        BDDAssertions.then(gameAfterSow.getPits().get(10).getQuantityOfSeeds()).isEqualTo(5);
        BDDAssertions.then(gameAfterSow.getPits().get(11).getQuantityOfSeeds()).isEqualTo(5);
        BDDAssertions.then(gameAfterSow.getPits().get(12).getQuantityOfSeeds()).isEqualTo(4);
        BDDAssertions.then(gameAfterSow.getPits().get(13).getQuantityOfSeeds()).isEqualTo(0);
    }
}
