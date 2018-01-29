import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertFalse;

public class RollTest {

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
    }

    @Test
    public void canRollDice(){
        Roll.rollDice(dice);
        int numberOfDice = dice.size();
        for (int i = 0; i < numberOfDice; i++){
            System.out.println("die Value: " + dice.get(i).getValue());
            assertFalse(dice.get(i).getValue() > 6);
            assertFalse(dice.get(i).getValue() < 1);
        }
    }
}
