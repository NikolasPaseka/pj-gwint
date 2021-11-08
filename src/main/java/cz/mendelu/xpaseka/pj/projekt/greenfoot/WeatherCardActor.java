package cz.mendelu.xpaseka.pj.projekt.greenfoot;

import cz.mendelu.xpaseka.pj.projekt.Player;
import cz.mendelu.xpaseka.pj.projekt.WeatherBoard;
import cz.mendelu.xpaseka.pj.projekt.cards.Card;
import cz.mendelu.xpaseka.pj.projekt.cards.UnitCard;
import cz.mendelu.xpaseka.pj.projekt.cards.WeatherCard;
import greenfoot.Actor;
import greenfoot.Greenfoot;

import java.util.ArrayList;
import java.util.List;

public class WeatherCardActor extends Actor {

    public WeatherCardActor(WeatherCard card) {
        setImage(String.format("images/cards/HD+/%s.jpg", card.getName()));
//        setImage("images/cards/test2.jpg");
    }
}