package cz.mendelu.xpaseka.pj.projekt.cards;

import cz.mendelu.xpaseka.pj.projekt.Game;
import cz.mendelu.xpaseka.pj.projekt.cards.enumTypes.FactionType;
import cz.mendelu.xpaseka.pj.projekt.cards.enumTypes.UnitType;

import java.util.List;

public class MoraleCard extends UnitCard {
    public MoraleCard(UnitType type, int power, String name, FactionType faction, boolean hero) {
        super(type, power, name, faction, hero);
    }

    public MoraleCard(MoraleCard card) {
        this(card.getType(), card.getPower(), card.getName(), card.getFaction(), card.isHero());
    }

    @Override
    public MoraleCard cloneObject() {
        return new MoraleCard(this);
    }

    /**
     * Přidá kartu jednotky na hráčovu hrací desku a použije efekt MoraleCard
     * Karta prida vsem ostatnim jednotkam +1 k sile v danem radku (i kdyz jsou aplikovane dalsi efekty)
     * Silu nepridava sobe a hrdinskym kartam
     *
     */
    @Override
    public void applyCard() {
        System.out.println("Playing Morale Card");
        var player = Game.getGameInstance().getPlayer();
        var unitCards = player.getCombatBoard().getRow(this.getType());

        for (UnitCard card: unitCards) {
            if (!card.isHero())
                card.setCurrentPower(card.getCurrentPower() + 1);
        }
        super.applyCard();
    }

    @Override
    public void removeEffect() {
        var player = Game.getGameInstance().getPlayer();
        var unitCards = player.getCombatBoard().getRow(this.getType());

        for (UnitCard card: unitCards) {
            if (!card.isHero() && card.getCurrentPower() > card.getPower())
                card.setCurrentPower(card.getCurrentPower() - 1);
        }
        super.removeEffect();
    }
}
