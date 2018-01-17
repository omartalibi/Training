package kata.leapyear;

import org.junit.Test;

import java.util.GregorianCalendar;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class LeapYearShould {

    @Test
    public void leap_year_when_divisible_by_4(){
            assertTrue(LeapYearSimple.leapyear(1992));
    }

    @Test
    public void typical_common_year_when_not_divisible_by_4(){
            assertFalse(LeapYearSimple.leapyear(2017));
    }

    @Test
    public void typical_common_year_when_divisible_by_4_and_100_but_not_divisible_by_400(){
            assertFalse(LeapYearSimple.leapyear(1000));
    }

    @Test
    public void forAllNumbers() {
        for (int i = 1; i < 3000; i++) {
            assertEquals(LeapYearSimple.leapyear(i), new GregorianCalendar().isLeapYear(i));
        }
    }
}
