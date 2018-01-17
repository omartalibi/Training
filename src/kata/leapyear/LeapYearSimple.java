package kata.leapyear;

public class LeapYearSimple {
    static boolean isDivisble(long number, int divisor) {
        return number % divisor == 0;
    }

    public static String leapyear(final int year) {

        if (isDivisble(year,4)) {
            if(isDivisble(year,100) && isDivisble(year,400) || !isDivisble(year,100))
                return "leap year";
            else
                return "typical common year";

        }
        else
            return "typical common year";

    }
}
