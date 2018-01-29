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
    public void scoreSheetHasUpperSectionScore(){
        assertEquals(0, scoreSheet.getUpperSectionScore());
    }
}
