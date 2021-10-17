package cz.mendelu.xpaseka.pj.projekt.cards;

import cz.mendelu.xpaseka.pj.projekt.Game;

public class HornCard extends Card {
    public HornCard() {
        super("Horn");
    }

    public void applyCard() {
        System.out.println("horn");
        Game.getPlayer().addHorn(this);
    }
}