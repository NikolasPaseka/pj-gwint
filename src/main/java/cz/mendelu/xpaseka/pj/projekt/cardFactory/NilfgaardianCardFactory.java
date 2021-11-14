package cz.mendelu.xpaseka.pj.projekt.cardFactory;

import cz.mendelu.xpaseka.pj.projekt.cards.*;
import cz.mendelu.xpaseka.pj.projekt.cards.enumTypes.FactionType;
import cz.mendelu.xpaseka.pj.projekt.cards.enumTypes.UnitType;

import java.util.ArrayList;
import java.util.List;

public class NilfgaardianCardFactory implements CardFactory {

    @Override
    public List<Card> createAllCards() {
        List<Card> nilfgaardianCards = new ArrayList<>();
        var faction = FactionType.NILFGAARDIAN_EMPIRE;

        nilfgaardianCards.add(new TightBondCard(UnitType.CLOSE_COMBAT, 3, "Impera Brigade Guard", faction, false));
        nilfgaardianCards.add(new UnitCard(UnitType.LONG_RANGE, 3, "Puttkammer", faction, false));
        nilfgaardianCards.add(new UnitCard(UnitType.SIEGE, 3, "Rotten Mangonel", faction, false));
        nilfgaardianCards.add(new UnitCard(UnitType.CLOSE_COMBAT, 3, "Morteisen", faction, false));
        nilfgaardianCards.add(new SpyCard(UnitType.CLOSE_COMBAT, 9, "Stefan Skellen", faction, false));
        nilfgaardianCards.add(new UnitCard(UnitType.SIEGE, 10, "Heavy Zerrikanian Fire Scorpion", faction, false));
        nilfgaardianCards.add(new UnitCard(UnitType.LONG_RANGE, 10, "Black Infantry Archer", faction, false));
        nilfgaardianCards.add(new UnitCard(UnitType.LONG_RANGE, 10, "Tibor Eggebracht", faction, true));
        nilfgaardianCards.add(new UnitCard(UnitType.CLOSE_COMBAT, 10, "Letho of Gulet", faction, true));
        nilfgaardianCards.add(new TightBondCard(UnitType.CLOSE_COMBAT, 5, "Young Emissary", faction, false));
        nilfgaardianCards.add(new UnitCard(UnitType.SIEGE, 5, "Zerrikanian Fire Scorpion", faction, false));
        nilfgaardianCards.add(new UnitCard(UnitType.LONG_RANGE, 5, "Renuald aep Matsen", faction, false));
        nilfgaardianCards.add(new UnitCard(UnitType.SIEGE, 6, "Siege Engineer", faction, false));
        nilfgaardianCards.add(new UnitCard(UnitType.CLOSE_COMBAT, 6, "Cahir Mawr Dyffryn aep Ceallach", faction, false));
        nilfgaardianCards.add(new UnitCard(UnitType.LONG_RANGE, 6, "Fringilla Vigo", faction, false));
        nilfgaardianCards.add(new UnitCard(UnitType.LONG_RANGE, 6, "Assire var Anahid", faction, false));
        nilfgaardianCards.add(new SpyCard(UnitType.CLOSE_COMBAT, 7, "Shilard Fitz-Oesterlen", faction, false));
        nilfgaardianCards.add(new MedicCard(UnitType.CLOSE_COMBAT, 10, "Menno Coehorn", faction, true));
        nilfgaardianCards.add(new SpyCard(UnitType.CLOSE_COMBAT, 4, "Vattier de Rideaux", faction, false));
        nilfgaardianCards.add(new UnitCard(UnitType.SIEGE, 10, "Morvran Voorhis", faction, true));
        nilfgaardianCards.add(new MedicCard(UnitType.SIEGE, 0, "Siege Technician", faction, false));
        nilfgaardianCards.add(new MedicCard(UnitType.LONG_RANGE, 1, "Etolian Auxiliary Archers", faction, false));
        nilfgaardianCards.add(new TightBondCard(UnitType.CLOSE_COMBAT, 2, "Nausicaa Cavalry Rider", faction, false));
        nilfgaardianCards.add(new UnitCard(UnitType.LONG_RANGE, 2, "Sweers", faction, false));
        nilfgaardianCards.add(new UnitCard(UnitType.LONG_RANGE, 2, "Albrich", faction, false));
        nilfgaardianCards.add(new UnitCard(UnitType.LONG_RANGE, 4, "Vanhemar", faction, false));
        nilfgaardianCards.add(new UnitCard(UnitType.CLOSE_COMBAT, 4, "Rainfarn", faction, false));
        nilfgaardianCards.add(new UnitCard(UnitType.LONG_RANGE, 4, "Cynthia", faction, false));

        return nilfgaardianCards;
    }
}
