package cz.mendelu.xpaseka.pj.projekt.cards;

import cz.mendelu.xpaseka.pj.projekt.Game;
import cz.mendelu.xpaseka.pj.projekt.Player;
import cz.mendelu.xpaseka.pj.projekt.cards.enumTypes.FactionType;
import cz.mendelu.xpaseka.pj.projekt.cards.enumTypes.UnitType;

public class SpyCard extends UnitCard {
    public SpyCard(UnitType type, int power, String name, FactionType faction, boolean hero) {
        super(type, power, name, faction, hero);
    }

    /**
     * Metoda vylozi kartu na nepriteluv stul a aplikuje efekt Spy
     * Karta pridava silu protivnikovi ale hrac si vezme 2 pridavne karty ze sveho balicku
     *
     * @author xpaseka
     *
     */
    public void applyCard() {
        System.out.println(name);
        Game.getOpponent().addCardToCombatBoard(this);

        Player player = Game.getPlayer();
        var deck = player.getDeck();

        if (deck.size() >= 2) {
            player.addCardToHand(deck.remove(deck.size()-1));
            player.addCardToHand(deck.remove(deck.size()-1));
        }
    }
}
