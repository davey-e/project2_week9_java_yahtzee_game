import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class ScoreSheetTest {

    ScoreSheet scoreSheet;
    HashMap<ScoreLine, Integer> scores;
    Die die1;
    Die die2;
    Die die3;
    Die die4;
    Die die5;
    Die die6;
    Die die7;
    ArrayList<Die> dice;
    ArrayList<Die> dice2;
    ArrayList<Die> dice3;

    @Before
    public void before(){
        scoreSheet = new ScoreSheet();
        scores = new HashMap<>();
        scores.put(ScoreLine.ONES, null);
        scores.put(ScoreLine.TWOS, null);
        scores.put(ScoreLine.THREES, null);
        scores.put(ScoreLine.FOURS, null);
        scores.put(ScoreLine.FIVES, null);
        scores.put(ScoreLine.SIXES, null);
        scores.put(ScoreLine.THREEOAK, null);
        scores.put(ScoreLine.FOUROAK, null);
        scores.put(ScoreLine.FH, null);
        scores.put(ScoreLine.SMALLSTR, null);
        scores.put(ScoreLine.LARGESTR, null);
        scores.put(ScoreLine.YAHTZEE, null);
        scores.put(ScoreLine.CHANCE, null);
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
        die6 = new Die();
        die6.setValue(1);
        dice2 = new ArrayList<>();
        dice2.addAll(Arrays.asList(die1, die2, die3, die4, die6));
        die7 = new Die();
        die7.setValue(6);
        dice3 = new ArrayList<>();
        dice3.addAll(Arrays.asList(die1, die2, die3, die4, die7));


    }

    @Test
    public void scoreSheetHasScores(){
        assertEquals(scores, scoreSheet.getScores());
    }

    @Test
    public void canGetSingleScore(){
        scoreSheet.setSingleScore(ScoreLine.ONES, dice);
        assertEquals(1, scoreSheet.getSingleScore(ScoreLine.ONES));
    }

    @Test
    public void scoreSheetHasUpperSectionScore(){
        assertEquals(0, scoreSheet.getUpperSectionScore());
    }

    @Test
    public void scoreSheetHasUpperSectionBonus(){
        assertEquals(0, scoreSheet.getUpperSectionBonus());
    }

    @Test
    public void scoreSheetHasLowerSectionScore(){
        assertEquals(0, scoreSheet.getLowerSectionScore());

    }

    @Test
    public void scoreSheetHasTotalScore(){
        assertEquals(0, scoreSheet.getTotalScore());
    }

    @Test
    public void canSetScoreInUpperSection(){
        int status1 = scoreSheet.setSingleScore(ScoreLine.ONES, dice);
        assertEquals(1, scoreSheet.getSingleScore(ScoreLine.ONES));
        assertEquals(0, status1);
        int status2 = scoreSheet.setSingleScore(ScoreLine.TWOS, dice);
        assertEquals(2, scoreSheet.getSingleScore(ScoreLine.TWOS));
        assertEquals(0, status2);
        int status3 = scoreSheet.setSingleScore(ScoreLine.THREES, dice);
        assertEquals(3, scoreSheet.getSingleScore(ScoreLine.THREES));
        assertEquals(0, status3);
    }

    @Test
    public void canSetScoreInLowerSection(){
        int status1 = scoreSheet.setSingleScore(ScoreLine.CHANCE, dice);
        assertEquals(15, scoreSheet.getSingleScore(ScoreLine.CHANCE));
    }

    @Test
    public void setScoreToZeroIfNoDiceMatchScoreLine(){
        int status = scoreSheet.setSingleScore(ScoreLine.SIXES, dice);
        assertEquals(0, scoreSheet.getSingleScore(ScoreLine.SIXES));
        assertEquals(1, status);
    }

    @Test
    public void wontSetScoreIfScoreLineAlreadyHasScore__UpperSection(){
        int status = scoreSheet.setSingleScore(ScoreLine.ONES, dice);
        assertEquals(1, scoreSheet.getSingleScore(ScoreLine.ONES));
        assertEquals(0, status);
        status = scoreSheet.setSingleScore(ScoreLine.ONES, dice2);
        assertEquals(1, scoreSheet.getSingleScore(ScoreLine.ONES));
        assertEquals(2, status);
    }

    @Test
    public void wontSetScoreIfScoreLineAlreadyHasScore__LowerSection(){
        int status = scoreSheet.setSingleScore(ScoreLine.CHANCE, dice);
        assertEquals(15, scoreSheet.getSingleScore(ScoreLine.CHANCE));
        assertEquals(0, status);
        status = scoreSheet.setSingleScore(ScoreLine.CHANCE, dice2);
        assertEquals(15, scoreSheet.getSingleScore(ScoreLine.CHANCE));
        assertEquals(2, status);
    }

    @Test
    public void canSetUpperSectionScore(){
        scoreSheet.setUpperSectionScore(3);
        assertEquals(3, scoreSheet.getUpperSectionScore());
    }

    @Test
    public void canSetTotalScore(){
        scoreSheet.setTotalScore(10);
        assertEquals(10, scoreSheet.getTotalScore());
    }

    @Test
    public void canCalculateUpperSectionScore(){
        scoreSheet.setSingleScore(ScoreLine.ONES, dice);
        scoreSheet.setSingleScore(ScoreLine.TWOS, dice);
        scoreSheet.setSingleScore(ScoreLine.THREES, dice);
        scoreSheet.setSingleScore(ScoreLine.FOURS, dice);
        scoreSheet.setSingleScore(ScoreLine.FIVES, dice);
        scoreSheet.setSingleScore(ScoreLine.SIXES, dice3);
        scoreSheet.calculateUpperSectionScore();
        assertEquals(21, scoreSheet.getUpperSectionScore());
        assertEquals(0, scoreSheet.getUpperSectionBonus());
    }

    @Test
    public void canCalculateLowerSectionScore(){
        scoreSheet.setSingleScore(ScoreLine.THREEOAK, dice);
        scoreSheet.setSingleScore(ScoreLine.FOUROAK, dice);
        scoreSheet.setSingleScore(ScoreLine.FH, dice);
        scoreSheet.setSingleScore(ScoreLine.SMALLSTR, dice);
        scoreSheet.setSingleScore(ScoreLine.LARGESTR, dice);
        scoreSheet.setSingleScore(ScoreLine.YAHTZEE, dice);
        scoreSheet.setSingleScore(ScoreLine.CHANCE, dice);
        scoreSheet.calculateLowerSectionScore();
        assertEquals(190, scoreSheet.getLowerSectionScore());
    }

    @Test
    public void canCalculateUpperSectionScoreWithBonus(){
        Die die1 = new Die();
        die1.setValue(1);
        Die die2 = new Die();
        die2.setValue(2);
        Die die3 = new Die();
        die3.setValue(3);
        Die die4 = new Die();
        die4.setValue(4);
        Die die5 = new Die();
        die5.setValue(5);
        Die die6 = new Die();
        die6.setValue(6);

        ArrayList<Die> diceOnes = new ArrayList<>();
        diceOnes.addAll(Arrays.asList(die1, die1, die1, die2, die2));
        ArrayList<Die> diceTwos= new ArrayList<>();
        diceTwos.addAll(Arrays.asList(die2, die2, die2, die3, die3));
        ArrayList<Die> diceThrees = new ArrayList<>();
        diceThrees.addAll(Arrays.asList(die3, die3, die3, die4, die4));
        ArrayList<Die> diceFours = new ArrayList<>();
        diceFours.addAll(Arrays.asList(die4, die4, die4, die5, die5));
        ArrayList<Die> diceFives = new ArrayList<>();
        diceFives.addAll(Arrays.asList(die5, die5, die5, die6, die6));
        ArrayList<Die> diceSixes = new ArrayList<>();
        diceSixes.addAll(Arrays.asList(die6, die6, die6, die1, die1));

        scoreSheet.setSingleScore(ScoreLine.ONES, diceOnes);
        scoreSheet.setSingleScore(ScoreLine.TWOS, diceTwos);
        scoreSheet.setSingleScore(ScoreLine.THREES, diceThrees);
        scoreSheet.setSingleScore(ScoreLine.FOURS, diceFours);
        scoreSheet.setSingleScore(ScoreLine.FIVES, diceFives);
        scoreSheet.setSingleScore(ScoreLine.SIXES, diceSixes);
        scoreSheet.calculateUpperSectionScore();
        assertEquals(63, scoreSheet.getUpperSectionScore());
        assertEquals(35, scoreSheet.getUpperSectionBonus());
    }

    @Test
    public void canCalculateTotalScore(){
        scoreSheet.setSingleScore(ScoreLine.ONES, dice);
        scoreSheet.setSingleScore(ScoreLine.TWOS, dice);
        scoreSheet.setSingleScore(ScoreLine.THREES, dice);
        scoreSheet.setSingleScore(ScoreLine.FOURS, dice);
        scoreSheet.setSingleScore(ScoreLine.FIVES, dice);
        scoreSheet.setSingleScore(ScoreLine.SIXES, dice3);
        scoreSheet.calculateUpperSectionScore();
        scoreSheet.setSingleScore(ScoreLine.THREEOAK, dice);
        scoreSheet.setSingleScore(ScoreLine.FOUROAK, dice);
        scoreSheet.setSingleScore(ScoreLine.FH, dice);
        scoreSheet.setSingleScore(ScoreLine.SMALLSTR, dice);
        scoreSheet.setSingleScore(ScoreLine.LARGESTR, dice);
        scoreSheet.setSingleScore(ScoreLine.YAHTZEE, dice);
        scoreSheet.setSingleScore(ScoreLine.CHANCE, dice);
        scoreSheet.calculateLowerSectionScore();
        scoreSheet.calculateTotalScore();
        assertEquals(211, scoreSheet.getTotalScore());
    }

}
