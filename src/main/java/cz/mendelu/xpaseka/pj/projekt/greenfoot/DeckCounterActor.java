package cz.mendelu.xpaseka.pj.projekt.greenfoot;

import cz.mendelu.xpaseka.pj.projekt.Player;
import greenfoot.Actor;
import greenfoot.GreenfootImage;

import java.awt.*;

public class DeckCounterActor extends Actor {
    private final Player player;
    private int counter = 0;

    DeckCounterActor(Player player) {
        this.player = player;
    }

    @Override
    public void act() {
        if (counter != player.getDeck().size()) {
            counter = player.getDeck().size();
            updateCounter();
        }
    }

    public void updateCounter() {
        setImage(new GreenfootImage(String.valueOf(counter), 30, Color.WHITE, new Color(0, 0, 0, 0)));
    }
}
