import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

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

}
