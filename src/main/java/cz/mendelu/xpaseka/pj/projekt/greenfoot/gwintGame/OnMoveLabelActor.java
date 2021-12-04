package cz.mendelu.xpaseka.pj.projekt.greenfoot.gwintGame;

import cz.mendelu.xpaseka.pj.projekt.Game;
import cz.mendelu.xpaseka.pj.projekt.Player;
import greenfoot.Actor;
import greenfoot.GreenfootImage;

import java.awt.*;

public class OnMoveLabelActor extends Actor {
    private PlayerEnum onMove;

    public OnMoveLabelActor(PlayerEnum onMove) {
        this.onMove = onMove;
        update();
    }

    @Override
    public void act() {
        if (onMove != Game.getGameInstance().getPlayerOnMove()) {
            onMove = Game.getGameInstance().getPlayerOnMove();
            update();
        }
    }

    public void update() {
        setImage(new GreenfootImage(onMove.name(), 35, Color.WHITE, null));
    }
}
