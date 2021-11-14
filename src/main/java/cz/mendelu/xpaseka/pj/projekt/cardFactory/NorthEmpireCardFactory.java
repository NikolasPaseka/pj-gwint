package cz.mendelu.xpaseka.pj.projekt.cardFactory;

import cz.mendelu.xpaseka.pj.projekt.cards.*;
import cz.mendelu.xpaseka.pj.projekt.cards.enumTypes.FactionType;
import cz.mendelu.xpaseka.pj.projekt.cards.enumTypes.UnitType;
import cz.mendelu.xpaseka.pj.projekt.cards.MedicCard;
import cz.mendelu.xpaseka.pj.projekt.cards.SpyCard;
import cz.mendelu.xpaseka.pj.projekt.cards.TightBondCard;
import cz.mendelu.xpaseka.pj.projekt.cards.UnitCard;

import java.util.ArrayList;
import java.util.List;

public class NorthEmpireCardFactory implements CardFactory {
    @Override
    public List<Card> createAllCards() {
        List<Card> northEmpireCards = new ArrayList<>();

        northEmpireCards.add(new UnitCard(UnitType.CLOSE_COMBAT, 10, "Vernon Roche", FactionType.NORTH_EMPIRE,true));
        northEmpireCards.add(new UnitCard(UnitType.CLOSE_COMBAT, 10, "John Natalis", FactionType.NORTH_EMPIRE,true));
        northEmpireCards.add(new UnitCard(UnitType.CLOSE_COMBAT, 10, "Esterad Thyssen", FactionType.NORTH_EMPIRE,true));
        northEmpireCards.add(new UnitCard(UnitType.LONG_RANGE,10, "Philippa Eilhart", FactionType.NORTH_EMPIRE,true));
        northEmpireCards.add(new SpyCard(UnitType.SIEGE,1, "Thaler", FactionType.NORTH_EMPIRE,false));
        northEmpireCards.add(new UnitCard(UnitType.CLOSE_COMBAT,5, "Ves", FactionType.NORTH_EMPIRE,false));
        northEmpireCards.add(new UnitCard(UnitType.CLOSE_COMBAT,5, "Siegfried of Denesle", FactionType.NORTH_EMPIRE,false));
        northEmpireCards.add(new UnitCard(UnitType.CLOSE_COMBAT,2, "Yarpen Zigrin", FactionType.NORTH_EMPIRE,false));
        northEmpireCards.add(new SpyCard(UnitType.CLOSE_COMBAT,4, "Sigismund Djikstra", FactionType.NORTH_EMPIRE,false));
        northEmpireCards.add(new UnitCard(UnitType.LONG_RANGE,5, "Keira Metz", FactionType.NORTH_EMPIRE,false));
        northEmpireCards.add(new UnitCard(UnitType.LONG_RANGE,5, "Sile de Tansarville", FactionType.NORTH_EMPIRE,false));
        northEmpireCards.add(new UnitCard(UnitType.LONG_RANGE,4, "Sabrina Glevissig", FactionType.NORTH_EMPIRE,false));
        northEmpireCards.add(new UnitCard(UnitType.LONG_RANGE,4, "Sheldon Skaggs", FactionType.NORTH_EMPIRE,false));
        northEmpireCards.add(new UnitCard(UnitType.LONG_RANGE,6, "Dethmold", FactionType.NORTH_EMPIRE,false));
        northEmpireCards.add(new SpyCard(UnitType.CLOSE_COMBAT,5, "Prince Stennis", FactionType.NORTH_EMPIRE,false));
        northEmpireCards.add(new UnitCard(UnitType.SIEGE,6, "Trebuchet", FactionType.NORTH_EMPIRE,false));
        northEmpireCards.add(new TightBondCard(UnitType.CLOSE_COMBAT,1, "Poor Fucking Infantry", FactionType.NORTH_EMPIRE,false));
        northEmpireCards.add(new TightBondCard(UnitType.LONG_RANGE,5, "Crinfrid Reavers Dragon Hunter", FactionType.NORTH_EMPIRE,false));
        northEmpireCards.add(new UnitCard(UnitType.CLOSE_COMBAT,1, "Redanian Foot Soldier", FactionType.NORTH_EMPIRE,false));
        northEmpireCards.add(new TightBondCard(UnitType.SIEGE,1, "Catapult", FactionType.NORTH_EMPIRE,false));
        northEmpireCards.add(new UnitCard(UnitType.SIEGE,6, "Ballista", FactionType.NORTH_EMPIRE,false));
        northEmpireCards.add(new UnitCard(UnitType.SIEGE,1, "Kaedweni Siege Expert", FactionType.NORTH_EMPIRE,false)); //TODO morale card
        northEmpireCards.add(new TightBondCard(UnitType.CLOSE_COMBAT,4, "Blue Stripes Commando", FactionType.NORTH_EMPIRE,false));
        northEmpireCards.add(new UnitCard(UnitType.SIEGE,6, "Siege Tower", FactionType.NORTH_EMPIRE,false));
        northEmpireCards.add(new MedicCard(UnitType.SIEGE,5, "Dun Banner Medic", FactionType.NORTH_EMPIRE,false));

        return northEmpireCards;
    }
}
