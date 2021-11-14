package cz.mendelu.xpaseka.pj.projekt.factions;

import cz.mendelu.xpaseka.pj.projekt.Player;

public class Scoiatel extends Faction {

    public Scoiatel() {
        name = "Scoiatel";
    }

    public void applyEffect() {
        System.out.println("Choose who plays first");
    }

    protected void createLeaders() {
        // TODO
    }
}
