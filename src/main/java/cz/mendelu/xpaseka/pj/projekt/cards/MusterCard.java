package cz.mendelu.xpaseka.pj.projekt.cards;

import cz.mendelu.xpaseka.pj.projekt.Game;
import cz.mendelu.xpaseka.pj.projekt.cards.enumTypes.FactionType;
import cz.mendelu.xpaseka.pj.projekt.cards.enumTypes.UnitType;

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
        Game.getPlayer().addCardToCombatBoard(this);
        List<Card> playersDeck = Game.getPlayer().getDeck();

        for (int i = 0; i < playersDeck.size(); i++) {
            if (playersDeck.get(i).getName().equals(name) && playersDeck.get(i) instanceof UnitCard) {
                Game.getPlayer().addCardToCombatBoard((UnitCard) playersDeck.remove(i));
            }
        }
    }
}