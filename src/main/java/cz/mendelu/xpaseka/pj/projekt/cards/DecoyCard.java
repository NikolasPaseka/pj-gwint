package cz.mendelu.xpaseka.pj.projekt.cards;

import cz.mendelu.xpaseka.pj.projekt.Game;
import cz.mendelu.xpaseka.pj.projekt.cards.enumTypes.FactionType;
import cz.mendelu.xpaseka.pj.projekt.cards.enumTypes.UnitType;

public class DecoyCard extends UnitCard {
    private int index = -1;

    public DecoyCard() {
        super(null, 0, "Decoy", FactionType.NEUTRAL, false);
    }

    @Override
    public DecoyCard cloneObject() {
        return new DecoyCard();
    }

    public void setUnitType(UnitType type) {
        this.type = type;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    @Override
    public void setCurrentPower(int power) {
        this.currentPower = 0;
    }

    @Override
    public void applyCard() {
        if (index > -1 && type != null) {
            var game = Game.getGameInstance();
            var board = game.getPlayer().getCombatBoard();
            var row = board.getRow(type);
            var cardToChange = row.remove((index));
            cardToChange.removeEffect();
            game.getPlayer().addCardToHand(cardToChange);
            row.add(index, this);
        }
    }
}
