package cz.mendelu.xpaseka.pj.projekt.greenfoot;

import cz.mendelu.xpaseka.pj.projekt.Game;
import cz.mendelu.xpaseka.pj.projekt.greenfoot.deckBuilding.DeckBuildingWorld;
import greenfoot.Actor;
import greenfoot.Greenfoot;
import greenfoot.GreenfootImage;

import java.awt.*;

public class LoadBuildButton extends Actor {
    private final String buildName;

    public LoadBuildButton(String buildName) {
        this.buildName = buildName;
        //setImage(new GreenfootImage(buildName, 20, Color.WHITE, null));
        setImage("images/Buttons/button_active.png");
        var text = new GreenfootImage(buildName, 20, Color.WHITE, null);
        getImage().drawImage(text, getImage().getWidth()/2-text.getWidth()/2, getImage().getHeight()/2-text.getHeight()/2);
    }

    @Override
    public void act() {
        if (Greenfoot.mouseClicked(this)) {
            if (Game.getGameInstance().loadBuild(buildName)) {
                Greenfoot.setWorld(new DeckBuildingWorld());
            } else {
                System.out.println("could not load game file");
            }
        }
    }
}
