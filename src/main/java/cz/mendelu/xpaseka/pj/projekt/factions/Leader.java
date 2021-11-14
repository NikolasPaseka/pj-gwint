package cz.mendelu.xpaseka.pj.projekt.factions;

import java.io.Serializable;

public abstract class Leader implements Serializable {
    protected String name;
    protected String abilityDescription;

    public Leader() {
        setAttributes();
    }

    public String getName() {
        return name;
    }

    public String getAbilityDescription() {
        return abilityDescription;
    }

    public abstract void applyAbility();
    protected abstract void setAttributes();
}
