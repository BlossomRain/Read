package part4.chapter10;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class GenericEraseTest {

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("hello", "你好");
        map.put("how are you?", "吃了没？ ");
        System.out.println(map.get("hello"));
        System.out.println(map.get("how are you?"));
    }

    public void testRawType(){
        ArrayList<Integer> ilist = new ArrayList<>();
        ArrayList<String> slist = new ArrayList<>();
        ArrayList list; // 裸类型
        list = ilist;
        list = slist;
    }
}
