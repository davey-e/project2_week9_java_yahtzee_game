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
    ArrayList<Die> dice;
    ArrayList<Die> dice2;

    @Before
    public void before(){
        scoreSheet = new ScoreSheet();
        scores = new HashMap<>();
        scores.put(ScoreLine.ONES,0);
        scores.put(ScoreLine.TWOS,0);
        scores.put(ScoreLine.THREES,0);
        scores.put(ScoreLine.FOURS,0);
        scores.put(ScoreLine.FIVES,0);
        scores.put(ScoreLine.SIXES,0);
        die1 = new Die();
        die1.setValue(1);
        die2 = new Die();
        die2.setValue(2);
        die3 = new Die();
        die3.setValue(1);
        die4 = new Die();
        die4.setValue(1);
        die5 = new Die();
        die5.setValue(3);
        dice = new ArrayList<>();
        dice.addAll(Arrays.asList(die1, die2, die3, die4, die5));
        die6 = new Die();
        die6.setValue(1);
        dice2 = new ArrayList<>();
        dice2.addAll(Arrays.asList(die1, die2, die3, die4, die6));


    }

    @Test
    public void scoreSheetHasScores(){
        assertEquals(scores, scoreSheet.getScores());
    }

    @Test
    public void canGetSingleScore(){
        assertEquals(0, scoreSheet.getSingleScore(ScoreLine.ONES));
    }

    @Test
    public void scoreSheetHasUpperSectionScore(){
        assertEquals(0, scoreSheet.getUpperSectionScore());
    }

    @Test
    public void scoreSheetHasTotalScore(){
        assertEquals(0, scoreSheet.getTotalScore());
    }

    @Test
    public void canSetScoreInUpperSection(){
        scoreSheet.setSingleScore(ScoreLine.ONES, dice);
        assertEquals(3, scoreSheet.getSingleScore(ScoreLine.ONES));
        scoreSheet.setSingleScore(ScoreLine.TWOS, dice);
        assertEquals(2, scoreSheet.getSingleScore(ScoreLine.TWOS));
        scoreSheet.setSingleScore(ScoreLine.THREES, dice);
        assertEquals(3, scoreSheet.getSingleScore(ScoreLine.THREES));
    }

    @Test
    public void wontSetScoreIfNoDiceMatchScoreLine(){
        scoreSheet.setSingleScore(ScoreLine.SIXES, dice);
        assertEquals(0, scoreSheet.getSingleScore(ScoreLine.SIXES));
    }

    @Test
    public void wontSetScoreIfScoreLineAlreadyHasScore(){
        scoreSheet.setSingleScore(ScoreLine.ONES, dice);
        assertEquals(3, scoreSheet.getSingleScore(ScoreLine.ONES));
        scoreSheet.setSingleScore(ScoreLine.ONES, dice2);
        assertEquals(3, scoreSheet.getSingleScore(ScoreLine.ONES));
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
        scoreSheet.calculateUpperSectionScore();
        assertEquals(5, scoreSheet.getUpperSectionScore());
    }

    @Test
    public void canCalculateTotalScore(){
        scoreSheet.setSingleScore(ScoreLine.ONES, dice);
        scoreSheet.setSingleScore(ScoreLine.TWOS, dice);
        scoreSheet.calculateUpperSectionScore();
        scoreSheet.calculateTotalScore();
        assertEquals(5, scoreSheet.getTotalScore());
    }

}
