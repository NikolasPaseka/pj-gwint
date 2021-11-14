package cz.mendelu.xpaseka.pj.projekt.greenfoot.gwintGame;

import cz.mendelu.xpaseka.pj.projekt.Game;
import cz.mendelu.xpaseka.pj.projekt.Player;
import cz.mendelu.xpaseka.pj.projekt.cards.Card;
import cz.mendelu.xpaseka.pj.projekt.cards.UnitCard;
import cz.mendelu.xpaseka.pj.projekt.cards.enumTypes.UnitType;
import greenfoot.Actor;
import greenfoot.Greenfoot;

import java.awt.*;

/**
 * Actor pro zobrazeni karet na bojisti
 * S karty uzivatel nemuze sam o sobe interagovat
 * Pouze se vykresluje jejich celkova sila a zobrazuje se barva podle vzrustu ci poklesu sily
 *
 * @author xpaseka
 * @version etapa 4
 */

public class BoardCardActor extends Actor {

    private final Card card;

    private int cardPower;
    private int index;

    public BoardCardActor(Card card, int index) {
        this.card = card;

        this.cardPower = -1;
        this.index = index;
        setImage(String.format("images/cards/HD+/%s/%s.jpg", ((UnitCard) card).getFaction().name(), card.getName()));
    }

    @Override
    public void act() {
        if (card instanceof UnitCard && cardPower != ((UnitCard) card).getTotalPower()) {
            updatePower();
        }
    }

    public void updatePower() {
        //removes draw string
        setImage(String.format("images/cards/HD+/%s/%s.jpg", ((UnitCard) card).getFaction().name(), card.getName()));

        cardPower = ((UnitCard) card).getTotalPower();
        String powerString = String.valueOf(cardPower);
        if (cardPower < ((UnitCard) card).getPower()) {
            getImage().setColor(new Color(222, 24, 24));
        } else if (cardPower > ((UnitCard) card).getPower()) {
            getImage().setColor(new Color(9, 189, 30));
        } else {
            getImage().setColor(Color.BLACK);
        }
        // soumerne vykresleni vetsich i mensich cisel
        if (cardPower < 10) {
            getImage().drawString(powerString, 8, 15);
        } else {
            getImage().drawString(powerString, 4, 15);
        }
    }
}
