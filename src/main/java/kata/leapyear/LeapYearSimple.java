package kata.leapyear;

public class LeapYearSimple {

    public static String leapyear(final int year) {
        if(isDivisble(year, 4))
            if(isDivisble(year, 100))
                if (isDivisble(year, 400))
                    return "atypical leap year";
                else
                    return "atypical common year";
            else
                return "typical leap year";
        return "typical common year";
    }

    static boolean isDivisble(long number, int divisor) {
        return number % divisor == 0;
    }
}
