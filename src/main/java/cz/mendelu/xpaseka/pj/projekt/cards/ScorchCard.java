package cz.mendelu.xpaseka.pj.projekt.cards;

import cz.mendelu.xpaseka.pj.projekt.Game;
import cz.mendelu.xpaseka.pj.projekt.cards.enumTypes.FactionType;
import cz.mendelu.xpaseka.pj.projekt.cards.enumTypes.UnitType;

import java.util.List;

public class ScorchCard extends UnitCard {
    public ScorchCard(UnitType type, int power, String name, FactionType faction, boolean hero) {
        super(type, power, name, faction, hero);
    }

    /**
     * Přidá kartu jednotky na hráčovu hrací desku a použije efekt ScorchCard
     * Efekt Scorch nalezne protivnikovi nejsilnejsi jednotky a spali je
     *
     * @author xpaseka
     */
    @Override
    public void applyCard() {
        super.applyCard();
        var opponentCards = Game.getOpponent().getCombatBoard().getAllUnits();
        int maxPower = 0;

        for (List<UnitCard> cards : opponentCards.values()) {
            for (UnitCard card : cards) {
                if (card.getCurrentPower() > maxPower) {
                    maxPower = card.getCurrentPower();
                }
            }
        }

        for (List<UnitCard> cards : opponentCards.values()) {
            for (int i = 0; i < cards.size(); i++) {
                if (cards.get(i).getCurrentPower() == maxPower) {
                    cards.remove(i);
                }
            }
        }
    }
}
