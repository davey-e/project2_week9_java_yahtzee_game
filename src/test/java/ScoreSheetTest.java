import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class ScoreSheetTest {

    ScoreSheet scoreSheet;
    HashMap<String, Integer> scores;

    @Before
    public void before(){
        scoreSheet = new ScoreSheet();
        scores = new HashMap<>();
        scores.put("Ones",0);
        scores.put("Twos",0);
        scores.put("Threes",0);
        scores.put("Fours",0);
        scores.put("Fives",0);
        scores.put("Sixes",0);
    }

    @Test
    public void scoreSheetHasScores(){
        assertEquals(scores, scoreSheet.getScores());
    }

    @Test
    public void canGetSingleScore(){
        assertEquals(0, scoreSheet.getSingleScore("Ones"));
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
        scoreSheet.setSingleScore("Ones", 3);
        assertEquals(3, scoreSheet.getSingleScore("Ones"));
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
        scoreSheet.setSingleScore("Ones", 3);
        scoreSheet.setSingleScore("Twos", 6);
        scoreSheet.setSingleScore("Threes", 9);
        scoreSheet.setSingleScore("Fours", 8);
        scoreSheet.setSingleScore("Fives", 15);
        scoreSheet.setSingleScore("Sixes", 18);
        scoreSheet.calculateUpperSectionScore();
        assertEquals(59, scoreSheet.getUpperSectionScore());
    }

}
