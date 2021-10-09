package cz.mendelu.xpaseka.pj.projekt;

import cz.mendelu.xpaseka.pj.projekt.cards.Card;
import cz.mendelu.xpaseka.pj.projekt.cards.HornCard;
import cz.mendelu.xpaseka.pj.projekt.cards.TypeOfCard;
import cz.mendelu.xpaseka.pj.projekt.cards.UnitCard;

import java.util.ArrayList;
import java.util.List;

public class CombatBoard {
    private List<UnitCard> closeCombatRow;
    private List<UnitCard> longRangeRow;
    private List<UnitCard> siegeRow;
    private HornCard closeCombatRowHorn;
    private HornCard longRangeRowHorn;
    private HornCard siegeRowHorn;
    private int closeCombatScore = 0;
    private int longRangeScore = 0;
    private int siegeScore = 0;

    CombatBoard() {
        closeCombatRow = new ArrayList<>();
        longRangeRow = new ArrayList<>();
        siegeRow = new ArrayList<>();
        closeCombatRowHorn = null;
        longRangeRowHorn = null;
        siegeRowHorn = null;
    }

    public void addCard(UnitCard card) {
        if (card.getType() == TypeOfCard.CLOSE_COMBAT) {
            closeCombatRow.add(card);
            closeCombatScore += card.getCurrentPower();
        } else if (card.getType() == TypeOfCard.LONG_RANGE) {
            longRangeRow.add(card);
            longRangeScore += card.getCurrentPower();
        } else if (card.getType() == TypeOfCard.SIEGE) {
            siegeRow.add(card);
            siegeScore += card.getCurrentPower();
        }
    }

    public void addHornCard(HornCard horn) {
        if (closeCombatRowHorn == null) {
            closeCombatRowHorn = horn;
            closeCombatScore *= 2;
        } else if (longRangeRowHorn == null) {
            longRangeRowHorn = horn;
            longRangeScore *= 2;
        } else if (siegeRowHorn == null) {
            siegeRowHorn = horn;
            longRangeScore *= 2;
        }
    }

    public void changeCardsPower(TypeOfCard type, int power) {
        if (type == TypeOfCard.LONG_RANGE) {
            for (UnitCard card: longRangeRow) {
                card.setCurrentPower(power);
            }
        }
    }

    public void resetCurrentPower() {
        for (UnitCard card: closeCombatRow) {
            card.resetCurrentPower();
        }
        for (UnitCard card: longRangeRow) {
            card.resetCurrentPower();
        }
        for (UnitCard card: siegeRow) {
            card.resetCurrentPower();
        }
    }

    public int getTotalScore() {
        int score = 0;
        for (UnitCard card: closeCombatRow) {
            score += card.getCurrentPower();
        }
        for (UnitCard card: longRangeRow) {
            score += card.getCurrentPower();
        }
        for (UnitCard card: siegeRow) {
            score += card.getCurrentPower();
        }
        return score;
    }
}
