import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class GameTest {

    Game game;

    @Before
    public void before(){
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
    public void canDetermineWinner(){
        game.setupPlayers(2);
        game.getPlayers().get(0).getScoreSheet().setTotalScore(100);
        game.getPlayers().get(1).getScoreSheet().setTotalScore(80);
        game.determineWinner();
        assertEquals("Player1", game.getWinner().getName());
    }
}
