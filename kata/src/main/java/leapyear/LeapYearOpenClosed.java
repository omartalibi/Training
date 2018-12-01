package leapyear;

public class LeapYearOpenClosed {
    enum Rules {

        CommonYear("common year"), LeapYear("leap year");

        private String divisor;

        Rules(final String divisor) {
            this.divisor = divisor;
        }

        boolean apply(final long year) {
            boolean result = false;
            if (isDivisble(year,4)) {
                if(isDivisble(year,100) && isDivisble(year,400) || !isDivisble(year,100))
                    result=true;
            }
            return result;
        }
    }
    public static boolean leapyear(final int year) {
            return false;
    }

    static boolean isDivisble(long number, int divisor) {
        return number % divisor == 0;
    }


}
