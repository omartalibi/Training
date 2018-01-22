package kata.leapyear;

import org.junit.Test;
import static org.junit.Assert.assertEquals;


public class LeapYearShould {

    @Test
    public void typical_leap_year(){
        assertEquals("typical leap year", LeapYearSimple.leapyear(1996));
    }

}
