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

public class Monsters extends Faction {
    public Monsters() {
        name = "Monsters";
        createLeaders();
    }

    @Override
    public void applyEffect() {
        // TODO
    }

    protected void createLeaders() {
        leaders.add(new Leader() {
            @Override
            protected void setAttributes() {
                name = "Eredin Destroyer of Worlds";
                abilityDescription = "Pick a card from your discard pile and put it back into your hand";
            }

            @Override
            public void applyAbility() {
                // TODO - vyber konkretni karty
                var player = Game.getGameInstance().getPlayer();
                if (player.getDiscardPile().size() > 0) {
                    player.addCardToHand(player.getDiscardPile().remove(player.getDiscardPile().size()-1));
                }
            }
        });

        leaders.add(new Leader() {
            @Override
            protected void setAttributes() {
                name = "Eredin Bringer of Death";
                abilityDescription = "Discard 2 cards from your hand, Draw 1 card of your choice from you deck";
            }

            @Override
            public void applyAbility() {
                // TODO
            }
        });

        leaders.add(new Leader() {
            @Override
            protected void setAttributes() {
                name = "Eredin King of the Wild Hunt";
                abilityDescription = "Horn effect on your Close Combat row";
            }

            @Override
            public void applyAbility() {
                HornCard closeCombatHorn = new HornCard();
                closeCombatHorn.setUnitType(UnitType.CLOSE_COMBAT);
                closeCombatHorn.applyCard();
            }
        });

        leaders.add(new Leader() {
            @Override
            protected void setAttributes() {
                name = "Eredin Commander of the Red Riders";
                abilityDescription = "Pick any weather card from your deck and play it immediately";
            }

            @Override
            public void applyAbility() {
               // TODO
            }
        });
    }
}
