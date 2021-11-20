package cz.mendelu.xpaseka.pj.projekt.greenfoot.factionSelection;

import cz.mendelu.xpaseka.pj.projekt.Game;
import cz.mendelu.xpaseka.pj.projekt.factions.Monsters;
import cz.mendelu.xpaseka.pj.projekt.factions.Nilfgaard;
import cz.mendelu.xpaseka.pj.projekt.factions.NorthEmpire;
import cz.mendelu.xpaseka.pj.projekt.factions.Scoiatel;
import cz.mendelu.xpaseka.pj.projekt.greenfoot.deckBuilding.DeckBuildingWorld;
import greenfoot.Greenfoot;
import greenfoot.GreenfootImage;
import greenfoot.World;

import java.awt.*;

public class FactionChoiceWorld extends World {
    private boolean leaderChoice = false;

    public FactionChoiceWorld() {
        super(1600, 900, 1);
        setBackground("images/background.png");

        getBackground().drawImage(new GreenfootImage(" Choose faction: ", 50, Color.WHITE, new Color(0,0,0,0)), 620, 170);

        addObject(new FactionChoiceActor(new NorthEmpire()), 300, 450);
        //addObject(new FactionLabelActor());

        addObject(new FactionChoiceActor(new Nilfgaard()), 600, 450);
        addObject(new FactionChoiceActor(new Scoiatel()), 900, 450);
        //addObject(new FactionChoiceActor(new Monsters()), 1200, 450);
        getBackground().setColor(Color.ORANGE);
        getBackground().setFont(getBackground().getFont().deriveFont(18f));
        getBackground().drawString("Monsters - TODO", 1200, 450);
    }

    @Override
    public void act() {
        if (Game.getPlayer().getFaction() != null && !leaderChoice) {
            renderLeader();
        }
        if (Game.getPlayer().getLeader() != null) {
            Greenfoot.setWorld(new DeckBuildingWorld());
        }
    }

    public void renderLeader() {
        setBackground("images/background.png");
        getBackground().drawImage(new GreenfootImage(" Choose a faction leader: ", 50, Color.WHITE, new Color(0,0,0,0)), 520, 170);

        leaderChoice = true;
        removeObjects(getObjects(FactionChoiceActor.class));
        removeObjects(getObjects(FactionLabelActor.class));
        var leaders = Game.getPlayer().getFaction().getLeaders();
        for (int i = 0; i < leaders.size(); i++) {
            addObject(new LeaderChoiceActor(leaders.get(i), i), 400 + (i*250), 450);
        }
    }
}
