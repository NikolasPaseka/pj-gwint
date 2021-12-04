package cz.mendelu.xpaseka.pj.projekt.greenfoot.gwintGame;

import cz.mendelu.xpaseka.pj.projekt.Game;
import cz.mendelu.xpaseka.pj.projekt.cards.HornCard;
import cz.mendelu.xpaseka.pj.projekt.cards.enumTypes.UnitType;
import greenfoot.Actor;
import greenfoot.Greenfoot;

/**
 * Actor pro vybrani akce pri zahrani karty Roh
 * Znemozni zahrani jinych karet, dokud se neprovede vyber tohoto actora
 *
 * @author xpaseka
 * @version etapa 4
 */

public class HornButtonActor extends Actor {
    private final UnitType unitType;
    private final int cardIndex;

    HornButtonActor(int cardIndex, UnitType unitType) {
        this.cardIndex = cardIndex;
        this.unitType = unitType;
        setImage("images/Buttons/glow_button.png");
    }

    @Override
    public void act() {
        if (Greenfoot.mouseClicked(this)) {
            HornCard card = (HornCard) Game.getGameInstance().getPlayer().getHand().get(cardIndex);
            card.setUnitType(unitType);
            Game.getGameInstance().getPlayer().playCard(cardIndex);

            ((GwintWorld) getWorld()).setPlayableHand(true);

            getWorld().removeObjects(getWorld().getObjects(HornButtonActor.class));
        }
    }
}
