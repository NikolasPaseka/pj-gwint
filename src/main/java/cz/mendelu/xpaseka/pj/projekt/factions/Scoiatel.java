package cz.mendelu.xpaseka.pj.projekt.factions;

import cz.mendelu.xpaseka.pj.projekt.Game;
import cz.mendelu.xpaseka.pj.projekt.Player;
import cz.mendelu.xpaseka.pj.projekt.cards.Card;
import cz.mendelu.xpaseka.pj.projekt.cards.HornCard;
import cz.mendelu.xpaseka.pj.projekt.cards.ScorchSpecialCard;
import cz.mendelu.xpaseka.pj.projekt.cards.WeatherCard;
import cz.mendelu.xpaseka.pj.projekt.cards.enumTypes.UnitType;
import cz.mendelu.xpaseka.pj.projekt.cards.enumTypes.WeatherType;

import java.util.Iterator;

public class Scoiatel extends Faction {

    public Scoiatel() {
        name = "Scoiatel";
        createLeaders();
    }

    public void applyEffect() {
        System.out.println("Choose who plays first");
    }

    protected void createLeaders() {
        leaders.add(new Leader() {
            @Override
            public void applyAbility() {
                HornCard siegeHorn = new HornCard();
                siegeHorn.setUnitType(UnitType.LONG_RANGE);
                siegeHorn.applyCard();
            }

            @Override
            protected void setAttributes() {
                name = "Francesca Findabair the Beautiful";
                abilityDescription = "Horn effect on your Ranged Combat row";
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
                        if (((WeatherCard) card).getWeatherType() == WeatherType.FROST) {
                            card.applyCard();
                            iterator.remove();
                            found = true;
                        }
                    }
                }
            }

            @Override
            protected void setAttributes() {
                name = "Francesca Findabair Pureblood Elf";
                abilityDescription = "Pick a Frost card from your deck and play it immediately";
            }
        });

        leaders.add(new Leader() {
            @Override
            public void applyAbility() {
                var deck = Game.getPlayer().getDeck();
                Game.getPlayer().addCardToHand(deck.remove(deck.size()-1));
            }

            @Override
            protected void setAttributes() {
                name = "Francesca Findabair Daisy of the Valley";
                abilityDescription = "Draw extra card at the beginning of the game";
            }
        });

        leaders.add(new Leader() {
            @Override
            public void applyAbility() {
                var opponent = Game.getOpponent();
                int siegeScore = opponent.getCombatBoard().getRowScore(UnitType.CLOSE_COMBAT);
                if (siegeScore >= 10) {
                    new ScorchSpecialCard().applyCard();
                    // TODO Scorch only close combat
                }
            }

            @Override
            protected void setAttributes() {
                name = "Francesca Findabair Queen of Dol Blathanna";
                abilityDescription = "Scorch Close Combat if enemies Close Combat strengh is 10 or higher";
            }
        });
    }
}
