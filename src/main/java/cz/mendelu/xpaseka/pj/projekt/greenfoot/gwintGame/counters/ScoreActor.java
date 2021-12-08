package cz.mendelu.xpaseka.pj.projekt.greenfoot.gwintGame.counters;

import cz.mendelu.xpaseka.pj.projekt.Game;
import cz.mendelu.xpaseka.pj.projekt.Player;
import cz.mendelu.xpaseka.pj.projekt.cards.Card;
import cz.mendelu.xpaseka.pj.projekt.cards.UnitCard;
import cz.mendelu.xpaseka.pj.projekt.cards.enumTypes.UnitType;
import cz.mendelu.xpaseka.pj.projekt.greenfoot.gwintGame.PlayerEnum;
import greenfoot.Actor;
import greenfoot.Greenfoot;
import greenfoot.GreenfootImage;

import java.awt.*;

public class ScoreActor extends Actor {
    private final PlayerEnum player;

    public ScoreActor(PlayerEnum player) {
        this.player = player;
        update();
    }

    @Override
    public void act() {
        update();
    }

    public void update() {
        Player p = (PlayerEnum.PLAYER == player) ? Game.getGameInstance().getPlayer() : Game.getGameInstance().getOpponent();
        int score = p.getTotalScore();
        setImage(new GreenfootImage(String.valueOf(score), 35, Color.WHITE, new Color(0, 0, 0, 0)));
    }
}
