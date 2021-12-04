package cz.mendelu.xpaseka.pj.projekt.greenfoot.factionSelection;

import cz.mendelu.xpaseka.pj.projekt.Game;
import cz.mendelu.xpaseka.pj.projekt.cards.enumTypes.FactionType;
import cz.mendelu.xpaseka.pj.projekt.factions.Faction;
import greenfoot.Actor;
import greenfoot.Greenfoot;
import greenfoot.GreenfootImage;

import java.awt.*;

public class FactionChoiceActor extends Actor {
    private final Faction faction;
    private boolean renderedLabel = false;

    public FactionChoiceActor(Faction faction) {
        this.faction = faction;
        setImage(String.format("images/factionLogos/%s.png", faction.getName()));
    }

    @Override
    public void act() {
        if (Greenfoot.mouseClicked(this)) {
            Game.getGameInstance().getPlayer().setFaction(faction);
        }
        if (!renderedLabel) {
            getWorld().addObject(new FactionLabelActor(faction.getName()), getX(), getY() + 100);
            renderedLabel = true;
        }
    }
}
