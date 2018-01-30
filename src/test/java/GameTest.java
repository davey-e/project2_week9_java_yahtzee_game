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
}
