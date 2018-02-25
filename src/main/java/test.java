import kata.leapyear.LeapYearSimple;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.GregorianCalendar;

public class test {
    public static void main(String[] args) {
            String date_str="20180111";

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");

            LocalDate date = LocalDate.parse(date_str, formatter);

            int day = date.getDayOfWeek().getValue();

            System.out.println(day);

            final StringBuilder resultAccumulator = new StringBuilder();
            resultAccumulator.append("tt");
            resultAccumulator.append("rr");
            System.out.println(resultAccumulator.toString());

    }
}
