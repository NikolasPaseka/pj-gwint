package cz.mendelu.xpaseka.pj.projekt.greenfoot;

import cz.mendelu.xpaseka.pj.projekt.Player;
import cz.mendelu.xpaseka.pj.projekt.cards.Card;
import cz.mendelu.xpaseka.pj.projekt.cards.HornCard;
import cz.mendelu.xpaseka.pj.projekt.cards.UnitCard;
import cz.mendelu.xpaseka.pj.projekt.cards.enumTypes.UnitType;
import greenfoot.Actor;
import greenfoot.Greenfoot;

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
//        setImage("images/cards/test2.jpg");
    }

    @Override
    public void act() {
        if (Greenfoot.mouseClicked(this) && playable) {
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
            getWorld().addObject(new HornButtonActor(index, UnitType.CLOSE_COMBAT), 500, 450);
            getWorld().addObject(new HornButtonActor(index, UnitType.LONG_RANGE), 850, 450);
            getWorld().addObject(new HornButtonActor(index, UnitType.SIEGE), 1200, 450);

            var handCards = getWorld().getObjects(HandCardActor.class);
            for (HandCardActor handCardActor : handCards) {
                handCardActor.setPlayable(false);
            }
        } else {
            player.playCard(index);
        }
    }

    public void setPlayable(boolean playable) {
        this.playable = playable;
    }
}
