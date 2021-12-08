package cz.mendelu.xpaseka.pj.projekt;

import cz.mendelu.xpaseka.pj.projekt.cards.*;
import cz.mendelu.xpaseka.pj.projekt.cards.enumTypes.UnitType;
import cz.mendelu.xpaseka.pj.projekt.factions.Monsters;

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

        // update of weather cards effects
        Game.getGameInstance().getWeatherBoard().reapplyWeatherEffects();

        applyHorn();
        applyMoraleEffect(card);
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
                        if (card instanceof TightBondCard) {
                            card.setPowerMultiplicator(((TightBondCard) card).getNumberOfBondCards()*2);
                        } else {
                            card.setPowerMultiplicator(2);
                        }
                    }
                }
            }
        }
    }

    private void applyMoraleEffect(UnitCard card) {
        int numberOfMoraleCards = 0;
        for (var c: unitCards.get(card.getType())) {
            if (c instanceof MoraleCard) numberOfMoraleCards++;
        }
        if ((card instanceof MoraleCard)) card.setCurrentPower(card.getCurrentPower() + numberOfMoraleCards);
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

    public Map<UnitType, HornCard> getHornCards() {
        return hornCards;
    }

    public void clear() {
        unitCards.clear();
        hornCards.clear();
        unitCards.put(UnitType.CLOSE_COMBAT, new ArrayList<>());
        unitCards.put(UnitType.LONG_RANGE, new ArrayList<>());
        unitCards.put(UnitType.SIEGE, new ArrayList<>());
        hornCards.put(UnitType.CLOSE_COMBAT, null);
        hornCards.put(UnitType.LONG_RANGE, null);
        hornCards.put(UnitType.SIEGE, null);
    }
}
