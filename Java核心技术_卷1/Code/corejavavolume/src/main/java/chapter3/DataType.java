package chapter3;

import org.junit.Test;
import static java.lang.Math.*;
/**
 *
 */
public class DataType {




//    public static void main(String[] args){
//        for (int i = 0; i < args.length; i++) {
//            System.out.print(" " + args[i]);
//        }
//    }

    //测试Math类
    @Test
    public void testMath(){
        System.out.println(sqrt(-1));
        System.out.println(-1 % -2);
        System.out.println(floorMod(11,-2));
        int i = -1;
        System.out.println(- -i);
        int[][][] arr= new int[1][2][];
    }

    //测试整型变量
    @Test
    public void testInt(){
        int a = 1_000;
        int b = 0xffff;
        double c = 0x1p2,d=0x2p2,e=0x2p1;
        System.out.println(c+" "+d+" "+e);
        System.out.println("0/0.0" + " " + 0/0.0);
        System.out.println(Double.isNaN(0/0.0));
        System.out.println(0/0.0 == 0/0.0);

    }
}
