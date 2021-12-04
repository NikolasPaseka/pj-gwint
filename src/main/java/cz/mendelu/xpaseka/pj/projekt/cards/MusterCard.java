package cz.mendelu.xpaseka.pj.projekt.cards;

import cz.mendelu.xpaseka.pj.projekt.Game;
import cz.mendelu.xpaseka.pj.projekt.cards.enumTypes.FactionType;
import cz.mendelu.xpaseka.pj.projekt.cards.enumTypes.UnitType;

import java.util.Iterator;
import java.util.List;

public class MusterCard extends UnitCard {
    public MusterCard(UnitType type, int power, String name, FactionType faction, boolean hero) {
        super(type, power, name, faction, hero);
    }

    public MusterCard(MusterCard card) {
        this(card.getType(), card.getPower(), card.getName(), card.getFaction(), card.isHero());
    }

    @Override
    public MusterCard cloneObject() {
        return new MusterCard(this);
    }

    /**
     * Přidá kartu jednotky na hráčovu hrací desku a použije efekt MusterCard
     * Efekt MusterCard nalezne všechny stejné jednotky v odkládacím báličku hráče a vyloží na stůl
     *
     *
     * @author xpaseka
     * @version etapa 2
     * @version etapa 3
     */
    @Override
    public void applyCard() {
        System.out.println("Playing Muster card");
        super.applyCard();

        var player = Game.getGameInstance().getPlayer();
        List<Card> playersDeck = player.getDeck();
        Iterator<Card> iterator = playersDeck.listIterator();

        while (iterator.hasNext()) {
            var card = iterator.next();
            if (card.getName().equals(name) && card instanceof UnitCard) {
                player.addCardToCombatBoard((UnitCard) card);
                iterator.remove();
            }
        }
    }
}