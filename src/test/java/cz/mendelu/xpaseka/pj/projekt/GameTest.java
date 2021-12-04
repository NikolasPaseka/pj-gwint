package cz.mendelu.xpaseka.pj.projekt;

import cz.mendelu.xpaseka.pj.projekt.factions.NorthEmpire;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    /**
     * @author xpaseka
     * @version etapa 2
     */
    @Test
    void buildDeck() {
        // setup
        var game = new Game();
        Player player = game.getPlayer();
        player.setFaction(new NorthEmpire());
        int minDeckSize = 22;

        //when
        player.setDeck(Game.buildDeck(player));

        // then
        assertNotNull(player.getDeck());
        assertTrue(player.getDeck().size() >= minDeckSize);
    }

    /**
     * @author xpaseka
     * @version etapa 2
     */
    @Test
    void buildDeck_fail() {
        // setup
        var game = new Game();
        Player player = game.getPlayer();

        //when
        player.setDeck(Game.buildDeck(player));
        int expectedSize = 0;

        // then
        assertEquals(expectedSize, player.getDeck().size());
    }
}