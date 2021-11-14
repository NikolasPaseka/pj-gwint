package cz.mendelu.xpaseka.pj.projekt.greenfoot.deckBuilding;

import cz.mendelu.xpaseka.pj.projekt.cards.UnitCard;
import cz.mendelu.xpaseka.pj.projekt.cards.enumTypes.UnitType;
import greenfoot.Actor;
import greenfoot.Greenfoot;
import greenfoot.GreenfootImage;

import java.awt.*;

/**
 * Actor pro filtrovani jednotek v DeckBuilding World
 * Filter je nastaven podle Unit Type
 *
 * @author xpaseka
 * @version etapa 4
 */

public class CardFilterButton extends Actor {
    private boolean clickable;
    private UnitType unitType;

    CardFilterButton(boolean clickable, UnitType unitType) {
        this.clickable = clickable;
        this.unitType = unitType;
        updateImage();
    }

    public void act() {
        if (Greenfoot.mouseClicked(this)) {
            ((DeckBuildingWorld) getWorld()).setFilter(unitType);
            ((DeckBuildingWorld) getWorld()).updateCards();
            var buttons = getWorld().getObjects(CardFilterButton.class);
            for (var button : buttons) {
                button.setClickable(true);
            }
            setClickable(false);
        }
    }

    public void setClickable(boolean clickable) {
        this.clickable = clickable;
        updateImage();
    }

    public void updateImage() {
        if (unitType != null) {
            if (clickable) {
                setImage(String.format("images/Unit Type Buttons/%s_unclickable.png", unitType.name()));
            } else {
                setImage(String.format("images/Unit Type Buttons/%s_clickable.png", unitType.name()));
            }
        } else {
            if (clickable) {
                setImage("images/Unit Type Buttons/special_cards_unclickable.png");
            } else {
                setImage("images/Unit Type Buttons/special_cards_clickable.png");
            }
        }
    }
}
