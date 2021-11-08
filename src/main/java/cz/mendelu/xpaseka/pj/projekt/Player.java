package cz.mendelu.xpaseka.pj.projekt;

import cz.mendelu.xpaseka.pj.projekt.cards.Card;
import cz.mendelu.xpaseka.pj.projekt.cards.HornCard;
import cz.mendelu.xpaseka.pj.projekt.cards.UnitCard;
import cz.mendelu.xpaseka.pj.projekt.factions.Faction;

import java.util.*;


public class Player {
    private String name;
    private int lifes;
    private int score;
    private List<Card> hand = new ArrayList<>();
    private List<Card> deck = new ArrayList<>();
    private List<Card> discardPile = new ArrayList<>();
    private Faction faction;
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

    public void addCardToHand(Card card) {
        hand.add(card);
    }

    public void addCardToDeck(Card card) {
        deck.add(card);
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

    public void useFactionAbility() {
        faction.applyEffect();
    }

    public Faction getFaction() {
        return faction;
    }

    public void addHorn(HornCard horn) {
//        combatBoard.addHornCard(horn);
    }

    public CombatBoard getCombatBoard() {
        return combatBoard;
    }

    public void setDeck(List<Card> deck) {
        this.deck = deck;
    }

    public void setHand() {
        System.out.println(deck.size());
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
}
