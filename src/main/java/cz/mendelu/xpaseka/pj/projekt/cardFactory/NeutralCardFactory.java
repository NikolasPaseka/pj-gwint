package cz.mendelu.xpaseka.pj.projekt.cardFactory;

import cz.mendelu.xpaseka.pj.projekt.cards.*;
import cz.mendelu.xpaseka.pj.projekt.cards.enumTypes.FactionType;
import cz.mendelu.xpaseka.pj.projekt.cards.enumTypes.UnitType;
import cz.mendelu.xpaseka.pj.projekt.cards.MedicCard;
import cz.mendelu.xpaseka.pj.projekt.cards.ScorchCard;
import cz.mendelu.xpaseka.pj.projekt.cards.SpyCard;
import cz.mendelu.xpaseka.pj.projekt.cards.UnitCard;

import java.util.ArrayList;
import java.util.List;

public class NeutralCardFactory implements CardFactory {

    @Override
    public List<Card> createAllCards() {
        List<Card> neutralCards = new ArrayList<>();

        neutralCards.add(new UnitCard(UnitType.CLOSE_COMBAT, 15, "Geralt of Rivia", FactionType.NEUTRAL,true));
        neutralCards.add(new UnitCard(UnitType.CLOSE_COMBAT, 15, "Cirilla Fiona Elen Riannon", FactionType.NEUTRAL,true));
        neutralCards.add(new UnitCard(UnitType.CLOSE_COMBAT, 6, "Vesemir", FactionType.NEUTRAL,false));
        neutralCards.add(new MedicCard(UnitType.LONG_RANGE, 7, "Yennefer of Vengerberg", FactionType.NEUTRAL,true));
        neutralCards.add(new UnitCard(UnitType.CLOSE_COMBAT, 7, "Triss Merigold", FactionType.NEUTRAL,true));
        neutralCards.add(new UnitCard(UnitType.CLOSE_COMBAT, 2, "Dandelion", FactionType.NEUTRAL,false)); //TODO morale card
        neutralCards.add(new UnitCard(UnitType.CLOSE_COMBAT, 5, "Zoltan Chivay", FactionType.NEUTRAL,false));
        neutralCards.add(new UnitCard(UnitType.CLOSE_COMBAT, 5, "Emiel Regis Rohellec Terzieff", FactionType.NEUTRAL,false));
        neutralCards.add(new ScorchCard(UnitType.CLOSE_COMBAT, 7, "Villentretenmerth", FactionType.NEUTRAL,false));
        neutralCards.add(new SpyCard(UnitType.CLOSE_COMBAT, 0, "Avallach", FactionType.NEUTRAL,true));

        return neutralCards;
    }
}
