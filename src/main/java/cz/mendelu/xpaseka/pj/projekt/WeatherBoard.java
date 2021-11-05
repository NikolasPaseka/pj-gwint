package cz.mendelu.xpaseka.pj.projekt;

import cz.mendelu.xpaseka.pj.projekt.cards.*;
import cz.mendelu.xpaseka.pj.projekt.cards.enumTypes.UnitType;
import cz.mendelu.xpaseka.pj.projekt.cards.enumTypes.WeatherType;
import cz.mendelu.xpaseka.pj.projekt.cards.UnitCard;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WeatherBoard {
    /**
     * @author xpaseka
     * @version etapa 3
     */
    private static Set<WeatherCard> weatherCards = new HashSet<>();

    /**
     * Metoda pro pridani Karty pocasi na hraci desku
     * Metoda na zaklade typu pocasi zavola prislusnou private metodu
     * Karta Rain - vsem kartam typu Long Range nastavi silu karty na 1
     * Karta Frost - vsem kartam typu Close Combat nastavi silu karty na 1
     * Karta Fog - vsem kartam typu Siege nastavi silu karty na 1
     * Karta Sun - odebere vsechny karty pocasi z hraci desky
     *
     * @param card karta pocasi predana od hrace
     *
     * @author xpaseka
     * @version etapa 3
     */
    public static void addWeatherCard(WeatherCard card) {
        if (!weatherCards.contains(card)) {
            weatherCards.add(card);
            if (card.getWeatherType() == WeatherType.RAIN) {
                applyRainEffect();
            } else if (card.getWeatherType() == WeatherType.FROST) {
                applyFrostEffect();
            } else if (card.getWeatherType() == WeatherType.FOG) {
                applyFogEffect();
            } else if (card.getWeatherType() == WeatherType.SUN) {
                applySunEffect();
            }
        }
    }

    private static void applyRainEffect() {
        List<UnitCard> playerLongRange = Game.getPlayer().getCombatBoard().getRow(UnitType.LONG_RANGE);
        List<UnitCard> opponentLongRange = Game.getPlayer().getCombatBoard().getRow(UnitType.LONG_RANGE);
        for (UnitCard card : playerLongRange) {
            card.setCurrentPower(1);
        }
        for (UnitCard card : opponentLongRange) {
            card.setCurrentPower(1);
        }
    }

    private static void applyFrostEffect() {
        List<UnitCard> playerCloseCombat= Game.getPlayer().getCombatBoard().getRow(UnitType.CLOSE_COMBAT);
        List<UnitCard> opponentCloseCombat = Game.getPlayer().getCombatBoard().getRow(UnitType.CLOSE_COMBAT);
        for (UnitCard card : playerCloseCombat) {
            card.setCurrentPower(1);
        }
        for (UnitCard card : opponentCloseCombat) {
            card.setCurrentPower(1);
        }
    }

    private static void applyFogEffect() {
        List<UnitCard> playerSiege= Game.getPlayer().getCombatBoard().getRow(UnitType.SIEGE);
        List<UnitCard> opponentSiege = Game.getPlayer().getCombatBoard().getRow(UnitType.SIEGE);
        for (UnitCard card : playerSiege) {
            card.setCurrentPower(1);
        }
        for (UnitCard card : opponentSiege) {
            card.setCurrentPower(1);
        }
    }

    private static void applySunEffect() {
        weatherCards.clear();

        var playerUnitCards = Game.getPlayer().getCombatBoard().getAllUnits();
        var opponentUnitCards = Game.getOpponent().getCombatBoard().getAllUnits();

        for (List<UnitCard> cards: playerUnitCards.values()) {
            for (UnitCard card : cards) {
                card.resetCurrentPower();
            }
        }
        for (List<UnitCard> cards : opponentUnitCards.values()) {
            for (UnitCard card : cards) {
                card.resetCurrentPower();
            }
        }
    }
}
