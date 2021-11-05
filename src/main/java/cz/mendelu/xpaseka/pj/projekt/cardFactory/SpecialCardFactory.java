package cz.mendelu.xpaseka.pj.projekt.cardFactory;

import cz.mendelu.xpaseka.pj.projekt.cards.*;
import cz.mendelu.xpaseka.pj.projekt.cards.enumTypes.WeatherType;

import java.security.AlgorithmConstraints;
import java.util.ArrayList;
import java.util.List;

public class SpecialCardFactory implements CardFactory {

    @Override
    public List<Card> createAllCards() {
        List<Card> specialCards = new ArrayList<>();

        specialCards.add(new DecoyCard());
        specialCards.add(new HornCard());
        specialCards.add(new ScorchSpecialCard());
        specialCards.add(new WeatherCard(WeatherType.FROST));
        specialCards.add(new WeatherCard(WeatherType.FOG));
        specialCards.add(new WeatherCard(WeatherType.RAIN));
        specialCards.add(new WeatherCard(WeatherType.SUN));

        return specialCards;
    }
}
