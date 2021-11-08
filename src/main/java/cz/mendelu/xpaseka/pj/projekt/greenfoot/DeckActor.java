package cz.mendelu.xpaseka.pj.projekt.greenfoot;

import cz.mendelu.xpaseka.pj.projekt.Player;
import cz.mendelu.xpaseka.pj.projekt.cards.Card;
import greenfoot.Actor;
import greenfoot.GreenfootImage;

import java.util.List;

public class DeckActor extends Actor {
    private final Player player;
    private boolean imageSet = false;

    DeckActor(Player player) {
        this.player = player;
        removeImage();
    }

    @Override
    public void act() {
        if (player.getDeck().size() > 0 && !imageSet) {
            setDeckImage();
        } else if (player.getDeck().size() <= 0) {
            removeImage();
        }
    }

    public void setDeckImage() {
        setImage(String.format("images/cards/HD+/Back side/%s.jpg", player.getFaction().getName()));
        imageSet = true;
    }

    public void removeImage() {
        getImage().clear();
    }
}
