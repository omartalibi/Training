package kata.fizzbuzz;

import java.util.*;
import java.util.stream.*;

public class FizzBuzzStream {

    public static String fizzBuzz(final int number) {
        List<Integer> numbers = new ArrayList<Integer>();
        numbers.add(number);

        List<String> a = numbers.stream()
                .filter(nb -> nb % 15 == 0)
                .map(nb -> "fizzBuzz")
                .collect(Collectors.toList());

        return a.get(0);
    }

    }
