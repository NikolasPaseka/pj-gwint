package cz.mendelu.xpaseka.pj.projekt.cards;

import cz.mendelu.xpaseka.pj.projekt.Game;

import java.io.Serializable;

public abstract class Card implements Serializable{
    protected String name;

    public Card(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract Card cloneObject();
    public abstract void applyCard();
}
