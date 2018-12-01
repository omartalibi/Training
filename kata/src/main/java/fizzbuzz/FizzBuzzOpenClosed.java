package fizzbuzz;

public class FizzBuzzOpenClosed {

    enum Rules {
        FIZZ(3, "Fizz"), BUZZ(5, "Buzz");

        private int divisor;
        private String label;

        Rules(final int divisor, final String label) {
            this.divisor = divisor;
            this.label = label;
        }

        void apply(final long number, final StringBuilder accumulator) {
            if (isDivisble(number, divisor)) {
                accumulator.append(label);
            }
        }
    }

    public static String fizzBuzz(final long number) {
        final StringBuilder resultAccumulator = new StringBuilder();
        for (final Rules rule : Rules.values()) {
            rule.apply(number, resultAccumulator);
        }
        if (resultAccumulator.length() == 0) {
            return Long.toString(number);
        }
        return resultAccumulator.toString();
    }

    static boolean isDivisble(long number, int divisor) {
        return number % divisor == 0;
    }
}
