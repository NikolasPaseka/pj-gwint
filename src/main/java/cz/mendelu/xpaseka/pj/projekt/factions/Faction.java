package cz.mendelu.xpaseka.pj.projekt.factions;

import cz.mendelu.xpaseka.pj.projekt.Player;
import cz.mendelu.xpaseka.pj.projekt.cards.Card;

import java.util.List;

public abstract class Faction {
    protected String name;
    Player player;

    Faction(Player player) {
        this.player = player;
    }

    public String getName() {
        return name;
    }

    public abstract void applyEffect();
}
