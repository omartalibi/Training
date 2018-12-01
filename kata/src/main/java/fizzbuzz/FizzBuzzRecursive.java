package fizzbuzz;

public class FizzBuzzRecursive {

    public static String fizzBuzz(final int number) {
        final String divisorRulesApplied = fizzbuzzrec(number);
        if (divisorRulesApplied.isEmpty()) {
            return String.valueOf(number);
        }
        return divisorRulesApplied;
    }


    private static String fizzbuzzrec(final int number) {
        if (number % 3 == 0) {
            return "Fizz" + fizzbuzzrec(purgeDivisor(number, 3));
        }
        if (number % 5 == 0) {
            return "Buzz";
        }
        return "";
    }

    private static int purgeDivisor(final int number, final int divisor) {
        if (number % divisor == 0) {
            return purgeDivisor(number / divisor, divisor);
        }
        return number;
    }
}
