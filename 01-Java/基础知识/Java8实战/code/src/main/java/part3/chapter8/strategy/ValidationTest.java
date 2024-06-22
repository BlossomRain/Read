package part3.chapter8.strategy;

import org.junit.Test;
import part3.chapter8.strategy.impl.IsAllLowerCase;
import part3.chapter8.strategy.impl.IsNumeric;

public class ValidationTest {

    // Lambda表达式简化
    @Test
    public void testLambda() {
        Validator numericValidator =
                new Validator((String s) -> s.matches("[a-z]+"));
        boolean b1 = numericValidator.validate("aaaa");
        Validator lowerCaseValidator =
                new Validator((String s) -> s.matches("\\d+"));
        boolean b2 = lowerCaseValidator.validate("bbbb");
    }

    // 传统方式的实现以及使用
    @Test
    public void testTradition() {
        Validator numericValidator = new Validator(new IsNumeric());
        boolean b1 = numericValidator.validate("aaaa");
        Validator lowerCaseValidator = new Validator(new IsAllLowerCase());
        boolean b2 = lowerCaseValidator.validate("bbbb");
    }
}

