package practice;

import java.util.HashMap;

public class HashMapTest {

    public static void main(String[] args) {
        HashMap<String, Integer> mp = new HashMap<>();
        System.out.println("mp = " + mp);
        Integer ret = mp.merge("test", 1, (val1, val2) -> val1 + 1);
        System.out.println("ret = " + ret);
        System.out.println("mp = " + mp);
        Integer ret2 = mp.merge("test", 1, (val1, val2) -> val1 + 1);
        System.out.println("ret2 = " + ret2);
        System.out.println("mp = " + mp);
    }

}
