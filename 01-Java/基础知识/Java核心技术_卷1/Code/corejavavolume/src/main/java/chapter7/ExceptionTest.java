package chapter7;

import org.junit.Test;

import java.util.logging.Logger;

public class ExceptionTest {

    @Test
    public void testLogger() {
        Logger.getGlobal().info("hello logger");
        Logger.getGlobal().info("hello");
    }
}
