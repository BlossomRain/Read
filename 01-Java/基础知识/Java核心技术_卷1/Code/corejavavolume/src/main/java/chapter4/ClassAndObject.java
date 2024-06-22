package chapter4;

import org.junit.Test;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;

public class ClassAndObject {

    @Test
    public void testInitOrder(){
        new Son();
    }

    @Test
    public void testSwap() {
        Integer a = new Integer("2");
        Integer b = new Integer("20");

        swap(a, b);
        System.out.println("a=" + a + " b=" + b);
    }

    private void swap(Integer a, Integer b) {
        Integer tmp = a;
        a = b;
        b = tmp;
    }

    @Test
    public void testDate() {
        LocalDate date = LocalDate.now();
        int month = date.getMonthValue();
        int today = date.getDayOfMonth();

        date = date.minusDays(today - 1);
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        int value = dayOfWeek.getValue();

        System.out.println("Mon Tue Wed Thu Fri Sat Sun");
        for (int i = 1; i < value; i++) {
            System.out.print("    ");
        }

        while (date.getMonthValue() == month) {
            System.out.printf("%3d", date.getDayOfMonth());
            if (date.getDayOfMonth() == today)
                System.out.print("*");
            else
                System.out.print(" ");
            date = date.plusDays(1);
            if (date.getDayOfWeek().getValue() == 1) System.out.println();
        }
        if (date.getDayOfWeek().getValue() != 1) System.out.println();
    }
}
