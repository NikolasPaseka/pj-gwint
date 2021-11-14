package cz.mendelu.xpaseka.pj.projekt.greenfoot.gwintGame;

import cz.mendelu.xpaseka.pj.projekt.cards.WeatherCard;
import greenfoot.Actor;

public class WeatherCardActor extends Actor {
    public WeatherCardActor(WeatherCard weatherCard) {
        setImage(String.format("images/cards/HD+/%s.jpg", weatherCard.getName()));
    }
}
