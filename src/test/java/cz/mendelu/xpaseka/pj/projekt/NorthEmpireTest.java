package cz.mendelu.xpaseka.pj.projekt;

import cz.mendelu.xpaseka.pj.projekt.cards.Card;
import cz.mendelu.xpaseka.pj.projekt.cards.enumTypes.FactionType;
import cz.mendelu.xpaseka.pj.projekt.cards.enumTypes.UnitType;
import cz.mendelu.xpaseka.pj.projekt.cards.UnitCard;
import cz.mendelu.xpaseka.pj.projekt.factions.Faction;
import cz.mendelu.xpaseka.pj.projekt.factions.NorthEmpire;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
        Game.getGameInstance().reloadPlayer(new Player("Player"));
        var player = Game.getGameInstance().getPlayer();

        UnitCard ciri = new UnitCard(UnitType.CLOSE_COMBAT, 9, "Ciri", FactionType.NEUTRAL, true);
        UnitCard cynthia = new UnitCard(UnitType.LONG_RANGE, 7, "cynthia", FactionType.NORTH_EMPIRE, false);
        UnitCard yennefer = new UnitCard(UnitType.LONG_RANGE, 8, "Yen", FactionType.NILFGAARDIAN_EMPIRE, true);
        UnitCard yennefer2 = new UnitCard(UnitType.LONG_RANGE, 8, "Yen", FactionType.NILFGAARDIAN_EMPIRE, true);
        player.addCardToDeck(ciri);
        player.addCardToDeck(cynthia);
        player.addCardToDeck(yennefer);
        player.addCardToHand(yennefer2);

        List<Card> deck = player.getDeck();
        List<Card> hand = player.getHand();

        Faction northEmpire = new NorthEmpire();

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
    @Test
    void applyEffect_emptyDeck() {
        // setup
        Game.getGameInstance().reloadPlayer(new Player("Player"));

        Faction northEmpire = new NorthEmpire();

        // when + then
        assertThrows(IndexOutOfBoundsException.class, () -> northEmpire.applyEffect());
    }
}