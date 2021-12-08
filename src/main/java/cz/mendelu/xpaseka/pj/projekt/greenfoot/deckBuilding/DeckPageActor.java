package cz.mendelu.xpaseka.pj.projekt.greenfoot.deckBuilding;

import greenfoot.Actor;
import greenfoot.Greenfoot;
import greenfoot.GreenfootImage;

import java.awt.*;

public class DeckPageActor extends Actor {
    private boolean clickable = true;
    private final int page;

    DeckPageActor(int page) {
        this.page = page;
        updateImage();
    }

    public void act() {
        if (((DeckBuildingWorld)getWorld()).getCurrentDeckPage() == page) {
            setClickable(false);
        }
        if (Greenfoot.mouseClicked(this)) {
            var buttons = getWorld().getObjects(DeckPageActor.class);
            for (var button : buttons) {
                button.setClickable(true);
            }
            setClickable(false);
            ((DeckBuildingWorld) getWorld()).setCurrentDeckPage(page);
            ((DeckBuildingWorld) getWorld()).updateCards();
        }
    }

    public void setClickable(boolean clickable) {
        this.clickable = clickable;
        updateImage();
    }

    public void updateImage() {
        if (clickable) {
            setImage("images/Buttons/pageButton_notactive.png");
        } else {
            setImage("images/Buttons/pageButton_active.png");
        }
        getImage().drawImage(new GreenfootImage(Integer.toString(page), 20, Color.WHITE, null), 10, 12);
    }
}
