import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class DieTest {

    Die die1;

    @Before
    public void before(){

        die1 = new Die();
    }

    @Test
    public void dieHasValue(){
        assertEquals(0, die1.getValue());
    }

    @Test
    public void dieHasHoldStatus(){
        assertFalse(die1.getHoldStatus());
    }

    @Test
    public void canSetValue(){
        die1.setValue(1);
        assertEquals(1, die1.getValue());
    }

    @Test
    public void canSetHoldStatus(){
        die1.setHoldStatus(true);
        assertTrue(die1.getHoldStatus());
    }

    @Test
    public void canRollDie(){
        die1.rollDie();
        System.out.println("die1 Value: " + die1.getValue());
        assertFalse(die1.getValue() > 6);
        assertFalse(die1.getValue() < 1);
    }

}
