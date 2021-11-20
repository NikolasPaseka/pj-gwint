package cz.mendelu.xpaseka.pj.projekt;

import cz.mendelu.xpaseka.pj.projekt.cards.HornCard;
import cz.mendelu.xpaseka.pj.projekt.cards.WeatherCard;
import cz.mendelu.xpaseka.pj.projekt.cards.enumTypes.UnitType;
import cz.mendelu.xpaseka.pj.projekt.cards.UnitCard;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CombatBoard implements Serializable {
    /**
     * @author xpaseka
     * @version etapa 3
     */
    private Map<UnitType, List<UnitCard>> unitCards = new HashMap<>();
    private Map<UnitType, HornCard> hornCards = new HashMap<>();

    CombatBoard() {
        unitCards.put(UnitType.CLOSE_COMBAT, new ArrayList<>());
        unitCards.put(UnitType.LONG_RANGE, new ArrayList<>());
        unitCards.put(UnitType.SIEGE, new ArrayList<>());
        hornCards.put(UnitType.CLOSE_COMBAT, null);
        hornCards.put(UnitType.LONG_RANGE, null);
        hornCards.put(UnitType.SIEGE, null);
    }

    /**
     * Metoda prida kartu do prislusneho pole CombatBoard
     * Atribut karty type urcuje klic mapy
     *
     * @param card - predana karta pro vlozeni na CombatBoard
     *
     * @author xpaseka
     * @version etapa 3
     */
    public void addCard(UnitCard card) {
        List<UnitCard> cards = unitCards.get(card.getType());
        cards.add(card);
        unitCards.put(card.getType(), cards);
        WeatherBoard.reapplyWeatherEffects();
        applyHorn();
        System.out.println("" +UnitType.CLOSE_COMBAT + " " + unitCards.get(UnitType.CLOSE_COMBAT).size());
        for (UnitCard test: unitCards.get(UnitType.CLOSE_COMBAT)) {
            System.out.println(test.getName() + " " + test.getType());
        }
        System.out.println();
        System.out.println("" +UnitType.LONG_RANGE + " " + unitCards.get(UnitType.LONG_RANGE).size());
        for (UnitCard test: unitCards.get(UnitType.LONG_RANGE)) {
            System.out.println(test.getName() + " " + test.getType());
        }
        System.out.println();
        System.out.println("" +UnitType.SIEGE  + " " +  unitCards.get(UnitType.SIEGE).size());
        for (UnitCard test: unitCards.get(UnitType.SIEGE)) {
            System.out.println(test.getName() + " " + test.getType());
        }
        System.out.println();
    }

    public void addHornCard(UnitType unitType, HornCard horn) {
        hornCards.putIfAbsent(unitType, horn);
        applyHorn();
    }

    private void applyHorn() {
        for (var unitType : hornCards.keySet()) {
            var hornCard = hornCards.get(unitType);
            if (hornCard != null) {
                var cards = unitCards.get(unitType);
                for (UnitCard card : cards) {
                    if (!card.isHero()) {
                        card.setPowerMultiplicator(2);
                    }
                }
            }
        }
    }

    /**
     *
     * @param type - typ jednotek ktere chci ziskat
     * @return List pozadovanych jednotek
     *
     * @author xpaseka
     * @version etapa 3
     */
    public List<UnitCard> getRow(UnitType type) {
        return unitCards.get(type);
    }

    public Map<UnitType, List<UnitCard>> getAllUnits() {
        return unitCards;
    }

    /**
     * Metoda projizdi vsechny karty vylozene mapy - jednotlive klice a seznam karet
     * Skore se pocita z aktualni sily karty krat multiplikator z efektu karet
     *
     * @return celkove skore, ktere hrac dosahuje
     *
     * @author xpaseka
     * @version etapa 3
     */
    public int getTotalScore() {
        int score = 0;
        for (List<UnitCard> cards : unitCards.values()) {
            for (UnitCard card : cards) {
                score += card.getCurrentPower() * card.getPowerMultiplicator();
            }
        }
        return score;
    }

    public int getRowScore(UnitType unitType) {
        int score = 0;
        for (UnitCard card : unitCards.get(unitType)) {
            score += card.getCurrentPower() * card.getPowerMultiplicator();
        }
        return score;
    }
}
