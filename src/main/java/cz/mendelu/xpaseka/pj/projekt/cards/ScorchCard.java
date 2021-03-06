package cz.mendelu.xpaseka.pj.projekt.cards;

import cz.mendelu.xpaseka.pj.projekt.Game;
import cz.mendelu.xpaseka.pj.projekt.cards.enumTypes.FactionType;
import cz.mendelu.xpaseka.pj.projekt.cards.enumTypes.UnitType;

import java.util.List;
import java.util.ListIterator;

public class ScorchCard extends UnitCard {
    public ScorchCard(UnitType type, int power, String name, FactionType faction, boolean hero) {
        super(type, power, name, faction, hero);
    }

    public ScorchCard(ScorchCard card) {
        this(card.getType(), card.getPower(), card.getName(), card.getFaction(), card.isHero());
    }

    @Override
    public ScorchCard cloneObject() {
        return new ScorchCard(this);
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
        var opponent = Game.getGameInstance().getOpponent();
        var opponentCards = opponent.getCombatBoard().getAllUnits();
        int maxPower = 0;

        for (List<UnitCard> cards : opponentCards.values()) {
            for (UnitCard card : cards) {
                if (card.getCurrentPower() > maxPower && !card.isHero()) {
                    maxPower = card.getCurrentPower();
                }
            }
        }

        for (List<UnitCard> cards : opponentCards.values()) {
            ListIterator<UnitCard> iterator = cards.listIterator();
            while (iterator.hasNext()) {
                var card = iterator.next();
                if (card.getCurrentPower() == maxPower) {
                    card.removeEffect();
                    opponent.addCardToDiscardPile(card);
                    iterator.remove();
                }
            }
        }
    }
}
