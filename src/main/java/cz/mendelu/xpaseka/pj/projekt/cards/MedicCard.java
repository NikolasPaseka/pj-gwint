package cz.mendelu.xpaseka.pj.projekt.cards;

import cz.mendelu.xpaseka.pj.projekt.Game;
import cz.mendelu.xpaseka.pj.projekt.Player;
import cz.mendelu.xpaseka.pj.projekt.cards.enumTypes.FactionType;
import cz.mendelu.xpaseka.pj.projekt.cards.enumTypes.UnitType;

public class MedicCard extends UnitCard {
    public MedicCard(UnitType type, int power, String name, FactionType faction, boolean hero) {
        super(type, power, name, faction, hero);
    }

    /**
     * Metoda prida kartu na hracuv stul a aplikuje efekt medika
     * Efekt medika umozni vybrat kartu ze spalenych karet a instantne ji zahraje
     * Efekt medika se da zretezit - vybrat kartu medika, ktera zase aplikuje efekt
     *
     * @author xpaseka
     */
    @Override
    public void applyCard() {
        super.applyCard();

        Player player = Game.getPlayer();
        var discardPile = player.getDiscardPile();

        // TODO IO implementace - vyber konkretni karty (prozatim se bere posledni karta)
        if (discardPile.size() > 0) {
            Card card = discardPile.get(discardPile.size()-1);
            card.applyCard();
        }
    }
}