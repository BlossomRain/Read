package part3.chapter8.template;

import org.junit.Test;

public class BankTest {
    @Test
    public void testLambda() {
        new OnlineBanking().processCustomer(1337, (Customer c) ->
                System.out.println("Hello " + c.getName()));
    }
}
