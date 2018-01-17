package kata.leapyear;

public class LeapYearSimple {
    static boolean isDivisble(long number, int divisor) {
        return number % divisor == 0;
    }

    public static boolean leapyear(final int year) {
        boolean result = false;
        if (isDivisble(year,4)) {
            if(isDivisble(year,100) && isDivisble(year,400) || !isDivisble(year,100))
                result=true;
        }
        return result;
    }
}
