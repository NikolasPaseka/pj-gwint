package cz.mendelu.xpaseka.pj.projekt.factions;

import cz.mendelu.xpaseka.pj.projekt.Player;
import cz.mendelu.xpaseka.pj.projekt.cards.Card;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public abstract class Faction implements Serializable {
    protected String name;
    protected List<Leader> leaders = new ArrayList<>();

    public String getName() {
        return name;
    }

    public List<Leader> getLeaders() {
        return leaders;
    }

    public Leader getLeader(int index) {
        return leaders.get(index);
    }

    public abstract void applyEffect();
    protected abstract void createLeaders();
}
