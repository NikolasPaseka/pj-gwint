package cz.mendelu.xpaseka.pj.projekt.greenfoot;

import cz.mendelu.xpaseka.pj.projekt.Game;
import cz.mendelu.xpaseka.pj.projekt.Player;
import cz.mendelu.xpaseka.pj.projekt.cards.Card;
import cz.mendelu.xpaseka.pj.projekt.cards.UnitCard;
import cz.mendelu.xpaseka.pj.projekt.cards.enumTypes.UnitType;
import greenfoot.Actor;
import greenfoot.Greenfoot;
import greenfoot.GreenfootImage;

import java.awt.*;

public class ScoreActor extends Actor {
    private final Player player;

    public ScoreActor(Player player) {
        this.player = player;
        update();
    }

    @Override
    public void act() {
        update();
    }

    public void update() {
        int score = player.getTotalScore();
        setImage(new GreenfootImage(String.valueOf(score), 50, Color.WHITE, new Color(0, 0, 0, 0)));
    }
}
