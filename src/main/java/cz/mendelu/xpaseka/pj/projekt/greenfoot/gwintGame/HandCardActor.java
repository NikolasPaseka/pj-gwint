package cz.mendelu.xpaseka.pj.projekt.greenfoot.gwintGame;

import cz.mendelu.xpaseka.pj.projekt.Game;
import cz.mendelu.xpaseka.pj.projekt.Player;
import cz.mendelu.xpaseka.pj.projekt.cards.*;
import cz.mendelu.xpaseka.pj.projekt.cards.enumTypes.UnitType;
import greenfoot.Actor;
import greenfoot.Greenfoot;

/**
 * Actor pro zobrazeni hracich karet v hracove ruce
 * Pri kliknuti se zahraje konkretni karta podle parametru Index
 *
 * @author xpaseka
 * @version etapa 4
 */

public class HandCardActor extends Actor {
    private final Card card;
    private final Player player;

    private boolean playable = true;
    private int index;

    public HandCardActor(Player player, Card card, int index) {
        this.player = player;
        this.card = card;
        this.index = index;
        if (card instanceof UnitCard) {
            setImage(String.format("images/cards/HD+/%s/%s.jpg", ((UnitCard) card).getFaction().name(), card.getName()));
        } else {
            setImage(String.format("images/cards/HD+/%s.jpg", card.getName()));
        }
        if (card instanceof UnitCard) {
            setPower();
        }
    }

    @Override
    public void act() {
        if (Greenfoot.mouseClicked(this) && playable && Game.getGameInstance().getPlayerOnMove() == PlayerEnum.PLAYER) {
            playCard();
        }
    }

    public void setPower() {
        var cardPower = ((UnitCard) card).getCurrentPower();

        String powerString = String.valueOf(cardPower);

        // soumerne vykresleni vetsich i mensich cisel
        if (cardPower < 10) {
            getImage().drawString(powerString, 8, 15);
        } else {
            getImage().drawString(powerString, 4, 15);
        }
    }

    public void playCard() {
        if (card instanceof HornCard) {
            getWorld().addObject(new HornButtonActor(index, UnitType.CLOSE_COMBAT), 447, 465);
            getWorld().addObject(new HornButtonActor(index, UnitType.LONG_RANGE), 447, 575);
            getWorld().addObject(new HornButtonActor(index, UnitType.SIEGE), 447, 685);
            ((GwintWorld) getWorld()).setPlayableHand(false);
            getWorld().addObject(new CancelMoveActor(), 1450, 490);
        } else if (card instanceof AgileCard) {
            getWorld().addObject(new UnitTypeButtonActor((AgileCard) card, index, ((AgileCard) card).getType()), 0, 0);
            getWorld().addObject(new UnitTypeButtonActor((AgileCard) card, index, ((AgileCard) card).getSecondUnitType()), 0, 0);
            ((GwintWorld) getWorld()).setPlayableHand(false);
            getWorld().addObject(new CancelMoveActor(), 1450, 490);
        } else if (card instanceof DecoyCard) {
            ((GwintWorld) getWorld()).renderUnitCardButtons((DecoyCard) card, index);
            ((GwintWorld) getWorld()).setPlayableHand(false);
            getWorld().addObject(new CancelMoveActor(), 1450, 490);
        } else {
            player.playCard(index);
        }
    }

    public void setPlayable(boolean playable) {
        this.playable = playable;
    }
}
