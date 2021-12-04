package cz.mendelu.xpaseka.pj.projekt.factions;

import cz.mendelu.xpaseka.pj.projekt.Game;
import cz.mendelu.xpaseka.pj.projekt.Player;
import cz.mendelu.xpaseka.pj.projekt.WeatherBoard;
import cz.mendelu.xpaseka.pj.projekt.cards.Card;
import cz.mendelu.xpaseka.pj.projekt.cards.HornCard;
import cz.mendelu.xpaseka.pj.projekt.cards.ScorchSpecialCard;
import cz.mendelu.xpaseka.pj.projekt.cards.WeatherCard;
import cz.mendelu.xpaseka.pj.projekt.cards.enumTypes.UnitType;
import cz.mendelu.xpaseka.pj.projekt.cards.enumTypes.WeatherType;

import java.util.Iterator;
import java.util.List;

public class NorthEmpire extends Faction {

    public NorthEmpire()  {
        name = "North Empire";
        createLeaders();
    }

    /**
     * Metoda pro využití efektu hráčovi frakce - může být využita hráčem pouze jednou za hru
     * Efekt frakce NorthEmpire přidělí hráči kartu z odkládacího balíčku pokud vyhraje kolo
     *
     * @author xpaseka
     * @version etapa 2
     * @version etapa 3
     */
    @Override
    public void applyEffect() {
        List<Card> deck = Game.getGameInstance().getPlayer().getDeck();
        int deckSize = deck.size();
        Card card = deck.remove(deckSize-1);
        Game.getGameInstance().getPlayer().addCardToHand(card);
    }

    protected void createLeaders() {
        leaders.add(new Leader() {
            @Override
            protected void setAttributes() {
                name = "Foltest the Steel-Forged";
                abilityDescription = "Scorch Siege if enemies Siege strengh is 10 or higher";
            }

            @Override
            public void applyAbility() {
                 var opponent = Game.getGameInstance().getOpponent();
                 int siegeScore = opponent.getCombatBoard().getRowScore(UnitType.SIEGE);
                 if (siegeScore >= 10) {
                     new ScorchSpecialCard().applyCard();
                     // TODO scorch only Siege
                 }
            }
        });

        leaders.add(new Leader() {
            @Override
            protected void setAttributes() {
                name = "Foltest the Siegemaster";
                abilityDescription = "Horn on Siege row";
            }

            @Override
            public void applyAbility() {
                HornCard siegeHorn = new HornCard();
                siegeHorn.setUnitType(UnitType.SIEGE);
                siegeHorn.applyCard();
            }
        });

        leaders.add(new Leader() {
            @Override
            protected void setAttributes() {
                name = "Foltest Lord Commander of the North";
                abilityDescription = "Clear any Weather effects in game";
            }

            @Override
            public void applyAbility() {
                new WeatherCard(WeatherType.SUN).applyCard();
            }
        });

        leaders.add(new Leader() {
            @Override
            protected void setAttributes() {
                name = "Foltest King of Temeria";
                abilityDescription = "Pick a Fog card from your deck and play it immediately";
            }

            @Override
            public void applyAbility() {
                boolean found = false;
                Iterator<Card> iterator = Game.getGameInstance().getPlayer().getDeck().listIterator();
                while (!found && iterator.hasNext()) {
                    Card card = iterator.next();
                    if (card instanceof WeatherCard) {
                        if (((WeatherCard) card).getWeatherType() == WeatherType.FOG) {
                            card.applyCard();
                            iterator.remove();
                            found = true;
                        }
                    }
                }
            }
        });
    }
}
