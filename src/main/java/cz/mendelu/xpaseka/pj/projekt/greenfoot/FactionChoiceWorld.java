package cz.mendelu.xpaseka.pj.projekt.greenfoot;

import cz.mendelu.xpaseka.pj.projekt.Game;
import cz.mendelu.xpaseka.pj.projekt.cards.enumTypes.FactionType;
import cz.mendelu.xpaseka.pj.projekt.factions.Monsters;
import cz.mendelu.xpaseka.pj.projekt.factions.Nilfgaard;
import cz.mendelu.xpaseka.pj.projekt.factions.NorthEmpire;
import cz.mendelu.xpaseka.pj.projekt.factions.Scoiatel;
import greenfoot.Greenfoot;
import greenfoot.GreenfootImage;
import greenfoot.World;

import java.awt.*;

public class FactionChoiceWorld extends World {

    public FactionChoiceWorld() {
        super(1600, 900, 1);
        setBackground("images/background.jpg");

        getBackground().drawImage(new GreenfootImage(" Choose faction: ", 50, Color.WHITE, new Color(0,0,0,0)), 600, 170);

        addObject(new FactionChoiceActor(new NorthEmpire(Game.getPlayer())), 300, 450);
        addObject(new FactionChoiceActor(new Nilfgaard(Game.getPlayer())), 600, 450);
        addObject(new FactionChoiceActor(new Scoiatel(Game.getPlayer())), 900, 450);
        addObject(new FactionChoiceActor(new Monsters(Game.getPlayer())), 1200, 450);
    }

    @Override
    public void act() {
        if (Game.getPlayer().getFaction() != null) {
            Greenfoot.setWorld(new GwintWorld());
        }
    }
}
