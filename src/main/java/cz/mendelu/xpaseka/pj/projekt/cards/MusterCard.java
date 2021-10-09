package cz.mendelu.xpaseka.pj.projekt.cards;

import cz.mendelu.xpaseka.pj.projekt.Board;
import cz.mendelu.xpaseka.pj.projekt.Game;
import cz.mendelu.xpaseka.pj.projekt.Player;

import java.util.ArrayList;
import java.util.List;

public class MusterCard extends UnitCard {
    public MusterCard(TypeOfCard type, int power, String name) {
        super(type, power, name);
    }

    public void applyCard() {
        System.out.println("Playing Muster card");
        Game.getPlayer().addCardToCombatBoard(this);
        List<Card> playersDeck = Game.getPlayer().getDeck();
        int i = 0;
        for (Card card: playersDeck) {
            if (card.getName().equals(name) && card instanceof UnitCard) {
                i++;
                Game.getPlayer().addCardToCombatBoard((UnitCard) card);
            }
        }
        System.out.println("Found " + i + " " + name + " cards");
    }
}