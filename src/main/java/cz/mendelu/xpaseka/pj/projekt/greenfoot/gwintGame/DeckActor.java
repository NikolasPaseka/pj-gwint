package cz.mendelu.xpaseka.pj.projekt.greenfoot.gwintGame;

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
    private final Player player;
    private boolean imageSet = false;

    DeckActor(Player player) {
        this.player = player;
        setTransparentImage();
    }

    @Override
    public void act() {
        if (player.getDeck().size() > 0 && !imageSet) {
            setDeckImage();
        } else if (player.getDeck().size() <= 0 && imageSet) {
            setTransparentImage();
        }
    }

    public void setDeckImage() {
        setImage(String.format("images/cards/HD+/Back side/%s.jpg", player.getFaction().getName()));
        imageSet = true;
    }

    public void setTransparentImage() {
        setImage("images/transparent_image.png");
        imageSet = false;
    }
}
