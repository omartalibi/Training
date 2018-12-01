package leapyear;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LeapYearStream {


    public static Boolean LeapYearStream(final int year) {

        List<Boolean> result;
        List<Integer> input = new ArrayList<Integer>();
        input.add(4);
/*
        result = input.stream()
                .filter(divisor -> (year % divisor) == 0)
                .map(x -> isLeapYear(year, x) == true)
                .collect(Collectors.toList());

        return result;
        */
    return false;
    }

    static boolean isDivisble(long number, int divisor) {
        return number % divisor == 0;
    }
    static boolean isLeapYear(int year, int divisor){
        if(isDivisble(year,100) && isDivisble(year,400) || !isDivisble(year,100)){
            return true;
    }
        return false;
    }
}
