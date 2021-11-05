package cz.mendelu.xpaseka.pj.projekt;

import cz.mendelu.xpaseka.pj.projekt.cards.Card;
import cz.mendelu.xpaseka.pj.projekt.cards.enumTypes.FactionType;
import cz.mendelu.xpaseka.pj.projekt.cards.MusterCard;
import cz.mendelu.xpaseka.pj.projekt.cards.enumTypes.UnitType;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MusterCardTest {

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
    void applyCard() {
        // setup
        Game.createNewGame();
        Player player = Game.getPlayer();
        Card arachas1 = new MusterCard(UnitType.LONG_RANGE, 5, "Arachas", FactionType.NEUTRAL, false);
        Card arachas2 = new MusterCard(UnitType.LONG_RANGE, 5, "Arachas", FactionType.NEUTRAL, false);
        Card arachas3 = new MusterCard(UnitType.LONG_RANGE, 5, "Arachas", FactionType.NEUTRAL, false);

        player.addCardToDeck(arachas2);
        player.addCardToDeck(arachas3);

        int expectedPower = 15;

        // when
        arachas1.applyCard();

        // then
        assertEquals(expectedPower, player.getTotalScore());
    }

    /**
     * @author xpaseka
     * @version etapa 2
     */
    @Test
    void applyCard_noMusterCards() {
        // setup
        Game.createNewGame();
        Player player = Game.getPlayer();
        Card havekar = new MusterCard(UnitType.LONG_RANGE, 3, "Havekar Smuggler", FactionType.NEUTRAL, false);

        int expectedPower = 3;

        // when
        havekar.applyCard();

        // then
        assertEquals(expectedPower, player.getTotalScore());
    }
}