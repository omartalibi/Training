package kata.fizzbuzz;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzzSimple {

    public static String fizzBuzz(final long number) {
        if (isDivisble(number, 3 * 5)) {
            return ("FizzBuzzOpenClosed");
        }
        if (isDivisble(number, 3)) {
            return ("Fizz");
        }
        if (isDivisble(number, 5)) {
            return ("Buzz");
        }
        return Long.toString(number);
    }

    static boolean isDivisble(long number, int divisor) {
        return number % divisor == 0;
    }
}
