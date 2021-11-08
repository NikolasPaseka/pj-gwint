package cz.mendelu.xpaseka.pj.projekt.greenfoot;

import cz.mendelu.xpaseka.pj.projekt.Game;
import cz.mendelu.xpaseka.pj.projekt.cards.HornCard;
import cz.mendelu.xpaseka.pj.projekt.cards.enumTypes.UnitType;
import greenfoot.Actor;
import greenfoot.Greenfoot;

public class HornButtonActor extends Actor {
    private final UnitType unitType;
    private final int cardIndex;

    HornButtonActor(int cardIndex, UnitType unitType) {
        this.cardIndex = cardIndex;
        this.unitType = unitType;
        setImage(String.format("images/Unit Type Buttons/%s.png", unitType.name()));
    }

    @Override
    public void act() {
        if (Greenfoot.mouseClicked(this)) {
            HornCard card = (HornCard) Game.getPlayer().getHand().get(cardIndex);
            card.setUnitType(unitType);
            Game.getPlayer().playCard(cardIndex);
            getWorld().addObject(new HornCardActor(unitType), 0, 0);

            var handCards = getWorld().getObjects(HandCardActor.class);
            for (HandCardActor handCardActor : handCards) {
                handCardActor.setPlayable(true);
            }

            getWorld().removeObjects(getWorld().getObjects(HornButtonActor.class));
        }
    }
}
