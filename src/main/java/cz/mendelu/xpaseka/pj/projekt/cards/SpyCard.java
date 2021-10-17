package cz.mendelu.xpaseka.pj.projekt.cards;

import cz.mendelu.xpaseka.pj.projekt.Game;

public class SpyCard extends UnitCard {
    public SpyCard(TypeOfCard type, int power, String name) {
        super(type, power, name);
    }

    public void applyCard() {
        System.out.println("spy");
        Game.getOpponent().addCardToCombatBoard(this);
    }
}
