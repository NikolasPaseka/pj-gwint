package cz.mendelu.xpaseka.pj.projekt.greenfoot;

import cz.mendelu.xpaseka.pj.projekt.CombatBoard;
import cz.mendelu.xpaseka.pj.projekt.Game;
import cz.mendelu.xpaseka.pj.projekt.Player;
import cz.mendelu.xpaseka.pj.projekt.WeatherBoard;
import cz.mendelu.xpaseka.pj.projekt.cards.Card;
import cz.mendelu.xpaseka.pj.projekt.cards.UnitCard;
import cz.mendelu.xpaseka.pj.projekt.cards.WeatherCard;
import cz.mendelu.xpaseka.pj.projekt.cards.enumTypes.UnitType;
import greenfoot.Actor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BoardActor extends Actor {

    public static class Position{
        public int x;
        public int y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private int playerNumberOfCards = 0;
    private int opponentNumberOfCards = 0;

    private final Player player;
    private final Player opponent;

    private Map<UnitType, Position> positionsPlayer = new HashMap<>();
    private Map<UnitType, Position> positionsOpponent = new HashMap<>();

    private Map<BoardType, Integer> boardSizes = new HashMap<>();

    enum BoardType {HAND, WEATHER}

    public BoardActor() {
        this.player = Game.getPlayer();
        this.opponent = Game.getOpponent();

        // pozice jednotlivych jednotek na desce
        positionsPlayer.put(UnitType.CLOSE_COMBAT, new Position(542, 465));
        positionsPlayer.put(UnitType.LONG_RANGE, new Position(542, 578));
        positionsPlayer.put(UnitType.SIEGE, new Position(542, 693));

        positionsOpponent.put(UnitType.CLOSE_COMBAT, new Position(542, 332));
        positionsOpponent.put(UnitType.LONG_RANGE, new Position(542, 200));
        positionsOpponent.put(UnitType.SIEGE, new Position(542, 150));

        boardSizes.put(BoardType.HAND, 0);
        boardSizes.put(BoardType.WEATHER, 0);
    }

    @Override
    public void act() {
        if (boardSizes.get(BoardType.HAND) != player.getHand().size()) {
            boardSizes.put(BoardType.HAND, player.getHand().size());
            updateHand(player.getHand());
        }
        if (boardSizes.get(BoardType.WEATHER) != WeatherBoard.getWeatherCards().size()) {
            boardSizes.put(BoardType.WEATHER, WeatherBoard.getWeatherCards().size());
            updateWeatherBoard();
            System.out.println(boardSizes.get(BoardType.WEATHER));
        }

        if (playerNumberOfCards != getNumberOfCards(player.getCombatBoard())) {
            playerNumberOfCards = getNumberOfCards(player.getCombatBoard());
            updateCombatBoard();
        }
        if (opponentNumberOfCards != getNumberOfCards(opponent.getCombatBoard())) {
            opponentNumberOfCards = getNumberOfCards(opponent.getCombatBoard());
            updateCombatBoard();
        }
    }

    public int getNumberOfCards(CombatBoard board) {
        var combatBoardUnits = board.getAllUnits();
        int numberOfCards = 0;
        for (List<UnitCard> cards : combatBoardUnits.values()) {
            numberOfCards += cards.size();
        }

        combatBoardUnits = opponent.getCombatBoard().getAllUnits();
        for (List<UnitCard> cards : combatBoardUnits.values()) {
            numberOfCards += cards.size();
        }

        return numberOfCards;
    }

    public void updateHand(List<Card> cards) {
        getWorld().removeObjects(getWorld().getObjects(HandCardActor.class));
        int i = 0;
        for (Card card : cards) {
            getWorld().addObject(new HandCardActor(player, card, i), 420 + (i * 79), 813);
            i++;
        }
    }

    public void updateWeatherBoard() {
        getWorld().removeObjects(getWorld().getObjects(WeatherCardActor.class));

        List<WeatherCard> cards = new ArrayList<>(WeatherBoard.getWeatherCards());
        int i = 0;
        for (WeatherCard card : cards) {
            getWorld().addObject(new WeatherCardActor(card), 110 + (i * 90), 450);
            i++;
        }
    }

    public void updateCombatBoard() {
        getWorld().removeObjects(getWorld().getObjects(BoardCardActor.class));
        updateCombat(player.getCombatBoard().getAllUnits(), positionsPlayer);
        updateCombat(opponent.getCombatBoard().getAllUnits(), positionsOpponent);
    }

    public void updateCombat(Map<UnitType, List<UnitCard>> board, Map<UnitType, Position> positions) {

        for (List<UnitCard> cards : board.values()) {
            int i = 0;
            for (UnitCard card : cards) {
                var position = positions.get(card.getType());
                getWorld().addObject(new BoardCardActor(card, i), position.x + (i * 79), position.y);
                i++;
            }
        }
    }

}
