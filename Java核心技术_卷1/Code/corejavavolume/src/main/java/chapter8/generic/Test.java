package chapter8.generic;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {

        List<Integer> intList = new ArrayList<>();
        List<String> strList = new ArrayList<>();

        // 与旧代码兼容
        List list = intList;        // 失去类型检查的效果
        List<Double> douList = list;

        // 证明泛型擦除
        System.out.println(intList.getClass() == strList.getClass());

        new DateInter();

    }
}
