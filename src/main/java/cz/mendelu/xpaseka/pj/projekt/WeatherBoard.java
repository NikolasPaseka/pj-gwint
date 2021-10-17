package cz.mendelu.xpaseka.pj.projekt;

import cz.mendelu.xpaseka.pj.projekt.cards.*;

import java.util.ArrayList;
import java.util.List;
public class WeatherBoard {
    private static List<WeatherCard> weatherCards = new ArrayList<>();

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
     * @version etapa 2
     */
    public static void addWeatherCard(WeatherCard card) {
        weatherCards.add(card);

        if (card.getWeatherType() == WeatherType.RAIN) {
            System.out.println("Applying Rain card");
            applyRainEffect();
        } else if (card.getWeatherType() == WeatherType.SUN) {
            System.out.println("Applying Sun card");
            applySunEffect();
        }
    }

    private static void applyRainEffect() {
        Game.getPlayer().getCombatBoard().changeCardsPower(TypeOfCard.LONG_RANGE, 1);
        Game.getOpponent().getCombatBoard().changeCardsPower(TypeOfCard.LONG_RANGE, 1);
    }

    private static void applySunEffect() {
        weatherCards.clear();
        Game.getPlayer().getCombatBoard().resetCurrentPower();
        Game.getOpponent().getCombatBoard().resetCurrentPower();
    }
}
