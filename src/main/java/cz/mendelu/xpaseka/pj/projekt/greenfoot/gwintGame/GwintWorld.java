package cz.mendelu.xpaseka.pj.projekt.greenfoot.gwintGame;

import cz.mendelu.xpaseka.pj.projekt.CombatBoard;
import cz.mendelu.xpaseka.pj.projekt.Game;
import cz.mendelu.xpaseka.pj.projekt.Player;
import cz.mendelu.xpaseka.pj.projekt.WeatherBoard;
import cz.mendelu.xpaseka.pj.projekt.cards.*;
import cz.mendelu.xpaseka.pj.projekt.cards.enumTypes.UnitType;
import cz.mendelu.xpaseka.pj.projekt.factions.NorthEmpire;
import greenfoot.Actor;
import greenfoot.Greenfoot;
import greenfoot.World;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Greenfoot World pro zobrazeni hlavni hry
 * Uchovava si pocet jednotlivych karet a pri zmene u hrace se jednotlive polozky zobrazi
 */

public class GwintWorld extends World {
    private int playerNumberOfCards = 0;
    private int opponentNumberOfCards = 0;

    private Player player;
    private Player opponent;

    private Map<UnitType, Position> positionsPlayer = new HashMap<>();
    private Map<UnitType, Position> positionsOpponent = new HashMap<>();

    private Map<BoardType, Integer> boardSizes = new HashMap<>();
    private Map<BoardType, Integer> boardSizesOp = new HashMap<>();

    private int playersHorns = 0;
    private int opponentsHorns = 0;

    enum BoardType {HAND, WEATHER, HORN}

    public static class Position{
        public int x;
        public int y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }


    public GwintWorld() {
        super(1600, 900, 1);
        setBackground("images/gwint-design3.png");

        this.player = Game.getPlayer();
        this.opponent = Game.getOpponent();

        // testing opponent build
        opponent.setFaction(new NorthEmpire());
        opponent.setLeader(3);
        opponent.setDeck(Game.buildDeck(opponent));
        opponent.setHand();

        setUp();
        renderActors();
    }

    public void setUp() {
        positionsPlayer.put(UnitType.CLOSE_COMBAT, new Position(542, 465));
        positionsPlayer.put(UnitType.LONG_RANGE, new Position(542, 578));
        positionsPlayer.put(UnitType.SIEGE, new Position(542, 693));

        positionsOpponent.put(UnitType.CLOSE_COMBAT, new Position(542, 332));
        positionsOpponent.put(UnitType.LONG_RANGE, new Position(542, 200));
        positionsOpponent.put(UnitType.SIEGE, new Position(542, 150));

        boardSizes.put(BoardType.HAND, 0);
        boardSizes.put(BoardType.WEATHER, 0);

        boardSizesOp.put(BoardType.HAND, 0);
    }

    public void renderActors() {
        // Leader card render
        addObject(new Actor() {
            {
                setImage(String.format("images/Leaders/%s/%s.png", player.getFaction().getName(), player.getLeader().getName()));
            }
        }, 196, 749);

        // faction logo render
        addObject(new Actor() {
            {
                setImage(String.format("images/factionLogos/smaller/%s.png", player.getFaction().getName()));
            }
        }, 60, 605);

        // Leader opponent card render
        addObject(new Actor() {
            {
                setImage(String.format("images/Leaders/%s/%s.png", opponent.getFaction().getName(), opponent.getLeader().getName()));
            }
        }, 196, 148);

        // faction opponent logo render
        addObject(new Actor() {
            {
                setImage(String.format("images/factionLogos/smaller/%s.png", opponent.getFaction().getName()));
            }
        }, 60, 290);

        addObject(new LifeActor(player, 2), 255, 580);
        addObject(new LifeActor(player, 1), 290, 580);

        addObject(new LifeActor(opponent, 2), 255, 265);
        addObject(new LifeActor(opponent, 1), 290, 265);

        addObject(new ScoreActor(player), 340, 602);
        addObject(new ScoreActor(opponent), 340, 288);

        // addObject(new RowScoreActor(Game.getPlayer(), UnitType.CLOSE_COMBAT), 120, 600);

        addObject(new DeckActor(player), 1435, 611);
        addObject(new DeckActor(opponent), 1435, 285);
        addObject(new DeckCounterActor(player), 1510, 611);
        addObject(new DeckCounterActor(opponent), 1500, 285);

        addObject(new DiscardPileActor(player), 1450, 800);
        addObject(new DiscardPileActor(opponent), 1450, 115);

        setPaintOrder(CardButtonActor.class, UnitTypeButtonActor.class, WeatherEffectActor.class, BoardCardActor.class);
    }

