import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class PlayerTest {

    Player player1;
    Die die1;
    Die die2;
    Die die3;
    Die die4;
    Die die5;
    ArrayList<Die> dice;
    ScoreSheet scoresheet;
    ArrayList<Boolean> diceToHold;

    @Before
    public void before(){

        die1 = new Die();
        die1.setValue(1);
        die2 = new Die();
        die2.setValue(2);
        die3 = new Die();
        die3.setValue(3);
        die4 = new Die();
        die4.setValue(4);
        die5 = new Die();
        die5.setValue(5);
        dice = new ArrayList<>();
        dice.addAll(Arrays.asList(die1, die2, die3, die4, die5));
        player1 = new Player("Dave", dice);
        scoresheet = new ScoreSheet();
        diceToHold = new ArrayList<>();
        diceToHold.addAll(Arrays.asList(true, true, false, false, true));

    }

    @Test
    public void playerHasName(){
        assertEquals("Dave", player1.getName());
    }

    @Test
    public void playerHasDiceArrayList(){
        assertEquals(dice, player1.getDice());
    }

    @Test
    public void playerHasScoreSheet(){
        assertEquals(scoresheet.getScores(), player1.getScoreSheet().getScores());
        assertEquals(scoresheet.getUpperSectionScore(), player1.getScoreSheet().getUpperSectionScore());
        assertEquals(scoresheet.getTotalScore(), player1.getScoreSheet().getTotalScore());
    }

    @Test
    public void playerHasRollCount(){
        assertEquals(0, player1.getRollCount());
    }

    @Test
    public void canAssignScoreToScoreLineOnPlayersScoreSheet(){
        player1.getScoreSheet().setSingleScore(ScoreLine.ONES, dice);
        assertEquals(1, player1.getScoreSheet().getSingleScore(ScoreLine.ONES));
    }

    @Test
    public void canPlayTurnWhenRollCountIsZero(){
        player1.playTurn();
        int numberOfDice = dice.size();
        for (int i = 0; i < numberOfDice; i++){
            System.out.println("die Value: " + dice.get(i).getValue());
            assertFalse(dice.get(i).getValue() > 6);
            assertFalse(dice.get(i).getValue() < 1);
        }
        assertEquals(1, player1.getRollCount());
    }

    @Test
    public void canPlayTurnWhenRollCountIsOne(){
        int numberOfDice = dice.size();
        player1.playTurn();
        player1.playTurn(diceToHold);

        for (int i = 0; i < numberOfDice; i++){
            System.out.println("die Value: " + dice.get(i).getValue());
            assertFalse(dice.get(i).getValue() > 6);
            assertFalse(dice.get(i).getValue() < 1);
        }
        assertEquals(2, player1.getRollCount());
    }

    @Test
    public void canPlayTurnWhenRollCountIsTwo(){
        int numberOfDice = dice.size();
        player1.playTurn();
        player1.playTurn(diceToHold);
        player1.playTurn(diceToHold);

        for (int i = 0; i < numberOfDice; i++){
            System.out.println("die Value: " + dice.get(i).getValue());
            assertFalse(dice.get(i).getValue() > 6);
            assertFalse(dice.get(i).getValue() < 1);
        }
        assertEquals(3, player1.getRollCount());
    }

    @Test
    public void canPlayTurnWhenRollCountIsThree(){
        int numberOfDice = dice.size();
        player1.playTurn();
        player1.playTurn(diceToHold);
        player1.playTurn(diceToHold);
        player1.playTurn(ScoreLine.ONES);

        for (int i = 0; i < numberOfDice; i++){
            System.out.println("die Value: " + dice.get(i).getValue());
            assertFalse(dice.get(i).getValue() > 6);
            assertFalse(dice.get(i).getValue() < 1);
        }
        assertEquals(0, player1.getRollCount());
    }
}
