package cz.mendelu.xpaseka.pj.projekt.cards;

import cz.mendelu.xpaseka.pj.projekt.WeatherBoard;
import cz.mendelu.xpaseka.pj.projekt.cards.enumTypes.WeatherType;

import java.util.Objects;

public class WeatherCard extends Card {
    WeatherType weatherType;

    public WeatherCard(WeatherType weatherType) {
        super(weatherType.name());
        this.weatherType = weatherType;
        this.name = weatherType.getName();
    }

    public WeatherCard(WeatherCard card) {
        this(card.getWeatherType());
    }

    @Override
    public WeatherCard cloneObject() {
        return new WeatherCard(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WeatherCard that = (WeatherCard) o;
        return weatherType == that.weatherType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(weatherType);
    }

    @Override
    public void applyCard() {
        WeatherBoard.addWeatherCard(this);
    }

    public WeatherType getWeatherType() {
        return weatherType;
    }
}
