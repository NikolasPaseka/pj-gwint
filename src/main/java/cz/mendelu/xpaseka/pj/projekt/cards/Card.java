package cz.mendelu.xpaseka.pj.projekt.cards;

import cz.mendelu.xpaseka.pj.projekt.Game;

public abstract class Card {
    protected String name;

    public Card(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract void applyCard();
}
