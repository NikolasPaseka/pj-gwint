package cz.mendelu.xpaseka.pj.projekt.cards;

import cz.mendelu.xpaseka.pj.projekt.Game;
import cz.mendelu.xpaseka.pj.projekt.Player;
import cz.mendelu.xpaseka.pj.projekt.cards.enumTypes.FactionType;
import cz.mendelu.xpaseka.pj.projekt.cards.enumTypes.UnitType;

public class TightBondCard extends UnitCard {
    public TightBondCard(UnitType type, int power, String name, FactionType faction, boolean hero) {
        super(type, power, name, faction, hero);
    }

    public TightBondCard(TightBondCard card) {
        this(card.getType(), card.getPower(), card.getName(), card.getFaction(), card.isHero());
    }

    @Override
    public TightBondCard cloneObject() {
        return new TightBondCard(this);
    }
    /**
     * Metoda prida kartu na hracuv stul a aplikuje efekt Tight Bond
     * Pokud jsou v radku kde se karta polozi stejne karty aplikuje se u nich efekt
     * Efekt zdvojnasobi polozene karte silu a vsem ostatnim stejnym kartam
     *
     * @author xpaseka
     */
    @Override
    public void applyCard() {
        super.applyCard();

        Player player = Game.getGameInstance().getPlayer();
        var row = player.getCombatBoard().getRow(this.type);

        int numberOfSameCards = 0;
        for (UnitCard card : row) {
            if (card.equals(this)) {
                numberOfSameCards++;
            }
        }
        if (numberOfSameCards > 1) {
            for (UnitCard card : row) {
                if (card.equals(this)) {
                    card.setPowerMultiplicator(numberOfSameCards);
                }
            }
        }
    }
}
