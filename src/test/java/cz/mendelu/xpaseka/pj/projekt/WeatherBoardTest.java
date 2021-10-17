package cz.mendelu.xpaseka.pj.projekt;

import cz.mendelu.xpaseka.pj.projekt.cards.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WeatherBoardTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    /**
     * @author xpaseka
     * @version etapa 2
     */
    @Test
    void addWeatherCard_Rain() {
        // setup
        Player player = Game.getPlayer();

        UnitCard yennefer = new UnitCard(TypeOfCard.LONG_RANGE, 8, "Yen");
        yennefer.applyCard();
        int expectedPower = 1;

        WeatherCard rainCard = new WeatherCard("Torrential Rain", WeatherType.RAIN);

        // when
        WeatherBoard.addWeatherCard(rainCard);

        // then
        assertEquals(expectedPower, player.getTotalScore());
    }

    /**
     * @author xpaseka
     * @version etapa 2
     */
    @Test
    void addWeatherCard_Sun() {
        // setup
        Player player = Game.getPlayer();

        UnitCard ciri = new UnitCard(TypeOfCard.CLOSE_COMBAT, 9, "Ciri");
        UnitCard cynthia = new UnitCard(TypeOfCard.LONG_RANGE, 7, "cynthia");
        UnitCard elemental = new UnitCard(TypeOfCard.SIEGE, 6, "Earth elemental");

        ciri.applyCard();
        cynthia.applyCard();
        elemental.applyCard();

        WeatherCard rainCard = new WeatherCard("Rain", WeatherType.RAIN);
        WeatherCard sunCard = new WeatherCard("Clear Weather", WeatherType.SUN);
        WeatherCard fogCard = new WeatherCard("Impenetrable Fog", WeatherType.FOG);

        int expectedPower = 22;

        // when
        WeatherBoard.addWeatherCard(rainCard);
        WeatherBoard.addWeatherCard(fogCard);
        WeatherBoard.addWeatherCard(sunCard);

        // then
        assertEquals(expectedPower, player.getTotalScore());
    }
}