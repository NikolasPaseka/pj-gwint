package cz.mendelu.xpaseka.pj.projekt;

import cz.mendelu.xpaseka.pj.projekt.cards.Card;
import cz.mendelu.xpaseka.pj.projekt.cards.HornCard;
import cz.mendelu.xpaseka.pj.projekt.cards.UnitCard;
import cz.mendelu.xpaseka.pj.projekt.factions.Faction;
import cz.mendelu.xpaseka.pj.projekt.factions.Scoiatel;

import java.util.ArrayList;
import java.util.List;


public class Player {
    private int lifes;
    private int score;
    private List<Card> hand;
    private List<Card> deck;
    private Faction faction;
    private CombatBoard combatBoard;

    Player() {
        lifes = 2;
        score = 0;
        hand = new ArrayList<>();
        deck = new ArrayList<>();
        chooseFaction();
        combatBoard = new CombatBoard();
    }

    private void chooseFaction() {
        faction = new Scoiatel(this);
    }

    public void addCardToHand(Card card) {
        hand.add(card);
    }

    public void addCardToDeck(Card card) {
        deck.add(card);
    }

    public void addCardToCombatBoard(UnitCard card) {
        combatBoard.addCard(card);
    }

    public void takeCardFromDeck() {
        hand.add(deck.remove(deck.size()-1));
    }

    private void printCards(List<Card> cards) {
        int i = 0;
        for (Card card: cards) {
            System.out.println(i++ + " " + card.getName());
        }
    }

    public void printHand() {
        System.out.println("Hand:");
        printCards(hand);
    }

    public void printDeck() {
        System.out.println("Deck:");
        printCards(deck);
    }


    public void playCard(int index) {
        hand.remove(index).applyCard();
    }

    public void useFactionAbility() {
        faction.applyAbility();
    }

    public void addHorn(HornCard horn) {
        combatBoard.addHornCard(horn);
    }

    public CombatBoard getCombatBoard() {
        return combatBoard;
    }

    public void setDeck(List<Card> deck) {
        this.deck = deck;
    }

    public List<Card> getDeck() {
        return deck;
    }

    public List<Card> getHand() {
        return hand;
    }

    public int getTotalScore() {
        return combatBoard.getTotalScore();
    }
}
