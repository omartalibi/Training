package kata.fizzbuzz;

import java.util.*;
import java.util.stream.*;

public class FizzBuzzStream {

    public static String fizzBuzz(final int number) {
        List<Integer> numbers = new ArrayList<Integer>();
        numbers.add(number);

        List<String> result;

        result = numbers.stream()
                .filter(nb -> nb % 3 == 0)
                .map(nb -> "Fizz")
                .collect(Collectors.toList());



        if(result.isEmpty())
            return String.valueOf(number);
        else
            return result.get(0);
    }

    }
