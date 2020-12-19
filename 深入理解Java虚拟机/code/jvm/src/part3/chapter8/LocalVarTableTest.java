package part3.chapter8;

/**
 * VM args: -verbose:gc
 */
public class LocalVarTableTest {
    public static void main(String[] args) {
        {
            byte[] placeholder = new byte[64 * 1024 * 1024];
        }
        int a = 0;
        System.gc();
    }
}
