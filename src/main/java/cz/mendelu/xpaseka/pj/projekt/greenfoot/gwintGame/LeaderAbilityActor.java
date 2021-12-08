package cz.mendelu.xpaseka.pj.projekt.greenfoot.gwintGame;

import cz.mendelu.xpaseka.pj.projekt.Game;
import greenfoot.Actor;
import greenfoot.Greenfoot;
import greenfoot.GreenfootImage;

import java.awt.*;

public class LeaderAbilityActor extends Actor {
    public LeaderAbilityActor() {
        setImage(new GreenfootImage("Use leader ability", 20, Color.WHITE, Color.BLACK));
    }

    @Override
    public void act() {
        if (Greenfoot.mouseClicked(this) && Game.getGameInstance().getPlayerOnMove() == PlayerEnum.PLAYER) {
            Game.getGameInstance().getPlayer().useLeaderAbility();
            getWorld().removeObjects(getWorld().getObjects(this.getClass()));
        }
    }
}
