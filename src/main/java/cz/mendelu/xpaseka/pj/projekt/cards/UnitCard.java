package cz.mendelu.xpaseka.pj.projekt.cards;

import cz.mendelu.xpaseka.pj.projekt.Game;

public class UnitCard extends Card {
    protected TypeOfCard type;
    protected int power;
    protected int currentPower;

    public UnitCard(TypeOfCard type, int power, String name) {
        super(name);
        this.type = type;
        this.power = power;
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

    public TypeOfCard getType() {
        return type;
    }

    public void applyCard() {
        System.out.println("Unit");
        Game.getPlayer().addCardToCombatBoard(this);
    }
}