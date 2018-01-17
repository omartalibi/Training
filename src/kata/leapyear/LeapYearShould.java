package kata.leapyear;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class LeapYearShould {

    @Test
    public void leap_year_when_divisible_by_4_and_neither_divisible_by_100_nor_400(){
            assertEquals("leap year", LeapYearSimple.leapyear(1992));
    }
}
