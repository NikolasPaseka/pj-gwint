package cz.mendelu.xpaseka.pj.projekt.factions;

import cz.mendelu.xpaseka.pj.projekt.Player;

public class Scoiatel extends Faction {

    public Scoiatel(Player player) {
        super(player);
        name = "Scoiatel";
    }

    public void applyEffect() {
        System.out.println("Choose who plays first");
    }

    public void applyAbility() {
        System.out.println("Takes card from deck");
        player.takeCardFromDeck();
    }
}
