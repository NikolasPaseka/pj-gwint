package cz.mendelu.xpaseka.pj.projekt.cards;

import cz.mendelu.xpaseka.pj.projekt.Game;
import cz.mendelu.xpaseka.pj.projekt.Player;
import cz.mendelu.xpaseka.pj.projekt.cards.enumTypes.FactionType;
import cz.mendelu.xpaseka.pj.projekt.cards.enumTypes.UnitType;

public class MedicCard extends UnitCard {
    public MedicCard(UnitType type, int power, String name, FactionType faction, boolean hero) {
        super(type, power, name, faction, hero);
    }

    public MedicCard(MedicCard card) {
        this(card.getType(), card.getPower(), card.getName(), card.getFaction(), card.isHero());
    }

    @Override
    public MedicCard cloneObject() {
        return new MedicCard(this);
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

        Player player = Game.getGameInstance().getPlayer();
        var discardPile = player.getDiscardPile();

        if (discardPile.size() > 0) {
            Card card = discardPile.remove(discardPile.size()-1);
            card.applyCard();
        }
    }
}
