package cz.mendelu.xpaseka.pj.projekt.greenfoot.factionSelection;

import cz.mendelu.xpaseka.pj.projekt.Game;
import cz.mendelu.xpaseka.pj.projekt.factions.Faction;
import greenfoot.Actor;
import greenfoot.Greenfoot;
import greenfoot.GreenfootImage;

import java.awt.*;

public class FactionLabelActor extends Actor {

    public FactionLabelActor(String factionName) {
        setImage(new GreenfootImage(factionName, 20, Color.WHITE, new Color(0,0,0,0)));
    }
}
