package kata.leapyear;

import org.junit.Test;
import static org.junit.Assert.assertEquals;


public class LeapYearShould {

    @Test
    public void typical_leap_year_when_divided_by_four() {
        assertEquals(true , LeapYearSimple.leapyear(1996));
    }


}
