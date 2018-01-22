package kata.leapyear;

public class LeapYearSimple {

    public static String leapyear(final int year) {
        if(isDivisble(year, 4))
            return "typical leap year";
        return "other stuff";
    }

    static boolean isDivisble(long number, int divisor) {
        return number % divisor == 0;
    }
}
