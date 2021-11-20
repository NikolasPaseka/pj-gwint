package cz.mendelu.xpaseka.pj.projekt.greenfoot.gwintGame;

import com.sun.tools.attach.AgentLoadException;
import cz.mendelu.xpaseka.pj.projekt.Game;
import cz.mendelu.xpaseka.pj.projekt.cards.AgileCard;
import cz.mendelu.xpaseka.pj.projekt.cards.enumTypes.UnitType;
import greenfoot.Actor;
import greenfoot.Greenfoot;

public class UnitTypeButtonActor extends Actor {
    private final AgileCard card;
    private final UnitType unitType;
    private final int index;
    private boolean rendered = false;

    public UnitTypeButtonActor(AgileCard card, int index, UnitType unitType) {
        this.card = card;
        this.unitType = unitType;
        this.index = index;
    }

    @Override
    public void act() {
        if (!rendered) {
            render();
        }
        if (Greenfoot.mouseClicked(this)) {
            AgileCard cardd = (AgileCard) Game.getPlayer().getHand().get(index);
            if (cardd.getType() != unitType) {
                cardd.switchUnitType();
            }
            Game.getPlayer().playCard(index);


            ((GwintWorld) getWorld()).setPlayableHand(true);

            getWorld().removeObjects(getWorld().getObjects(UnitTypeButtonActor.class));
        }
    }

    void render() {
        if (unitType == UnitType.CLOSE_COMBAT) {
            setLocation(913, 466);
        } else if (unitType == UnitType.LONG_RANGE) {
            setLocation(913, 576);
        } else {
            setLocation(913, 686);
        }
        setImage("images/Buttons/glow_row_button.png");
        rendered = true;
    }
}
