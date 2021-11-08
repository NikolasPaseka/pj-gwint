package cz.mendelu.xpaseka.pj.projekt.greenfoot;

import cz.mendelu.xpaseka.pj.projekt.Player;
import cz.mendelu.xpaseka.pj.projekt.cards.enumTypes.UnitType;
import greenfoot.Actor;
import greenfoot.GreenfootImage;

public class RowScoreActor extends Actor {
    private final Player player;
    private UnitType rowType;

    public RowScoreActor(Player player, UnitType rowType) {
        this.player = player;
        this.rowType = rowType;
        update();
    }

    @Override
    public void act() {
        update();
    }

    public void update() {
//        int score = player.getCombatBoard().ge;
//        setImage(new GreenfootImage(String.valueOf(score), 50, java.awt.Color.WHITE, java.awt.Color.BLACK));
    }
}