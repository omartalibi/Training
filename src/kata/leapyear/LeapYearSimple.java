package kata.leapyear;

public class LeapYearSimple {

    public static boolean leapyear(final int year) {
        if(isDivisble(year, 4))
            return true;

        return false;
    }

    static boolean isDivisble(long number, int divisor) {
        return number % divisor == 0;
    }
}
