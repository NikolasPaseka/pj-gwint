package cz.mendelu.xpaseka.pj.projekt.greenfoot.deckBuilding;

import cz.mendelu.xpaseka.pj.projekt.Game;
import cz.mendelu.xpaseka.pj.projekt.cards.Card;
import cz.mendelu.xpaseka.pj.projekt.cards.UnitCard;
import greenfoot.Actor;
import greenfoot.Greenfoot;

/**
 * Actor pro prepinani vkladani a odebirani karet z decku v DeckBuildingWorld
 *
 * @author xpaseka
 * @version etapa 4
 */

public class CardActor extends Actor {
    private final Card card;
    private boolean inDeck;

    CardActor(Card card, boolean inDeck) {
        this.card = card;
        this.inDeck = inDeck;
        if (card instanceof UnitCard) {
            setImage(String.format("images/cards/HD+/%s/%s.jpg", ((UnitCard) card).getFaction().name(), card.getName()));
        } else {
            setImage(String.format("images/cards/HD+/%s.jpg", card.getName()));
        }
        if (card instanceof UnitCard) {
            setPower();
        }
    }

    @Override
    public void act() {
        if (Greenfoot.mouseClicked(this) && !inDeck) {
            Game.getPlayer().addCardToDeck(card);
            inDeck = true;
        } else if (Greenfoot.mouseClicked(this) && inDeck) {
            Game.getPlayer().removeFromDeck(card);
            inDeck = false;
        }
    }

    public void setPower() {
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
