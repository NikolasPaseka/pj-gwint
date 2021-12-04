package cz.mendelu.xpaseka.pj.projekt;

import cz.mendelu.xpaseka.pj.projekt.cards.*;
import cz.mendelu.xpaseka.pj.projekt.cards.enumTypes.FactionType;
import cz.mendelu.xpaseka.pj.projekt.cards.enumTypes.UnitType;
import cz.mendelu.xpaseka.pj.projekt.cards.enumTypes.WeatherType;
import cz.mendelu.xpaseka.pj.projekt.cards.UnitCard;
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
        Game.getGameInstance().reloadPlayer(new Player("player"));
        Player player = Game.getGameInstance().getPlayer();

        UnitCard yennefer = new UnitCard(UnitType.SIEGE, 8, "Yen", FactionType.NILFGAARDIAN_EMPIRE, false);
        yennefer.applyCard();
        int expectedPower = 1;

        WeatherCard rainCard = new WeatherCard(WeatherType.RAIN);

        // when
        Game.getGameInstance().getWeatherBoard().addWeatherCard(rainCard);

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
        Game.getGameInstance().reloadPlayer(new Player("player"));
        Player player = Game.getGameInstance().getPlayer();

        UnitCard ciri = new UnitCard(UnitType.CLOSE_COMBAT, 9, "Ciri", FactionType.NEUTRAL, true);
        UnitCard cynthia = new UnitCard(UnitType.LONG_RANGE, 7, "Cynthia", FactionType.NORTH_EMPIRE,false);
        UnitCard elemental = new UnitCard(UnitType.SIEGE, 6, "Earth elemental", FactionType.MONSTERS,false);

        ciri.applyCard();
        cynthia.applyCard();
        elemental.applyCard();

        WeatherCard rainCard = new WeatherCard(WeatherType.RAIN);
        WeatherCard sunCard = new WeatherCard(WeatherType.SUN);
        WeatherCard fogCard = new WeatherCard(WeatherType.FOG);

        int expectedPower = 22;

        // when
        Game.getGameInstance().getWeatherBoard().addWeatherCard(rainCard);
        Game.getGameInstance().getWeatherBoard().addWeatherCard(fogCard);
        Game.getGameInstance().getWeatherBoard().addWeatherCard(sunCard);

        // then
        assertEquals(expectedPower, player.getTotalScore());
    }
}