package cz.mendelu.xpaseka.pj.projekt.greenfoot.gwintGame;

import cz.mendelu.xpaseka.pj.projekt.factions.Faction;
import cz.mendelu.xpaseka.pj.projekt.factions.Leader;
import greenfoot.Actor;
import greenfoot.Greenfoot;
import greenfoot.GreenfootImage;

import java.awt.*;

public class SubMenuActor extends Actor {
    public SubMenuActor() {
    }

    @Override
    public void act() {

    }

    public void showEndRound(PlayerEnum player) {
        setImage("images/sub-menu.png");
        GreenfootImage img;
        if (player == PlayerEnum.PLAYER) {
            img = new GreenfootImage("You won this round!", 50, Color.WHITE, null);
        } else if (player == PlayerEnum.OPPONENT) {
            img = new GreenfootImage("You lost this round!", 50, Color.WHITE, null);
        } else {
            img = new GreenfootImage("It's a tie!", 50, Color.WHITE, null);
        }
        getImage().drawImage(img, getImage().getWidth()/2-img.getWidth()/2, getImage().getHeight()/2-50);
        Greenfoot.delay(300);
        getWorld().removeObjects(getWorld().getObjects(SubMenuActor.class));
    }

    public void showLeadersAbility(Leader factionLeader) {
        setImage(new GreenfootImage("images/sub-menu2.png"));
        GreenfootImage img = new GreenfootImage("Leader's ability:\n" + factionLeader.getAbilityDescription(), 30, Color.WHITE, null);
        getImage().drawImage(img, getImage().getWidth()/2-img.getWidth()/2, getImage().getHeight()/2-50);
    }
}
