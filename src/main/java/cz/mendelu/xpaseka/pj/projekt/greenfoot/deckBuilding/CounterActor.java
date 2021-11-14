package cz.mendelu.xpaseka.pj.projekt.greenfoot.deckBuilding;

import cz.mendelu.xpaseka.pj.projekt.Game;
import cz.mendelu.xpaseka.pj.projekt.cards.Card;
import cz.mendelu.xpaseka.pj.projekt.cards.UnitCard;
import greenfoot.Actor;
import greenfoot.GreenfootImage;

import java.awt.*;

/**
 * Abstraktni actor pro jednotlive countery
 * Potomci jsou anonymne implementovany a prekryvaji metodu act()
 *
 * @author xpaseka
 * @version etapa 4
 */

public abstract class CounterActor extends Actor {
    public CounterActor() {
        setImage(new GreenfootImage("0", 25, Color.WHITE, new Color(0, 0, 0, 0)));
    }

    public void updateCounter(String value, Color color) {
        setImage(new GreenfootImage(value, 25, color, new Color(0, 0, 0, 0)));
    }

    public abstract void act();

    public static CounterActor DeckCounter = new CounterActor() {
        private int counter = -1;

        @Override
        public void act() {
            if (counter != Game.getPlayer().getDeck().size()) {
                counter = Game.getPlayer().getDeck().size();
                if (counter < 12) {
                    updateCounter(Integer.toString(counter), new Color(222, 24, 24));
                } else {
                    updateCounter(Integer.toString(counter), Color.white);
                }
            }
        }
    };

    public static CounterActor UnitCardsCounter = new CounterActor() {
        private int counter = 0;

        @Override
        public void act() {
            if (counter != countUnitCards()) {
                counter = countUnitCards();
                updateCounter(Integer.toString(counter), Color.WHITE);
            }
        }

        public int countUnitCards() {
            int numberOfUnitCards = 0;
            for (Card card : Game.getPlayer().getDeck()) {
                if (card instanceof UnitCard) numberOfUnitCards++;
            }
            return numberOfUnitCards;
        }
    };

    public static CounterActor SpecialCardsCounter = new CounterActor() {
        private int counter = -1;
        private int maxSpecialCards = 10;

        @Override
        public void act() {
            if (counter != Game.getPlayer().countSpecialCards()) {
                counter = Game.getPlayer().countSpecialCards();
                if (counter > maxSpecialCards) {
                    updateCounter(counter + "/" + maxSpecialCards, new Color(222, 24, 24));
                } else {
                    updateCounter(counter + "/" + maxSpecialCards, Color.WHITE);
                }
            }
        }
    };

    public static CounterActor UnitCardsStrengthCounter = new CounterActor() {
        private int counter = 0;
        @Override
        public void act() {
            if (counter != Game.getPlayer().countCardStrength()) {
                counter = Game.getPlayer().countCardStrength();
                updateCounter(Integer.toString(counter), Color.WHITE);
            }
        }
    };

    public static CounterActor HeroCardsCounter = new CounterActor() {
        private int counter = 0;

        @Override
        public void act() {
            if (counter != Game.getPlayer().countHeroesInDeck()) {
                counter = Game.getPlayer().countHeroesInDeck();
                updateCounter(Integer.toString(counter), Color.WHITE);
            }
        }
    };
}
