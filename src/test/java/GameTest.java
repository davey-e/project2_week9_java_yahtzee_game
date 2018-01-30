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
}
