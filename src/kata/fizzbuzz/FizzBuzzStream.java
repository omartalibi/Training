package kata.fizzbuzz;

import java.util.*;
import java.util.stream.*;


public class FizzBuzzStream {


    public static String fizzBuzz(final int number) {
        List<StringBuilder> result;
        List<Integer> input = new ArrayList<Integer>();
        input.add(3);
        input.add(5);

        //Junit 5/5
        result = input.stream()
                 .filter(divisor -> (number % divisor) == 0)
                 .map(x -> setDiv(x))
                 .collect(Collectors.toList());

        int size = result.size();

        if(result.isEmpty())
            return String.valueOf(number);
        if(size > 1)
            return result.get(0).toString() + result.get(1).toString();
        if(size == 1)
            return result.get(0).toString();
        return null;
    }
    public static StringBuilder setDiv(int divisor) {
        final StringBuilder resultAccumulator = new StringBuilder();
        if (divisor == 3)
             resultAccumulator.append("Fizz");
        if (divisor == 5)
             resultAccumulator.append("Buzz");
        return resultAccumulator;
    }

}
