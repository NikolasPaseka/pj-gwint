package cz.mendelu.xpaseka.pj.projekt.greenfoot.gwintGame;

import cz.mendelu.xpaseka.pj.projekt.Game;
import cz.mendelu.xpaseka.pj.projekt.cards.DecoyCard;
import cz.mendelu.xpaseka.pj.projekt.cards.enumTypes.UnitType;
import greenfoot.Actor;
import greenfoot.Greenfoot;

public class CardButtonActor extends Actor {
    private DecoyCard decoy;
    private UnitType unitType;
    private int index;
    private int indexHand;

    public CardButtonActor(DecoyCard decoy, UnitType unitType, int index, int indexHand) {
        this.decoy = decoy;
        this.unitType = unitType;
        this.index = index;
        this.indexHand = indexHand;
        setImage("images/Buttons/glow_card_button.png");
    }

    @Override
    public void act() {
        if (Greenfoot.mouseClicked(this)) {
            decoy.setUnitType(unitType);
            decoy.setIndex(index);
            Game.getGameInstance().getPlayer().playCard(indexHand);

            ((GwintWorld) getWorld()).setPlayableHand(true);

            ((GwintWorld) getWorld()).updateHand(Game.getGameInstance().getPlayer().getHand());
            ((GwintWorld) getWorld()).updateCombatBoard();
            getWorld().removeObjects(getWorld().getObjects(CardButtonActor.class));
        }
    }
}
