package kata.fizzbuzz;

import java.util.*;
import java.util.stream.*;

public class FizzBuzzStream {


    public static String fizzBuzz(final int number) {
        List<String> result;

        result = Arrays.asList(number).stream()
                .map(nb ->  {
                    if(nb%3==0){
                        return "Fizz";
                    }
                    return "Buzz";
                })
                .collect(Collectors.toList());


        if(result.isEmpty())
            return String.valueOf(number);
        else
            return result.get(0);
    }

    }
