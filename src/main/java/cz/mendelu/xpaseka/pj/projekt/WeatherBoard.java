package cz.mendelu.xpaseka.pj.projekt;

import cz.mendelu.xpaseka.pj.projekt.cards.*;
import cz.mendelu.xpaseka.pj.projekt.cards.enumTypes.UnitType;
import cz.mendelu.xpaseka.pj.projekt.cards.enumTypes.WeatherType;
import cz.mendelu.xpaseka.pj.projekt.cards.UnitCard;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WeatherBoard implements Serializable {
    private static WeatherBoard weatherBoardInstance = null;

    /**
     * @author xpaseka
     * @version etapa 3
     */
    private Set<WeatherCard> weatherCards = new HashSet<>();

    public Set<WeatherCard> getWeatherCards() {
        return weatherCards;
    }

    public static WeatherBoard getWeatherBoardInstance() {
        if (weatherBoardInstance == null) {
            weatherBoardInstance = new WeatherBoard();
        }
        return weatherBoardInstance;
    }

    /**
     * Prace s kolekci SET
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
     * @version etapa 2
     * @version etapa 3
     */
    public void addWeatherCard(WeatherCard card) {
        if (card.getWeatherType() == WeatherType.SUN) {
            applySunEffect();
        } else {
            weatherCards.add(card);
            reapplyWeatherEffects();
        }
    }

    public void reapplyWeatherEffects() {
        List<WeatherCard> cards = new ArrayList<>(weatherCards);
        for (WeatherCard card : cards) {
            if (card.getWeatherType() == WeatherType.RAIN) {
                applyWeatherEffect(UnitType.SIEGE);
            } else if (card.getWeatherType() == WeatherType.FROST) {
                applyWeatherEffect(UnitType.CLOSE_COMBAT);
            } else if (card.getWeatherType() == WeatherType.FOG) {
                applyWeatherEffect(UnitType.LONG_RANGE);
            }
        }
    }

    private void applyWeatherEffect(UnitType type) {
        List<UnitCard> playerCards = Game.getGameInstance().getPlayer().getCombatBoard().getRow(type);
        List<UnitCard> opponentCards = Game.getGameInstance().getOpponent().getCombatBoard().getRow(type);

        for (UnitCard card : playerCards) {
            if (!card.isHero()) {
                card.setCurrentPower(1);
            }
        }
        for (UnitCard card : opponentCards) {
            if (!card.isHero()) {
                card.setCurrentPower(1);
            }
        }
    }

    private void applySunEffect() {
        weatherCards.clear();

        var playerUnitCards = Game.getGameInstance().getPlayer().getCombatBoard().getAllUnits();
        var opponentUnitCards = Game.getGameInstance().getOpponent().getCombatBoard().getAllUnits();

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
