import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class PlayerTest {

    Player player1;
    Die die1;
    Die die2;
    Die die3;
    Die die4;
    Die die5;
    ArrayList<Die> dice;
    ScoreSheet scoresheet;

    @Before
    public void before(){

        die1 = new Die();
        die2 = new Die();
        die3 = new Die();
        die4 = new Die();
        die5 = new Die();
        dice = new ArrayList<>();
        dice.addAll(Arrays.asList(die1, die2, die3, die4, die5));
        player1 = new Player("Dave", dice);
        scoresheet = new ScoreSheet();

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
    public void canAssignScoreToScoreLineOnPlayersScoreSheet(){
        player1.getScoreSheet().setSingleScore("Ones", 1);
        assertEquals(1, player1.getScoreSheet().getSingleScore("Ones"));
    }
}
