package kata.fizzbuzz;

public class FizzBuzzRecursive {

    public static String fizzBuzz(final int number) {

        //Junit : 4/5
        int tmp;
        if(number % 3 == 0){
            tmp = number;
            while(tmp % 3 == 0)
                tmp = tmp / 3;
            return "Fizz" + fizzBuzz(tmp);
        }
        else if(number % 5 == 0) return "Buzz";

        return String.valueOf(number);
    }

}
