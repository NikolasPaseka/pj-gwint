package cz.mendelu.xpaseka.pj.projekt.greenfoot;

import cz.mendelu.xpaseka.pj.projekt.Game;
import cz.mendelu.xpaseka.pj.projekt.cards.enumTypes.FactionType;
import cz.mendelu.xpaseka.pj.projekt.factions.Faction;
import greenfoot.Actor;
import greenfoot.Greenfoot;
import greenfoot.GreenfootImage;

import java.awt.*;

public class FactionChoiceActor extends Actor {
    private final Faction faction;

    public FactionChoiceActor(Faction faction) {
        this.faction = faction;
        setImage(String.format("images/factionLogos/%s.png", faction.getName()));
    }

    @Override
    public void act() {
        if (Greenfoot.mouseClicked(this)) {
            Game.getPlayer().setFaction(faction);
        }
    }
}
