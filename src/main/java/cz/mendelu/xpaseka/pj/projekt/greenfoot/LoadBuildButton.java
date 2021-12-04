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
        getImage().setFont(getImage().getFont().deriveFont(18f));
        getImage().setColor(Color.WHITE);
        getImage().drawString(buildName, 15,32);
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
