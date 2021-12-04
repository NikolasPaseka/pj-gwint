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
    private final PlayerEnum player;
    private boolean grey = false;

    public LifeActor(PlayerEnum player, int lifeCrystal) {
        this.player = player;
        this.lifeCrystal = lifeCrystal;
        setImage("images/Lifes/life_red.png");
    }

    @Override
    public void act() {
        var p = (PlayerEnum.PLAYER == player) ? Game.getGameInstance().getPlayer() : Game.getGameInstance().getOpponent();
        if (!grey && p.getLifes() < lifeCrystal) {
            setImage("images/Lifes/life_grey.png");
            grey = true;
        }
    }
}
