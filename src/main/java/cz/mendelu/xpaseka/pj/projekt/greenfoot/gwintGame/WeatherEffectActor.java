package cz.mendelu.xpaseka.pj.projekt.greenfoot.gwintGame;

import cz.mendelu.xpaseka.pj.projekt.cards.enumTypes.UnitType;
import cz.mendelu.xpaseka.pj.projekt.cards.enumTypes.WeatherType;
import greenfoot.Actor;

public class WeatherEffectActor extends Actor {
    private final WeatherType weatherType;
    private boolean rendered = false;

    WeatherEffectActor(WeatherType weatherType) {
        this.weatherType = weatherType;
        setImage(String.format("images/Weather Effects/%s.png", weatherType.getName()));
    }

    @Override
    public void act() {
        if (!rendered) {
            render();
        }
    }

    public void render() {
        if (weatherType == WeatherType.FROST) {
            setLocation(917, 465);
        } else if (weatherType == WeatherType.FOG) {
            setLocation(917, 578);
        } else if (weatherType == WeatherType.RAIN) {
            setLocation(917, 688);
        }
        rendered = true;
    }
}
