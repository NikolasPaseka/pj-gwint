package cz.mendelu.xpaseka.pj.projekt;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import cz.mendelu.xpaseka.pj.projekt.cardFactory.*;
import cz.mendelu.xpaseka.pj.projekt.cards.*;
import cz.mendelu.xpaseka.pj.projekt.factions.Monsters;
import cz.mendelu.xpaseka.pj.projekt.factions.Nilfgaard;
import cz.mendelu.xpaseka.pj.projekt.factions.NorthEmpire;
import cz.mendelu.xpaseka.pj.projekt.factions.Scoiatel;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        return cardList;
    }

    public static boolean checkDeck(List<Card> deck) {
        boolean playableDeck = true;

        if (deck.size() >= 12) {
            int numberOfSpecialCards = 0;
            for (Card card : deck) {
                if (!(card instanceof UnitCard)) numberOfSpecialCards++;
                else {
                    if (((UnitCard) card).isHero()) {
                        int occurrences = Collections.frequency(deck, card);
                        if (occurrences > 1) playableDeck = false;
                    }
                }
            }
            if (numberOfSpecialCards > 10) playableDeck = false;
        } else {
            playableDeck = false;
        }

        return playableDeck;
    }

    /**
     * Ulozeni hracove konfigurace do slozky saves
     *
     * @author xpaseka
     * @version etapa 4
     *
     * @param buildName - nazev buildu
     */
    public static void saveBuild(String buildName) {
        try (var out = new ObjectOutputStream(new FileOutputStream("saves/" + buildName + ".player"))) {
            out.writeObject(player);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Nacteni hracove konfigurace ze slozky saves
     *
     * @author xpaseka
     * @version etapa 4
     *
     * @param buildName - nazev buildu
     */
    public static void loadBuild(String buildName) {
        try (var in = new ObjectInputStream(new FileInputStream("saves/" + buildName + ".player"))) {
            player = (Player) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Slouzi pro nacitani textovych souboru ze slozky text-files
     *
     * @author xpaseka
     * @version etapa 4
     *
     * @param fileName - nazev textaku pro nacteni
     * @return slozeny text
     */
    public static String getGameRules(String fileName) {
        StringBuilder text = new StringBuilder();
        try(var r = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream("text-files/" + fileName + ".txt"), StandardCharsets.UTF_8))) {
            String line;
            while ((line = r.readLine()) != null) {
                text.append(line).append('\n');
            }
        } catch (IOException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        }
        return text.toString();
    }

    public static void main(String[] args) {
        System.out.println(player.getLifes());
    }
}
