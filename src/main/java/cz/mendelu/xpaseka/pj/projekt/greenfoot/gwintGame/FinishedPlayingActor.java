package cz.mendelu.xpaseka.pj.projekt.greenfoot.gwintGame;

import cz.mendelu.xpaseka.pj.projekt.Game;
import greenfoot.Actor;

public class FinishedPlayingActor extends Actor {
    private boolean finishedRound;
    private PlayerEnum player;

    public FinishedPlayingActor(PlayerEnum player) {
        this.player = player;
    }

    @Override
    public void act() {
        var p = (player == PlayerEnum.PLAYER) ? Game.getGameInstance().getPlayer() : Game.getGameInstance().getOpponent();
        if (p.getFinishedRound() != finishedRound) {
            finishedRound = p.getFinishedRound();
        }
        render();
    }

    private void render() {
        if (finishedRound) {
            setImage("images/white-flag.png");
        } else {
            setImage("images/transparent_image.png");
        }
    }
}
