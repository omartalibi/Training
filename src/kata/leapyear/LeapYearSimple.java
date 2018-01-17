package kata.leapyear;

public class LeapYearSimple {

    public static String leapyear(final int year){
        if(year % 4 == 0 && year % 100 != 0 && year % 400 != 0 )
            return "leap year";
        return null;
    }
}
