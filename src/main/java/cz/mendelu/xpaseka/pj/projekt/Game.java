package cz.mendelu.xpaseka.pj.projekt;

import cz.mendelu.xpaseka.pj.projekt.cards.*;
import cz.mendelu.xpaseka.pj.projekt.factions.Scoiatel;

import java.util.Scanner;

public class Game {
    private static Player player1 = new Player();
    private static Player player2 = new Player();

    public static Player getPlayer() {
        return player1;
    }

    public static Player getOpponent() {
        return player2;
    }

    public static void main(String[] args) {
        Card ciri = new UnitCard(TypeOfCard.CLOSE_COMBAT, 9, "Ciri");
        Card siege = new UnitCard(TypeOfCard.SIEGE, 7, "Giga Siege");
        Card yennefer = new UnitCard(TypeOfCard.LONG_RANGE, 8, "Yen");

        Card spy = new SpyCard(TypeOfCard.LONG_RANGE, 2, "Djisktra");
        Card horn = new HornCard();

        player1.addCardToHand(ciri);
        player1.addCardToDeck(siege);
        player1.addCardToDeck(yennefer);
        player1.addCardToHand(spy);
        player1.addCardToDeck(horn);
        player1.addCardToHand(new MusterCard(TypeOfCard.LONG_RANGE, 5, "Arachas"));
        player1.addCardToDeck(new MusterCard(TypeOfCard.LONG_RANGE, 5, "Arachas"));
        player1.addCardToDeck(new MusterCard(TypeOfCard.LONG_RANGE, 5, "Arachas"));

        player1.addCardToHand(new WeatherCard("Rain", WeatherType.RAIN));

        player1.useFactionAbility();
        player1.playCard(1);
        player1.printHand();
        player1.printDeck();
        player1.playCard(1);
        player1.playCard(1);

        System.out.println("Total Friendly score: " + player1.getCombatBoard().getTotalScore());
        System.out.println("Total Enemy score: " + player2.getCombatBoard().getTotalScore());

        player1.addCardToHand(new WeatherCard("Sun", WeatherType.SUN));
        player1.printHand();
        player1.playCard(2);


        System.out.println("Total Friendly score: " + player1.getCombatBoard().getTotalScore());
        System.out.println("Total Enemy score: " + player2.getCombatBoard().getTotalScore());
    }
}
