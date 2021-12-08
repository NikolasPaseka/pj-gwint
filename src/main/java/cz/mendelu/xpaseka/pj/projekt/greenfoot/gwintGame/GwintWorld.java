package cz.mendelu.xpaseka.pj.projekt.greenfoot.gwintGame;

import cz.mendelu.xpaseka.pj.projekt.*;
import cz.mendelu.xpaseka.pj.projekt.cards.*;
import cz.mendelu.xpaseka.pj.projekt.cards.enumTypes.UnitType;
import cz.mendelu.xpaseka.pj.projekt.greenfoot.gwintGame.counters.DeckCounterActor;
import cz.mendelu.xpaseka.pj.projekt.greenfoot.gwintGame.counters.HandCounterActor;
import cz.mendelu.xpaseka.pj.projekt.greenfoot.gwintGame.counters.ScoreActor;
import cz.mendelu.xpaseka.pj.projekt.network.Network;
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
    private boolean finishedRound = false;

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

    private boolean opponentConnected = false;

    public GwintWorld() {
        super(1600, 900, 1);
        setBackground("images/gwint-design3.png");

        this.player = Game.getGameInstance().getPlayer();
        this.opponent = Game.getGameInstance().getOpponent();

        // testing opponent build
//        opponent.setFaction(new NorthEmpire());
//        opponent.setLeader(3);
//        opponent.setDeck(Game.buildDeck(opponent));
//        opponent.setHand();

        setUpIPAddress();
        setUp();
        renderActors();
    }

    private void setUp() {
        positionsPlayer.put(UnitType.CLOSE_COMBAT, new Position(542, 465));
        positionsPlayer.put(UnitType.LONG_RANGE, new Position(542, 578));
        positionsPlayer.put(UnitType.SIEGE, new Position(542, 693));

        positionsOpponent.put(UnitType.CLOSE_COMBAT, new Position(542, 322));
        positionsOpponent.put(UnitType.LONG_RANGE, new Position(542, 210));
        positionsOpponent.put(UnitType.SIEGE, new Position(542, 95));

        boardSizes.put(BoardType.HAND, 0);
        boardSizes.put(BoardType.WEATHER, 0);

        boardSizesOp.put(BoardType.HAND, 0);
    }

    private void renderActors() {
        // Leader card render
        addObject(new LeaderActor(player.getFaction(), player.getLeader()), 196, 749);

        // faction logo render
        addObject(new Actor() {
            {
                setImage(String.format("images/factionLogos/smaller/%s.png", player.getFaction().getName()));
            }
        }, 60, 605);


        addObject(new LifeActor(PlayerEnum.PLAYER, 2), 255, 580);
        addObject(new LifeActor(PlayerEnum.PLAYER, 1), 290, 580);

        addObject(new LifeActor(PlayerEnum.OPPONENT, 2), 255, 265);
        addObject(new LifeActor(PlayerEnum.OPPONENT, 1), 290, 265);

        addObject(new HandCounterActor(PlayerEnum.PLAYER), 160, 625);
        addObject(new HandCounterActor(PlayerEnum.OPPONENT), 160, 310);

        addObject(new FinishedPlayingActor(PlayerEnum.PLAYER), 100, 760);
        addObject(new FinishedPlayingActor(PlayerEnum.OPPONENT), 100, 160);

        addObject(new ScoreActor(PlayerEnum.PLAYER), 340, 602);
        addObject(new ScoreActor(PlayerEnum.OPPONENT), 340, 288);

        // addObject(new RowScoreActor(Game.getPlayer(), UnitType.CLOSE_COMBAT), 120, 600);

        addObject(new DeckActor(PlayerEnum.PLAYER), 1435, 611);
        addObject(new DeckActor(PlayerEnum.OPPONENT), 1435, 285);
        addObject(new DeckCounterActor(PlayerEnum.PLAYER), 1500, 611);
        addObject(new DeckCounterActor(PlayerEnum.OPPONENT), 1500, 285);

        addObject(new DiscardPileActor(PlayerEnum.PLAYER), 1435, 770);
        addObject(new DiscardPileActor(PlayerEnum.OPPONENT), 1435, 128);

        addObject(new OnMoveLabelActor(Game.getGameInstance().getPlayerOnMove()), 1450, 420);

        addObject(new LeaderAbilityActor(), 300, 850);
        addObject(new FinishRoundButtonActor(), 100, 850);

        setPaintOrder(SubMenuActor.class, CardButtonActor.class, UnitTypeButtonActor.class, WeatherEffectActor.class, BoardCardActor.class);
    }

    private void setUpIPAddress() {
        String ipAddress = Greenfoot.ask("ip address of your opponent: ");
        Network.createClient(ipAddress);
        Network.getClient().sent();

        if (!Network.getServer().getConnected()) {
            System.out.println("You are first");
            Game.getGameInstance().setPlayerOnMove(PlayerEnum.PLAYER);
        } else {
            System.out.println("You are second");
            Game.getGameInstance().setPlayerOnMove(PlayerEnum.OPPONENT);
        }
        //Game.getGameInstance().setPlayerOnMove(PlayerEnum.PLAYER);
    }

    @Override
    public void act() {
        renderNetworkChanges();
        renderObjects();

        if (player.getFinishedRound() && opponent.getFinishedRound()) {
            var submenu = new SubMenuActor();
            addObject(submenu, 800, 400);
            if (player.getTotalScore() > opponent.getTotalScore()) {
                submenu.showEndRound(PlayerEnum.PLAYER);
            } else if (player.getTotalScore() < opponent.getTotalScore()) {
                submenu.showEndRound(PlayerEnum.OPPONENT);
            } else {
                submenu.showEndRound(null);
            }
            Game.getGameInstance().startNewRound();
            getObjects(FinishRoundButtonActor.class).get(0).resetFinishedRound();
        }
    }

    private void renderNetworkChanges() {
        // check connection
        if (!opponentConnected && Network.getServer().getConnected()) {
            System.out.println("connected");
            opponentConnected = true;
            opponent = Game.getGameInstance().getOpponent();
            // Leader opponent card render
            addObject(new LeaderActor(opponent.getFaction(), opponent.getLeader()), 196, 148);

            // faction opponent logo render
            addObject(new Actor() {
                {
                    setImage(String.format("images/factionLogos/smaller/%s.png", opponent.getFaction().getName()));
                }
            }, 60, 290);

            getObjects(DeckActor.class).get(0).setDeckImage();
            getObjects(DeckActor.class).get(1).setDeckImage();
        }

        // Check players change
        if (opponent != Game.getGameInstance().getOpponent()) {
            opponent = Game.getGameInstance().getOpponent();
            updateCombatBoard();
        }
        if (player != Game.getGameInstance().getPlayer()) {
            player = Game.getGameInstance().getPlayer();
            updateCombatBoard();
            updateHand(player.getHand());
        }
    }

    private void renderObjects() {
        // Players hand check
        if (boardSizes.get(BoardType.HAND) != player.getHand().size()) {
            boardSizes.put(BoardType.HAND, player.getHand().size());
            updateHand(player.getHand());
        }

        // WeatherBoard check
        var weatherBoard = Game.getGameInstance().getWeatherBoard();
        if (boardSizes.get(BoardType.WEATHER) != weatherBoard.getWeatherCards().size()) {
            boardSizes.put(BoardType.WEATHER, weatherBoard.getWeatherCards().size());
            updateWeatherBoard();
            weatherBoard.reapplyWeatherEffects();
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

        var weatherBoard = Game.getGameInstance().getWeatherBoard();
        List<WeatherCard> cards = new ArrayList<>(weatherBoard.getWeatherCards());
        int i = 0;
        for (WeatherCard card : cards) {
            addObject(new WeatherCardActor(card),110 + (i * 90), 450);
            addObject(new WeatherEffectActor(card.getWeatherType(), PlayerEnum.PLAYER), 0, 0);
            addObject(new WeatherEffectActor(card.getWeatherType(), PlayerEnum.OPPONENT), 0, 0);
            i++;
        }
    }

    public void updateCombatBoard() {
        removeObjects(getObjects(BoardCardActor.class));
        updateCombat(player.getCombatBoard().getAllUnits(), positionsPlayer);
        updateCombat(opponent.getCombatBoard().getAllUnits(), positionsOpponent);
    }

    public void updateCombat(Map<UnitType, List<UnitCard>> board, Map<UnitType, Position> positions) {
        int cardOffset = 79;
        for (List<UnitCard> cards : board.values()) {
            int i = 0;
            if (cards.size() >= 10) {
                cardOffset = 790 / cards.size();
            }
            for (UnitCard card : cards) {
                var position = positions.get(card.getType());
                addObject(new BoardCardActor(card, i), position.x + (i * cardOffset), position.y);
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
        removeObjects(getObjects(HornActor.class));
        for (var hornsMap: player.getCombatBoard().getHornCards().entrySet()) {
            if (hornsMap.getValue() != null) {
                var position = positions.get(hornsMap.getKey());
                addObject(new HornActor(), position.x - 100, position.y);
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
        removeObjects(getObjects(CancelMoveActor.class));

        var hand = getObjects(HandCardActor.class);
        for (var card: hand) {
            card.setPlayable(playableHand);
        }
    }

    public void reload() {
        player = Game.getGameInstance().getPlayer();
        opponent = Game.getGameInstance().getOpponent();
    }
}
