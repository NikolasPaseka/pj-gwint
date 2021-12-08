package cz.mendelu.xpaseka.pj.projekt.greenfoot.gwintGame;

import cz.mendelu.xpaseka.pj.projekt.Game;
import cz.mendelu.xpaseka.pj.projekt.Player;
import cz.mendelu.xpaseka.pj.projekt.cards.Card;
import greenfoot.Actor;
import greenfoot.GreenfootImage;

import java.util.List;

/**
 * Actor pro zobrazeni odkladaciho balicku
 * Pokud hrac uz nema zadne karty, nastavi se transparentni obrazek
 *
 * @author xpaseka
 * @version etapa 4
 */

public class DeckActor extends Actor {
    private final PlayerEnum player;
    private boolean imageSet = false;

    DeckActor(PlayerEnum player) {
        this.player = player;
        setTransparentImage();
    }

    @Override
    public void act() {
        var p = (player == PlayerEnum.PLAYER) ? Game.getGameInstance().getPlayer() : Game.getGameInstance().getOpponent();
        if (p.getDeck().size() > 0 && !imageSet) {
            setDeckImage();
        } else if (p.getDeck().size() <= 0 && imageSet) {
            setTransparentImage();
        }
    }

    public void setDeckImage() {
        var p = (player == PlayerEnum.PLAYER) ? Game.getGameInstance().getPlayer() : Game.getGameInstance().getOpponent();
        setImage(String.format("images/cards/HD+/Back side/%s.jpg", p.getFaction().getName()));
        imageSet = true;
    }

    public void setTransparentImage() {
        setImage("images/transparent_image.png");
        imageSet = false;
    }
}
