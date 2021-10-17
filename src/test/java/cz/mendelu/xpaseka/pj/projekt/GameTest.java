package cz.mendelu.xpaseka.pj.projekt;

import cz.mendelu.xpaseka.pj.projekt.cards.TypeOfCard;
import cz.mendelu.xpaseka.pj.projekt.cards.UnitCard;
import cz.mendelu.xpaseka.pj.projekt.cards.WeatherCard;
import cz.mendelu.xpaseka.pj.projekt.cards.WeatherType;
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
        Player player = Game.getPlayer();
        int minDeckSize = 22;

        //when
        player.setDeck(Game.buildDeck());

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
        Player player = Game.getPlayer();

        //when
        player.setDeck(Game.buildDeck());

        // then
        assertNull(player.getDeck());
    }
}