package cz.mendelu.xpaseka.pj.projekt.greenfoot.gwintGame;

import cz.mendelu.xpaseka.pj.projekt.cards.HornCard;
import cz.mendelu.xpaseka.pj.projekt.cards.enumTypes.UnitType;
import greenfoot.Actor;

public class HornCardActor extends Actor {
    private final UnitType unitType;
    private boolean rendered = false;

    public HornCardActor(UnitType unitType) {
        this.unitType = unitType;
        setImage("images/cards/HD+/Commander's Horn.jpg");
    }
    @Override
    public void act() {
        if (!rendered) {
            render();
        }
    }

    public void render() {
        if (unitType == UnitType.CLOSE_COMBAT) {
            setLocation(447, 466);
        } else if (unitType == UnitType.LONG_RANGE) {
            setLocation(447, 576);
        } else {
            setLocation(447, 686);
        }
        rendered = true;
    }
}
