package cz.mendelu.xpaseka.pj.projekt.cards;

import cz.mendelu.xpaseka.pj.projekt.CombatBoard;
import cz.mendelu.xpaseka.pj.projekt.Game;
import cz.mendelu.xpaseka.pj.projekt.cards.enumTypes.UnitType;

public class HornCard extends Card {
    volatile UnitType unitType = null;

    public HornCard() {
        super("Commander's Horn");
    }

    @Override
    public HornCard cloneObject() {
        return new HornCard();
    }

    public void applyCard() {
        var game = Game.getGameInstance();
        game.getPlayer().getCombatBoard().addHornCard(unitType, this);
    }

    public void setUnitType(UnitType unitType) {
        this.unitType = unitType;
    }

    public boolean isUnitType() {
        return unitType != null;
    }
}