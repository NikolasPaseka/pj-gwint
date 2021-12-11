package cz.mendelu.xpaseka.pj.projekt.cards;

import cz.mendelu.xpaseka.pj.projekt.Game;

import java.util.List;
import java.util.ListIterator;

public class ScorchSpecialCard extends Card {

    public ScorchSpecialCard() {
        super("Scorch");
    }

    public ScorchSpecialCard cloneObject() {
        return new ScorchSpecialCard();
    }

    @Override
    public void applyCard() {
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
