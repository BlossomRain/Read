package part3.chapter10.optional;

import java.util.Optional;
import java.util.Properties;

public class OptionalTest {


    public static void main(String[] args) {
        Properties props = new Properties();

        props.setProperty("a", "5");
        props.setProperty("b", "true");
        props.setProperty("c", "-3");

        int b = new OptionalTest().readDuration(props, "b");
        System.out.println(b);
    }

    public int readDuration(Properties props, String name) {
        return Optional.ofNullable(props.getProperty(name))
                .flatMap(OptionalTest::stringToInt)
                .filter(i -> i > 0)
                .orElse(0);
    }

    public static Optional<Integer> stringToInt(String s) {
        try {
            return Optional.of(Integer.parseInt(s));
        } catch (NumberFormatException e) {
            return Optional.empty();
        }
    }

    public String getCarInsuranceName(Optional<Person> person) {
        return person.flatMap(Person::getCar)
                .flatMap(Car::getInsurance)
                .map(Insurance::getName)
                .orElse("Unknown");
    }
}
