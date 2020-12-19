package ch06.extend;

public class OperationTest {
    /*public static void main(String[] args) {
        Operation op = BasicOperation.DIVIDE;
        System.out.println(op.apply(15, 3));
        op=ExtendedOperation.EXP;
        System.out.println(op.apply(2,5));
    }*/

    public static void main(String[] args) {
        double x = Double.parseDouble(args[0]);
        double y = Double.parseDouble(args[1]);
        test(ExtendedOperation.class, x, y);
    }

    private static <T extends Enum<T> & Operation> void test(Class<T> opEnumType, double x, double y) {
        for (Operation op : opEnumType.getEnumConstants())
            System.out.printf("%f %s %f = %f%n",x, op, y, op.apply(x, y));
    }
}
