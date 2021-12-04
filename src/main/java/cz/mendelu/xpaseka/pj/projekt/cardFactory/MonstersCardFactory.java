package cz.mendelu.xpaseka.pj.projekt.cardFactory;

import cz.mendelu.xpaseka.pj.projekt.cards.*;
import cz.mendelu.xpaseka.pj.projekt.cards.enumTypes.FactionType;
import cz.mendelu.xpaseka.pj.projekt.cards.enumTypes.UnitType;

import java.util.ArrayList;
import java.util.List;

public class MonstersCardFactory implements CardFactory {

    @Override
    public List<Card> createAllCards() {
        FactionType monster = FactionType.MONSTERS;
        List<Card> monstersCards = new ArrayList<>();

        monstersCards.add(new UnitCard(UnitType.SIEGE, 6, "Earth Elemental", monster,false));
        monstersCards.add(new UnitCard(UnitType.SIEGE, 6, "Fire Elemental", monster,false));
        monstersCards.add(new UnitCard(UnitType.CLOSE_COMBAT, 6, "Fiend", monster,false));
        monstersCards.add(new MusterCard(UnitType.SIEGE, 6, "Arachas Behemoth", monster,false));
        monstersCards.add(new MusterCard(UnitType.CLOSE_COMBAT, 6, "Crone", monster,false));
        monstersCards.add(new UnitCard(UnitType.CLOSE_COMBAT, 5, "Forktail", monster,false));
        monstersCards.add(new UnitCard(UnitType.CLOSE_COMBAT, 5, "Plague Maiden", monster,false));
        monstersCards.add(new UnitCard(UnitType.CLOSE_COMBAT, 5, "Griffin", monster,false));
        monstersCards.add(new UnitCard(UnitType.CLOSE_COMBAT, 5, "Werewolf", monster,false));
        monstersCards.add(new UnitCard(UnitType.CLOSE_COMBAT, 5, "Frightener", monster,false));
        monstersCards.add(new UnitCard(UnitType.SIEGE, 5, "Ice Giant", monster,false));
        monstersCards.add(new UnitCard(UnitType.LONG_RANGE, 5, "Grave Hag", monster,false));
        monstersCards.add(new UnitCard(UnitType.CLOSE_COMBAT, 4, "Botchling", monster,false));
        monstersCards.add(new MusterCard(UnitType.CLOSE_COMBAT, 4, "Arachas", monster,false));
        monstersCards.add(new MusterCard(UnitType.CLOSE_COMBAT, 4, "Vampire", monster,false));
        monstersCards.add(new UnitCard(UnitType.LONG_RANGE, 2, "Endrega", monster,false));
        monstersCards.add(new AgileCard(UnitType.CLOSE_COMBAT, 2, "Harpy", monster,false, UnitType.LONG_RANGE));
        monstersCards.add(new UnitCard(UnitType.LONG_RANGE, 2, "Cockatrice", monster,false));
        monstersCards.add(new UnitCard(UnitType.LONG_RANGE, 2, "Gargoyle", monster,false));
        monstersCards.add(new AgileCard(UnitType.CLOSE_COMBAT, 2, "Celaeno Harpy", monster,false, UnitType.LONG_RANGE));
        monstersCards.add(new UnitCard(UnitType.CLOSE_COMBAT, 2, "Foglet", monster,false));
        monstersCards.add(new UnitCard(UnitType.LONG_RANGE, 2, "Wyvern", monster,false));
        monstersCards.add(new MusterCard(UnitType.CLOSE_COMBAT, 2, "Nekker", monster,false));
        monstersCards.add(new MusterCard(UnitType.CLOSE_COMBAT, 1, "Ghoul", monster,false));

        monstersCards.add(new UnitCard(UnitType.CLOSE_COMBAT, 10, "Draug", monster,true));
        monstersCards.add(new UnitCard(UnitType.CLOSE_COMBAT, 10, "Imlerith", monster,true));
        monstersCards.add(new UnitCard(UnitType.LONG_RANGE, 10, "Leshen", monster,true));
        monstersCards.add(new MoraleCard(UnitType.LONG_RANGE, 8, "Kayran", monster,true));
        return monstersCards;
    }
}
