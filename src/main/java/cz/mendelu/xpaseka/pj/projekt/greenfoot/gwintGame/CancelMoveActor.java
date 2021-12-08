package cz.mendelu.xpaseka.pj.projekt.greenfoot.gwintGame;

import greenfoot.Actor;
import greenfoot.Greenfoot;
import greenfoot.GreenfootImage;

import java.awt.*;

public class CancelMoveActor extends Actor {
    public CancelMoveActor() {
        setImage("images/Buttons/button_active.png");
        var text = new GreenfootImage("Cancel move", 25, Color.WHITE, null);
        getImage().drawImage(text, getImage().getWidth()/2-text.getWidth()/2, getImage().getHeight()/2-text.getHeight()/2);
    }

    @Override
    public void act() {
        if (Greenfoot.mouseClicked(this)) {
            getWorld().removeObjects(getWorld().getObjects(HornButtonActor.class));
            getWorld().removeObjects(getWorld().getObjects(UnitTypeButtonActor.class));
            getWorld().removeObjects(getWorld().getObjects(CardButtonActor.class));

            ((GwintWorld) getWorld()).setPlayableHand(true); // also deletes the button
        }
    }
}
