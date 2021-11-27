package cz.mendelu.xpaseka.pj.projekt;

import cz.mendelu.xpaseka.pj.projekt.cards.AgileCard;
import cz.mendelu.xpaseka.pj.projekt.cards.Card;
import cz.mendelu.xpaseka.pj.projekt.cards.UnitCard;
import cz.mendelu.xpaseka.pj.projekt.factions.Faction;
import cz.mendelu.xpaseka.pj.projekt.factions.Leader;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.*;


public class Player implements Serializable {
    private String name;
    private int lifes;
    private int score;
    private List<Card> hand = new ArrayList<>();
    private List<Card> deck = new ArrayList<>();
    private List<Card> discardPile = new ArrayList<>();
    private Faction faction;
    private Leader leader;
    private boolean usedLeaderAbility = false;
    private CombatBoard combatBoard;

    Player(String name) {
        this.name = name;
        this.lifes = 2;
        this.score = 0;
        this.combatBoard = new CombatBoard();
    }

    /**
     * @author xpaseka
     * @version etapa 3
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return lifes == player.lifes && score == player.score && name.equals(player.name) && faction.equals(player.faction);
    }

    /**
     * @author xpaseka
     * @version etapa 3
     */
    @Override
    public int hashCode() {
        return Objects.hash(name, lifes, score, faction);
    }

    public void setFaction(Faction faction) {
        this.faction = faction;
    }

    public void setLeader(int index) {
        leader = faction.getLeader(index);
    }

    public Leader getLeader() {
        return leader;
    }

    public boolean getUsedLeaderAbility() {
        return usedLeaderAbility;
    }

    public void useFactionAbility() {
        faction.applyEffect();
    }

    public void useLeaderAbility() {
        leader.applyAbility();
        usedLeaderAbility = true;
    }

    public int getLifes() {
        return lifes;
    }

    public void addCardToHand(Card card) {
        hand.add(card);
    }

    public void addCardToDeck(Card card) {
        deck.add(card.cloneObject());
    }

    public void addCardToDiscardPile(Card card) {
        if (card instanceof UnitCard) {
            ((UnitCard) card).resetCurrentPower();
        }
        discardPile.add(card);
    }

    public void addCardToCombatBoard(UnitCard card) {
        combatBoard.addCard(card);
    }

    public void takeCardFromDeck() {
        hand.add(deck.remove(deck.size()-1));
    }

    public void playCard(int index) {
        hand.remove(index).applyCard();
    }

    public Faction getFaction() {
        return faction;
    }

    public CombatBoard getCombatBoard() {
        return combatBoard;
    }

    public void setDeck(List<Card> deck) {
        this.deck = deck;
    }

    public void removeFromDeck(Card card) {
        deck.remove(card);
    }

    public void setHand() {
        Collections.shuffle(deck);
        for (int i = 0; i < 10; i++) {
            hand.add(deck.remove(deck.size()-1-i));
        }
    }

    public List<Card> getDeck() {
        return deck;
    }

    public List<Card> getHand() {
        return hand;
    }

    public List<Card> getDiscardPile() {
        return discardPile;
    }

    public int getTotalScore() {
        return combatBoard.getTotalScore();
    }

    public int countHeroesInDeck() {
        int numberOfHeroes = 0;
        for (Card card : Game.getPlayer().getDeck()) {
            if (card instanceof UnitCard) {
                if (((UnitCard) card).isHero()) numberOfHeroes++;
            }
        }
        return numberOfHeroes;
    }

    public int countCardStrength() {
        int totalStrength = 0;
        for (Card card : Game.getPlayer().getDeck()) {
            if (card instanceof UnitCard) {
                totalStrength += ((UnitCard) card).getPower();
            }
        }
        return totalStrength;
    }

    public int countSpecialCards() {
        int numberOfSpecialCards = 0;
        for (Card card : Game.getPlayer().getDeck()) {
            if (!(card instanceof UnitCard)) numberOfSpecialCards++;
        }
        return numberOfSpecialCards;
    }
}
