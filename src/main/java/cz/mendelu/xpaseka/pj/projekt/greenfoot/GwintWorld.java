package cz.mendelu.xpaseka.pj.projekt.greenfoot;

import cz.mendelu.xpaseka.pj.projekt.Game;
import cz.mendelu.xpaseka.pj.projekt.cards.enumTypes.UnitType;
import cz.mendelu.xpaseka.pj.projekt.factions.NorthEmpire;
import greenfoot.World;

public class GwintWorld extends World {
    public UnitType unitTypeSelection = null;

    public GwintWorld() {
        super(1600, 900, 1);
        setBackground("images/design-hd+.jpg");

        addObject(new ScoreActor(Game.getPlayer()), 90, 600);
        addObject(new ScoreActor(Game.getOpponent()), 90, 115);

        addObject(new DeckActor(Game.getPlayer()), 1435, 611);
        addObject(new DeckActor(Game.getOpponent()), 1450, 200);
        addObject(new DeckCounterActor(Game.getPlayer()), 1510, 611);
        addObject(new DeckCounterActor(Game.getOpponent()), 1500, 200);

        addObject(new DiscardPileActor(Game.getPlayer()), 1450, 800);
        addObject(new DiscardPileActor(Game.getOpponent()), 1450, 115);

        addObject(new BoardActor(), 0, 0);

        Game.buildDeck(Game.getPlayer());
    }

    public void selectUnitType() {
        while (unitTypeSelection == null) {

        }
    }
}
