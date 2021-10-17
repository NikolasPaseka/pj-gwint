package cz.mendelu.xpaseka.pj.projekt;

import cz.mendelu.xpaseka.pj.projekt.Game;
import cz.mendelu.xpaseka.pj.projekt.Player;
import cz.mendelu.xpaseka.pj.projekt.cards.Card;
import cz.mendelu.xpaseka.pj.projekt.cards.MusterCard;
import cz.mendelu.xpaseka.pj.projekt.cards.TypeOfCard;
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
        Player player = Game.getPlayer();
        Card arachas1 = new MusterCard(TypeOfCard.LONG_RANGE, 5, "Arachas");
        Card arachas2 = new MusterCard(TypeOfCard.LONG_RANGE, 5, "Arachas");
        Card arachas3 = new MusterCard(TypeOfCard.LONG_RANGE, 5, "Arachas");

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
        Player player = Game.getPlayer();
        Card havekar = new MusterCard(TypeOfCard.LONG_RANGE, 3, "Havekar Smuggler");

        int expectedPower = 3;

        // when
        havekar.applyCard();

        // then
        assertEquals(expectedPower, player.getTotalScore());
    }
}