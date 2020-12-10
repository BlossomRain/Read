package part3.chapter12.date;

import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoField;

public class DateTest {

    @Test
    public void testLocalDate() {
        // Date
        LocalDate date = LocalDate.of(2020, 12, 1);
        date = LocalDate.now();
        int year = date.get(ChronoField.YEAR);
        int month = date.get(ChronoField.MONTH_OF_YEAR);
        int day = date.get(ChronoField.DAY_OF_MONTH);

        // Time
        LocalTime time = LocalTime.now();
        //System.out.println(date + " " + time);

        // DateTime
        LocalDateTime dateTime = LocalDateTime.of(date, time);
        System.out.println(dateTime);


    }
}
