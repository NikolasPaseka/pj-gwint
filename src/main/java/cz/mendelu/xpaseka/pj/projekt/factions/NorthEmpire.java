package cz.mendelu.xpaseka.pj.projekt.factions;

import cz.mendelu.xpaseka.pj.projekt.Player;

public class NorthEmpire extends Faction {

    public NorthEmpire(Player player) {
        super(player);
    }

    /**
     * Metoda pro využití efektu hráčovi frakce - může být využita hráčem pouze jednou za hru
     * Efekt frakce NorthEmpire přidělí hráči kartu z odkládacího balíčku pokud vyhraje kolo
     *
     * @author xpaseka
     * @version etapa 2
     */
    public void applyEffect() {
        System.out.println("Draw a card if you win a round");
    }

    public void applyAbility() {
        System.out.println("Destroy your enemy's strongest Ranged Combat unit(s) if the combined strength of all his or her Ranged Combat units is 10 or more");
    }
}
