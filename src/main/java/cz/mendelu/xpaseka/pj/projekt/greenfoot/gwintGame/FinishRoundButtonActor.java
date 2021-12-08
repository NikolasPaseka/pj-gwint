package cz.mendelu.xpaseka.pj.projekt.greenfoot.gwintGame;

import cz.mendelu.xpaseka.pj.projekt.Game;
import cz.mendelu.xpaseka.pj.projekt.network.Network;
import greenfoot.Actor;
import greenfoot.Greenfoot;
import greenfoot.GreenfootImage;

import java.awt.*;

public class FinishRoundButtonActor extends Actor {
    private boolean finishedRound = false;

    public FinishRoundButtonActor() {
        setImage(new GreenfootImage("Finish Round", 20, Color.WHITE, Color.BLACK));
    }

    @Override
    public void act() {
        var player = Game.getGameInstance().getPlayer();
        if ((Greenfoot.mouseClicked(this) && !finishedRound && Game.getGameInstance().getPlayerOnMove() == PlayerEnum.PLAYER)
                || (player.getHand().size() <= 0 && !finishedRound)) {
            player.setFinishedRound(true);
            Game.getGameInstance().setPlayerOnMove(PlayerEnum.OPPONENT);
            Network.getClient().sent();
            finishedRound = true;
            System.out.println("You ended round");
        }
    }

    public void resetFinishedRound() {
        finishedRound = false;
    }
}
