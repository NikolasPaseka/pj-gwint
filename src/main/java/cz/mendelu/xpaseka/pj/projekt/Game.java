package cz.mendelu.xpaseka.pj.projekt;

import cz.mendelu.xpaseka.pj.projekt.cards.*;

import java.util.List;

public class Game {
    private static Player player = new Player();
    private static Player opponent = new Player();

    public static Player getPlayer() {
        return player;
    }

    public static Player getOpponent() {
        return opponent;
    }

    public static void startNewRound(){}

    /**
     * Metoda, která vytvoří odkládací balíček dle požadavků a vrátí
     * Odkládací balíček musí obsahovat alespon 22 karet
     *
     * @return List karet - odkládací balíček hráče
     *
     * @author xpaseka
     * @version etapa 2
     */
    public static List<Card> buildDeck(){
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    public static void main(String[] args) {
        Card ciri = new UnitCard(TypeOfCard.CLOSE_COMBAT, 9, "Ciri");
        Card siege = new UnitCard(TypeOfCard.SIEGE, 7, "Giga Siege");
        Card yennefer = new UnitCard(TypeOfCard.LONG_RANGE, 8, "Yen");

        Card spy = new SpyCard(TypeOfCard.LONG_RANGE, 2, "Djisktra");
        Card horn = new HornCard();

        player.addCardToHand(ciri);
        player.addCardToDeck(siege);
        player.addCardToDeck(yennefer);
        player.addCardToHand(spy);
        player.addCardToDeck(horn);
        player.addCardToHand(new MusterCard(TypeOfCard.LONG_RANGE, 5, "Arachas"));
        player.addCardToDeck(new MusterCard(TypeOfCard.LONG_RANGE, 5, "Arachas"));
        player.addCardToDeck(new MusterCard(TypeOfCard.LONG_RANGE, 5, "Arachas"));

        player.addCardToHand(new WeatherCard("Rain", WeatherType.RAIN));

        player.useFactionAbility();
        player.playCard(1);
        player.printHand();
        player.printDeck();
        player.playCard(1);
        player.playCard(1);

        System.out.println("Total Friendly score: " + player.getCombatBoard().getTotalScore());
        System.out.println("Total Enemy score: " + opponent.getCombatBoard().getTotalScore());

        player.addCardToHand(new WeatherCard("Sun", WeatherType.SUN));
        player.printHand();
        player.playCard(2);


        System.out.println("Total Friendly score: " + player.getCombatBoard().getTotalScore());
        System.out.println("Total Enemy score: " + opponent.getCombatBoard().getTotalScore());
    }
}
