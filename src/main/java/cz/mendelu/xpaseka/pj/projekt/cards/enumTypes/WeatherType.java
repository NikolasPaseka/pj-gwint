package cz.mendelu.xpaseka.pj.projekt.cards.enumTypes;

public enum WeatherType {
    RAIN("Torrential Rain"),
    FROST("Biting Frost"),
    FOG("Impenetrable Fog"),
    SUN("Clear Weather");

    private String name;

    private WeatherType(String name) {
        this.name = name;
    }
}
