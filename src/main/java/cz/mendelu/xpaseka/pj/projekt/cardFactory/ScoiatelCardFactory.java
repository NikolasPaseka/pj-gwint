package cz.mendelu.xpaseka.pj.projekt.cardFactory;

import cz.mendelu.xpaseka.pj.projekt.cards.*;
import cz.mendelu.xpaseka.pj.projekt.cards.enumTypes.FactionType;
import cz.mendelu.xpaseka.pj.projekt.cards.enumTypes.UnitType;

import java.util.ArrayList;
import java.util.List;

public class ScoiatelCardFactory implements CardFactory {

    @Override
    public List<Card> createAllCards() {
        List<Card> scoiatelCards = new ArrayList<>();
        var faction = FactionType.SCOIATEL;

        scoiatelCards.add(new UnitCard(UnitType.LONG_RANGE, 10, "Eithne", faction, true));
        scoiatelCards.add(new UnitCard(UnitType.LONG_RANGE, 10, "Saesenthessis", faction, true));
        scoiatelCards.add(new UnitCard(UnitType.CLOSE_COMBAT, 10, "Isengrim Faolitarna", faction, true)); // TODO morale card
        scoiatelCards.add(new UnitCard(UnitType.LONG_RANGE, 10, "Iorverth", faction, true));
        scoiatelCards.add(new UnitCard(UnitType.LONG_RANGE, 10, "Milva", faction, false)); // TODO morale card
        scoiatelCards.add(new UnitCard(UnitType.CLOSE_COMBAT, 6, "Dennis Cranmer", faction, false));
        scoiatelCards.add(new UnitCard(UnitType.LONG_RANGE, 6, "Ida Emean aep Sivney", faction, false));
        scoiatelCards.add(new AgileCard(UnitType.CLOSE_COMBAT, 6, "Filavandrel aen Fidhail", faction, false, UnitType.LONG_RANGE));
        scoiatelCards.add(new AgileCard(UnitType.CLOSE_COMBAT, 6, "Yaevinn", faction, false, UnitType.LONG_RANGE));
        scoiatelCards.add(new AgileCard(UnitType.CLOSE_COMBAT, 6, "Barclay Els", faction, false, UnitType.LONG_RANGE));
        scoiatelCards.add(new AgileCard(UnitType.CLOSE_COMBAT, 6, "Dol Blathanna Scout", faction, false, UnitType.LONG_RANGE));
        scoiatelCards.add(new MusterCard(UnitType.CLOSE_COMBAT, 5, "Havekar Smuggler", faction, false));
        scoiatelCards.add(new AgileCard(UnitType.CLOSE_COMBAT, 5, "Vrihedd Brigade Veteran", faction, false, UnitType.LONG_RANGE));
        scoiatelCards.add(new UnitCard(UnitType.CLOSE_COMBAT, 5, "Mahakaman Defender", faction, false));
        scoiatelCards.add(new UnitCard(UnitType.LONG_RANGE, 4, "Vrihedd Brigade Recruit", faction, false));
        scoiatelCards.add(new UnitCard(UnitType.LONG_RANGE, 4, "Dol Blathanna Archer", faction, false));
        scoiatelCards.add(new AgileCard(UnitType.LONG_RANGE, 3, "Ciaran aep Easnillien", faction, false, UnitType.CLOSE_COMBAT));
        scoiatelCards.add(new MusterCard(UnitType.CLOSE_COMBAT, 3, "Dwarven Skirmisher", faction, false));
        scoiatelCards.add(new UnitCard(UnitType.LONG_RANGE, 2, "Toruviel", faction, false));
        scoiatelCards.add(new MusterCard(UnitType.LONG_RANGE, 2, "Elven Skirmisher", faction, false));
        scoiatelCards.add(new MedicCard(UnitType.LONG_RANGE, 0, "Havekar Healer", faction, false));

        return scoiatelCards;
    }
}
