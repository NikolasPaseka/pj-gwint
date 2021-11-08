package cz.mendelu.xpaseka.pj.projekt;

import cz.mendelu.xpaseka.pj.projekt.cardFactory.*;
import cz.mendelu.xpaseka.pj.projekt.cards.*;
import cz.mendelu.xpaseka.pj.projekt.factions.Monsters;
import cz.mendelu.xpaseka.pj.projekt.factions.Nilfgaard;
import cz.mendelu.xpaseka.pj.projekt.factions.NorthEmpire;
import cz.mendelu.xpaseka.pj.projekt.factions.Scoiatel;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private static Player player = new Player("player1");
    private static Player opponent = new Player("player2");

    public static void createNewGame() {
        player = new Player("player1");
        opponent = new Player("player2");
    }

    public static Player getPlayer() {
        return player;
    }

    public static Player getOpponent() {
        return opponent;
    }

    public static void startNewRound(){
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Metoda, která vytvoří vsechny karty ze kterych si hrac vybere svuj balicek
     * Hrac musi mit vybranou frakci, jinak vraci prazdny balicek
     * Nehlede na frakci, kazdy ma k dispizici neutralni a specialni karty
     * Podle prislusne frakce se dale vytvori karty frakce
     * Odkládací balíček musí obsahovat alespon 22 karet
     *
     * @return List karet - odkládací balíček hráče
     *
     * @author xpaseka
     * @version etapa 2
     * @version etapa 3
     */
    public static List<Card> buildDeck(Player player){
        // TODO implementace IO operaci pro zmenu karet v balicku - etapa 4
        List<Card> cardList = new ArrayList<>();
        CardFactory deck;

        if (player.getFaction() != null) {
            // nacte vsechny neutralni a specialni karty
            deck = new NeutralCardFactory();
            cardList = deck.createAllCards();
            deck = new SpecialCardFactory();
            cardList.addAll(deck.createAllCards());

            if (player.getFaction() instanceof NorthEmpire) {
                deck = new NorthEmpireCardFactory();
                cardList.addAll(deck.createAllCards());
            } else if (player.getFaction() instanceof Scoiatel) {
                deck = new ScoiatelCardFactory();
                cardList.addAll(deck.createAllCards());
            } else if (player.getFaction() instanceof Nilfgaard) {
                deck = new NilfgaardianCardFactory();
                cardList.addAll(deck.createAllCards());
            } else if (player.getFaction() instanceof Monsters) {
                deck = new MonstersCardFactory();
                cardList.addAll(deck.createAllCards());
            }
        }
        player.setDeck(cardList);
        player.setHand();
        return cardList;
    }

    public static void main(String[] args) {
/*        Card ciri = new UnitCard(UnitType.CLOSE_COMBAT, 9, "Ciri");
        Card siege = new UnitCard(UnitType.SIEGE, 7, "Giga Siege");
        Card yennefer = new UnitCard(UnitType.LONG_RANGE, 8, "Yen");

        Card spy = new SpyCard(UnitType.LONG_RANGE, 2, "Djisktra");
        Card horn = new HornCard();

        player.addCardToHand(ciri);
        player.addCardToDeck(siege);
        player.addCardToDeck(yennefer);
        player.addCardToHand(spy);
        player.addCardToDeck(horn);
        player.addCardToHand(new MusterCard(UnitType.LONG_RANGE, 5, "Arachas"));
        player.addCardToDeck(new MusterCard(UnitType.LONG_RANGE, 5, "Arachas"));
        player.addCardToDeck(new MusterCard(UnitType.LONG_RANGE, 5, "Arachas"));

        player.addCardToHand(new WeatherCard(WeatherType.RAIN));

        player.useFactionAbility();
        player.playCard(1);
        player.printHand();
        player.printDeck();
        player.playCard(1);
        player.playCard(1);

        System.out.println("Total Friendly score: " + player.getCombatBoard().getTotalScore());
        System.out.println("Total Enemy score: " + opponent.getCombatBoard().getTotalScore());

        player.addCardToHand(new WeatherCard(WeatherType.SUN));
        player.printHand();
        player.playCard(2);


        System.out.println("Total Friendly score: " + player.getCombatBoard().getTotalScore());
        System.out.println("Total Enemy score: " + opponent.getCombatBoard().getTotalScore());*/
    }
}
