package cz.mendelu.xpaseka.pj.projekt.cards;

import cz.mendelu.xpaseka.pj.projekt.WeatherBoard;

public class WeatherCard extends Card {
    WeatherType weatherType;
    public WeatherCard(String name, WeatherType weatherType) {
        super(name);
        this.weatherType = weatherType;
    }

    public void applyCard() {
        WeatherBoard.addWeatherCard(this);
    }

    public WeatherType getWeatherType() {
        return weatherType;
    }
}
