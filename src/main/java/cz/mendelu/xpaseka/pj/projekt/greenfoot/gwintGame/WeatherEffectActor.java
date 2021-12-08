package cz.mendelu.xpaseka.pj.projekt.greenfoot.gwintGame;

import cz.mendelu.xpaseka.pj.projekt.cards.enumTypes.UnitType;
import cz.mendelu.xpaseka.pj.projekt.cards.enumTypes.WeatherType;
import greenfoot.Actor;

public class WeatherEffectActor extends Actor {
    private final WeatherType weatherType;
    private final PlayerEnum board;
    private boolean rendered = false;

    WeatherEffectActor(WeatherType weatherType, PlayerEnum board) {
        this.weatherType = weatherType;
        this.board = board;
        setImage(String.format("images/Weather Effects/%s.png", weatherType.getName()));
    }

    @Override
    public void act() {
        if (!rendered) {
            render();
        }
    }

    public void render() {
        if (board == PlayerEnum.PLAYER) {
            if (weatherType == WeatherType.FROST) {
                setLocation(914, 465);
            } else if (weatherType == WeatherType.FOG) {
                setLocation(914, 578);
            } else if (weatherType == WeatherType.RAIN) {
                setLocation(914, 693);
            }
        } else {
            if (weatherType == WeatherType.FROST) {
                setLocation(914, 322);
            } else if (weatherType == WeatherType.FOG) {
                setLocation(914, 210);
            } else if (weatherType == WeatherType.RAIN) {
                setLocation(914, 95);
            }
        }
        rendered = true;
    }
}
