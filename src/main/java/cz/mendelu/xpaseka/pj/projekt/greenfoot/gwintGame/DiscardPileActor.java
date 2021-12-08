package cz.mendelu.xpaseka.pj.projekt.greenfoot.gwintGame;

import cz.mendelu.xpaseka.pj.projekt.Game;
import cz.mendelu.xpaseka.pj.projekt.Player;
import cz.mendelu.xpaseka.pj.projekt.cards.Card;
import cz.mendelu.xpaseka.pj.projekt.cards.UnitCard;
import greenfoot.Actor;

public class DiscardPileActor extends Actor {

    private final PlayerEnum player;

    private int playerDiscardPileSize = 0;

    DiscardPileActor(PlayerEnum player) {
        this.player = player;
        setTransparentImage();
    }

    @Override
    public void act() {
        var p = (PlayerEnum.PLAYER == player) ? Game.getGameInstance().getPlayer() : Game.getGameInstance().getOpponent();
        if (playerDiscardPileSize != p.getDiscardPile().size()) {
            playerDiscardPileSize = p.getDiscardPile().size();
            updateDiscardPile();
        }
    }

    private void updateDiscardPile() {
        var p = (PlayerEnum.PLAYER == player) ? Game.getGameInstance().getPlayer() : Game.getGameInstance().getOpponent();
        if (p.getDiscardPile().size() > 0) {
            var card = p.getDiscardPile().get(p.getDiscardPile().size() - 1);
            if (card instanceof UnitCard) {
                setImage(String.format("images/cards/HD+/%s/%s.jpg", ((UnitCard) card).getFaction().name(), card.getName()));
            } else {
                setImage(String.format("images/cards/HD+/%s.jpg", card.getName()));
            }
            setPower();
        } else {
            setTransparentImage();
        }
    }

    public void setPower() {
        var p = (PlayerEnum.PLAYER == player) ? Game.getGameInstance().getPlayer() : Game.getGameInstance().getOpponent();
        var card = p.getDiscardPile().get(p.getDiscardPile().size()-1);
        var cardPower = ((UnitCard) card).getCurrentPower();

        String powerString = String.valueOf(cardPower);

        // soumerne vykresleni vetsich i mensich cisel
        if (cardPower < 10) {
            getImage().drawString(powerString, 8, 15);
        } else {
            getImage().drawString(powerString, 4, 15);
        }
    }

    public void setTransparentImage() {
        setImage("images/transparent_image.png");
    }
}