    @Override
    public void act() {
        // Players hand check
        if (boardSizes.get(BoardType.HAND) != player.getHand().size()) {
            boardSizes.put(BoardType.HAND, player.getHand().size());
            updateHand(player.getHand());
        }

        // WeatherBoard check
        if (boardSizes.get(BoardType.WEATHER) != WeatherBoard.getWeatherCards().size()) {
            boardSizes.put(BoardType.WEATHER, WeatherBoard.getWeatherCards().size());
            updateWeatherBoard();
            System.out.println(boardSizes.get(BoardType.WEATHER));
        }

        // Horn cards check
        if (countHorns(player) != playersHorns) {
            playersHorns = countHorns(player);
            renderHornCards(player, positionsPlayer);
        }
        if (countHorns(opponent) != opponentsHorns) {
            opponentsHorns = countHorns(opponent);
            renderHornCards(opponent, positionsOpponent);
        }

        // CombatBoard check
        if (playerNumberOfCards != getNumberOfCards(player.getCombatBoard())) {
            playerNumberOfCards = getNumberOfCards(player.getCombatBoard());
            updateCombatBoard();
        }
        if (opponentNumberOfCards != getNumberOfCards(opponent.getCombatBoard())) {
            opponentNumberOfCards = getNumberOfCards(opponent.getCombatBoard());
            updateCombatBoard();
        }

        if (Greenfoot.isKeyDown("x")) {
            player.useLeaderAbility();
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
        removeObjects(getObjects(HandCardActor.class));
        int i = 0;
        for (Card card : cards) {
            addObject(new HandCardActor(player, card, i), 420 + (i * 79), 813);
            i++;
        }
    }

    public void updateWeatherBoard() {
        removeObjects(getObjects(WeatherCardActor.class));
        removeObjects(getObjects(WeatherEffectActor.class));

        List<WeatherCard> cards = new ArrayList<>(WeatherBoard.getWeatherCards());
        int i = 0;
        for (WeatherCard card : cards) {
            addObject(new WeatherCardActor(card),110 + (i * 90), 450);
            addObject(new WeatherEffectActor(card.getWeatherType()), 0, 0);
            i++;
        }
    }

    public void updateCombatBoard() {
        removeObjects(getObjects(BoardCardActor.class));
        updateCombat(player.getCombatBoard().getAllUnits(), positionsPlayer);
        updateCombat(opponent.getCombatBoard().getAllUnits(), positionsOpponent);
    }

    public void updateCombat(Map<UnitType, List<UnitCard>> board, Map<UnitType, Position> positions) {
        for (List<UnitCard> cards : board.values()) {
            int i = 0;
            for (UnitCard card : cards) {
                var position = positions.get(card.getType());
                addObject(new BoardCardActor(card, i), position.x + (i * 79), position.y);
                i++;
            }
        }
    }

    public void renderUnitCardButtons(DecoyCard decoy, int indexHand) {
        var board = player.getCombatBoard().getAllUnits();
        var positions = positionsPlayer;
        for (List<UnitCard> cards : board.values()) {
            int i = 0;
            for (UnitCard card : cards) {
                var position = positions.get(card.getType());
                if (!(card instanceof DecoyCard)) {
                    addObject(new CardButtonActor(decoy, card.getType(), i, indexHand), position.x + (i * 79), position.y);
                }
                i++;
            }
        }
    }

    private void renderHornCards(Player player, Map<UnitType, Position> positions) {
        for (var hornsMap: player.getCombatBoard().getHornCards().entrySet()) {
            if (hornsMap.getValue() != null) {
                var position = positions.get(hornsMap.getKey());
                addObject(new Actor() {
                    {
                        setImage("images/cards/HD+/Commander's Horn.jpg");
                    }
                }, position.x - 100, position.y);
            }
        }
    }

    private int countHorns(Player player) {
        int numberOfHorns = 0;
        var horns = player.getCombatBoard().getHornCards();
        for (HornCard hornCard: horns.values()) {
            if (hornCard != null) {
                numberOfHorns++;
            }
        }
        return numberOfHorns;
    }

    public void setPlayableHand(boolean playableHand) {
        var hand = getObjects(HandCardActor.class);
        for (var card: hand) {
            card.setPlayable(playableHand);
        }
    }



    public void reload() {
        player = Game.getPlayer();
        opponent = Game.getOpponent();
    }
}
