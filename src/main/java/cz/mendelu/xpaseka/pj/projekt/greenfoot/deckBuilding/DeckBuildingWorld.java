package cz.mendelu.xpaseka.pj.projekt.greenfoot.deckBuilding;

import cz.mendelu.xpaseka.pj.projekt.Game;
import cz.mendelu.xpaseka.pj.projekt.Player;
import cz.mendelu.xpaseka.pj.projekt.cards.Card;
import cz.mendelu.xpaseka.pj.projekt.cards.UnitCard;
import cz.mendelu.xpaseka.pj.projekt.cards.enumTypes.UnitType;
import cz.mendelu.xpaseka.pj.projekt.greenfoot.Button;
import greenfoot.Actor;
import greenfoot.World;

import java.util.ArrayList;
import java.util.List;

public class DeckBuildingWorld extends World {
    private Player player;
    private List<Card> cardCollection = new ArrayList<>();
    private int deckSize = 0;
    private UnitType filter = UnitType.CLOSE_COMBAT;
    private final Button playButton = Button.playButton;
    private final Button saveButton = Button.saveButton;

    public DeckBuildingWorld() {
        super(1600, 900, 1, false);
        setBackground("images/background-deckBuilding.png");

        player = Game.getPlayer();
        cardCollection = Game.buildDeck(player);

        addObject(new CardFilterButton(true, null), 280, 70);
        addObject(new CardFilterButton(false, UnitType.CLOSE_COMBAT), 380, 70);
        addObject(new CardFilterButton(true, UnitType.LONG_RANGE), 480, 70);
        addObject(new CardFilterButton(true, UnitType.SIEGE), 580, 70);

        // Leader render
        addObject(new Actor() {
            {
                setImage(String.format("images/Leaders/%s/%s.png", player.getFaction().getName(), player.getLeader().getName()));
            }
        }, 800, 250);

        addObject(playButton, 800, 750);
        addObject(saveButton, 800, 820);

        addObject(CounterActor.DeckCounter, 800, 420);
        addObject(CounterActor.UnitCardsCounter, 800, 500);
        addObject(CounterActor.SpecialCardsCounter, 800, 570);
        addObject(CounterActor.UnitCardsStrengthCounter, 800, 640);
        addObject(CounterActor.HeroCardsCounter, 800, 700);

        updateCardCollection(filter);
    }

    @Override
    public void act() {
        if (deckSize != player.getDeck().size()) {
            deckSize = player.getDeck().size();
            updateCards();
        }

        if (Game.checkDeck(player.getDeck())) {
            playButton.setActive(true);
            saveButton.setActive(true);
        } else {
            playButton.setActive(false);
            saveButton.setActive(false);
        }
    }

    public void updateCards() {
        removeObjects(getObjects(CardActor.class));
        updateCardCollection(filter);
        updateDeck();
    }

    public void updateCardCollection(UnitType unitType) {
        int i = 0;
        int coorX = 100;
        int coorY = 170;
        int cardsInRow = 7;
        for (Card card : cardCollection) {
            if (i == cardsInRow) {
                coorY += 109;
                i = 0;
            }
            if (unitType == null) {
                if (!(card instanceof UnitCard)) {
                    addObject(new CardActor(card, false), coorX + (i * 79), coorY);
                    i++;
                }
            } else {
                if ((card instanceof UnitCard) && ((UnitCard) card).getType() == unitType) {
                    addObject(new CardActor(card, false), coorX + (i * 79), coorY);
                    i++;
                }
            }
        }
    }

    public void updateDeck() {
        var cards = player.getDeck();
        int i = 0;
        int coorX = 1020;
        int coorY = 170;
        int cardsInRow = 7;
        for (Card card : cards) {
            if (i == cardsInRow) {
                coorY += 109;
                i = 0;
            }
            addObject(new CardActor(card, true), coorX + (i * 79), coorY);
            i++;
        }
    }

    public void setFilter(UnitType filter) {
        this.filter = filter;
    }

    public void reloadPlayer() {
        this.player = Game.getPlayer();
    }
}
