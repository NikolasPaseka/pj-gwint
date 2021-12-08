package cz.mendelu.xpaseka.pj.projekt.greenfoot.gwintGame;

import cz.mendelu.xpaseka.pj.projekt.factions.Faction;
import cz.mendelu.xpaseka.pj.projekt.factions.Leader;
import greenfoot.Actor;
import greenfoot.Greenfoot;
import greenfoot.GreenfootImage;

import java.awt.*;

public class LeaderActor extends Actor{
    private final Leader factionLeader;
    private final SubMenuActor textBox = new SubMenuActor();

    public LeaderActor(Faction faction, Leader factionLeader) {
        this.factionLeader = factionLeader;
        setImage(String.format("images/Leaders/%s/%s.png", faction.getName(), factionLeader.getName()));
    }

    @Override
    public void act() {
        if (Greenfoot.mouseMoved(this)) {
            getWorld().addObject(textBox, getWorld().getWidth()/2, getWorld().getHeight()/2);
            textBox.showLeadersAbility(factionLeader);
        } else if (Greenfoot.mouseMoved(null)) {
            getWorld().removeObject(textBox);
        }
    }
}
