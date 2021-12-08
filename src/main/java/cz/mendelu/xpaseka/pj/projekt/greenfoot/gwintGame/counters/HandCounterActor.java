package cz.mendelu.xpaseka.pj.projekt.greenfoot.gwintGame.counters;

import cz.mendelu.xpaseka.pj.projekt.Game;
import cz.mendelu.xpaseka.pj.projekt.Player;
import cz.mendelu.xpaseka.pj.projekt.greenfoot.gwintGame.PlayerEnum;
import greenfoot.Actor;
import greenfoot.GreenfootImage;

import java.awt.*;

public class HandCounterActor extends Actor {
    private PlayerEnum player;
    private int counter = 0;

    public HandCounterActor(PlayerEnum player) {
        this.player = player;
    }

    @Override
    public void act() {
        Player p;
        p = (PlayerEnum.PLAYER == player) ? Game.getGameInstance().getPlayer() : Game.getGameInstance().getOpponent();
        if (counter != p.getHand().size()) {
            counter = p.getHand().size();
            updateCounter();
        }
    }

    public void updateCounter() {
        setImage(new GreenfootImage(String.valueOf(counter), 25, Color.WHITE, new Color(0, 0, 0, 0)));
    }
}
