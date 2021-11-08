package cz.mendelu.xpaseka.pj.projekt.factions;

import cz.mendelu.xpaseka.pj.projekt.Player;
import cz.mendelu.xpaseka.pj.projekt.cards.Card;

import java.util.List;

public class NorthEmpire extends Faction {

    public NorthEmpire(Player player)  {
        super(player);
        name = "North Empire";
    }

    /**
     * Metoda pro využití efektu hráčovi frakce - může být využita hráčem pouze jednou za hru
     * Efekt frakce NorthEmpire přidělí hráči kartu z odkládacího balíčku pokud vyhraje kolo
     *
     * @author xpaseka
     * @version etapa 2
     * @version etapa 3
     */
    @Override
    public void applyEffect() {
        List<Card> deck = player.getDeck();
        int deckSize = deck.size();
        Card card = deck.remove(deckSize-1);
        player.addCardToHand(card);
    }
}
