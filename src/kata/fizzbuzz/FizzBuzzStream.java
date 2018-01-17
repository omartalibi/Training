package kata.fizzbuzz;

import java.util.*;
import java.util.stream.*;

public class FizzBuzzStream {


    public static String fizzBuzz(final int number) {
        List<String> result;

        //Junit 5/5
        result = Arrays.asList(number).stream()
                .map(nb ->  {
                    if(FizzBuzzSimple.isDivisble(nb, 15))
                        return "FizzBuzz";
                    if(FizzBuzzSimple.isDivisble(nb, 3))
                        return "Fizz";
                    if(FizzBuzzSimple.isDivisble(nb, 5))
                        return "Buzz";
                    return String.valueOf(nb);
                })
                .collect(Collectors.toList());


        if(result.isEmpty())
            return String.valueOf(number);
        else
            return result.get(0);
    }

    }
