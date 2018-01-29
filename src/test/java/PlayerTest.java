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

    }

    @Test
    public void playerHasName(){
        assertEquals("Dave", player1.getName());
    }

    @Test
    public void playerHasDiceArrayList(){
        assertEquals(dice, player1.getDice());
    }
}
