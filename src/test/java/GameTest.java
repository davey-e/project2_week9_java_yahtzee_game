import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class GameTest {

    Die die1;
    Die die2;
    Die die3;
    Die die4;
    Die die5;
    ArrayList<Die> dice;

    Game game;

    @Before
    public void before(){

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

        game = new Game();
    }

    @Test
    public void playersArrayListStartsEmpty(){
        assertEquals(0, game.getPlayers().size());
    }

    @Test
    public void winnerStartsNull(){
        assertNull(game.getWinner());
    }

    @Test
    public void hasNumberOfTurns(){
        assertEquals(6, game.getNumberOfTurns());
    }

    @Test
    public void hasTurnCount(){
        assertEquals(0, game.getTurnCount());
    }

    @Test
    public void canIncrementTurnCount(){
        game.incrementTurnCount();
        assertEquals(1, game.getTurnCount());
    }

    @Test
    public void canSetupPlayers(){
        game.setupPlayers(2);
        assertEquals(2, game.getPlayers().size());
        assertEquals("Player1", game.getPlayers().get(0).getName());
        assertEquals("Player2", game.getPlayers().get(1).getName());
    }

    @Test
    public void canGetNumberOfPlayers(){
        game.setupPlayers(2);
        assertEquals(2, game.getNumberOfPlayers());
    }

    @Test
    public void canCalculatePlayerTotalScores(){
        game.setupPlayers(2);
        Player player1 = game.getPlayers().get(0);
        Player player2 = game.getPlayers().get(1);
        assertEquals(0, player1.getScoreSheet().getUpperSectionScore());
        assertEquals(0, player1.getScoreSheet().getTotalScore());
        assertEquals(0, player2.getScoreSheet().getUpperSectionScore());
        assertEquals(0, player2.getScoreSheet().getTotalScore());
        player1.getScoreSheet().setSingleScore(ScoreLine.ONES, dice);
        player2.getScoreSheet().setSingleScore(ScoreLine.TWOS, dice);
        game.calculatePlayerTotalScores();
        assertEquals(3, player1.getScoreSheet().getUpperSectionScore());
        assertEquals(3, player1.getScoreSheet().getTotalScore());
        assertEquals(2, player2.getScoreSheet().getUpperSectionScore());
        assertEquals(2, player2.getScoreSheet().getTotalScore());
    }

    @Test
    public void canDetermineWinner(){
        game.setupPlayers(2);
        game.getPlayers().get(0).getScoreSheet().setTotalScore(100);
        game.getPlayers().get(1).getScoreSheet().setTotalScore(80);
        game.determineWinner();
        assertEquals("Player1", game.getWinner().getName());
    }

}
