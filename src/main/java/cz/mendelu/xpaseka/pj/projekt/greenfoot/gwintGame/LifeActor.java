package cz.mendelu.xpaseka.pj.projekt.greenfoot.gwintGame;

import cz.mendelu.xpaseka.pj.projekt.Game;
import cz.mendelu.xpaseka.pj.projekt.Player;
import greenfoot.Actor;

/**
 * Actor pro zobrazeni zivotu
 * Pokud bude mensi pocet zivotu hrace jak poradi Krystalu, tak krystal zesedne
 *
 * @author xpaseka
 * @version etapa 4
 */

public class LifeActor extends Actor {
    private final int lifeCrystal;
    private final Player player;
    private boolean grey = false;

    public LifeActor(Player player, int lifeCrystal) {
        this.player = player;
        this.lifeCrystal = lifeCrystal;
        setImage("images/Lifes/life_red.png");
    }

    @Override
    public void act() {
        if (!grey && player.getLifes() < lifeCrystal) {
            setImage("images/Lifes/life_grey.png");
            grey = true;
        }
    }
}
