package com.cycleon.kalah.repository;

import com.cycleon.kalah.model.Game;
import com.cycleon.kalah.model.Pit;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application-test.properties")
public class GameRepositoryTests {
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

    @Value("${game.rules.defaultSeeds}")
    private int defaultSeeds;

    @Autowired
    KalahGameRepository kalahGameRepository;

    @Test
    public void createGame(){
        Game game = new Game();

        // Setting up the pits for the game
        ArrayList<Pit> pits = new ArrayList<Pit>();
        for(int index = pitStartIndex; index <= pitEndIndex; index++) {
            Pit pit = new Pit();
            pit.setPitIdentifier(index);
            if(index == playerOneHouseIndex || index == playerTwoHouseIndex)
                pit.setQuantityOfSeeds(emptySeeds);
            else
                pit.setQuantityOfSeeds(defaultSeeds);
            pit.setGame(game);
            pits.add(pit);
        }
        game.setPits(pits);
        Game createdGame = kalahGameRepository.saveAndFlush(game);
        Assert.assertNotNull(createdGame.getId());
    }
}
