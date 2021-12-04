package cz.mendelu.xpaseka.pj.projekt.greenfoot.factionSelection;

import cz.mendelu.xpaseka.pj.projekt.Game;
import cz.mendelu.xpaseka.pj.projekt.factions.Leader;
import greenfoot.Actor;
import greenfoot.Greenfoot;
import greenfoot.GreenfootImage;

import java.awt.*;

/**
 * Actor pro zobrazeni textu specialni ability leader
 * Metoda act kontroluje hover efekt
 * Text se zobrazi je v pripade, ze se na daneho leadera nejede mysi
 *
 * @author xpaseka
 * @version etapa 4
 */

public class LeaderChoiceActor extends Actor {
    private Leader leader;
    private int index;
    private Actor textBox;
    public LeaderChoiceActor(Leader leader, int index) {
        this.leader = leader;
        this.index = index;
        setImage(String.format("images/Leaders/%s/%s.png", Game.getGameInstance().getPlayer().getFaction().getName(), leader.getName()));
        createTextBox();
    }

    @Override
    public void act() {
        if (Greenfoot.mouseClicked(this)) {
            Game.getGameInstance().getPlayer().setLeader(index);
        }
        if (Greenfoot.mouseMoved(this)) {
            getWorld().addObject(textBox, 800, 800);
        }
        else if (Greenfoot.mouseMoved(null)) {
            getWorld().removeObject(textBox);
        }
    }

    public void createTextBox() {
        textBox = new Actor() {
            {
                setImage(new GreenfootImage("Leader's ability: " + leader.getAbilityDescription(), 30, Color.WHITE, new Color(0,0,0,0)));
            }
        };
    }
}
