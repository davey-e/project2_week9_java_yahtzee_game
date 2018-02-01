import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class RollTest {

    Die die1;
    Die die2;
    Die die3;
    Die die4;
    Die die5;
    ArrayList<Die> dice;
    ArrayList<Boolean> diceToHold;

    @Before
    public void before(){

        die1 = new Die();
        die2 = new Die();
        die3 = new Die();
        die4 = new Die();
        die5 = new Die();
        dice = new ArrayList<>();
        dice.addAll(Arrays.asList(die1, die2, die3, die4, die5));
        diceToHold = new ArrayList<>();
        diceToHold.addAll(Arrays.asList(true, true, false, false, true));
    }

    @Test
    public void canRollDice(){
        Roll.rollDice(dice);
        int numberOfDice = dice.size();
        for (int i = 0; i < numberOfDice; i++){
            assertFalse(dice.get(i).getValue() > 6);
            assertFalse(dice.get(i).getValue() < 1);
        }
    }

    @Test
    public void canHoldDice(){
        Roll.holdDice(dice, diceToHold);
        assertTrue(dice.get(0).getHoldStatus());
        assertTrue(dice.get(1).getHoldStatus());
        assertFalse(dice.get(2).getHoldStatus());
        assertFalse(dice.get(3).getHoldStatus());
        assertTrue(dice.get(4).getHoldStatus());
    }
}
