package cz.mendelu.xpaseka.pj.projekt;

import cz.mendelu.xpaseka.pj.projekt.cards.*;

import java.util.ArrayList;
import java.util.List;
public class Board {
    private static List<WeatherCard> weatherCards = new ArrayList<>();

    public static void addWeatherCard(WeatherCard card) {
        weatherCards.add(card);
        applyWeatherEffect(card);
    }

    private static void applyWeatherEffect(WeatherCard card) {
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
