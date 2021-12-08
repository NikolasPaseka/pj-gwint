package cz.mendelu.xpaseka.pj.projekt.greenfoot.gwintGame.counters;

import cz.mendelu.xpaseka.pj.projekt.Player;
import cz.mendelu.xpaseka.pj.projekt.cards.enumTypes.UnitType;
import greenfoot.Actor;
import greenfoot.GreenfootImage;

public class RowScoreActor extends Actor {
    private final Player player;
    private UnitType unitType;

    public RowScoreActor(Player player, UnitType unitType) {
        this.player = player;
        this.unitType = unitType;
        update();
    }

    @Override
    public void act() {
        update();
    }

    public void update() {
        int score = player.getCombatBoard().getRowScore(unitType);
        setImage(new GreenfootImage(String.valueOf(score), 50, java.awt.Color.WHITE, java.awt.Color.BLACK));
    }
}