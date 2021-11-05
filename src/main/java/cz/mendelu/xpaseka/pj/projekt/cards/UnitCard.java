package cz.mendelu.xpaseka.pj.projekt.cards;

import cz.mendelu.xpaseka.pj.projekt.Game;
import cz.mendelu.xpaseka.pj.projekt.cards.enumTypes.FactionType;
import cz.mendelu.xpaseka.pj.projekt.cards.enumTypes.UnitType;

import java.util.Objects;

public class UnitCard extends Card {
    protected final UnitType type;
    protected final int power;
    protected int currentPower;
    protected int powerMultiplicator;
    protected final FactionType faction;
    protected final boolean hero;

    public UnitCard(UnitType type, int power, String name, FactionType faction, boolean hero) {
        super(name);
        this.type = type;
        this.power = power;
        this.currentPower = power;
        this.powerMultiplicator = 1;
        this.faction = faction;
        this.hero = hero;
    }

    /**
     * @author xpaseka
     * @version etapa 3
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UnitCard unitCard = (UnitCard) o;
        return name.equals(unitCard.name) && power == unitCard.power && type == unitCard.type && faction == unitCard.faction && hero == unitCard.hero;
    }

    /**
     * @author xpaseka
     * @version etapa 3
     */
    @Override
    public int hashCode() {
        return Objects.hash(name, power, type, faction, hero);
    }

    /**
     * @author xpaseka
     * @version etapa 3
     */
    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("UnitCard[");
        sb.append("name='").append(name).append('\'');
        sb.append(", type=").append(type);
        sb.append(", power=").append(power);
        sb.append(", currentPower=").append(currentPower);
        sb.append(", powerMultiplicator=").append(powerMultiplicator);
        sb.append(", faction=").append(faction);
        sb.append(", hero=").append(hero);
        sb.append(']');
        return sb.toString();
    }

    public int getCurrentPower() {
        return currentPower;
    }

    public void setCurrentPower(int power) {
        currentPower = power;
    }

    public void resetCurrentPower() {
        currentPower = power;
    }

    public void setPowerMultiplicator(int multiply) {
        powerMultiplicator *= multiply;
    }

    public int getPowerMultiplicator() {
        return powerMultiplicator;
    }

    public UnitType getType() {
        return type;
    }

    @Override
    public void applyCard() {
        System.out.println(name);
        Game.getPlayer().addCardToCombatBoard(this);
    }
}