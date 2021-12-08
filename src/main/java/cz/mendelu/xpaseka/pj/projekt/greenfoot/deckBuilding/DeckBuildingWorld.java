package cz.mendelu.xpaseka.pj.projekt.greenfoot.deckBuilding;

import cz.mendelu.xpaseka.pj.projekt.Game;
import cz.mendelu.xpaseka.pj.projekt.Player;
import cz.mendelu.xpaseka.pj.projekt.cards.Card;
import cz.mendelu.xpaseka.pj.projekt.cards.DecoyCard;
import cz.mendelu.xpaseka.pj.projekt.cards.UnitCard;
import cz.mendelu.xpaseka.pj.projekt.cards.enumTypes.UnitType;
import cz.mendelu.xpaseka.pj.projekt.greenfoot.Button;
import greenfoot.Actor;
import greenfoot.GreenfootImage;
import greenfoot.World;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class DeckBuildingWorld extends World {
    private Player player;
    private List<Card> cardCollection = new ArrayList<>();
    private int deckSize = 0;
    private int currentDeckPage = 1;
    private UnitType filter = UnitType.CLOSE_COMBAT;
    private final Button playButton = Button.playButton;
    private final Button saveButton = Button.saveButton;

    public static final int cardsOnPage = 42;

    public DeckBuildingWorld() {
        super(1600, 900, 1, false);
        setBackground("images/background-deckBuilding.png");

        player = Game.getGameInstance().getPlayer();
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

        addObject(CounterActor.DeckCounter, 800, 405);
        addObject(CounterActor.UnitCardsCounter, 800, 480);
        addObject(CounterActor.SpecialCardsCounter, 800, 560);
        addObject(CounterActor.UnitCardsStrengthCounter, 800, 620);
        addObject(CounterActor.HeroCardsCounter, 800, 690);

        updateCardCollection(filter);
    }

    @Override
    public void act() {
        if (deckSize != player.getDeck().size()) {
            deckSize = player.getDeck().size();
            if (deckSize / cardsOnPage >= 1 && deckSize % cardsOnPage == 1) currentDeckPage++;
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
                if (!(card instanceof UnitCard) || card instanceof DecoyCard) {
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
        int j = 0;
        int coorX = 1020;
        int coorY = 170;
        int cardsInRow = 7;
        renderDeckPages();

        for (int i = (currentDeckPage-1)*cardsOnPage; i < (((currentDeckPage-1)*cardsOnPage)+cardsOnPage) && i < cards.size(); i++) {
            if (j == cardsInRow) {
                coorY += 109;
                j = 0;
            }
            addObject(new CardActor(cards.get(i), true), coorX + (j * 79), coorY);
            j++;
        }
    }

    public void renderDeckPages() {
        removeObjects(getObjects(DeckPageActor.class));
        int numberOfPages = (player.getDeck().size()/cardsOnPage)+1;
        for (int i = 1; i <= numberOfPages; i++) {
            addObject(new DeckPageActor(i), 1150 + (i*40), 70);
        }
        if (currentDeckPage > numberOfPages) currentDeckPage = 1;
        getObjects(DeckPageActor.class).get(currentDeckPage-1).setClickable(false);
    }

    public void setCurrentDeckPage(int currentDeckPage) {
        this.currentDeckPage = currentDeckPage;
    }

    public int getCurrentDeckPage() {
        return this.currentDeckPage;
    }

    public void setFilter(UnitType filter) {
        this.filter = filter;
    }

    public void reloadPlayer() {
        this.player = Game.getGameInstance().getPlayer();
    }
}
