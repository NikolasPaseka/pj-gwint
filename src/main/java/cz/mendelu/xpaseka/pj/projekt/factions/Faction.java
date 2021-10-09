package cz.mendelu.xpaseka.pj.projekt.factions;

import cz.mendelu.xpaseka.pj.projekt.Player;

public abstract class Faction {
    protected String name;
    Player player;

    Faction(Player player) {
        this.player = player;
    }

    public abstract void applyEffect();
    public abstract void applyAbility();
}
