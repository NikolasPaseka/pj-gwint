package cz.mendelu.xpaseka.pj.projekt;

import cz.mendelu.xpaseka.pj.projekt.cards.Card;
import cz.mendelu.xpaseka.pj.projekt.cards.MusterCard;
import cz.mendelu.xpaseka.pj.projekt.cards.TypeOfCard;
import cz.mendelu.xpaseka.pj.projekt.cards.UnitCard;
import cz.mendelu.xpaseka.pj.projekt.factions.Faction;
import cz.mendelu.xpaseka.pj.projekt.factions.NorthEmpire;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class NorthEmpireTest {

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
    void applyEffect() {
        // setup
        Player player = Game.getPlayer();

        UnitCard ciri = new UnitCard(TypeOfCard.CLOSE_COMBAT, 9, "Ciri");
        UnitCard cynthia = new UnitCard(TypeOfCard.LONG_RANGE, 7, "cynthia");
        UnitCard yennefer = new UnitCard(TypeOfCard.LONG_RANGE, 8, "Yen");
        UnitCard yennefer2 = new UnitCard(TypeOfCard.LONG_RANGE, 8, "Yen");
        player.addCardToDeck(ciri);
        player.addCardToDeck(cynthia);
        player.addCardToDeck(yennefer);
        player.addCardToHand(yennefer2);

        List<Card> deck = player.getDeck();
        List<Card> hand = player.getHand();

        Faction northEmpire = new NorthEmpire(player);

        int expectedDeckSize = 2;
        int expectedHandSize = 2;
        // when
        northEmpire.applyEffect();

        // then
        assertEquals(expectedDeckSize, deck.size());
        assertEquals(expectedHandSize, hand.size());
    }

    /**
     * @author xpaseka
     * @version etapa 2
     */
    void applyEffect_emptyDeck() {
        // setup
        Player player = Game.getPlayer();
        Faction northEmpire = new NorthEmpire(player);

        // when + then
        assertThrows(IndexOutOfBoundsException.class, () -> northEmpire.applyEffect());
    }
}