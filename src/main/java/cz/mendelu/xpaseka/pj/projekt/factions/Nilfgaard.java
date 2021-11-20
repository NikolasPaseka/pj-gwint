package cz.mendelu.xpaseka.pj.projekt.factions;

import cz.mendelu.xpaseka.pj.projekt.Game;
import cz.mendelu.xpaseka.pj.projekt.Player;
import cz.mendelu.xpaseka.pj.projekt.cards.Card;
import cz.mendelu.xpaseka.pj.projekt.cards.WeatherCard;
import cz.mendelu.xpaseka.pj.projekt.cards.enumTypes.WeatherType;

import java.util.Iterator;

public class Nilfgaard extends Faction {
    public Nilfgaard() {
        name = "Nilfgaardian Empire";
        createLeaders();
    }

    @Override
    public void applyEffect() {
        // TODO
    }

    protected void createLeaders() {
        leaders.add(new Leader() {
            @Override
            public void applyAbility() {
                // TODO
            }

            @Override
            protected void setAttributes() {
                name = "Emhyr var Emreis the White Flame";
                abilityDescription = "Cancel your opponents Leader ability";
            }
        });

        leaders.add(new Leader() {
            @Override
            public void applyAbility() {
                boolean found = false;
                Iterator<Card> iterator = Game.getPlayer().getDeck().listIterator();
                while (!found && iterator.hasNext()) {
                    Card card = iterator.next();
                    if (card instanceof WeatherCard) {
                        if (((WeatherCard) card).getWeatherType() == WeatherType.RAIN) {
                            card.applyCard();
                            iterator.remove();
                            found = true;
                        }
                    }
                }
            }

            @Override
            protected void setAttributes() {
                name = "Emhyr var Emreis His Imperial Majesty";
                abilityDescription = "Pick a Rain card from your deck and play it immediately";
            }
        });

        leaders.add(new Leader() {
            @Override
            public void applyAbility() {
                // TODO
            }

            @Override
            protected void setAttributes() {
                name = "Emhyr var Emreis Emperor of Nilfgaard";
                abilityDescription = "Look at 3 random cards of your opponents hand";
            }
        });

        leaders.add(new Leader() {
            @Override
            public void applyAbility() {
                var discardPile = Game.getOpponent().getDiscardPile();
                if (discardPile.size() > 0) {
                    Game.getPlayer().addCardToHand(discardPile.remove(discardPile.size()-1));
                }
            }

            @Override
            protected void setAttributes() {
                name = "Emhyr var Emreis the Relentless";
                abilityDescription = "Draw card from opponent’s discard pile";
            }
        });
    }
}
