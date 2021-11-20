package cz.mendelu.xpaseka.pj.projekt.cards;

import cz.mendelu.xpaseka.pj.projekt.cards.enumTypes.FactionType;
import cz.mendelu.xpaseka.pj.projekt.cards.enumTypes.UnitType;

public class AgileCard extends UnitCard {
    private UnitType secondUnitType;
    public AgileCard(UnitType unitType, int power, String name, FactionType faction, boolean hero, UnitType secondUnitType) {
        super(unitType, power, name, faction, hero);
        this.secondUnitType = secondUnitType;
    }

    public AgileCard(AgileCard card) {
        super(card.getType(), card.getPower(), card.getName(), card.getFaction(), card.isHero());
        this.secondUnitType = card.getSecondUnitType();
    }

    @Override
    public AgileCard cloneObject() {
        return new AgileCard(this);
    }

    public void switchUnitType() {
        var pom = this.type;
        this.type = secondUnitType;
        secondUnitType = pom;
    }

    public UnitType getSecondUnitType() {
        return secondUnitType;
    }

    @Override
    public void applyCard() {
        super.applyCard();
    }
}
