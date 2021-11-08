package cz.mendelu.xpaseka.pj.projekt.greenfoot;

import cz.mendelu.xpaseka.pj.projekt.Game;
import cz.mendelu.xpaseka.pj.projekt.Player;
import cz.mendelu.xpaseka.pj.projekt.cards.Card;
import cz.mendelu.xpaseka.pj.projekt.cards.UnitCard;
import greenfoot.Actor;

public class DiscardPileActor extends Actor {

    private final Player player;

    private int playerDiscardPileSize = 0;
    private int opponentDiscardPileSize = 0;

    DiscardPileActor(Player player) {
        this.player = player;
//        if (card instanceof UnitCard) {
//            setImage(String.format("images/cards/HD+/%s/%s.jpg", ((UnitCard) card).getFaction().name(), card.getName()));
//        } else {
//            setImage(String.format("images/cards/HD+/%s.jpg", card.getName()));
//        }
    }

    @Override
    public void act() {
        if (playerDiscardPileSize != player.getDiscardPile().size()) {
            playerDiscardPileSize = player.getDiscardPile().size();
            updateDiscardPile();
        }
    }

    private void updateDiscardPile() {
        var card = player.getDiscardPile().get(player.getDiscardPile().size()-1);
        if (card instanceof UnitCard) {
            setImage(String.format("images/cards/HD+/%s/%s.jpg", ((UnitCard) card).getFaction().name(), card.getName()));
        } else {
            setImage(String.format("images/cards/HD+/%s.jpg", card.getName()));
        }
        setPower();
    }

    public void setPower() {
        var card = player.getDiscardPile().get(player.getDiscardPile().size()-1);
        var cardPower = ((UnitCard) card).getCurrentPower();

        String powerString = String.valueOf(cardPower);

        // soumerne vykresleni vetsich i mensich cisel
        if (cardPower < 10) {
            getImage().drawString(powerString, 8, 15);
        } else {
            getImage().drawString(powerString, 4, 15);
        }
    }
}
